import java.rmi.*;
import java.io.Serializable;

public interface RmiIntf extends Remote{
	double add(double d1, double d2) throws RemoteException;
	double minus(double d1, double d2) throws RemoteException;
	Snode nodeSum(Snode n1) throws RemoteException;
}
