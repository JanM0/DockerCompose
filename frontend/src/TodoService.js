import Axios from "axios"

const url = `${process.env.REACT_APP_BACKEND}/api/todo`


const ToDoService = {
    getCount: (onResp, onError) => {
        Axios.get(url).then(onResp).catch(onError);
    },
    getTodos: (onResp, onError) => {
        Axios.get(`${url}/all`).then(onResp).catch(onError);
    },
    addTodo: (onResp, onError) => {
        Axios.post(url).then(onResp).catch(onError);
    }
}


Object.freeze(ToDoService);

export default ToDoService;