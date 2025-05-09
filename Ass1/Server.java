import java.rmi.*;

public class Server {
	public static void main(String[] args) {
		try {
			ServerImplementation serverImplementation = new ServerImplementation();
			Naming.rebind("Server", serverImplementation);
			System.out.println("Server is active...");
		} catch (Exception e) {
			System.out.println("Something went wrong! " + e.getMessage());
		}
	}
}
