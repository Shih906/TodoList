import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [{
            path: "/",
            name: "todolist",
            component: () => import("./components/TodoList")
        },
        {
            path: "/todolist/:id",
            name: "updateTodoItem",
            component: () => import("./components/TodoItem")
        },
        {
            path: "/add",
            name: "add",
            component: () => import("./components/AddTodoList")
        }
    ]
});