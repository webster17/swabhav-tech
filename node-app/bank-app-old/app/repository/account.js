BankAppModel = require('./connection');

module.exports = () => {
    let obj = {};

    obj.authenticate = (userName, password, response) => {
        BankAppModel.Account.findOne({
            where: {
                USERNAME: userName,
                PASSWORD: password
            }, attributes: ['id', 'NAME', 'BALANCE']
        }).then(result => {
            if (result == null) {
                response.json({
                    "hasError": 1,
                    "status": 403,
                    "error": "Username and Password doesn't match!"
                });
            } else {
                response.json({
                    "hasError": 0,
                    "data": result,
                    "message": "Successfully loged in"
                });
            }
        });
    };

    obj.create = (id, name, userName, password, initialAmount, response) => {
        return BankAppModel.sequelize.transaction(t => {
            return BankAppModel.Account.create({
                ID: id,
                NAME: name,
                USERNAME: userName,
                PASSWORD: password,
                BALANCE: initialAmount
            }, { transaction: t }).then(user => {
                return BankAppModel.Transaction.create({
                    BM_ID: id,
                    AMOUNT: initialAmount,
                    TYPE: 'D'
                }, { transaction: t });
            });
        }).then(result => {
            response.json({
                "hasError": 0,
                "message": "Account has been successfully created"
            });
        }).catch(err => {
            let error = "Something went wrong!";
            if(err.original.sqlState == 50002)
                error = "Initial Amount must be greater than 1000";
            response.json({
                "hasError":1,
                'status': 422,
                'error':error
            })
        });
    };

    return obj;
}