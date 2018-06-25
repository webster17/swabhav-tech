const Account = require('./accountCustomError');

let dispalyError = err => console.error('\nError: '+err.message);

try {
    const acc1 = new Account(1198007, 'Santosh Dangodra', 2000);

    acc1.getInfo('Account Created:');
    //acc1.deposit(-500);
    acc1.deposit(3000);
    acc1.withdraw(2000);
    acc1.withdraw(1000);
    acc1.getInfo('After all transaction:');
}catch (err) {
    dispalyError(err);
} finally{
    console.log('\nAccount object is released!');
}