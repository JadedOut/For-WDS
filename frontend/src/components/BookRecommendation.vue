<template>
    <div class="book-recommendation">
      <h1>My Book Shelf</h1>
      <p class="subtitle">Get a random book recommendation from books I've read</p>
      
      <button 
        @click="getRandomBook" 
        :disabled="loading"
        class="recommendation-btn"
      >
        {{ loading ? 'Getting Book...' : 'Get Random Book' }}
      </button>
      
      <div v-if="error" class="error-message">
        <p>{{ error }}</p>
        <button @click="clearError" class="retry-btn">Try Again</button>
      </div>
      
      <div v-if="currentBook && !loading" class="book-card">
        <h2>{{ currentBook.title }}</h2>
        <p class="author">by {{ currentBook.author }}</p>
        <div class="book-details">
          <span class="rating">Rating: {{ currentBook.rating }}/10</span>
        </div>
        <div class="book-review">
          <p class="review">Review: {{ currentBook.review }}</p>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import bookService from '@/services/bookService.js'
  
  export default {
    name: 'BookRecommendation',
    data() {
      return {
        currentBook: null,
        loading: false,
        error: null
      }
    },
    methods: {
      async getRandomBook() {
        this.loading = true
        this.error = null
        
        try {
          this.currentBook = await bookService.getRandomBook()
        } catch (error) {
          this.error = error.message
          this.currentBook = null
        } finally {
          this.loading = false
        }
      },
      
      clearError() {
        this.error = null
      }
    }
  }
  </script>
  
  <style scoped>
  .book-recommendation {
    max-width: 40rem;
    margin: 0 auto;
    padding: 2rem;
    text-align: center;
  }
  
  h1 {
    color: var(--color-heading);
    margin-bottom: 0.5rem;
  }
  
  .subtitle {
    color: var(--color-text);
    opacity: 0.7;
    margin-bottom: 2rem;
  }
  
  .recommendation-btn {
    background-color: hsla(204, 70%, 53%, 1);
    color: var(--vt-c-white);
    border: none;
    padding: 1rem 2rem;
    font-size: 1.1rem;
    border-radius: 0.5rem;
    cursor: pointer;
    transition: all 0.3s ease;
  }
  
  .recommendation-btn:hover:not(:disabled) {
    background-color: hsla(204, 70%, 43%, 1);
    transform: translateY(-1px);
  }
  
  .recommendation-btn:disabled {
    background-color: var(--color-border);
    cursor: not-allowed;
    transform: none;
  }
  
  .error-message {
    background-color: hsla(0, 74%, 57%, 1);
    color: var(--vt-c-white);
    padding: 1rem;
    border-radius: 0.5rem;
    margin: 1rem 0;
  }
  
  .retry-btn {
    background-color: var(--vt-c-white);
    color: hsla(0, 74%, 57%, 1);
    border: none;
    padding: 0.5rem 1rem;
    border-radius: 0.25rem;
    cursor: pointer;
    margin-top: 0.5rem;
    transition: all 0.2s ease;
  }
  
  .retry-btn:hover {
    background-color: var(--color-background-soft);
  }
  
  .book-card {
    background-color: var(--color-background-soft);
    border: 1px solid var(--color-border);
    border-radius: 0.75rem;
    padding: 2rem;
    margin-top: 2rem;
    text-align: left;
    transition: border-color 0.2s ease;
  }
  
  .book-card:hover {
    border-color: var(--color-border-hover);
  }
  
  .book-card h2 {
    color: var(--color-heading);
    margin-bottom: 0.5rem;
    font-size: 1.5rem;
  }
  
  .author {
    color: var(--color-text);
    opacity: 0.8;
    font-style: italic;
    margin-bottom: 1rem;
    font-size: 1.1rem;
  }
  
  .book-details {
    margin-bottom: 1rem;
  }
  
  .rating {
    background-color: hsla(145, 63%, 42%, 1);
    color: var(--vt-c-white);
    padding: 0.25rem 0.75rem;
    border-radius: 1.25rem;
    font-size: 0.9rem;
    font-weight: bold;
    display: inline-block;
  }
  
  .book-review {
    margin-top: 1.5rem;
    padding-top: 1rem;
    border-top: 1px solid var(--color-border);
  }
  
  .review {
    color: var(--color-text);
    opacity: 0.85;
    font-size: 0.95rem;
    line-height: 1.6;
    margin: 0;
    font-style: italic;
    text-align: left;
  }
  </style>