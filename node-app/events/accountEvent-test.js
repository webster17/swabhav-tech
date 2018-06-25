const Account = require('./accountEvent');

let dispalyError = err => console.error('\nError: '+err.message);

try {
    const acc1 = new Account(1198007, 'Santosh Dangodra', 5000);

    event = acc1.getEventEmitter();

    
    event.on('deposit',(amount)=>console.log('\n'+amount+' Deposited successfully!'));
    event.on('withdraw',(amount)=>console.log('\n'+amount+' withdrwal successfully!'));

    acc1.getInfo('Account Created:');
    acc1.deposit(3000);
    acc1.withdraw(1000);
    acc1.getInfo('After all transaction:');

}catch (err) {
    dispalyError(err);
} finally{
    console.log('\nAccount object is released!');
}

console.log('End of the script!');