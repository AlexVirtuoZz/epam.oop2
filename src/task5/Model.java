package task5;


import task5.messages.Message;
import java.util.LinkedList;

/**
 * Created by alexander on 17.05.16.
 */
public class Model {
    //Messages' counter
    static public int id;

    //A list to keep messages
    LinkedList<Message> forum = new LinkedList<>();

    //A method to add a message into forum
    public void addMessage(Message message){
        if (message != null) forum.add(message);
    }

    // A method to remove message fro forum
    public void deleteMessage(int id) throws NullPointerException{
        forum.remove(getById(id));
    }

    /**
     * A method to find a message by its id
     * @param id is message's id
     * @return message, if it was found
     */
    public Message getById(int id){
        for (Message m : forum){
            if (m.getId() == id) return m;
        }
        return null;
    }

    /**
     * A method to return short information of all messages posted on forum
     * If forum is empty @return null
     * Create new StringBuilder. Append short info of all messages
     * @return info by toString() method
     */
    public String list(){
        if (forum.isEmpty()) return null;
        StringBuilder list = new StringBuilder();
        for (Message m : forum){
            list.append(m.shortInfo());
        }
        return list.toString();
    }

    /**
     * Next messages are to edit message's author, theme or text
     * After edition - update message's update time
     * @param message
     */
    public void editAuthor(String author, Message message){
        message.setAuthor(author);
        message.update();
    }

    public void editText(String text, Message message){
        message.setText(text);
        message.update();
    }

    public void editTheme(String theme, Message message){
        message.setTheme(theme);
        message.update();
    }

    /**
     * A method to duplicate a message by its id
     * If message, received by getById() method is not null
     * Create a temporary copy of received message
     * Set id manually
     * Add copy to forum
     * @param id is message's id
     */
    public void duplicateMessage(int id){
        Message message = getById(id);
        if (message != null) {
            Message temp = (Message) message.clone();
            temp.setId(++Model.id);
            forum.add(temp);
        }
    }

}
