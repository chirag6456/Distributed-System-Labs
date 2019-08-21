import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class Client
{
    public Client(){}

    public static void main(String args[]) throws Exception
    {
        try
        {
            Registry reg = LocateRegistry.getRegistry(null);

            Hello stub = (Hello) reg.lookup("Hello");

            List<Student> list =(List)stub.getStudents();
            for (Student s :list)  
            {
                System.out.println("ID: " + s.getId()); 
                System.out.println("name: " + s.getName()); 
                System.out.println("branch: " + s.getBranch()); 
                System.out.println("percent: " + s.getCpi()); 
            }
        }
        catch (Exception e) 
        { 
            System.err.println("Client exception: " + e.toString()); 
            e.printStackTrace(); 
        } 
    }
    
}
