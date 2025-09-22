# Book Recommendation App

Provides random book recommendations from the books I've read each time you click the "Get Random Book" button

## Tech Stack

- **Frontend**: Vue 3 + Vite
- **Backend**: Spring Boot + Maven
- **Architecture**: REST API with MVC pattern

## Prerequisites

- Java 17+
- Node.js 16+
- Maven 3.6+

## Setup & Run

1. **Start backend:**
```bash
cd backend/bookshelf
mvn spring-boot:run
```
Backend runs on: `http://localhost:8080`

2. **Start frontend:**
```bash
cd frontend
npm install
npm run dev
```
Frontend runs on: `http://localhost:5173`

## API Endpoints

- `GET /api/random-book` - Get random book recommendation

