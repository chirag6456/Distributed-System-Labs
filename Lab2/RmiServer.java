import java.rmi.*;  
import java.rmi.registry.*; 
class RmiServer{
     public static void main(String[] args) {
        try{  
            ConnectInterface stubt=new MethodClass();
            Naming.rebind("rmi://localhost:5000/sonoo",stubt);  
            //System.out.println(stub.sayThis("Hello World"));  
            }catch(Exception e){}
    }
}