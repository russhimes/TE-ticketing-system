<template>
  <div id="app">
    <div id="nav">
      <the-header />
    </div>
    <router-view />
  </div>
</template>

<script>
import TheHeader from './components/TheHeader.vue'
export default {
  components: {TheHeader}
  
}
</script>

<style>
*{
  font-family: sans-serif;
}
</style>