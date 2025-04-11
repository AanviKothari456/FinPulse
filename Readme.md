# 📈 FinPulse: Real-Time Niche Sector Sentiment Tracker

FinPulse is a real-time sentiment tracker for niche financial sectors (like green hydrogen, rare metals, AI chips). It scrapes Reddit and X, analyzes posts with LLM-powered sentiment engines, and generates alerts for unusual spikes in bullish or bearish chatter.

---

## 🧠 Core Features
- 🔍 Track sentiment across custom financial sectors
- 🧾 Summarized social chatter from Reddit & X
- 🧠 Sentiment classification via FinBERT or custom LLMs
- 🚨 Alerts for bullish/bearish chatter spikes
- 📱 React Native frontend for mobile use

---

## ⚙️ Tech Stack

### Backend
- Java 17 + Spring Boot
- PostgreSQL (data storage)
- JPA (ORM)
- Scheduled tasks (Spring Scheduler)

### Sentiment Engine
- Python (FastAPI) with FinBERT / VADER
- Microservice architecture (calls from Java backend)

### Frontend
- React Native + React Navigation
- Axios for HTTP
- FlatList views for sector sentiment and alerts

---

## 🧪 Local Development

### Backend Setup
```bash
cd backend
# Configure database in application.properties
./mvnw spring-boot:run
```

### PostgreSQL Setup
```bash
createdb finpulse
```
Edit `backend/src/main/resources/application.properties` with your credentials:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/finpulse
spring.datasource.username=your_user
spring.datasource.password=your_pass
```

### Frontend Setup
```bash
cd frontend
npm install
npx expo start
```

> Make sure to point `axios` to your backend IP/port in dev.

---

## 🧠 How It Works

1. Scrapers pull posts from Reddit/X tagged by sector.
2. Python NLP microservice tags sentiment + confidence.
3. Java backend stores post + flags if spikes detected.
4. React Native app displays live feed and alerts.

---

## 💡 Future Ideas
- Web frontend for dashboards
- Multi-language sentiment (Hindi, Spanish, etc.)
- User-specific push alerts
- NLP models trained on finance-specific slang

---

## 🔐 Security
- Sanitized inputs
- Rate-limited endpoints
- Encrypted user data (if login added)

---


