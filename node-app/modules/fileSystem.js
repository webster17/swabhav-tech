var fileSystem = require("fs");

function displayError(err) {
  console.error('Error: ' + err);
}
let filePath = 'info.txt';

//file statistics
fileSystem.stat(filePath, (err, statistics) => {
  if (err)
    return displayError(err);
  console.log("\nFile Information:");
  console.log('is File? ' + statistics.isFile());                           //Returns true if file type of a simple file
  console.log('is Directory? ' + statistics.isDirectory());                 //Returns true if file type of a directory.  
  console.log('isBlockDevice? ' + statistics.isBlockDevice());	                //Returns true if file type of a block device.
  console.log('isCharacterDevice? ' + statistics.isCharacterDevice());	        //Returns true if file type of a character device.
  console.log('isSymbolicLink? ' + statistics.isSymbolicLink());	              //Returns true if file type of a symbolic link.
  console.log('isFIFO? ' + statistics.isFIFO());	                              //Returns true if file type of a FIFO.
  console.log('isSocket? ' + statistics.isSocket());	                          //Returns true if file type of asocket.
  console.log(statistics);
})

fileSystem.writeFile('newlyCreatedFile.txt', "Hello, It's newly created file!", (err) => {
  if (err)
    return displayError(err);
  console.log('\nData written Successfully!');


  // Asynchronous - Opening File
  console.log("\nFile opening...");
  fileSystem.open('newlyCreatedFile.txt', 'r+', function (err, fileData) {
    if (err)
      return displayError(err);
    console.log("\nFile opened successfully!");
    console.log('\nGoing for reading the file:');
    //
    fileSystem.readFile(fileData, (err, data) => {
      if (err)
        return displayError(err);
      console.log('\nData: ' + data);
      fileSystem.close(fileData, (err)=>{
        if(err)
          return displayError(err);
        console.log('\nFile closed successfully!');
      })
    })
  });
})

// Asynchronous read
fileSystem.readFile(filePath, function (err, data) {
  if (err)
    return displayError(err);
  console.log("\nAsynchronous read:\n" + data.toString());
});

// Synchronous read
var data = fileSystem.readFileSync(filePath);
console.log("\nSynchronous read:\n" + data.toString());

console.log("\nProgram Ended");