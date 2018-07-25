const mongoose = require('mongoose');
mongoose.connect('mongodb://root:root123@ds018508.mlab.com:18508/bank', { useNewUrlParser: true });

var db = mongoose.connection;
db.on('error', (err)=>{console.log(err.name+": "+err.message+" (Code:"+err.code+")")});
db.once('open', function() {
  console.log("We are connected!");
});

module.exports = mongoose;