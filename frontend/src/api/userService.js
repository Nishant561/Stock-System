import api from "./axios";

const createUser = (data)=> api.post("/user/signup", data);
const loginUser = (data) => api.post("/user/login", data);
export {
    createUser,
    loginUser
}