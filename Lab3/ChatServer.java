import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatServer extends UnicastRemoteObject implements ChatServerInterface
{
    public static final long serialVersionUID = 1L;
    private ArrayList<ChatClientInterface> chatClients;
    protected ChatServer() throws RemoteException{
        chatClients = new ArrayList<ChatClientInterface>();
    }

    public synchronized void registerChatClient(ChatClientInterface chatClient) throws RemoteException{
            this.chatClients.add(chatClient);
    }

    public synchronized void broadcastMessage(String message) throws RemoteException{
        int i = 0;
        while(i< chatClients.size()){
            chatClients.get(i++).retrieveMessage(message);
        }
    }
}