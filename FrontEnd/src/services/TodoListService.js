import http from "../http-common";

class ToloListService {
    getTodoList() {
        return http.get("/todoList");
    }

    getTodoListById(id) {
        return http.get("/todoList/" + id);
    }

    createTodoList(data) {
        return http.post("/todoList", data);
    }

    updateById(id, data) {
        return http.put("/todoList/" + id, data);
    }

    deleteById(id) {
        return http.delete("/todoList/" + id);
    }

    deleteAll() {
        return http.delete("/todoList");
    }
}

export default new ToloListService();