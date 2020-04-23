# Two player chat game 

### Definition
1. create 2 Player instances
1. one of the players should send a message to second player (let's call this player "initiator")
1. when a player receives a message, it should reply with a message that contains the received message concatenated with the value of a counter holding the number of messages this player already sent.
1. finalize the program (gracefully) after the initiator sent 10 messages and received back 10 messages (stop condition)
1. the application must be able to be run both on single thread and multi thread.

### Spec
By leveraging of the Executors, the application can run both 
on single and multi thread.
The EventBus class can has several subscribers and send the messages
to different listeners. 
It can be run from the command line.