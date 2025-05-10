import java.rmi.*;

// Remote interface that declares methods which can be called remotely by clients
interface ServerInterface extends Remote {
	public double Addition(double num1, double num2) throws RemoteException;
	public double Subtraction(double num1, double num2) throws RemoteException;
	public double Division(double num1, double num2) throws RemoteException;
	public double Multiplication(double num1, double num2) throws RemoteException;
}
