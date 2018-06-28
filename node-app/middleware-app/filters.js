function filters(app) {
    app.use(function (req, res, next) {
        console.log('log filter!');
        next();
    }, function (req, res, next) {
        console.log('Cookie is set: '+req.query.user);
        next();
    });

    app.use(function (req, res, next) {
        req.on('end', function () {
            console.log('Response compressed!');
        });
        next();
    });
}

module.exports = filters;