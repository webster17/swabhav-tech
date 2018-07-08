const contactControllers = require('./contact-controller');
const express = require('express');
require('express-group-routes');
const bodyParser = require('body-parser')
const app = express();

// create application/json parser
app.use(bodyParser.json());

// create application/x-www-form-urlencoded parser
app.use(bodyParser.urlencoded({ extended: true }));

app.listen(8080, () => console.log('Node server is running..'));

contactControllers(app);