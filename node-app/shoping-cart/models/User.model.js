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
        type: String,
        required: [true, 'Why no name?']
    },
    username: {
        type: String,
        unique: [true, 'User name is already exist!'],
        required: [true, 'User name is necessary to login']
    },
    password: {
        type:String,
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
    orders: [OrderSchema]
});

var User = mongoose.model('User', UserSchema);