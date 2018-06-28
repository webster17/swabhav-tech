const validator = require('validator');
const fs = require('fs');
const uuidv4 = require('uuid/v4')


class customError extends Error {
    constructor(errName, errMessage) {
        super(errMessage);
        this.name = errName;
    }
}

function handleError(err) {
    return JSON.parse(err.message);
}

class User {

    constructor(name, contactNo, email, guid = "") {
        this.setName(name);
        this.setContactNo(contactNo);
        this.setEmail(email);
        if (guid == '')
            this.guid = uuidv4();
        else
            this.guid = guid;
    }

    getName() {
        return this.name;
    }

    getGUID() {
        return this.guid;
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
            id: this.guid,
            name: this.name,
            contactNo: this.contactNo,
            email: this.email
        };
    }

}

contactService = function () {
    var obj = {};
    let dataBaseFile = 'data/contact-db.json';

    readFile = function () {
        fileData = fs.readFileSync(dataBaseFile).toString();
        if (fileData == '')
            return [];
        return JSON.parse(fileData);
    }

    writeIntoFile = function (contactDB) {
        fs.writeFileSync(dataBaseFile, JSON.stringify(contactDB));
    }

    isAlreadyExistContactNo = function (contact) {
        let exist = false;
        let contactDB = readFile();
        for (let key in contactDB)
            if (contactDB[key].contactNo == contact)
                exist = true;
        return exist;
    }

    obj.search = function (keyword) {
        let searched = [];
        let contactDB = readFile();
        for (let key in contactDB) {
            if (contactDB[key].name.includes(keyword) || contactDB[key].contactNo.includes(keyword) || contactDB[key].email.includes(keyword))
                searched.push(contactDB[key]);
        }
        return {
            "hasError": 0,
            "data": searched,
            "message": searched.length + " contacts are filtered"
        };
    }

    obj.add = function (name, contactNo, email) {
        try {
            let user = new User(name, contactNo, email);
            let contactDB = readFile();
            if (isAlreadyExistContactNo(contactNo))
                throw new customError('CONTACT_NO_ALREADY_EXIST', '{"hasError":1, "status":409, "error":"Contact number alredy exist!"}');
            else {
                contactDB[user.getGUID()] = user.getContactObject();
                writeIntoFile(contactDB);
                return {
                    "hasError": 0,
                    "data": contactDB[user.getGUID()],
                    "message": " contact is successfully added"
                };
            }
        } catch (err) {
            return handleError(err);
        }
    };

    obj.update = function (id, name, contactNo, email) {
        try {
            let user = new User(name, contactNo, email, id);
            let contactDB = readFile();
            if (isAlreadyExistContactNo(contactNo) && contactDB[id].contactNo != contactNo)
                throw new customError('CONTACT_NO_ALREADY_EXIST', '{"hasError":1, "status":409, "error":"Contact number alredy exist!"}');
            else {
                contactDB[id].name = name;
                contactDB[id].email = email;
                contactDB[id].contactNo = contactNo;
                writeIntoFile(contactDB);
                return {
                    "hasError": 0,
                    "data": contactDB[id],
                    "message": " contact is successfully updated"
                };
            }
        } catch (err) {
            return handleError(err);
        }
    }

    obj.delete = function (id) {
        try {
            let contactDB = readFile();
            if (contactDB.hasOwnProperty(id)) {
                delete contactDB[id];
                writeIntoFile(contactDB);
                return {
                    "hasError": 0,
                    "data": id,
                    "message": "contact is successfully deleted"
                }
            }
            else
                throw new customError('ID_NOT_MATCH', '{"hasError":1, "status":404, "error":"User is not exist!"}');
        } catch (err) {
            return handleError(err);
        }
    }

    obj.get = function (id) {
        try {
            let contactDB = readFile();
            if (contactDB.hasOwnProperty(id)) {
                return {
                    "hasError": 0,
                    "data": contactDB[id],
                    "message": "contact is fetched"
                };
            }
            else
                throw new customError('ID_NOT_MATCH', '{"hasError":1, "status":404, "error":"User is not exist!"}');
        } catch (err) {
            return handleError(err);
        }
    }

    obj.getAll = function () {
        return {
            "hasError": 0,
            "data": readFile(),
            "message": "all contacts fetched"
        };
    }

    return obj;
}

module.exports = contactService;