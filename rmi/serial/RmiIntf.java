import java.rmi.*;
import java.io.Serializable;

public interface RmiIntf extends Remote{
	double add(double d1, double d2) throws RemoteException;
	double minus(double d1, double d2) throws RemoteException;
	Snode nodeSum(Snode n1) throws RemoteException;
}

class Snode implements Serializable{
	int key;
	String name="";
	
	Snode(int key, String name) {
		this.key = key;
		this.name = name;
	}

	void print(){
		System.out.println("this node's name is "+name+", and key value is "+key);
	}
}