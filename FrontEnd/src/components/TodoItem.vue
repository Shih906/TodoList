<template>
  <div v-if="currentTodoItem" class="edit-form">
    <h4><strong>編輯代辦事項</strong></h4>
    <hr />
    <form>
      <div class="form-group">
        <label for="title"><strong>標題</strong></label>
        <input
          type="text"
          class="form-control"
          id="title"
          v-model="currentTodoItem.title"
        />
      </div>
      <div class="form-group">
        <label for="description"><strong>描述</strong></label>
        <input
          type="text"
          class="form-control"
          id="description"
          v-model="currentTodoItem.description"
        />
      </div>
    </form>

    <center>
      <button
        type="submit"
        class="m-3 btn btn-sm btn-success"
        @click="updateTutorial"
      >
        儲存編輯
      </button>
    </center>
  </div>
</template>

<script>
import TodoListService from "../services/TodoListService";

export default {
  name: "todolist",
  data() {
    return {
      currentTodoItem: null,
    };
  },
  methods: {
    getTodoItem(id) {
      TodoListService.getTodoListById(id)
        .then((response) => {
          this.currentTodoItem = response.data[0];
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    updateTutorial() {
      TodoListService.updateById(this.currentTodoItem.id, this.currentTodoItem)
        .then((response) => {
          console.log(response.data);
          alert("更新成功!");
          this.$router.push({ name: "todolist" });
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  mounted() {
    this.getTodoItem(this.$route.params.id);
  },
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>