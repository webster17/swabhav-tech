const Account = require('./account');

let dispalyError = errMessage => console.error('\nInvalid ' + errMessage + '!');

try {
    const acc1 = new Account(1198007, 'Santosh Dangodra', 2000);

    acc1.getInfo('Account Created:');
    acc1.deposit(-500);
    acc1.deposit(3000);
    acc1.withdraw(2000);
    acc1.withdraw(1000);
    acc1.getInfo('After all transaction:');
}catch (err) {
    if (err.message === "INVALID_BALANCE")
        dispalyError('Balance');
    else if (err.message === "INVALID_ACCOUNT_NO")
        dispalyError('Account No');
    else if (err.message === "INVALID_NAME")
        dispalyError("name");
    else if (err.message === "INVALID_DEPOSIT_AMOUNT")
        dispalyError('deposit amount');
    else if (err.message === "INVALID_WITHDRAW_AMOUNT")
        dispalyError('withdraw amount');
    else
        dispalyError(err.message);
} finally{
    console.log('\nAccount object is released!');
}