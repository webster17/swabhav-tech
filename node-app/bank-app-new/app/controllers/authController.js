const service = require("");

class AuthController{

  constructor(req){
    this.userName = req.body.userName;
    this.passwrod = req.body.passwrod;
  }
  authAttempt(){
      var v1=true;
  }

};


module.exports =   AuthController;