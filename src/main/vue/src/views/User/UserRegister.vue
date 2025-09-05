<template>
  <div>
    <button @click="postExample">post_click</button>
    <!-- <button @click="getExample">get_click</button> -->
    <p>서버응답 {{ result }}</p>
  </div>
</template>

<script setup>
import axios from 'axios'
import { reactive, ref } from 'vue'

const result = ref("")

const obj = {
  color : "red",
  wheel : "4",
  selCode : {
    code : "1",
    name : "test"
  }
}



function postExample() {
  axios.post('/api/postProducts', obj)
  .then((res) => {
    result.value = res.data
    console.log('🚀 ~ res.data:', res.data)
    })
    .catch((res) => {
      console.log('🚀 ~ error', res)
    })
}
</script>
