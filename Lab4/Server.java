import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends StudentImpl{
    public Server() {}
    public static void main(String args[]){
        try{
            StudentImpl o = new StudentImpl();

            Hello stub = (Hello) UnicastRemoteObject.exportObject(o, 0);

            Registry reg = LocateRegistry.getRegistry();

            reg.bind("Hello", stub);

            System.err.println("Server Ready");
            }
        catch(Exception e){
            System.err.println("Server excepotion:" + e.toString() );
            e.printStackTrace();
        }
        }
    }
