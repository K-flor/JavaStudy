import java.rmi.*;
import java.rmi.server.*;

public class IntfImplement extends UnicastRemoteObject implements RmiIntf{
	public IntfImplement() throws RemoteException{
	}

	public double add(double d1, double d2){
		return d1+d2;
	}

	public double minus(double d1, double d2){
		return d1-d2;
	}

	public Snode nodeSum(Snode n1){
		return new Snode(n1.key +1, "Nd3");
	}
}