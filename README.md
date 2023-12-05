# CPSC416Project

Our project is to build a Transaction system suing 2 Phase Commit.
We have completed all the necessary classes to be able to transact resource values from one node to another.

To run our project, please use IntelliJ to run the test through the console and you will be able to see how 
the client is able to issue a transaction from one node to another.

Below is a sample output:

<img width="542" alt="Screenshot 2023-12-04 at 4 27 55 PM" src="https://github.com/brianchang12/CPSC416Project/assets/59339384/dddf233e-4e51-4869-987c-9b347ffea310">

How this relates to our original design is that we wanted to have a transaction system where one node would transfer resources 
to another node. The client would issue the transaction and the Transaction Manager would facilitate the transaction such as to reach
consensus for the transaction to be possible. 
