const bankAPIService = require('../app/services/bank-api.service')();

function api(app) {

    /**
     * @swagger
     * definitions:
     *   Statements:
     *     properties:
     *       ID:
     *         type: integer
     *       BM_ID: 
     *         type: uuid
     *       AMOUNT:
     *         type: float
     *       TYPE:
     *         type: string
     *       DATE:
     *         type: date  
     *       currentBalance:
     *         type: float
     */


    /**
     * @swagger
     * /api/v1/bank/statements/{Id}:
     *   get:
     *     tags:
     *       - Account Statements
     *     description: Returns all statements
     *     produces:
     *       - application/json
     *     responses:
     *       200:
     *         description: An array of statemtens
     *         schema:
     *           $ref: '#/definitions/Statements'
     */
    app.get('/api/v1/bank/statements/:Id', (req, res) => {
        bankAPIService.getAllStatements(req.params.Id, res);
    });

    app.group('/api/v1/bank', (router) => {

        router.post('/login', (req, res) => {
            if (req.body)
                bankAPIService.authAttempt(req.body.userName, req.body.password, res);
            else
                res.sendStatus(400);
        });

        router.post('/signup', (req, res) => {
            if (req.body)
                bankAPIService.createAccount(req.body.name, req.body.userName, req.body.password, req.body.initialAmount, res);
            else
                res.sendStatus(400);
        });

        router.post('/transaction/:Id/withdraw/:Amount', (req, res) => {
            bankAPIService.withdraw(req.params.Id, req.params.Amount, res);
        });

        router.post('/transaction/:Id/deposit/:Amount', (req, res) => {
            bankAPIService.deposit(req.params.Id, req.params.Amount, res);
        });
    });
}

module.exports = api;