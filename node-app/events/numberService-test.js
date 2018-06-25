const NumberService = require('./numberService');

const numberService = new NumberService();

event = numberService.getEventEmitter();
event.on('success', (number)=>console.log('Number is generated successfully: '+number));
event.on('failure', ()=>console.log('Number generation failuer!'));
numberService.getVerifiedNumber();