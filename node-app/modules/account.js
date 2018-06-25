function Account(accNo, name, balance) {
    let _accNo, _name, _balance

    if (accNo > 0)
        _accNo = accNo;
    else
        throw new Error('INVALID_ACCOUNT_NO');

    if (isNaN(name))
        _name = name;
    else
        throw new Error('INVALID_NAME');

    if (balance > 500)
        _balance = balance;
    else
        throw new Error('INVALID_BALANCE');

    _notify = function (message) {
        console.log('\n' + message);
        console.log('Your Current balance is: ' + _balance);
    }

    this.deposit = function (amount) {
        if (amount <= 0)
            throw new Error('INVALID_DEPOSIT_AMOUNT');
        _balance += amount;
        _notify(amount+' Deposited successfully!');
    }

    this.withdraw = function (amount) {
        if (_balance - amount < 500)
            throw new Error('INVALID_WITHDRAW_AMOUNT');
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