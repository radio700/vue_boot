<template>
  <div class="instagram-login-container">
    <div class="left-panel">
<!--      <img src="https://via.placeholder.com/400" alt="Instagram Showcase" class="showcase-image">-->
    </div>

    <div class="right-panel">
      <div class="login-box">
        <h1 class="logo">Instagram</h1>

        <form @submit.prevent="login">
          <input
            type="text"
            v-model="username"
            placeholder="전화번호, 사용자 이름 또는 이메일"
            class="input-field"
          >
          <input
            type="password"
            v-model="password"
            placeholder="비밀번호"
            class="input-field"
          >
          <button type="submit" class="login-button">
            로그인
          </button>
        </form>

        <div class="divider">
          <span>또는</span>
        </div>

        <button class="facebook-login-button">
          <i class="fab fa-facebook-square"></i> Facebook으로 로그인
        </button>

        <a href="#" class="forgot-password">
          비밀번호를 잊으셨나요?
        </a>
      </div>

      <div class="signup-box">
        <p>계정이 없으신가요? <a href="#" class="signup-link">가입하기</a></p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from "axios";

const username = ref('');
const password = ref('');

const login = async () => {
  try {
    const res = await axios.post("/api/login", {
      username: username.value,
      password: password.value,
    })
      .then(res => {
        console.log(res.data);
        if (res && res.data && res.data.token) {
          localStorage.setItem('token', res.data.token);
          axios.defaults.headers.common['Authorization'] = 'Bearer ' + res.data.token;
        }
        // window.location.href = '/';
      })
    // message.value = "로그인 성공";
  } catch (err) {
    // message.value = "로그인 실패";
  }
};

</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap');

.instagram-login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #fafafa;
  font-family: 'Roboto', sans-serif;
  color: #262626;
}

.left-panel {
  display: none; /* 모바일에서는 숨김 */
}

.right-panel {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 350px;
}

.login-box, .signup-box {
  background-color: #fff;
  border: 1px solid #dbdbdb;
  border-radius: 1px;
  padding: 20px;
  width: 100%;
  box-sizing: border-box;
}

.login-box {
  margin-bottom: 10px;
}

.logo {
  font-family: 'Billabong', cursive; /* Instagram 폰트를 위한 예시. 실제로는 별도 폰트 파일을 사용해야 합니다. */
  font-size: 52px;
  font-weight: 400;
  text-align: center;
  margin-top: 20px;
  margin-bottom: 20px;
}

.input-field {
  width: 100%;
  padding: 10px;
  margin-bottom: 6px;
  border: 1px solid #dbdbdb;
  background-color: #fafafa;
  border-radius: 3px;
  box-sizing: border-box;
}

.login-button {
  width: 100%;
  padding: 8px;
  background-color: #0095f6;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-weight: 600;
}

.divider {
  display: flex;
  align-items: center;
  text-align: center;
  margin: 15px 0;
}

.divider::before, .divider::after {
  content: '';
  flex: 1;
  border-bottom: 1px solid #dbdbdb;
}

.divider span {
  padding: 0 10px;
  font-size: 13px;
  color: #8e8e8e;
}

.facebook-login-button {
  width: 100%;
  padding: 8px;
  background-color: transparent;
  color: #385185;
  border: none;
  cursor: pointer;
  font-weight: 600;
  margin-top: 10px;
}

.forgot-password {
  display: block;
  text-align: center;
  margin-top: 15px;
  font-size: 12px;
  color: #00376b;
  text-decoration: none;
}

.signup-box p {
  text-align: center;
  font-size: 14px;
}

.signup-link {
  color: #0095f6;
  text-decoration: none;
  font-weight: 600;
}

/* 데스크탑 환경에서 좌측 패널 보이기 */
@media (min-width: 875px) {
  .instagram-login-container {
    justify-content: center;
    gap: 32px;
  }
  .left-panel {
    display: block;
  }
  .showcase-image {
    width: 400px;
    height: auto;
  }
}
</style>
