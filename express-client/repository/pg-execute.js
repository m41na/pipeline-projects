const {Pool} = require('pg');
const config = require('./pg-config');
const pool = new Pool(config.db);

const query = (query, params) =>
    new Promise((resolve, reject) => {
        pool.query(query, params, (error, results) => {
            if (error) {
                reject(error)
            }

            const {rows, fields} = results
            resolve({rows, fields})
        });
    })

module.exports = {
    query
}