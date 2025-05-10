import java.rmi.*;

public class Server {
	public static void main(String[] args) {
		try {
			// Create an instance of the class that implements the remote interface
			ServerImplementation serverImplementation = new ServerImplementation();

			// Bind the remote object to the RMI registry using the name "Server"
			Naming.rebind("Server", serverImplementation);

			System.out.println("Server is active...");
		} catch (Exception e) {
			System.out.println("Something went wrong! " + e.getMessage());
		}
	}
}
