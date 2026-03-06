🤖 Spring Boot AI Chatbot Microservice

An AI-powered chatbot built using Java Spring Boot and the OpenAI API.
This project demonstrates how to integrate Large Language Models (LLMs) into a Spring Boot microservice architecture.

It provides a REST API that accepts a user message and returns an AI-generated response.

🚀 Features

✔ AI-powered chatbot using OpenAI API
✔ Spring Boot REST Microservice
✔ Clean microservice architecture
✔ Environment variable configuration for API keys
✔ Postman testing support
✔ Easy integration with frontend apps (Angular / React)

🏗 Architecture
User / Client
     |
     v
REST API (Spring Boot)
     |
     v
OpenAI API
     |
     v
AI Generated Response
🛠 Tech Stack
Technology	Description
Java	Backend programming language
Spring Boot	Microservice framework
OpenAI API	AI / LLM integration
Maven	Dependency management
REST API	Communication layer
Postman	API testing
GitHub	Version control
📂 Project Structure
springboot-ai-chatbot
│
├── src
│   ├── main
│   │   ├── java/com/example/chatbot
│   │   │   ├── controller
│   │   │   │   └── ChatController.java
│   │   │   ├── service
│   │   │   │   └── ChatService.java
│   │   │   └── SpringbootAiChatbotApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│
├── pom.xml
└── README.md


⚙️ Setup Instructions

1️⃣ Clone the Repository
git clone https://github.com/DilliRajan/springboot-ai-chatbot
cd springboot-ai-chatbot

2️⃣ Configure OpenAI API Key

Create an environment variable:

Linux / Mac

export OPENAI_API_KEY=your_api_key_here

Windows

set OPENAI_API_KEY=your_api_key_here

⚠️ Never commit API keys to GitHub.

3️⃣ Build the Project
mvn clean install

4️⃣ Run the Application
mvn spring-boot:run

Application will start on:

http://localhost:8080
📡 API Endpoint
Chat with AI

POST

http://localhost:8080/api/chat
Request
{
 "message": "Explain microservices architecture"
}
Response
{
 "response": "Microservices architecture is a design approach where applications are built as small independent services..."
}
🧪 Testing with Postman

Open Postman

Create POST request

URL:

http://localhost:8080/api/chat

Body → JSON

{
 "message": "What is Spring Boot?"
}
🔐 Security Best Practices

✔ Use environment variables for API keys
✔ Do not commit secrets to GitHub
✔ Use .gitignore for sensitive files

📌 Future Improvements

• Angular / React chat UI
• RAG (Retrieval Augmented Generation) integration
• Chat history with database
• Docker containerization
• Kubernetes deployment
• AI log analysis module

👨‍💻 Author

Dilli Rajan

Java Full Stack Developer | Microservices | AI Integration | Cloud Native

⭐ Support

If you like this project, please give it a star ⭐ on GitHub.
