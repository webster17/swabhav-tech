var express = require('express');
var filters = require('./filters');
var app = express();

app.listen(8080, () => console.log('Node server is running..'));

filters(app);

app.get('/index.html', (req, res) => {
    res.send('<h1>This is index page</h1>');
    console.log('Index Page!');
});