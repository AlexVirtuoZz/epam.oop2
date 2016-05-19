package task5;

/**
 * Created by alexander on 17.05.16.
 */
public class View {
    // System messages
    public final String WELCOME = "Welcome to our forum!\nType 'help' to get a list of available commands";
    public final String HELP = "Type 'post' to add new message. Or 'post admin' to post a message as an admin\n" +
            "Type 'list' to show posted messages\n" +
            "Type 'delete x' to delete message from forum, where x is message's id\n" +
            "Type 'duplicate x' to add a copy of a message into forum, where x is message's id\n" +
            "Type 'show x' to see full message, where x is message's id\n" +
            "Type 'edit author\\ theme\\ text x' to edit author \\ theme \\ text of a message, where x is message's id\n" +
            "Type 'exit' to quit the program";
    public final String BYE = "Come back later! Bye!";

    // Interface messages
    public final String AUTHOR = "Enter your name";
    public final String THEME = "Enter your theme";
    public final String TEXT = "Enter your message";

    // Errors
    public final String ERROR = "Wrong input. Try again";
    public final String NO_ID = "No message with such id was found\nType 'list' to see posted messages";
    public final String EMPTY_FORUM = "No messages are saved on forum. Type 'post' to post new message";

    void print(String message){
        System.out.println(message);
    }
}
