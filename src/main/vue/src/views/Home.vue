<script setup>
import { ref, onMounted } from 'vue'

// 통계 데이터
const stats = ref({
  loaded: false,
  totalUsers: 0,
  totalProducts: 0,
  activeOrders: 0,
  totalRevenue: 0,
})

// 통계 데이터 로드
const loadStats = async () => {
  try {
    // 실제로는 API에서 가져와야 함
    // const response = await fetch('/api/stats')
    // const data = await response.json()

    // 임시 데이터
    setTimeout(() => {
      stats.value = {
        loaded: true,
        totalUsers: 1250,
        totalProducts: 450,
        activeOrders: 89,
        totalRevenue: 2450000,
      }
    }, 1000)
  } catch (error) {
    console.error('통계 데이터 로드 실패:', error)
  }
}

// 통화 포맷팅
const formatCurrency = (amount) => {
  return new Intl.NumberFormat('ko-KR', {
    style: 'currency',
    currency: 'KRW',
  }).format(amount)
}

// 컴포넌트 마운트 시 실행
onMounted(() => {
  loadStats()
})
</script>

<template>
  <div class="home">
    <!-- 히어로 섹션 -->
    <section class="hero">
      <div class="hero-content">
        <h1 class="hero-title">MyApp에 오신 것을 환영합니다</h1>
        <p class="hero-subtitle">
          Spring Boot 3 + Vue 3 + PostgreSQL + MyBatis로 구축된<br />
          현대적인 웹 애플리케이션입니다.
        </p>
        <div class="hero-buttons">
          <router-link to="/users" class="btn btn-primary">사용자 관리</router-link>
          <router-link to="/products" class="btn btn-secondary">상품 관리</router-link>
        </div>
      </div>
    </section>

    <!-- 기능 소개 섹션 -->
    <section class="features">
      <div class="container">
        <h2 class="section-title">주요 기능</h2>
        <div class="features-grid">
          <div class="feature-card">
            <div class="feature-icon">👥</div>
            <h3>사용자 관리</h3>
            <p>사용자 정보를 효율적으로 관리하고 CRUD 작업을 수행할 수 있습니다.</p>
            <router-link to="/users" class="feature-link">자세히 보기</router-link>
          </div>

          <div class="feature-card">
            <div class="feature-icon">📦</div>
            <h3>상품 관리</h3>
            <p>상품 정보를 체계적으로 관리하고 재고를 추적할 수 있습니다.</p>
            <router-link to="/products" class="feature-link">자세히 보기</router-link>
          </div>

          <div class="feature-card">
            <div class="feature-icon">📊</div>
            <h3>실시간 대시보드</h3>
            <p>실시간으로 업데이트되는 대시보드에서 현황을 한눈에 파악하세요.</p>
            <a href="#" class="feature-link">준비 중</a>
          </div>

          <div class="feature-card">
            <div class="feature-icon">🔒</div>
            <h3>보안 시스템</h3>
            <p>강력한 인증 및 권한 관리 시스템으로 데이터를 안전하게 보호합니다.</p>
            <a href="#" class="feature-link">준비 중</a>
          </div>
        </div>
      </div>
    </section>

    <!-- 통계 섹션 -->
    <section class="stats" v-if="stats.loaded">
      <div class="container">
        <h2 class="section-title">현재 현황</h2>
        <div class="stats-grid">
          <div class="stat-item">
            <div class="stat-number">{{ stats.totalUsers }}</div>
            <div class="stat-label">등록된 사용자</div>
          </div>
          <div class="stat-item">
            <div class="stat-number">{{ stats.totalProducts }}</div>
            <div class="stat-label">등록된 상품</div>
          </div>
          <div class="stat-item">
            <div class="stat-number">{{ stats.activeOrders }}</div>
            <div class="stat-label">활성 주문</div>
          </div>
          <div class="stat-item">
            <div class="stat-number">{{ formatCurrency(stats.totalRevenue) }}</div>
            <div class="stat-label">총 매출</div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<style scoped>
.home {
  min-height: calc(100vh - 60px);
}

/* 히어로 섹션 */
.hero {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  padding: 100px 0;
  text-align: center;
}

.hero-content {
  max-width: 800px;
  margin: 0 auto;
  padding: 0 20px;
}

.hero-title {
  font-size: 3.5rem;
  font-weight: 700;
  margin-bottom: 20px;
  line-height: 1.2;
}

.hero-subtitle {
  font-size: 1.3rem;
  margin-bottom: 40px;
  opacity: 0.9;
  line-height: 1.6;
}

.hero-buttons {
  display: flex;
  gap: 20px;
  justify-content: center;
  flex-wrap: wrap;
}

.btn {
  display: inline-block;
  padding: 15px 30px;
  text-decoration: none;
  border-radius: 8px;
  font-weight: 600;
  font-size: 1.1rem;
  transition: all 0.3s ease;
  border: 2px solid transparent;
}

.btn-primary {
  background-color: #fff;
  color: #667eea;
}

.btn-primary:hover {
  background-color: transparent;
  color: #fff;
  border-color: #fff;
}

.btn-secondary {
  background-color: transparent;
  color: #fff;
  border-color: #fff;
}

.btn-secondary:hover {
  background-color: #fff;
  color: #667eea;
}

/* 기능 섹션 */
.features {
  padding: 100px 0;
  background-color: #f8f9fa;
}

.section-title {
  text-align: center;
  font-size: 2.5rem;
  font-weight: 700;
  margin-bottom: 60px;
  color: #333;
}

.features-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
  gap: 30px;
  max-width: 1200px;
  margin: 0 auto;
}

.feature-card {
  background-color: white;
  padding: 40px 30px;
  border-radius: 12px;
  text-align: center;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  transition:
    transform 0.3s ease,
    box-shadow 0.3s ease;
}

.feature-card:hover {
  transform: translateY(-10px);
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.15);
}

.feature-icon {
  font-size: 3rem;
  margin-bottom: 20px;
}

.feature-card h3 {
  font-size: 1.5rem;
  font-weight: 600;
  margin-bottom: 15px;
  color: #333;
}

.feature-card p {
  color: #666;
  line-height: 1.6;
  margin-bottom: 20px;
}

.feature-link {
  color: #667eea;
  text-decoration: none;
  font-weight: 600;
  transition: color 0.3s ease;
}

.feature-link:hover {
  color: #764ba2;
}

/* 통계 섹션 */
.stats {
  padding: 80px 0;
  background-color: #fff;
}

.stats-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
}
</style>
