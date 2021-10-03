import java.rmi.*;

public class AddClient{
	public static void main(String[] args){
		try{
			
			String serverURL = "rmi://"+ args[0] + "/AddServer";
			RmiIntf intf = (RmiIntf)Naming.lookup(serverURL);

			System.out.println("The first number is : " + args[1] );
			double d1 = Double.valueOf(args[1]).doubleValue();

			System.out.println("The second number is : " + args[2] );
			double d2 = Double.valueOf(args[2]).doubleValue();

			System.out.println("The sum is " + intf.add(d1,d2));
			System.out.println("The minus is "+ intf.minus(d1,d2));
			

			Snode n = new Snode(4, "naming");
			Snode nn = intf.nodeSum(n);
			nn.print();

			System.out.println("Client End");

		} catch(Exception e){
		
		}
	}
}