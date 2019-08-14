
import java.rmi.*;

public interface ChatServerInterface extends Remote{
    void registerChatClient(ChatClientInterface chatClient) throws RemoteException;
    void broadcastMessage(String message) throws RemoteException;
}