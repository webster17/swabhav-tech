const transaction = require('../repository/transaction')();
const account = require('../repository/account')();
const uuidv1 = require('uuid/v1');

module.exports = () => {
    let obj = {};

    obj.authAttempt = (userName, password, res) => {
        account.authenticate(userName, password, res);
    };

    obj.createAccount = (name, userName, password, initialAmount, res) =>{
        id = uuidv1();
        account.create(id, name, userName, password, initialAmount, res);
    };

    obj.getAllStatements= (id, res) => {
        transaction.getAll(id, res);
    }

    obj.deposit = (id,  amount, res)=>{
        transaction.create(id, amount, 'D', res);
    };

    obj.withdraw = (id, amount, res)=>{
        transaction.create(id, amount, 'W', res);
    };

    return obj;
}