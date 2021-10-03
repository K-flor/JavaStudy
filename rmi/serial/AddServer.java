import java.rmi.*;
import java.rmi.server.*;

public class AddServer{
	public static void main(String[] args){
		try{
			
			IntfImplement impl = new IntfImplement();
			Naming.rebind("AddServer", impl);

		} catch(Exception e){ 
		
		}
	}
}