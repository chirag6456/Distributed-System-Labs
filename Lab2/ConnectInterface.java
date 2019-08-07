import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConnectInterface extends Remote{
    public String sayThis(String th) throws RemoteException;
}