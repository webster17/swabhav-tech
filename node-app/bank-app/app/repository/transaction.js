BankAppModel = require('./connection');

module.exports = () => {
    let obj = {};

    obj.getAll = (id, response) => {

        BankAppModel.Transaction.findAll({ where: { BM_ID: id }, order: ['ID'] }).then(result => {
            let statements = []
            for (let i = 0, balance = 0; i < result.length; i++) {
                if(result[i].dataValues.TYPE == 'D' || result[i].dataValues.TYPE == 'd')
                    result[i].dataValues.currentBalance = balance += result[i].dataValues.AMOUNT;
                else 
                    result[i].dataValues.currentBalance = balance -= result[i].dataValues.AMOUNT;
                statements.push(result[i].dataValues);
            }
            response.json(statements);
        });
    };

    obj.create = (bm_id, amount, type, response) => {

        return BankAppModel.sequelize.transaction().then(function (t) {
            return BankAppModel.Transaction.create({
                BM_ID: bm_id,
                AMOUNT: amount,
                TYPE: type
            }, { transaction: t }).then(account => {
                return BankAppModel.Account.findOne({
                    ID: bm_id
                }, { transaction: t }).then(account => {
                    let balance = account.dataValues.BALANCE;
                    if (type == 'W' || type == 'w')
                        balance = parseFloat(balance) - parseFloat(amount);
                    else
                        balance = parseFloat(balance) + parseFloat(amount);
                    return account.update({
                        BALANCE: balance
                    }, { transaction: t });
                });
            }).then(result => {
                t.commit();
                response.json({
                    "hasError": 0,
                    "message": "Transaction done successfully"
                });
            }).catch(err => {
                t.rollback();
                let error = "Something went wrong!";
                if (err.original.sqlState == 50002)
                    error = "You don't have an enough balance!";
                response.json({
                    "hasError": 1,
                    'status': 422,
                    'error': error
                });
            });
        });
    };

    return obj;
}