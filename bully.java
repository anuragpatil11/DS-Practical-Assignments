import java.util.*;

public class bully{

	static boolean[] active;
	static int n;

	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);

		System.out.println("Enter no. of process");
		n=sc.nextInt();

		System.out.println("Enter coordinator");
		int coordinator=sc.nextInt();

		active = new boolean[n+1];
		
		for (int i=1;i<=n ;i++ ) {
			active[i]=true;
		}

		int ch;

		do{
			System.out.println("1. Crash");
			System.out.println("2. Recover");
			System.out.println("3. exit");
			ch=sc.nextInt();

			switch(ch){
			case 1: crash(sc);

			case 2: recoverAndElect(sc);

			}
		}while(ch!=3);
	}

	static void crash(Scanner sc){
		System.out.println("Enter Crashid ");
		int crashP=sc.nextInt();
		active[crashP]=false;
		System.out.println("process crashesd"+crashP);
	}

	static void recoverAndElect(Scanner sc){
		System.out.print("Enter recover index");
		int recover=sc.nextInt();

		for (int i=recover+1;i<n ;i++ ) {
			if(active[i])
			System.out.print(i+" ");
		}

		for (int i=n;i>=1 ;i-- ) {
			if(active[i]){
				System.out.println("New Coordinator"+i);
				break;
			}
		}
	}
}