import java.rmi.*;  
class RmiClient{
    public static void main(String[] arg){
        try{  
            ConnectInterface stub=(ConnectInterface) Naming.lookup("rmi://localhost:5000/sonoo");  
            System.out.println(stub.sayThis("Hello World"));  
            }catch(Exception e){}


    }

}