module.exports = function accountControllers(app) {
    app.get('/account', (req, res) => {
        res.send('Account');
    });
}