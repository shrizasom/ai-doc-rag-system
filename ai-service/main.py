from fastapi import FastAPI
from rag_pipeline import get_answer
import os
from dotenv import load_dotenv
from vector_store import process_document

load_dotenv()
OPENAI_API_KEY = os.getenv("OPENAI_API_KEY")

app = FastAPI()

@app.post("/ask")
def ask(request: dict):
    question = request["question"]
    answer = get_answer(question)
    return {"answer": answer}

@app.post("/upload")
def upload(request: dict):
    file_path = request["file_path"]
    process_document(file_path)
    return {"status": "processed"}