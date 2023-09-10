const express = require('express');
const router = express.Router();

const home = require('./home')
const assignments = require('./assignments')

router.use("/", home)
router.use("/assignments", assignments)

module.exports = router