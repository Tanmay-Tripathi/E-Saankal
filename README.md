# E-Saankal

Designed and developed an Android and IoT project that enables users to open a solenoid door lock through a mobile application.

Implemented a solenoid lock control system using a Raspberry Pi and established a communication channel between the Pi and a
mobile application through socket communication.


# Android
Application was build in JAVA & XML. The UI was kept really simple and Java concepts of Threading and Socket programming were used.

# Backend
For the backend, we implemented a server-client model using sockets. We created a central server that connected our client application to the door lock. Whenever a request was made from the client application, a signal was sent to the Raspberry Pi to open the door lock upon successful verification.

# hardware
For the hardware part, we used a Raspberry Pi along with a solenoid lock. The Raspberry Pi waited for a signal from the server, and on successful reception of the signal, it sent a signal to the solenoid lock to open it. The Raspberry Pi could be replaced with a cheaper NodeMCU in future updates of the project.
