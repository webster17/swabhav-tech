module.exports = function controlers(app) {
    app.get('/', (req, res) => {
        res.send("Home");
    });
};