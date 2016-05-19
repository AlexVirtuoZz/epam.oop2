package task5;

import task5.messages.AdminMessage;
import task5.messages.Message;
import task5.messages.UserMessage;

import java.util.Scanner;

/**
 * Created by alexander on 17.05.16.
 */
public class Controller {
    Model model = new Model();
    View view = new View();

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    /**
     * Main method to be processed
     * While user's input is not 'exit' - read and execute user's commands
     */
    void userProcess(){
        Scanner scanner = new Scanner(System.in);
        view.print(view.WELCOME);
        while (true){
            readCommand(scanner);
        }

    }

    /**
     * A method to read and execute user's commands
     * This method splits user's input by space and executes command by the first argument
     * case 'help' - display all available commands to user
     * case 'post' - create a new message and add it into forum
     * case 'post admin' - create a new admin message and add it into forum
     * case 'edit' 'param' 'id' - edit required parameter of a message with required id
     * case 'delete x' - remove message with id x from forum
     * case 'list' - display all posted messages
     * case 'show x' - display full information about message with id x
     * case 'duplicate x' - add a copy of message with id x into forum
     * case 'exit' - shut down the program
     * @param sc is user's input scanner
     */
    void readCommand(Scanner sc){
        while (true) {
            String input = sc.nextLine();
            String[] paramAndValue = input.split(" ");
            switch (paramAndValue[0]) {
                case ("help"): {
                    view.print(view.HELP);
                    break;
                }
                case ("post"): {
                    try {
                        addMessage(sc, paramAndValue[1]);
                        break;
                    } catch (ArrayIndexOutOfBoundsException e){
                        addMessage(sc, "user");
                        break;
                    }
                }
                case ("edit"): {
                    try {
                    Message message = model.getById(Integer.parseInt(paramAndValue[2]));
                    switch (paramAndValue[1]) {
                        case ("author"): {
                            model.editAuthor(sc.nextLine(), message);
                            break;
                        }
                        case ("theme"): {
                            model.editTheme(sc.nextLine(), message);
                            break;
                        }
                        case ("text"): {
                            model.editText(sc.nextLine(), message);
                            break;
                        }
                    }
                    } catch ( ArrayIndexOutOfBoundsException | NumberFormatException | NullPointerException e) {
                        view.print(view.ERROR);
                        view.print(view.NO_ID);
                        break;
                    }
                }
                case ("delete"): {
                    try {
                        model.deleteMessage(Integer.parseInt(paramAndValue[1]));
                        break;
                    } catch (NumberFormatException e){
                        view.print(view.ERROR);
                        view.print(view.NO_ID);
                        break;
                    }
                }
                case ("duplicate"): {
                    try {
                        model.duplicateMessage(Integer.parseInt(paramAndValue[1]));
                        break;
                    } catch (NumberFormatException e){
                        view.print(view.ERROR);
                        view.print(view.NO_ID);
                        break;
                    }
                }
                case ("list"): {
                    String list = model.list();
                    if (list == null){
                        view.print(view.EMPTY_FORUM);
                        break;
                    }
                    view.print(list);
                    break;
                }
                case ("show"): {
                    try {
                        view.print(model.getById(Integer.parseInt(paramAndValue[1])).toString());
                        break;
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e){
                        view.print(view.ERROR);
                        view.print(view.NO_ID);
                        break;
                    }
                }
                case ("exit"): {
                    view.print(view.BYE);
                    System.exit(0);
                }
                default:
                    view.print(view.ERROR);
            }
        }
    }

    /**
     * A method to create and add a message into forum
     * Declare an empty message
     * If it's an admin message - create new admin message. Else create new user message
     * Read and set all message parameters with user's input
     * Set message's id
     * Add message into forum and display its full information to user
     * @param scanner is user's input scanner
     * @param admin to check if a message is admin message
     */
    void addMessage(Scanner scanner, String admin){
        Message message;
        if (admin.equalsIgnoreCase("admin")) message = new AdminMessage();
        else message = new UserMessage();
        view.print(view.AUTHOR);
        message.setAuthor(((message instanceof AdminMessage) ?
                ((AdminMessage) message).getSubName() : ((UserMessage) message).getSubName()) + scanner.nextLine());
        view.print(view.THEME);
        message.setTheme(scanner.nextLine());
        view.print(view.TEXT);
        message.setText(scanner.nextLine());
        message.setId(++model.id);
        model.addMessage(message);
        view.print(message.toString());
    }

}
