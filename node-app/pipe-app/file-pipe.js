var fs = require('fs');
let readStream = fs.createReadStream('data.json');
let writeStream = fs.createWriteStream('data-copy.json');
// readStream.pipe(process.stdout);
readStream.pipe(writeStream);
console.log('End of the Script');