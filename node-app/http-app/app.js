
var http = require('http');
var url = require('url');
var fs = require('fs');

http.createServer(function (req, res) {
    let fileName = 'index.html';
    
    if (req.url == '/api')
        fileName = 'data.json';
    else if (req.url != '/')
        fileName = req.url.substring(1);

    let path = 'public/' + fileName;
    console.log(path)
    let splitFile = fileName.split(".");
    let type='text/html'

    if (splitFile[1] == 'json')
        type = 'application/json';
    else if (splitFile[1] == 'png')
        type = 'image/png';

    try {
        if (fs.existsSync(path)) {
            res.writeHead(200, { "Content-type": type});
            fs.readFile(path, (err, data)=>{
                res.write(data);
                res.end();
            });
        } else {
            res.writeHead(404, { "Content-Type": type });
            res.write('404 Not Found!');
            res.end();
        }
    } catch (err) {
        res.write('<br>Error: ' + err.message);
    }

}).listen(8080);