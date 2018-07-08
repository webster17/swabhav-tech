const mysql = require('mysql');

const connection = function () {
    obj = {};

    obj.execute = (query, success, reject) => {
        let con = mysql.createConnection({
            host: "127.0.0.1",
            user: "root",
            password: "",
            database: "contact-db"
        });

        con.connect((err) => {
            if (err) {
                reject(err);
                return;
            }

            con.query(query, (err, result) => {
                if (err) {
                    reject(err);
                    return;
                }
                success(result);
            });
        });
    };

    return obj;
}

module.exports = connection;