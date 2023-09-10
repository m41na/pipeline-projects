import {useEffect, useState} from 'react'
import moment from 'moment'

function App() {
  const [data, setData] = useState([])

    useEffect(() => {
        fetch('http://localhost:8093/assignments').then(res => res.json()).then(setData)
    }, []);

  return (
    <table>
        <thead>
        <tr>
            <th>Initials</th>
            <th>Email</th>
            <th>Task</th>
            <th>Completed</th>
            <th>Date</th>
            <th>Complexity</th>
        </tr>
        </thead>
        <tbody>
        {data.map(row => (
            <tr key={row.todo.id}>
                <td>{row.assignee.firstName.charAt(0).toUpperCase()}{row.assignee.lastName.charAt(0).toUpperCase()}</td>
                <td>{row.assignee.emailAddress}</td>
                <td>{row.todo.task}</td>
                <td>{moment(row.date_assigned).format("MM/DD/YYYY")}</td>
                <td>{row.difficulty}</td>
            </tr>
        ))}
        </tbody>
    </table>
  )
}

export default App
