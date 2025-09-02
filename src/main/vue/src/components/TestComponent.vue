<template>
  <div>
    <h1>연결 테스트</h1>
    <button @click="testApi">연결 테스트</button>
    <p v-if="message">{{ message }}</p>
    <p v-if="error" class="error">{{ error }}</p>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const message = ref('')
const error = ref('')

const testApi = async () => {
  message.value = ''
  error.value = ''

  try {
    // Vite 프록시 설정 덕분에 'http://localhost:8080'을 명시하지 않아도 됩니다.
    const response = await axios.get('/api/products')
    console.debug('🚀 ~ testApi ~ response:', response)
    message.value = response.data.message
  } catch (err) {
    console.error('API 호출 실패:', err)
    error.value = '백엔드 연결 실패. 프록시 및 CORS 설정을 확인하세요.'
  }
}
</script>

<style>
.error {
  color: red;
  font-weight: bold;
}
</style>
