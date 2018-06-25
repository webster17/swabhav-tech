var zlib = require('zlib');
var fs = require('fs');

let compression = zlib.createGzip();
console.log('End of the script');

let readStream = fs.createReadStream('data.json');
let writeStream = fs.createWriteStream('data.json.gz');

readStream.pipe(compression).pipe(writeStream);