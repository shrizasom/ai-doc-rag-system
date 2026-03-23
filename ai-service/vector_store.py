from langchain_community.document_loaders import PyPDFLoader
from langchain_text_splitters import CharacterTextSplitter
from langchain_community.vectorstores import FAISS
from langchain_openai import OpenAIEmbeddings

def process_document(file_path):
    # Load PDF
    loader = PyPDFLoader(file_path)
    documents = loader.load()
    # Split text
    splitter = CharacterTextSplitter(chunk_size=500, chunk_overlap=50)
    docs = splitter.split_documents(documents)
    # Embeddings
    embeddings = OpenAIEmbeddings()
    # Vector DB
    db = FAISS.from_documents(docs, embeddings)
    # Save
    db.save_local("faiss_index")