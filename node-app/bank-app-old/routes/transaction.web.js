module.exports = function transactionControllers(app) {
    app.get('/transaction', (req, res) => {
        res.send('Transaction');
    });
}