import java.rmi.*;
import java.rmi.server.*;

// This class implements the remote interface and extends UnicastRemoteObject 
// to allow the object to receive remote method calls
public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {

    // Constructor must throw RemoteException
    public ServerImplementation() throws RemoteException {}

	public double Addition(double num1, double num2) throws RemoteException {
		return num1 + num2;
	}

	public double Subtraction(double num1, double num2) throws RemoteException {
		return num1 - num2;
	}

	public double Division(double num1, double num2) throws RemoteException {
		if (num2 == 0) {
			System.out.println("Cannot divide with zero!");
			return -1;
		}
		return num1 / num2;
	}

	public double Multiplication(double num1, double num2) throws RemoteException {
		return num1 * num2;
	}
}
