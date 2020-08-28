import React, { useState, Fragment, useEffect } from 'react';
import './App.css';
import ToDoService from './TodoService';

const App = () => {
  const [todos, setTodos] = useState([]);
  const addTodo = () => {
    ToDoService.addTodo(resp => {
      const newTodos = [...todos]
      newTodos.push(resp.data)
      setTodos(newTodos);
    }, console.log);
  }

  useEffect(() => {
    ToDoService.getTodos(resp => setTodos(resp.data), console.log);
  }, [])

  return (
    <Fragment>

      <h1>Hallo, hier deine Todos:</h1>
      <ul>
        {todos ?
          todos.map((todo, i) => (<li key={i}>{todo.name}</li>))
          :
          <li>empty</li>
        }
      </ul>
      <button onClick={addTodo}>Todo +</button>
    </Fragment>

  );
}

export default App;
