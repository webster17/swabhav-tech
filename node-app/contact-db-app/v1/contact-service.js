const validator = require('validator');
var connection = require('./connection');
const con = connection();
const uuidv4 = require('uuid/v4');

class customError extends Error {
    constructor(errName, errMessage) {
        super(errMessage);
        this.name = errName;
    }
}

function handleError(err, response) {
    response.json(JSON.parse(err.message));
}

function handleSQLError(err, response) {
    response.json({
        hasError: 1,
        status: 500,
        error: err.sqlMessage
    });
}

class User {

    constructor(name, contactNo, email, id = "") {
        this.setName(name);
        this.setContactNo(contactNo);
        this.setEmail(email);
        if (id == '')
            this.id = uuidv4();
        else
            this.id = id;
    }

    getName() {
        return this.name;
    }

    getID() {
        return this.id;
    }

    getContactNo() {
        return this.contactNo;
    }

    getEmail() {
        return this.email;
    }

    setName(name) {
        if (validator.isAlpha(name))
            this.name = name;
        else
            throw new customError('INVALID_NAME', '{"hasError":1, "status":406, "error":"Invalid name!"}');
    }

    setContactNo(contactNo) {
        if (validator.isMobilePhone(contactNo, 'en-IN'))
            this.contactNo = contactNo;
        else
            throw new customError('INVALID_CONTACT_NO', '{"hasError":1, "status":406, "error":"Invalid contact number!"}');
    }

    setEmail(email) {
        if (validator.isEmail(email) || email == '')
            this.email = email;
        else
            throw new customError('INVALID_EMAIL_ID', '{"hasError":1, "status":406, "error":"Invalid email-id format!"}');
    }

    getContactObject() {
        return {
            id: this.id,
            name: this.name,
            contactNo: this.contactNo,
            email: this.email
        };
    }

}

contactService = function () {
    var obj = {};

    obj.search = function (keyword, response) {
        con.execute(("SELECT * FROM CONTACT WHERE NAME LIKE '%" + keyword + "%' OR CONTACT LIKE '%" + keyword + "%' OR EMAIL LIKE '%" + keyword + "%'"), (result) => {
            response.json({
                "hasError": 0,
                "data": result,
                "message": result.length + " contacts filtered"
            });
        }, (err) => { handleSQLError(err, response) });
    }

    obj.add = function (name, contactNo, email, response) {
        try {
            let user = new User(name, contactNo, email);
            con.execute(("SELECT 1 FROM CONTACT WHERE contact='" + contactNo + "'"), (result) => {
                if (result.length == 1)
                    handleError(new customError('ID_NOT_MATCH', '{"hasError":1, "status":409, "error":"Contact number alredy exist!"}'), response);
                else {
                    con.execute(("INSERT INTO `contact`(`id`, `name`, `contact`, `email`) VALUES ('" + user.getID() + "','" + user.getName() + "','" + user.getContactNo() + "','" + user.getEmail() + "')"), (result) => {
                        response.json({
                            "hasError": 0,
                            "data": user.getContactObject,
                            "message": "Contact is successfully added"
                        });
                    }, (err) => { handleSQLError(err, response) });
                }
            }, (err) => { handleSQLError(err, response) });
        } catch (err) {
            handleError(err, response);
        }
    };

    obj.update = function (id, name, contactNo, email, response) {
        try {
            let user = new User(name, contactNo, email, id);
            con.execute(("SELECT 1 FROM CONTACT WHERE contact='" + contactNo + "' AND id!='" + id + "'"), (result) => {
                if (result.length == 1)
                    handleError(new customError('ID_NOT_MATCH', '{"hasError":1, "status":409, "error":"Contact number alredy exist!"}'), response);
                else {
                    con.execute(("UPDATE `contact` SET `name`='" + user.getName() + "',`contact`='" + user.getContactNo() + "',`email`='" + user.getEmail() + "' WHERE id='" + id + "'"), (result) => {
                        response.json({
                            "hasError": 0,
                            "data": user.getContactObject,
                            "message": "Contact is successfully updated"
                        });
                    }, (err) => { handleSQLError(err, response) });
                }
            }, (err) => { handleSQLError(err, response) });
        } catch (err) {
            handleError(err, response);
        }
    }

    obj.delete = function (id, response) {
        try {
            con.execute(("DELETE FROM CONTACT WHERE id='" + id + "'"), (result) => {
                if (result.affectedRows < 1)
                    handleError(new customError('ID_NOT_MATCH', '{"hasError":1, "status":404, "error":"Contact is not exist!"}'), response);
                else
                    response.json({
                        "hasError": 0,
                        "message": "Contact is deleted"
                    });
            }, (err) => { handleSQLError(err, response) });
        } catch (err) {
            handleError(err, response);
        }
    }

    obj.get = function (id, response) {
        try {
            con.execute(("SELECT * FROM CONTACT WHERE id='" + id + "'"), (result) => {
                if (result.length < 1)
                    handleError(new customError('ID_NOT_MATCH', '{"hasError":1, "status":404, "error":"Contact is not exist!"}'), response);
                else
                    response.json({
                        "hasError": 0,
                        "data": result,
                        "message": "Contact is fetched"
                    });
            }, (err) => { handleSQLError(err, response) });
        } catch (err) {
            handleError(err, response);
        }
    }

    obj.getAll = function (response) {
        con.execute(("SELECT * FROM CONTACT"), (result) => {
            response.json({
                "hasError": 0,
                "data": result,
                "message": "all contacts fetched"
            })
        }, (err) => { handleSQLError(err, response) });
    }

    return obj;
}

module.exports = contactService;