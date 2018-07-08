const bankControllers = require('./bank-controllers');
const accountControllers = require('./account-controller');
const transactionControllers = require('./transaction-controller');

module.exports = function controlers(app) {
    app.get('/', (req, res) => {
        res.send("Home");
    });

    bankControllers(app);
    accountControllers(app);
    transactionControllers(app);
};