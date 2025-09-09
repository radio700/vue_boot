import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
// import vueDevTools from 'vite-plugin-vue-devtools'

export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080', // Spring Boot 백엔드 서버 주소
        changeOrigin: true, // 대상 서버의 호스트 헤더를 변경
        rewrite: (path) => path.replace(/^\/api/, ''), // 요청 경로에서 /api 제거
        withCredentials: true // 세션 쿠키를 주고받기 위해 필요
      },
    },
  },
})
