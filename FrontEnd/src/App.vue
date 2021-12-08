<template>
  <div id="app">
    <div class="container mt-3">
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <router-link to="/" class="navbar-brand" style="margin-left: 10px"
          >代辦事項清單</router-link
        >
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <router-link to="/add" class="nav-link">新增</router-link>
            </li>
          </ul>
        </div>
      </nav>
      <br />
    </div>
    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>

<style>
.navbar {
  max-width: 800px;
  margin-left: auto;
  margin-right: auto;
}
</style>

