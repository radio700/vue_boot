<!-- src/components/common/NavBar.vue -->
<template>
  <nav class="navbar">
    <div class="nav-container">
      <!-- 로고 영역 -->
      <div class="nav-logo">
        <router-link to="/" class="logo-link">
          <!-- <img src="/logo.svg" alt="Logo" class="logo-image" /> -->
          <span class="logo-text">MyApp</span>
        </router-link>
      </div>

      <!-- 메뉴 영역 -->
      <div class="nav-menu" :class="{ active: isMenuOpen }">
        <router-link
          to="/"
          class="nav-link"
          :class="{ active: $route.path === '/' }"
          @click="closeMenu"
        >
          홈dd
        </router-link>

        <router-link
          to="/users"
          class="nav-link"
          :class="{ active: $route.path === '/users' }"
          @click="closeMenu"
        >
          사용자 관리
        </router-link>

        <router-link
          to="/products"
          class="nav-link"
          :class="{ active: $route.path === '/products' }"
          @click="closeMenu"
        >
          상품 관리
        </router-link>

        <router-link
          to="/about"
          class="nav-link"
          :class="{ active: $route.path === '/about' }"
          @click="closeMenu"
        >
          소개
        </router-link>

        <!-- 드롭다운 메뉴 예시 -->
        <div class="dropdown" @mouseover="showDropdown" @mouseleave="hideDropdown">
          <button class="nav-link dropdown-btn">더보기f ▼</button>
          <div class="dropdown-content" :class="{ show: isDropdownOpen }">
            <router-link to="/settings" @click="closeMenu">설정</router-link>
            <router-link to="/help" @click="closeMenu">도움말</router-link>
            <router-link to="/contact" @click="closeMenu">연락처</router-link>
          </div>
        </div>
      </div>

      <!-- 사용자 정보 영역 -->
      <div class="nav-user">
        <div v-if="isLoggedIn" class="user-info">
          <img :src="user.avatar || '/default-avatar.png'" alt="User" class="user-avatar" />
          <span class="user-name">{{ user.name }}</span>
          <button @click="logout" class="logout-btn">로그아웃</button>
        </div>
        <div v-else class="auth-buttons">
          <router-link to="/login" class="login-btn">로그인</router-link>
          <router-link to="/signup" class="signup-btn">회원가입</router-link>
        </div>
      </div>

      <!-- 모바일 햄버거 메뉴 -->
      <div class="nav-toggle" @click="toggleMenu">
        <div class="hamburger" :class="{ active: isMenuOpen }">
          <span></span>
          <span></span>
          <span></span>
        </div>
      </div>
    </div>
  </nav>
</template>

<script setup>
import { ref, computed, onMounted, onUnmounted } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

// 반응형 데이터
const isMenuOpen = ref(false)
const isDropdownOpen = ref(false)
const user = ref({
  name: '김철수',
  avatar: null,
})

// 계산된 속성
const isLoggedIn = computed(() => {
  // 실제로는 Vuex/Pinia 스토어에서 가져와야 함
  return !!user.value.name
})

// 메뉴 토글 (모바일)
const toggleMenu = () => {
  isMenuOpen.value = !isMenuOpen.value
}

// 메뉴 닫기
const closeMenu = () => {
  isMenuOpen.value = false
  isDropdownOpen.value = false
}

// 드롭다운 표시
const showDropdown = () => {
  isDropdownOpen.value = true
}

// 드롭다운 숨기기
const hideDropdown = () => {
  setTimeout(() => {
    isDropdownOpen.value = false
  }, 200)
}

// 로그아웃
const logout = () => {
  // 실제 로그아웃 로직 구현
  user.value = {}
  localStorage.removeItem('token')
  router.push('/login')
}

// 창 크기 변경 시 메뉴 닫기
const handleResize = () => {
  if (window.innerWidth > 768) {
    isMenuOpen.value = false
  }
}

onMounted(() => {
  window.addEventListener('resize', handleResize)
})

onUnmounted(() => {
  window.removeEventListener('resize', handleResize)
})
</script>

<style scoped>
.navbar {
  background-color: #ffffff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
  height: 60px;
}

.nav-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 100%;
}

/* 로고 영역 */
.nav-logo {
  display: flex;
  align-items: center;
}

.logo-link {
  display: flex;
  align-items: center;
  text-decoration: none;
  color: #333;
}

.logo-image {
  height: 40px;
  margin-right: 10px;
}

.logo-text {
  font-size: 24px;
  font-weight: bold;
  color: #007bff;
}

/* 메뉴 영역 */
.nav-menu {
  display: flex;
  align-items: center;
  gap: 30px;
}

.nav-link {
  text-decoration: none;
  color: #333;
  font-weight: 500;
  padding: 8px 16px;
  border-radius: 4px;
  transition: all 0.3s ease;
  position: relative;
}

.nav-link:hover {
  color: #007bff;
  background-color: #f8f9fa;
}

.nav-link.active {
  color: #007bff;
  background-color: #e3f2fd;
}

/* 드롭다운 */
.dropdown {
  position: relative;
}

.dropdown-btn {
  background: none;
  border: none;
  cursor: pointer;
  font-size: 16px;
}

.dropdown-content {
  position: absolute;
  top: 100%;
  left: 0;
  background-color: white;
  min-width: 160px;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
  border-radius: 4px;
  opacity: 0;
  visibility: hidden;
  transform: translateY(-10px);
  transition: all 0.3s ease;
}

.dropdown-content.show {
  opacity: 1;
  visibility: visible;
  transform: translateY(0);
}

.dropdown-content a {
  display: block;
  padding: 12px 16px;
  text-decoration: none;
  color: #333;
  border-bottom: 1px solid #eee;
}

.dropdown-content a:hover {
  background-color: #f8f9fa;
}

.dropdown-content a:last-child {
  border-bottom: none;
}

/* 사용자 정보 영역 */
.nav-user {
  display: flex;
  align-items: center;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 10px;
}

.user-avatar {
  width: 32px;
  height: 32px;
  border-radius: 50%;
  object-fit: cover;
}

.user-name {
  font-weight: 500;
  color: #333;
}

.logout-btn {
  background-color: #dc3545;
  color: white;
  border: none;
  padding: 6px 12px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 14px;
  transition: background-color 0.3s ease;
}

.logout-btn:hover {
  background-color: #c82333;
}

.auth-buttons {
  display: flex;
  gap: 10px;
}

.login-btn,
.signup-btn {
  padding: 8px 16px;
  text-decoration: none;
  border-radius: 4px;
  font-weight: 500;
  transition: all 0.3s ease;
}

.login-btn {
  color: #007bff;
  border: 2px solid #007bff;
  background-color: transparent;
}

.login-btn:hover {
  background-color: #007bff;
  color: white;
}

.signup-btn {
  background-color: #007bff;
  color: white;
  border: 2px solid #007bff;
}

.signup-btn:hover {
  background-color: #0056b3;
  border-color: #0056b3;
}

/* 햄버거 메뉴 (모바일) */
.nav-toggle {
  display: none;
  cursor: pointer;
}

.hamburger {
  display: flex;
  flex-direction: column;
  width: 25px;
  height: 18px;
  justify-content: space-between;
}

.hamburger span {
  display: block;
  height: 3px;
  width: 100%;
  background-color: #333;
  border-radius: 1px;
  transition: all 0.3s ease;
}

.hamburger.active span:nth-child(1) {
  transform: rotate(45deg) translate(6px, 6px);
}

.hamburger.active span:nth-child(2) {
  opacity: 0;
}

.hamburger.active span:nth-child(3) {
  transform: rotate(-45deg) translate(6px, -6px);
}

/* 반응형 디자인 */
@media (max-width: 768px) {
  .nav-toggle {
    display: block;
  }

  .nav-menu {
    position: fixed;
    top: 60px;
    left: -100%;
    width: 100%;
    height: calc(100vh - 60px);
    background-color: white;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    padding-top: 50px;
    transition: left 0.3s ease;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }

  .nav-menu.active {
    left: 0;
  }

  .nav-link {
    padding: 15px 0;
    font-size: 18px;
    width: 200px;
    text-align: center;
  }

  .dropdown-content {
    position: static;
    box-shadow: none;
    background-color: #f8f9fa;
    opacity: 1;
    visibility: visible;
    transform: none;
    margin-top: 10px;
  }

  .nav-user {
    display: none;
  }
}

@media (max-width: 480px) {
  .nav-container {
    padding: 0 15px;
  }

  .logo-text {
    font-size: 20px;
  }

  .logo-image {
    height: 30px;
  }
}
</style>
