import java.rmi.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			// Define the URL where the remote object (Server) is registered
			String serverUrl = "rmi://localhost/Server";

			// Look up the remote object in the RMI registry and cast it to the server interface
			ServerInterface serverInterface = (ServerInterface) Naming.lookup(serverUrl);

			Scanner sc = new Scanner(System.in);
			double num1;
			double num2;
			System.out.print("Enter number 1:- ");
			num1 = sc.nextDouble();
			System.out.print("Enter number 2:- ");
			num2 = sc.nextDouble();
			System.out.println("Number 1 is:- " + num1);
			System.out.println("Number 2 is:- " + num2);
			System.out.println("-----------Results------------");
			System.out.println(num1 + " + " + num2 + " = " + serverInterface.Addition(num1, num2));
			System.out.println(num1 + " - " + num2 + " = " + serverInterface.Subtraction(num1, num2));
			System.out.println(num1 + " / " + num2 + " = " + serverInterface.Division(num1, num2));
			System.out.println(num1 + " x " + num2 + " = " + serverInterface.Multiplication(num1, num2));
		} catch (Exception e) {
			System.out.println("Something went wrong! " + e.getMessage());
		}
	}
}
