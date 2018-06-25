let dataService = require('./dataService');
dataService().getData().map(data=>console.log(data));
dataService().getDataAsync(function(array){
    console.log('\nData returned Asynchronously:');
    array.map(data=>console.log(data));
});
dataService().getDataAsyncArrow(array=>{
    console.log('\nData returned Asynchronously using arrow function:');
    array.map(value=>console.log(value));
});
console.log('\nEnd of the script');