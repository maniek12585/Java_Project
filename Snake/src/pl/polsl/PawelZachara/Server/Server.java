//package pl.polsl.PawelZachara.Server;
//
//import java.net.*;
//import java.io.*;
//
///**
// * @author Paweł Zachara
// * @version 1.3
// * 
// * Snake
// */
//
//public class Server implements Closeable {
//
//    /**
//     * port number
//     */
//    final private int PORT = 8888;
//
//    /**
//     * field represents the socket waiting for client connections
//     */
//    private ServerSocket serverSocket;
//
//    /**
//     * Creates the server socket
//     *
//     * IOException when port is already bind
//     */
//    Server() throws IOException {
//        serverSocket = new ServerSocket(PORT);
//    }
//
//    /**
//     * The main application method
//     * @param args
//     */
//    public static void main(String args[]) {
//
//        try (Server tcpServer = new Server()) {
//            System.out.println("Server started");
//            while (true) {
//                Socket socket = tcpServer.serverSocket.accept();
//                try (SingleService singleService = new SingleService(socket)) {
//                    singleService.realize();
//                } catch (IOException e) {
//                    System.err.println(e.getMessage());
//                }
//            }
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//    }
//
//    @Override
//    public void close() throws IOException {
//        if (serverSocket != null) {
//            serverSocket.close();
//        }
//    }
//}
//
///**
// * The server class servicing a single connection
// */
//class SingleService implements Closeable {
//
//    /**
//     * socket representing connection to the client
//     */
//    private Socket socket;
//    /**
//     * buffered input character stream
//     */
//    private BufferedReader input;
//    /**
//     * Formatted output character stream
//     */
//    private PrintWriter output;
//
//    /**
//     * The constructor of instance of the SingleService class. Use the socket as
//     * a parameter.
//     *
//     * @param socket socket representing connection to the client
//     */
//    public SingleService(Socket socket) throws IOException {
//        this.socket = socket;
//        output = new PrintWriter(
//                new BufferedWriter(
//                        new OutputStreamWriter(
//                                socket.getOutputStream())), true);
//        input = new BufferedReader(
//                new InputStreamReader(
//                        socket.getInputStream()));
//    }
//
//    /**
//     * Realizes the service
//     */
//    public void realize() {
//        try {            
//            output.println("Press 'enter' to start");
//            if(true){
//                String start;
//                start = input.readLine();
//                output.println("Welcome to Java Sever");
//            }
//            while (true) {
//                HandleData handleDataFromServer = new HandleData();
//                String str = input.readLine();
//                //output.println(str);
//                if (str.toUpperCase().equals("QUIT")) {
//                    break;
//                }
//                if (str.toUpperCase().equals("HELP")) {
//                    output.println("Just write arabic number in range 1-3999");
//                }
//
//                System.out.println("Client sent: " + str);
////                System.out.println(outputString);
////                System.out.println(outputHistoryString);
//
//                snake.setInputPackage
//            }
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        } finally {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                System.err.println(e.getMessage());
//            }
//        }
//    }
//
//    @Override
//    public void close() throws IOException {
//        if (socket != null) {
//            socket.close();
//        }
//    }
//}
//
