import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
// import TestComponent from '@/components/TestComponent.vue'
// import Home from '@/views/Home.vue'
import HomeUsers from '@/views/User/HomeUsers.vue'
import UserRegister from '@/views/User/UserRegister.vue'
import LoginView from '@/views/LoginView.vue'

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
    {
      path: '/users',
      name: 'HomeUsers',
      component: HomeUsers,
    },
    {
      path: '/signup',
      name: 'UserRegister',
      component: UserRegister,
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
    },
    {
      path: '/products',
      name: 'products',
      component: LoginView,
    },
    // {
    //   path: '/home',
    //   name: 'home',
    //   component: Home,
    // },
  ],
})

export default router
