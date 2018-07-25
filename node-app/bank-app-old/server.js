const express = require('express');
var path = require('path');
require('express-group-routes');
const bodyParser = require('body-parser');
const web = require('./routes/web');
const api = require('./routes/api');
const colors = require('./colors');
var swaggerJSDoc = require('swagger-jsdoc');
var routes = require('./routes/api');

// use express router
const app = express();

// swagger definition
var swaggerDefinition = {
  info: {
    title: 'Bank-App swagger API',
    version: '1.0.0',
    description: 'Demonstrating how to desribe a RESTful API with Swagger',
  },
  host: 'localhost:8080',
  basePath: '/api/v1/bank',
};

// options for the swagger docs
var options = {
  // import swaggerDefinitions
  swaggerDefinition: swaggerDefinition,
  // path to the API docs
  apis: ['./routes/*.js'],
};

// initialize swagger-jsdoc


var swaggerSpec = swaggerJSDoc(options);


app.use(express.static(__dirname + '/public')); //Serves resources from public folder

// create application/json parser
app.use(bodyParser.json());

// create application/x-www-form-urlencoded parser
app.use(bodyParser.urlencoded({ extended: true }));


app.get('/swagger.json', function(req, res) {
  res.setHeader('Content-Type', 'application/json');
  res.send(swaggerSpec);
});

// intialize routes
web(app);
api(app);

let port = process.env.PORT || 8080;
// start server
app.listen(port, () => console.log(colors.Bright, colors.fg.Green, 'Bank-App is runnig on port: '+port, colors.Reset));