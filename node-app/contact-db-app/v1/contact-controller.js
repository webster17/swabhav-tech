const contactServiceFn = require('./contact-service');
const contactService = contactServiceFn();

function contactControllers(app) {
    app.group('/api/v1/contacts', (router) => {
        router.get('/', (req, res) => {
            contactService.getAll(res);
        })
        router.get('/:id', (req, res) => {
            contactService.get(req.params.id, res);
        })
        router.post('/', (req, res) => {
            if (req.body) {
                contactService.add(req.body.name, req.body.contact, req.body.email, res);
            } else {
                res.sendStatus(400);
            }
        })
        router.put('/:id', (req, res) => {
            if (req.body) {
                contactService.update(req.params.id, req.body.name, req.body.contact, req.body.email, res);
            } else {
                res.sendStatus(400);
            }
        })
        router.get('/search/:keyword', (req, res) => {
            contactService.search(req.params.keyword, res);
        })
        router.delete('/:id', (req, res) => {
            contactService.delete(req.params.id, res);
        });
    });
}

module.exports = contactControllers;