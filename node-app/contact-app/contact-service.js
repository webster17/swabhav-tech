var validator = require('validator');
var fs = require('fs');

class customError extends Error {
    constructor(errName, errMessage) {
        super(errMessage);
        this.name = errName;
    }
}

class User {

    constructor(name, contactNo, email) {
        this.setName(name);
        this.setContactNo(contactNo);
        this.setEmail(email);
    }

    getName() {
        return this.name;
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
            throw new customError('INVALID_NAME', 'Invalid name!!');
    }

    setContactNo(contactNo) {
        if (validator.isMobilePhone(contactNo, 'en-IN'))
            this.contactNo = contactNo;
        else
            throw new customError('INVALID_CONTACT_NO', 'Invalid contact number!');
    }

    setEmail(email) {
        if (validator.isEmail(email) || email == '')
            this.email = email;
        else
            throw new customError('INVALID_EMAIL_ID', 'Invalid email-id format!');
    }

    getContactObject() {
        return {
            name: this.name,
            contactNo: this.contactNo,
            email: this.email
        };
    }

}

contactService = function () {
    var obj = {};
    let dataBaseFile = 'contact-db.json';

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
        for (i in contactDB)
            if (contactDB[i].contactNo == contact)
                exist = true;
        return exist;
    }

    obj.search = function (keyword) {
        let searched = [];
        let contactDB = readFile();
        for (i in contactDB) {
            if (contactDB[i].name.includes(keyword) || contactDB[i].contactNo.includes(keyword) || contactDB[i].email.includes(keyword))
                searched.push(contactDB[i]);
        }
        return searched;
    }

    obj.add = function (name, contactNo, email) {
        let user = new User(name, contactNo, email);
        let contactDB = readFile();
        if (isAlreadyExistContactNo(contactNo))
            throw new customError('CONTACT_NO_ALREADY_EXIST', 'Contact number alredy exist!');
        else {
            contactDB.push(user.getContactObject());
            writeIntoFile(contactDB);
        }
    };

    obj.update = function (id, name, contactNo, email) {
        let user = new User(name, contactNo, email);
        let contactDB = readFile();
        if (isAlreadyExistContactNo(contactNo) && contactDB[id - 1].contactNo != contactNo)
            throw new customError('CONTACT_NO_ALREADY_EXIST', 'Contact number alredy exist!');
        else {
            contactDB[id - 1].name = name;
            contactDB[id - 1].email = email;
            contactDB[id - 1].contactNo = contactNo;
            writeIntoFile(contactDB);
        }
    }

    obj.remove = function (id) {
        let contactDB = readFile();
        if (this.getUser(id)) {
            contactDB.splice(id - 1, 1);
            writeIntoFile(contactDB);
        }
    }

    obj.getUser = function (id) {
        let contactDB = readFile();
        if (id > 0 && id <= contactDB.length)
            return contactDB[id - 1];
        else
            throw new customError('ID_NOT_MATCH', 'User is not exist with id: ' + id + '!');
    }

    obj.getAllUsers = function () {
        return readFile();
    }

    return obj;
}

module.exports = contactService;