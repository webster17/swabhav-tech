var queryString = "SELECT * FROM notification_detail nd LEFT JOIN notification n ON nd.id_notification = n.uuid WHERE login_id = ?  id_company = ?;";
var filter = [loginId, idCompany];

var query = connection.query({
    sql: queryString,
    timeout: 10000,
}, filter );

query
  .on('error', function(err) {
   if (err) {
      console.log(err.code);
      // Do anything you want whenever there is an error.
      // throw err;
   } 
})
.on('result', function(row) {
  //Do something with your result.
})
.on('end', function() {
  connection.release();
});

'use strict';

const express = require('express');
const router = express.Router();

const Promise = require('bluebird');
const HttpStatus = require('http-status-codes');
const fs = Promise.promisifyAll(require('fs'));

const pool = require('./pool');     // my database pool module, using promise-mysql
const Errors = require('./errors'); // my collection of custom exceptions


////////////////////////////////////////////////////////////////////////////////
// GET /v1/provinces/:id
////////////////////////////////////////////////////////////////////////////////
router.get('/provinces/:id', async (req, res) => {

  try {

    // get a connection from the pool
    const connection = await pool.createConnection();

    try {

      // retrieve the list of provinces from the database
      const sql_p = `SELECT p.id, p.code, p.name, p.country_id
                     FROM provinces p
                     WHERE p.id = ?
                     LIMIT 1`;
      const provinces = await connection.query(sql_p);
      if (!provinces.length)
        throw new Errors.NotFound('province not found');

      const province = provinces[0];

      // retrieve the associated country from the database
      const sql_c = `SELECT c.code, c.name
                     FROM countries c
                     WHERE c.id = ?
                     LIMIT 1`;
      const countries = await connection.query(sql_c, province.country_id);
      if (!countries.length)
        throw new Errors.InternalServerError('country not found');

      province.country = countries[0];

      return res.send({ province });

    } finally {
      pool.releaseConnection(connection);
    }

  } catch (err) {
    if (err instanceof Errors.NotFound)
      return res.status(HttpStatus.NOT_FOUND).send({ message: err.message }); // 404
    console.log(err);
    return res.status(HttpStatus.INTERNAL_SERVER_ERROR).send({ error: err, message: err.message }); // 500
  }
});


////////////////////////////////////////////////////////////////////////////////
// GET /v1/provinces
////////////////////////////////////////////////////////////////////////////////
router.get('/provinces', async (req, res) => {

  try {

    // get a connection from the pool
    const connection = await pool.createConnection();

    try {

      // retrieve the list of provinces from the database
      const sql_p = `SELECT p.id, p.code, p.name, p.country_id
                     FROM provinces p`;
      const provinces = await connection.query(sql_p);

      const sql_c = `SELECT c.code, c.name
                     FROM countries c
                     WHERE c.id = ?
                     LIMIT 1`;

      const promises = provinces.map(async p => {

        // retrieve the associated country from the database
        const countries = await connection.query(sql_c, p.country_id);

        if (!countries.length)
          throw new Errors.InternalServerError('country not found');

        p.country = countries[0];

      });

      await Promise.all(promises);

      return res.send({ total: provinces.length, provinces });

    } finally {
      pool.releaseConnection(connection);
    }

  } catch (err) {
    console.log(err);
    return res.status(HttpStatus.INTERNAL_SERVER_ERROR).send({ error: err, message: err.message }); // 500
  }
});


////////////////////////////////////////////////////////////////////////////////
// OPTIONS /v1/provinces
////////////////////////////////////////////////////////////////////////////////
router.options('/provinces', async (req, res) => {
  try {
    const data = await fs.readFileAsync('./options/provinces.json');
    res.setHeader('Access-Control-Allow-Methods', 'HEAD,GET,OPTIONS');
    res.setHeader('Allow', 'HEAD,GET,OPTIONS');
    res.send(JSON.parse(data));
  } catch (err) {
    res.status(HttpStatus.INTERNAL_SERVER_ERROR).send({ error: err, message: err.message });
  }
});


module.exports = router;