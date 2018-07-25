const mongoose = require("mongoose");
const Schemma =  mongoose.Schema;

const TempUserSchema =  new Schema({

    name:{
        fname:{
            type:String
        },
        lname:{
            type:String,
        }
    },
    dob:{
        type:Date
    },
    Gender:{
        type:String
    },
    EmailId:{
        type:String
    },
    accountType:{
        type:String
    }
});