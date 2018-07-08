const mysql = require('mysql');
const readlineSync = require('readline-sync');

const connection = mysql.createConnection(
  {
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'techlabs'
  }
);

connection.connect(function (err) {

  if (err) {
    console.error('error connecting: ' + err.stack);
    return;
  }

  function getBalance(table, name) {

    connection.query("SELECT BALANCE FROM " + table + " WHERE NAME=?", [name], function (err, result) {
      if (err) {
        throw err;
        return;
      }
      console.log(table + ": " + result[0].BALANCE);
    });
  }

  function displayCurrentBalance() {
    console.log('\nCurrent Balance:');
    getBalance('CUSTOMER', 'sarvesh')
    getBalance('MERCHANT', 'techlabs');
  }

  function handleSQLError(err) {
    console.log('Transaction failed!');
    if (err.sqlState == 50001)
      console.log('Sorry you have insufficient balance');
    else
      console.log("Error: " + err.sqlMessage);

    displayCurrentBalance();
  }

  function makeTransaction(amount) {

    try {
      connection.beginTransaction((err) => {
        if (err) {
          handleSQLError(err);
        }
        else {
          connection.query('UPDATE CUSTOMER SET BALANCE=BALANCE-? WHERE NAME="sarvesh"', amount, (err, result) => {
            if (err) {
              connection.rollback(function () {
                handleSQLError(err);
              });
            }
            else {
              connection.query('UPDATE MERCHANT SET BALANCE=BALANCE+? WHERE NAME="techlabs"', amount, (err, result) => {
                if (err) {
                  connection.rollback(function () {
                    handleSQLError(err);
                  });
                }
                else {
                  connection.commit((err) => {
                    if (err) {
                      connection.rollback(function () {
                        handleSQLError(err);
                      });
                    }
                    else {
                      console.log('Transaction Done successfully.');
                      displayCurrentBalance();
                    }
                  });
                }
              });
            }
          });
        }
      });
    }
    catch (err) {
      console.log('In catch: ' + err.message);
    }
  }


  function start() {
    let amount = readlineSync.question('Enter how many you want to pay: ');
    makeTransaction(amount);
  }

  start();

});