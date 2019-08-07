 import java.rmi.*;  
import java.rmi.server.*;  
class MethodClass extends UnicastRemoteObject implements ConnectInterface{
    MethodClass()throws RemoteException{  
        super();  
        }  
        public String sayThis(String th){
            th=" Hello World";
            return th;
        }
}