package Properties;

import java.net.*;
import java.io.*;
import pl.polsl.PawelZachara.NumberConversion.Server.HandleInput;

/**
 * @author Paweł Zachara
 * @version 1.0
 * 
 * Roman numerals to arabic calculator
 */

/**
 * class that implements server 
 */
public class Server implements Closeable {

    /**
     * port number
     */
    final private int PORT = 8888;

    /**
     * field represents the socket waiting for client connections
     */
    private ServerSocket serverSocket;

    /**
     * Creates the server socket
     *
     * IOException when port is already bind
     */
    Server() throws IOException {
        serverSocket = new ServerSocket(PORT);
    }

    /**
     * The main application method
     * @param args
     */
    public static void main(String args[]) {

        try (Server tcpServer = new Server()) {
            System.out.println("Server started");
            while (true) {
                Socket socket = tcpServer.serverSocket.accept();
                try (SingleService singleService = new SingleService(socket)) {
                    singleService.realize();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void close() throws IOException {
        if (serverSocket != null) {
            serverSocket.close();
        }
    }
}

/**
 * The server class servicing a single connection
 */
class SingleService implements Closeable {

    /**
     * socket representing connection to the client
     */
    private Socket socket;
    /**
     * buffered input character stream
     */
    private BufferedReader input;
    /**
     * Formatted output character stream
     */
    private PrintWriter output;

    /**
     * The constructor of instance of the SingleService class. Use the socket as
     * a parameter.
     *
     * @param socket socket representing connection to the client
     */
    public SingleService(Socket socket) throws IOException {
        this.socket = socket;
        output = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream())), true);
        input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
    }

    /**
     * Realizes the service
     */
    public void realize() {
        try {            
            output.println("Press 'enter' to start");
            if(true){
                String start;
                start = input.readLine();
                output.println("Welcome to Java Sever");
            }
            while (true) {
                HandleInput handleInput = new HandleInput();
                String str = input.readLine();
                if (str.toUpperCase().equals("QUIT")) {
                    break;
                }
                else if (str.toUpperCase().equals("HELP")) {
                    output.println("Write roman number in range I to MMMMCMXCIX");
                }
                else{
                    String outputString = handleInput.handleData(str);
                    String outputHistoryString = handleInput.handleHistory(str);
                    output.println(outputString);
                }
                output.println("The server accepted the command correctly");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}
