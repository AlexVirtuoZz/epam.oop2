package task5;



/**
 * Created by alexander on 17.05.16.
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.userProcess();
    }
}
