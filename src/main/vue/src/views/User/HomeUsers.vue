<template>
  <div>
    <p>Count : {{ counter.count }}</p>
    <button @click="counter.increment">increment</button>
    <button @click="counter.decrement">decrement</button>
    <button @click="counter.reset">reset</button>
    <p>doubleCount : {{ counter.doubleCount }}</p>
  </div>
  <div>
    <h1>count : {{ asdf.count }}</h1>
    <button @click="asdf.doubleCount">double</button>
    <button @click="asdf.increment()">incre</button>
  </div>
  <div>
    <input type="text" @input="handleInput" />
    <p>값 : {{ message }}</p>
  </div>
  <div>
    <p v-if="isVisible">{{ isVisible }}</p>
    <button @click="changeState">chage</button>
  </div>
</template>

<script setup>
import { getQwer, useCounterStores } from '@/stores/countera'
import { ref } from 'vue'

const counter = useCounterStores()
const asdf = getQwer()

const message = ref('')

const handleInput = (event) => {
  console.log('🚀 ~ handleInput ~ event:', event.value)
  console.log('🚀 ~ handleInput ~ event.target:', event.target.value)
  event.value = event.target.value
}

const isVisible = ref(true)

function changeState() {
  // alert(isVisible.value)
  isVisible.value = !isVisible.value
  console.log('🚀 ~ changeState ~ isVisible.value:', isVisible)
}
</script>
