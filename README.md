# 🤖 AI Document Q&A System (RAG-based)

An end-to-end AI-powered application that allows users to upload documents and ask questions using Retrieval-Augmented Generation (RAG).

Built using **React, Spring Boot, FastAPI, LangChain, and OpenAI**.

---

## 🚀 Features

- 📄 Upload PDF documents
- 💬 Ask questions based on uploaded content
- 🧠 AI-powered answers using LLMs
- 🔍 Semantic search using vector embeddings (FAISS)
- ⚡ Microservices architecture (Java + Python)
- 🌐 Interactive chat UI (React)

---

## 🧱 Tech Stack

### Frontend
- React.js
- Axios

### Backend
- Java (Spring Boot)
- REST APIs

### AI Service
- Python (FastAPI)
- LangChain
- OpenAI (LLM + Embeddings)
- FAISS (Vector Database)

---

## 🏗️ Architecture


React UI (Port 3000)
↓
Spring Boot Backend (Port 8080)
↓
Python FastAPI AI Service (Port 8000)
↓
OpenAI + FAISS (RAG Pipeline)


---

## 📁 Project Structure


ai-doc-rag-system/
├── frontend/ # React UI
├── backend/ # Spring Boot API
├── ai-service/ # FastAPI + LangChain
└── README.md


---

## ⚙️ Setup Instructions

### 🔹 1. Clone Repository


git clone https://github.com/your-username/ai-doc-rag-system.git

cd ai-doc-rag-system


---

### 🔹 2. Setup AI Service (Python)


cd ai-service
python -m venv venv
venv\Scripts\activate # Windows
pip install -r requirements.txt


#### 👉 Add OpenAI API Key

Create `.env` file:


OPENAI_API_KEY=your_api_key_here


#### Run AI service:


uvicorn main:app --reload


Runs on: http://localhost:8000

---

### 🔹 3. Setup Backend (Spring Boot)


cd backend
./mvnw spring-boot:run


Runs on: http://localhost:8080

---

### 🔹 4. Setup Frontend (React)


cd frontend
npm install
npm start


Runs on: http://localhost:3000

---

## 🧪 How to Use

1. Open the frontend (http://localhost:3000)
2. Upload a PDF document
3. Ask questions in the chat interface
4. Get AI-generated answers based on document content

---

## 🧠 How It Works (RAG Pipeline)

1. Document is uploaded and processed
2. Text is split into chunks
3. Embeddings are created using OpenAI
4. Stored in FAISS vector database
5. Query is converted to embedding
6. Relevant chunks are retrieved
7. LLM generates final answer

---

## 📌 Future Improvements

- Multi-document support
- User authentication (JWT)
- Chat history persistence (PostgreSQL)
- AWS deployment (S3 + EC2)
- Streaming responses (real-time typing)
- Vector DB upgrade (Pinecone / Weaviate)

---

## 🧑‍💻 Author

**Shriza Som**  
- Software Engineer @ Accenture  
- Java Backend + AI Enthusiast  

---
