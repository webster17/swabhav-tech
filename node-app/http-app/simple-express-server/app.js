var express = require('express');
var app = express();

app.use(express.static(__dirname + '/public')); //Serves resources from public folder

var path = __dirname + '/public/';

app.listen(8080, () => console.log('Node server is running..'));

app.get('/', (req, res) => res.sendFile(path + 'index.html'));
app.get('/api', (req, res) => res.sendFile(path + 'data.json'));


//another way to get server resources
// var fs = require('fs');
// app.get('/file/:fileName', (req, res) => {
//     if (fs.existsSync(path + req.params.fileName)) {
//         let stream = fs.createReadStream(path + req.params.fileName);
//         stream.pipe(res);
//     } else {
//         res.status(404).send({ error: 'Resource Not Found!', status: "404" });
//     }
// });