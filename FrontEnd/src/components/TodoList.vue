<template>
  <div class="list row">
    <div class="col-md-6">
      <h4><strong>代辦事項</strong></h4>
      <hr />
      <ul class="list-group">
        <li
          class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(todoItem, index) in TodoList"
          :key="index"
          @click="setActiveTodoItem(todoItem, index)"
        >
          {{ todoItem.title }}
          <span v-if="todoItem.status" style="float: right"
            ><img
              src="https://img.icons8.com/emoji/48/000000/check-mark-emoji.png"
              id="checkStatusImg"
          /></span>
        </li>
      </ul>

      <button class="m-3 btn btn-sm btn-danger" @click="removeAllTutorials">
        清除全部
      </button>
    </div>
    <div class="col-md-6">
      <h4><strong>說明</strong></h4>
      <hr />
      <div v-if="currentTodoItem">
        <ul class="list-group">
          <li class="list-group-item" style="border: none">
            <label><strong>標題：</strong></label>
            {{ currentTodoItem.title }}
          </li>
          <li class="list-group-item" style="border: none">
            <label><strong>描述：</strong></label>
            {{ currentTodoItem.description }}
          </li>
          <li class="list-group-item" style="border: none">
            <label><strong>狀態：</strong></label>
            <strong>{{ currentTodoItem.status ? "已完成" : "未完成" }}</strong>
          </li>
        </ul>

        <button
          class="m-3 btn btn btn-success badge badge-pill"
          v-if="currentTodoItem.status"
          @click="updateStatus(false)"
        >
          加入代辦
        </button>

        <button
          class="m-3 btn btn btn-success badge badge-pill"
          v-else
          @click="updateStatus(true)"
        >
          完成
        </button>

        <button
          class="m-3 btn badge badge-pill bg-warning text-dark"
          @click="$router.push('/todoList/' + currentTodoItem.id)"
        >
          編輯
        </button>

        <button
          class="m-3 btn badge bg-danger"
          @click="removeTodoItemById(currentTodoItem.id)"
        >
          刪除
        </button>
      </div>
      <div v-else>
        <p>請點選代辦事項</p>
      </div>
    </div>
  </div>
</template>

<script>
import TodoListService from "../services/TodoListService";

export default {
  name: "TodoList",
  data() {
    return {
      TodoList: [],
      currentTodoItem: null,
      currentIndex: -1,
      title: "",
      finished: "",
    };
  },
  methods: {
    getTodoList() {
      TodoListService.getTodoList().then((response) => {
        this.TodoList = response.data;
      });
    },
    setActiveTodoItem(todoItem, index) {
      this.currentTodoItem = todoItem;
      // if (todoItem) {
      //   todoItem.status ? (this.finished = "#019858") : (this.finished = "");
      // }
      this.currentIndex = index;
    },
    updateTodoItemById(id, data) {
      TodoListService.updateById(id, data).then((response) => {
        console.log(response);
        this.refreshList();
      });
    },
    updateStatus(status) {
      var data = {
        id: this.currentTodoItem.id,
        title: this.currentTodoItem.title,
        description: this.currentTodoItem.description,
        status: status,
      };

      TodoListService.updateById(this.currentTodoItem.id, data)
        .then(() => {
          this.currentTodoItem.status = status;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    removeTodoItemById(id) {
      console.log(id);
      TodoListService.deleteById(id).then(() => {
        alert("刪除成功");
        this.refreshList();
      });
    },
    removeAllTutorials() {
      TodoListService.deleteAll()
        .then((response) => {
          console.log(response.data);
          this.refreshList();
        })
        .catch((e) => {
          console.log(e);
        });
    },
    retrieveTodoLists() {
      TodoListService.getTodoList()
        .then((response) => {
          this.TodoList = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveTodoLists();
      this.currentTodoItem = null;
      this.currentIndex = -1;
    },
  },
  created() {
    this.getTodoList();
    this.setActiveTodoItem();
  },
};
</script>

<style>
.list {
  text-align: middle;
  max-width: 750px;
  margin: auto;
}

#checkStatusImg {
  width: 16px;
  height: 16px;
}
</style>

