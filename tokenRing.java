import java.util.*;

public class tokenRing{

  public static void main(String[] args){
      
      Scanner sc = new Scanner(System.in);
      
      System.out.println("Enter no. of nodes");
      int n=sc.nextInt();
      
      for(int i=0;i<n;i++){
        System.out.print(i+" ");
      }
      System.out.println("0");
      
      int ch=0;
      do{
        System.out.println("Enter Sender");
        int sender=sc.nextInt();
        
        System.out.println("Enter Reciever");
        int reciever=sc.nextInt();
        
        System.out.println("Enter Data ");
        int data=sc.nextInt();
        
        // token passing
        int token=0;
        
        for(int i=token;i<sender;i++){
          System.out.print(i+"->");
        }
        System.out.println(sender);
        
        System.out.println("Sender "+ sender + " Data "+ data);
        for(int i=sender;i<reciever;i=(i+1)%n){
            System.out.println("Data "+data+" Sending Data to "+ i);
        }
        
        System.out.println("Reciver "+ reciever + " Data "+ data);
        
        token=sender;
        
        System.out.println("Do u wnat to continuie if YES then 1 if NO then 0");
        ch=sc.nextInt();
      
      }while(ch==1);
  }
}
