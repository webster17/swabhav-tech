const events = require('events');
const eventEmitter = new events.EventEmitter();

class NumberService{
    
    generateRandomNumber() {
        return Math.round(Math.random()*10);   
    }

    getEventEmitter(){
        return eventEmitter;
    }

    getVerifiedNumber(){
        let randomNumber = this.generateRandomNumber();
        console.log("Number: "+randomNumber);
        if(randomNumber>5){
            return eventEmitter.emit('success', randomNumber);
        }
        eventEmitter.emit('failure');
    }
}

module.exports=NumberService;