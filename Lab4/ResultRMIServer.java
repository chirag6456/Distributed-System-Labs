// ResultRMIServer.java

import java.rmi.*;
import java.rmi.server.*;

public class ResultRMIServer
{

 public static void main(String args[])
 {

   try
   {
     // Create ResultRMIImpl
     ResultRMIImpl myResult = new ResultRMIImpl("rmi://localhost:5000/");
     System.out.println("ResultRMI Server ready.");
   } 
   catch (Exception e)
   { 
     System.out.println("Exception: " + e.getMessage());
     e.printStackTrace();
   }
 }
}
