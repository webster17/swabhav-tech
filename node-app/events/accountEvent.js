var events = require('events');

class customError extends Error {
    constructor(errName, errMessage) {
        super(errMessage);
        this.name = errName;
    }
}

function Account(accNo, name, balance) {
    let _accNo, _name, _balance;
    let eventEmitter = new events.EventEmitter();

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

    var notify = function () {
        console.log('Your Current balance is: ' + _balance);
    }

    eventEmitter.on('balanceChanged', notify);

    this.getEventEmitter= ()=> eventEmitter;

    this.deposit = function (amount) {
        process.nextTick(function () {
            if (amount <= 0)
                throw new customError('INVALID_DEPOSIT_AMOUNT', 'Invalid deposit amount!');
            _balance += amount;
            eventEmitter.emit('deposit', amount);
            eventEmitter.emit('balanceChanged');
        });
    }

    this.withdraw = function (amount) {
        if (_balance - amount < 500)
            throw new customError('INVALID_WITHDRAW_AMOUNT', 'Invalid withdraw amount!');
        _balance -= amount;
        eventEmitter.emit('withdraw', amount);
        eventEmitter.emit('balanceChanged');
    }

    this.getInfo = function (statusMessage = 'this:') {
        console.log('\nInfo after ' + statusMessage);
        console.log('AccNo: ' + _accNo
            + '\nName: ' + _name
            + '\nBalance: ' + _balance);
    }
}

module.exports = Account;