const contactServiceFn = require('./contact-service');
const contactService = contactServiceFn();

function contactControllers(app) {
    app.group('/api/v1/contacts', (router) => {
        router.get('/', (req, res) => {
            res.json(contactService.getAll());
        })
        router.get('/:guid', (req, res) => {
            res.json(contactService.get(req.params.guid));
        })
        router.post('/', (req, res) => {
            if (req.body) {
                res.json(contactService.add(req.body.name, req.body.contactNo, req.body.email));
            } else {
                res.sendStatus(400);
            }
        })
        router.put('/:guid', (req, res) => {
            if (req.body) {
                res.json(contactService.update(req.params.guid, req.body.name, req.body.contactNo, req.body.email));
            } else {
                res.sendStatus(400);
            }
        })
        router.get('/search/:keyword', (req, res) => {
            res.json(contactService.search(req.params.keyword));
        })
        router.delete('/:guid', (req, res) => {
            res.json(contactService.delete(req.params.guid));
        });
    });
}

module.exports = contactControllers;