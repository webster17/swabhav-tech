const express = require('express');
require('express-group-routes');
const path = require('path');
const bodyParser = require('body-parser');
const colors = require('./config/colors');
const routes = require('./routes/api');

// Use express router
const app = express();

// Serves resources from public folder
app.use(express.static(__dirname + '/public'));

// Create application/json parser
app.use(bodyParser.json());

// Create application/x-www-form-urlencoded parser
app.use(bodyParser.urlencoded({ extended: true }));

// Initialize routes
routes(app);

// Start server
let port = process.env.PORT || 8080;
app.listen(port, () => console.log(colors.Bright, colors.fg.Green, 'Bank-App is runnig on port: '+port, colors.Reset));