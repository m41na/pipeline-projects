const express = require('express');
const router = express.Router();
const {getAll} = require('../handler/assignments')
const axios = require('axios')

/* GET users listing. */
router.get('/', async function(req, res, next) {
  try {
    const {rows} = await getAll();
    const expanded = []

    for (const row of rows) {
      const {todo_id, user_id, difficulty, date_assigned} = row

      const todo = await axios.get(`${process.env.TODOS_PORTAL}/api/todos/${todo_id}`)
          .then(res => res.data)
      const user = await axios.get(`${process.env.USERS_PORTAL}/api/users/${user_id}`)
          .then(res => res.data)

      expanded.push({todo, assignee: user, difficulty, date_assigned})
    }
    res.json(expanded);
  }
  catch(err){
      res.send(err)
  }
});

module.exports = router;
