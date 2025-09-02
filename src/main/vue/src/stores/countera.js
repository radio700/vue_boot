import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const getQwer = defineStore('qwer', () => {
  const count = ref(0)
  const doubleCount = computed(() => count.value * 2)
  function increment() {
    count.value++
  }

  return { count, doubleCount, increment }
})

export const useCounterStores = defineStore('counter', {
  state: () => ({
    count: 0,
  }),
  actions: {
    increment() {
      this.count++
    },
    decrement() {
      this.count--
    },
    reset() {
      this.count = 0
    },
  },
  getters: {
    doubleCount: (state) => state.count * 2,
  },
})
