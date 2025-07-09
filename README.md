<<<<<<< HEAD
# 🚀 Distributed In-Memory Key-Value Store (with React Frontend + Java/Node Backend)

A fast, lightweight, distributed **In-Memory Key-Value Store** inspired by Redis.  
This project supports basic key-value operations and includes a modern React-based user interface.

---

## 🏗️ Features
- ✅ Set, Get, Delete keys in-memory.
- ✅ Fetch all stored keys.
- ✅ LRU Cache mechanism for memory optimization (Backend).
- ✅ Multi-threaded, concurrent client support (Java TCP/IP Backend).
- ✅ Modern, Dark-themed React UI with:
  - Command execution
  - Key Management
  - Key Listing & Value Fetching
  
---

## 💻 Tech Stack
| Layer        | Technology              |
|--------------|-------------------------|
| Frontend     | React, Axios, Tailwind CSS (Dark Mode) |
| Backend (API)| Node.js, Express         |
| Core Engine  | Java (TCP/IP Sockets, Multithreading, HashMap, LRU Cache) |

---

## 📝 Commands Supported
- `SET <key> <value>` → Store a key-value pair.
- `GET <key>` → Retrieve a value by key.
- `DELETE <key>` → Delete a key-value pair.
- `KEYS` → Fetch all stored keys.

---

## 📂 Project Structure
KeyValueStore/
│
├── backend/ → Node.js Backend API (connects React ↔ Java TCP)
│ ├── server.js
│ └── package.json
│
├── java-tcp-server/ → Java TCP Socket Key-Value Engine
│ ├── src/
│ │ ├── server/
│ │ └── LRUCache.java
│ └── bin/
│
├── my-key-value-ui/ → React Frontend (Modern UI)
│ ├── src/
│ │ ├── components/
│ │ ├── App.js
│ │ └── index.js
│ └── package.json
│
├── .gitignore
└── README.md


---

## ⚙️ Installation & Run

### 🔸 1. Java TCP Backend (Key-Value Engine)

cd java-tcp-server
javac -d bin src/server/*.java
java -cp bin server.KeyValueStoreServer

🔸 2. Node.js Backend (API Layer)
cd backend
npm install
node server.js

🔸 3. React Frontend (UI)
cd my-key-value-ui
npm install
npm start


🌐 Accessing The App
Open:

http://localhost:3000

=======
# key-value-store
>>>>>>> 1d1a7625ec8fd845d73ec1eb0f3869c9aad0fd79
