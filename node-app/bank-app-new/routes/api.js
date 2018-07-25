const controller = require("./app/controller");l

function api(app) {
    app.group('/api/v1/bank', (app) => {
        app.get('/login', (req, res) => {
            controller.authAttempt(req, res);
        });

        
    });
}