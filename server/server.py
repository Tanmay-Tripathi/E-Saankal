import select, socket, sys
import queue as Queue

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setblocking(0)
server.bind(('', 65432))
server.listen(5)
inputs = [server]
outputs = []
message_queues = {}

all_connections = []
all_address = []

while inputs:
    readable, writable, exceptional = select.select(inputs, outputs, inputs)
    for s in readable:
        if s is server:
            try:
                 connection, client_address = s.accept()
                 connection.setblocking(0)
                 inputs.append(connection)
                 all_connections.append(connection)
                 all_address.append(client_address)
                 global pi
                 pi = all_connections[0]
                 print("Connection has been established :" + client_address[0])
             except:
                  print('problem')
        else:
            try:
                 data = s.recv(1024).decode('utf-8')
                 if not data:
                      data = ''
                 else:   
                      print(data)
                 if data=="data":
                      print("opening")
                      my_data = "data"
                      pi.sendall(my_data.encode('utf-8'))
             except:
                  print('problem')
                 
                



    

    
