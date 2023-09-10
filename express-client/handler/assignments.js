const {query} = require('../repository/pg-execute');

exports.getAll = () => query('SELECT * FROM tbl_assignments', [])