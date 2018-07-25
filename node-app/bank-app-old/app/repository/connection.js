const mysql = require('mysql2');
const mysqlModel = require('mysql2-model');
const Sequelize = require('sequelize');

let dbConfig = {
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'transaction'
};

const sequelize = new Sequelize(dbConfig.database, dbConfig.user, dbConfig.password, {
    host: dbConfig.host,
    dialect: 'mysql',
    operatorsAliases: false,

    pool: {
        max: 5,
        min: 0,
        acquire: 30000,
        idle: 10000
    }
});

const Account = sequelize.define('accounts', {
    ID: {
        type: Sequelize.UUID,
        primaryKey:true
    },
    NAME: Sequelize.STRING(70),
    USERNAME: Sequelize.STRING(50),
    PASSWORD: Sequelize.STRING(50),
    BALANCE: Sequelize.FLOAT,
}, {
    timestamps: false,
    paranoid: false
});

const Transaction = sequelize.define('transactions', {
    ID: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        autoIncrement: true,
    },
    BM_ID: Sequelize.UUID,
    AMOUNT:Sequelize.FLOAT,
    TYPE: Sequelize.ENUM('D', 'd', 'W', 'w'),
    DATE: Sequelize.DATE,
}, {
    timestamps: false,
    paranoid: false
});
Account.hasMany(Transaction, {foreignKey: 'BM_ID'});

module.exports = { Account, Transaction, sequelize };