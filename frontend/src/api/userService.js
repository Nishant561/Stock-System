import api from "./axios";

const createUser = (data)=> api.post("/user/signup", data);

export {
    createUser
}