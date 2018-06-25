class customError extends Error{
    constructor(errName, errMessage){
        super(errMessage);
        this.name = errName;
    }
}

function Account(accNo, name, balance) {
    let _accNo, _name, _balance

    if (accNo > 0)
        _accNo = accNo;
    else
        throw new customError('INVALID_ACCOUNT_NO', 'Invalid Account No!');

    if (isNaN(name))
        _name = name;
    else
        throw new customError('INVALID_NAME', 'Invalid Name!');

    if (balance > 500)
        _balance = balance;
    else
        throw new customError('INVALID_BALANCE', 'Invalid Balance!');

    _notify = function (message) {
        console.log('\n' + message);
        console.log('Your Current balance is: ' + _balance);
    }

    this.deposit = function (amount) {
        if (amount <= 0)
            throw new customError('INVALID_DEPOSIT_AMOUNT', 'Invalid deposit amount!');
        _balance += amount;
        _notify(amount+' Deposited successfully!');
    }

    this.withdraw = function (amount) {
        if (_balance - amount < 500)
            throw new customError('INVALID_WITHDRAW_AMOUNT', 'Invalid withdraw amount!');
        _balance -= amount;
        _notify(amount+' Withdrwal successfully!');
    }

    this.getInfo = function (statusMessage = 'this:') {
        console.log('\nInfo after ' + statusMessage);
        console.log('AccNo: ' + _accNo
            + '\nName: ' + _name
            + '\nBalance: ' + _balance);
    }
}

module.exports = Account;