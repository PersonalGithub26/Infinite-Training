import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientProg {
	
	public static void main(String[] args) {
		
		int a, b, c;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 numbers....");
		a = sc.nextInt();
		b=sc.nextInt();
		try {
			Calc obj = (Calc) Naming.lookup("localhost");
			System.out.println("Sum is "+obj.sum(a, b));
			System.out.println("Sub is "+obj.sub(a, b));
			System.out.println("mult is "+obj.mult(a, b));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
