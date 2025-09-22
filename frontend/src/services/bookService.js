import axios from 'axios'

const API_BASE_URL = 'http://localhost:8080/api'

const bookService = {
  async getRandomBook() {
    try {
      const response = await axios.get(`${API_BASE_URL}/random-book`)
      return response.data
    } catch (error) {
      console.error('Error fetching random book:', error)
      throw new Error('Failed to fetch book recommendation')
    }
  }
}

export default bookService