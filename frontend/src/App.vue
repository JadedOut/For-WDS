<template>
  <div class="app-container">
    <BookRecommendation />
  </div>
</template>

<script>
import BookRecommendation from './components/BookRecommendation.vue'

export default {
  name: 'App',
  components: {
    BookRecommendation
  }
}
</script>

<style>
.app-container {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 1rem;
  background-color: var(--color-background);
}
</style>
