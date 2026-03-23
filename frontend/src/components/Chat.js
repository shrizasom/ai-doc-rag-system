import React, { useState } from "react";
import axios from "axios";

const Chat = () => {
  const [question, setQuestion] = useState("");
  const [messages, setMessages] = useState([]);
  const [loading, setLoading] = useState(false);

  // 🔹 Send message
  const sendMessage = async () => {
    if (!question.trim()) return;

    const userMsg = { sender: "user", text: question };
    setMessages((prev) => [...prev, userMsg]);

    setLoading(true);

    try {
      const res = await axios.post("http://localhost:8080/api/ask", {
        question: question,
      });

      const botMsg = {
        sender: "bot",
        text: res.data.answer,
      };

      setMessages((prev) => [...prev, botMsg]);
    } catch (err) {
      setMessages((prev) => [
        ...prev,
        { sender: "bot", text: "⚠️ Error getting response" },
      ]);
    }

    setLoading(false);
    setQuestion("");
  };

  // 🔹 Upload file
  const handleUpload = async (e) => {
    const file = e.target.files[0];
    if (!file) return;

    const formData = new FormData();
    formData.append("file", file);

    try {
      await axios.post(
        "http://localhost:8080/api/document/upload",
        formData
      );

      setMessages((prev) => [
        ...prev,
        { sender: "bot", text: "✅ Document uploaded successfully!" },
      ]);
    } catch (err) {
      setMessages((prev) => [
        ...prev,
        { sender: "bot", text: "⚠️ Upload failed" },
      ]);
    }
  };

  return (
    <div className="chat-container">
      <h2>🤖 AI Document Chat</h2>

      {/* Upload */}
      <div className="upload-section">
        <input type="file" onChange={handleUpload} />
      </div>

      {/* Chat Box */}
      <div className="chat-box">
        {messages.map((msg, index) => (
          <div key={index} className={`chat-bubble ${msg.sender}`}>
            {msg.text}
          </div>
        ))}

        {loading && <div className="chat-bubble bot">Typing...</div>}
      </div>

      {/* Input */}
      <div className="input-area">
        <input
          type="text"
          placeholder="Ask something..."
          value={question}
          onChange={(e) => setQuestion(e.target.value)}
          onKeyDown={(e) => e.key === "Enter" && sendMessage()}
        />
        <button onClick={sendMessage}>Send</button>
      </div>
    </div>
  );
};

export default Chat;