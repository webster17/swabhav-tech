module.exports = function bankControllers(app) {
    app.get('/bank', (req, res) => {
        res.send('Bank');
    });
}