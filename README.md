Open a terminal or command prompt and navigate to the directory where your Main.java file is located. Then, compile the code using the javac command: javac Main.java

Once the code is compiled, you can run the program using the java command:java Main

Happy Game !


Follow up questions: What if this is a client-server chess game, what data should be sent back by the server to the client side?
The API should return the following information:
{
    'isValidMove' : true or false,
    'isGameOver' : true or false
}