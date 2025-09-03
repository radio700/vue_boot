<script setup>
import { ref } from "vue";

import axios from "axios";

const id = ref("");
const password = ref("");

const login = function () {
  console.log("🚀 ~ password:", password)


  axios.post("/api/login", {
    id : "a",
    password: "B",
  });

};
</script>

<template>
  <div>
    <div>
      <input type="text" name="id" v-model="id" />
    </div>
    <div>
      <input type="text" name="password" v-model="password" />
    </div>
    <div>
      <button @click="login">로그인</button>
    </div>
  </div>
</template>

<style scoped></style>
