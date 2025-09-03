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

const obj = {color : "red"}

const postExample = async() =>{
  try{
    const res = await axios.post("/api/postProducts",obj,{
      headers :{
        "Content-Type" : "application/json"
      }
    })
    result.value = res.data;
  } catch(e) {
    console.error(e)
    result.value = "에러"
  }
}


// let obj = "asdf"

// function postExample() {
//   axios.post('/api/postProducts', obj,{
//     headers : {
//       "Content-Type" : "application/json"
//     }
//   })
//   .then((res) => {
//     // console.log("🚀 ~ postExample JSON.stringify", JSON.stringify(obj))
//     console.log('🚀 ~ res.data:', res.data)
//     })
//     .catch((res) => {
//       console.log('🚀 ~ error', res)
//     })
// }



// const message = ref('')
// const error = ref('')

// const getExample = async () => {
//   console.log('get')
//   message.value = ''
//   error.value = ''

//   try {
//     // Vite 프록시 설정 덕분에 'http://localhost:8080'을 명시하지 않아도 됩니다.
//     const response = await axios.get('/api/getProducts')
//     console.debug('🚀 ~ testApi ~ response:', response)
//     message.value = response.data.message
//   } catch (err) {
//     console.error('API 호출 실패:', err)
//     error.value = '백엔드 연결 실패. 프록시 및 CORS 설정을 확인하세요.'
//   }
// }
</script>
