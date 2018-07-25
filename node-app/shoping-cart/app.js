const express = require('express');
var path = require('path');
require('express-group-routes');
const bodyParser = require('body-parser');
const api = require("./routes/api");
const colors = require('./colors');
var routes = require('./routes/api');
const mongoose = require("mongoose");

const app = express();
app.use(express.static(__dirname + '/public'));     //Serves resources from public folder
app.use(bodyParser.json());     // create application/json parser
app.use(bodyParser.urlencoded({ extended: true }));   // create application/x-www-form-urlencoded parser

// intialize routes
api(app);

// start server
app.listen(8080, () => console.log(colors.Bright, colors.fg.Green, 'Bank-App is runnig...', colors.Reset));