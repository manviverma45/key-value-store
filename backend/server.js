const net = require('net');
const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const app = express();
const PORT = 5001;

app.use(cors());
app.use(bodyParser.json());

const socket = new net.Socket();
socket.connect(12345, '127.0.0.1', () => {
console.log('Connected to Java TCP server');
});

app.post('/command', (req, res) => {
  const command = req.body.command;
  if (!command) {
  return res.status(400).json({ response: 'No command provided' });
  }

  socket.write(command + '\n');
  socket.once('data', (data) => {
  res.json({ response: data.toString().trim() });
  });
});


app.listen(PORT, () => {
console.log(`Backend API running at http://localhost:${PORT}`);
});
