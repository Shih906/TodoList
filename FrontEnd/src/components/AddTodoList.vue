<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <h4><strong>新增代辦事項</strong></h4>
        <hr />
        <label for="title"><strong>標題</strong></label>
        <input
          type="text"
          class="form-control"
          id="title"
          required
          v-model="todoItem.title"
          name="title"
        />
      </div>

      <div class="form-group">
        <label for="description"><strong>描述</strong></label>
        <input
          class="form-control"
          id="description"
          required
          v-model="todoItem.description"
          name="description"
        />
      </div>
      <center>
        <button @click="saveTodoList" class="m-3 btn btn-sm btn-success">
          送出
        </button>
      </center>
    </div>

    <div v-else>
      <h4>新增成功!</h4>
      <button class="btn btn-success" @click="newTodoList">OK</button>
    </div>
  </div>
</template>

<script>
import TodoListService from "../services/TodoListService";

export default {
  name: "addTodolist",
  data() {
    return {
      todoItem: {
        id: null,
        title: "",
        description: "",
        status: false,
      },
      submitted: false,
    };
  },
  methods: {
    saveTodoList() {
      var data = {
        title: this.todoItem.title,
        description: this.todoItem.description,
        status: this.todoItem.status,
      };

      TodoListService.createTodoList(data)
        .then((response) => {
          this.todoItem.id = response.data.id;
          console.log(response.data);
          // this.submitted = true;

          alert("新增成功!");
          this.newTodoList();
        })
        .catch((e) => {
          console.log(e);
        });
    },

    newTodoList() {
      this.submitted = false;
      this.todoItem = { status: false };
    },
  },
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>