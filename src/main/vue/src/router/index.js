import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
// import TestComponent from '@/components/TestComponent.vue'
// import Home from '@/views/Home.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue'),
    },
    // {
    //   path: '/products',
    //   name: 'products',
    //   component: TestComponent,
    // },
    // {
    //   path: '/home',
    //   name: 'home',
    //   component: Home,
    // },
  ],
})

export default router
