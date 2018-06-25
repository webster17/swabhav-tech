let dataService = function () {
    let obj = {};
    let _data = ['sarvesh', 'santosh', 'vipul'];
    obj.getData = function (callbackFn) {
        console.log('Data returned Synchronously:');
        return _data;
    }
    obj.getDataAsync = function (callbackFn) {
        process.nextTick(function () {
            callbackFn(_data);
        });
    }
    obj.getDataAsyncArrow = (callbackFn)=>process.nextTick(()=>callbackFn(_data));
    return obj;
}
module.exports = dataService;