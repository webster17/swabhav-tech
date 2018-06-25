var readlineSync = require('readline-sync');
var colors = require('./colors');

var dispalyError = err => console.error(colors.fg.Red, '\nError: ' + err.message, colors.Reset);
var contactService = require('./contact-service');
contactService = contactService();


function ContactAppConsole() {

    getUserChoice = function () {
        console.log(colors.fg.Cyan, "\n[1] Search\n[2] Add\n[3] Update\n[4] Remove\n[5] View All\n[6] Exit", colors.fg.Magenta);
        let choice = readlineSync.keyIn('Enter your choice? ', {limit: '$<1-6>'});
        return choice;
    }

    displayResponse = function (response) {
        console.log(colors.fg.Green, '\nID\tName\t\t\tContact\t\t\tEmail', colors.Dim);
        for (let i in response)
            console.log(parseInt(i) + 1 + '\t' + response[i].name + '\t\t\t' + response[i].contactNo + '\t\t' + response[i].email);
        console.log(colors.fg.White, response.length + " Records found.")
    }

    search = function () {
        console.log(colors.fg.Blue);
        let keyword = readlineSync.question('Enter your keyword to search? ', colors.Bright);
        displayResponse(contactService.search(keyword));
    }

    add = function () {
        console.log(colors.fg.Blue, '\nEnter your following details to add New Contact:');
        let name = readlineSync.question('Name: ');
        let contactNo = readlineSync.questionInt('Contact No: ');
        let email = readlineSync.questionEmail('Email: ');
        try {
            contactService.add(name, contactNo, email);
            viewAll();
        } catch (err) {
            dispalyError(err);
        }
    }

    update = function () {
        console.log(colors.fg.Blue, '\nEnter following details to Update Contact: ');
        let id = readlineSync.question('ID (which you want to update): ');
        try {
            let user = contactService.getUser(id);
            let name = readlineSync.question('Name (' + user.name + '): ');
            let contactNo = readlineSync.question('Contact No (' + user.contactNo + '): ');
            let email = readlineSync.question('Email (' + user.email + '): ');

            name = (name == '') ? user.name : name;
            contactNo = (contactNo == '') ? user.contactNo : contactNo;
            email = (email == '') ? user.email : email;
            contactService.update(id, name, contactNo, email);
            viewAll();
        } catch (err) {
            dispalyError(err);
        }
    }

    remove = function () {
        console.log(colors.fg.Blue, '\nEnter following details to Remove Contact: ');
        let id = readlineSync.question('ID (which you want to remove): ');
        try {
            if (contactService.getUser(id)) {
                let confirm = readlineSync.question('Are you sure to delete? (Y/N): ');
                if (confirm == 'y' || confirm == 'Y') {
                    contactService.remove(id);
                    viewAll();
                }
            }
        } catch (err) {
            dispalyError(err);
        }
    }

    viewAll = function () {
        displayResponse(contactService.getAllUsers());
    }

    this.start = function () {
        switch (getUserChoice()) {
            case "1":
                search();
                this.start();
                break;
            case "2":
                add();
                this.start();
                break;
            case "3":
                update();
                this.start();
                break;
            case "4":
                remove();
                this.start();
                break;
            case "5":
                viewAll();
                this.start();
                break;
            case "6":
                console.log(colors.fg.Green, '\nThank you for testing!', colors.Reset);
                return;
            default:
                console.log(colors.fg.Red, '\nEnter correct choice!', colors.Reset);
                this.start();
        }
    }
}

let contactAppConsole = new ContactAppConsole();
contactAppConsole.start();