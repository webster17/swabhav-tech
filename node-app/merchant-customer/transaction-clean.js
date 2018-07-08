const mysql = require('mysql');
const async = require('async');

const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'contact_db'
});

async.waterfall([
    (callback) => connection.connect((err) => callback(err)),
    (callback) => connection.beginTransaction((err) => callback(err)),
    (callback) => connection.query('UPDATE customer SET BALANCE = BALANCE- ' + 5000 + ' WHERE ACCOUNT_NO =? ', 101,
        (err, status) => callback(err, status)),
    (status, callback) => connection.query('UPDATE merchant SET BALANCE = BALANCE + ' + 5000 + ' WHERE ACCOUNT_NO =? ', 1001,
        (err, status) => callback(err, status)),
    (status, callback) => connection.commit((err) => callback(err))
], (err) => {
    if (err)
        connection.rollback(() => console.error(err.sqlMessage));
    else
        console.log("transaction completed");
    connection.end();
});