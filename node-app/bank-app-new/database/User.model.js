const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const LineItemSchema = new Schema({
  productId: {
    type: Schema.ObjectId,
    ref: "products"
  },
  quantity: { type: Number, min: 1 },
});

const OrderSchema = new Schema({
  date: { type: Date, default: Date.now },
  lineItems: [LineItemSchema]
});

const UserSchema = new Schema({
  name: {
    fname: {
      type: String,
      required: [true, 'Why no first name?']
    },
    lname: {
      type: String,
      required: [true, 'Why no last name?']
    },
    mname: {
      type: String,
      required: [true, 'Why no middle name?']
    }
  },
  username: {
    type: String,
    unique: [true, 'User name is already exist!'],
    required: [true, 'User name is necessary for login']
  },
  password: {
    type: String,
    min: [8, 'Password must be contain 6 digits'],
    required: [true, 'Password is necessary to login']
  },
  dob: {
    type: Date,
    required: [true, 'Need to know are you adult?']
  },
  gender: {
    type: String,
    enum: ['Male', 'Female', 'Other'],
    required: [true, 'Required to help for suggestion']
  },
  phone: {
    type: String,
    validate: {
      validator: function (v) {
        return /\d{3}-\d{3}-\d{4}/.test(v);
      },
      message: '{VALUE} is not a valid phone number!'
    },
    required: [true, 'User phone number required']
  },
  accounts: [{
    accno: {
      type:Number
    },
    type: {
      type:ObjectId,
      ref='Bank.account.type'
    },
    doo: {

    },
    transactions: [{
      type:{
        type:ObjectId,
        ref="Bank.transaction.type"       
      },
      subType:{
        type:ObjectId,
        ref: ' Bank.transaction.subType'    
      },
      amount:{
        type:mongoose.Schema.Decimal128
      },
      date:{
        type:date
      }
    }]
  }],
  recipients: [{
    accno:{
      type:"ObjectId",
      ref="User.account"
    }
  }],
  forgotPassword:[{
    otp:{
        type:Number,
    },
    date:{
      type:Date
    }
  }],
  appointment:[{ 
    type:{
      type:ObjectId,
      ref: "Bank.Appointment"
    },
    message:{
      type:String
    },
    date:{
      type:Date
    },
    status:{
      type:ObjectId,
      ref:"Bank"
    }
  }]

});

var User = mongoose.model('User', UserSchema);