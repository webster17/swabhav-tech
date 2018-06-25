let balance = 500;
console.log('Your current balance is: '+balance)
let deposit =  function(amount, callbackFunction){
    balance = balance+amount;
    callbackFunction(balance)
}

deposit(500,(newBalance)=>console.log('New balance is changed to '+newBalance));
setTimeout(()=>console.log('Email notification has been sent.'), 3000);

var names = ['santosh', 'sarvesh', 'pratik', 'vipul'];
names.map(name=>console.log(name));
var upperCaseNames = names.map(name=>name.toUpperCase());
console.log('Upper Case Names List:')
upperCaseNames.map(name=>console.log(name));