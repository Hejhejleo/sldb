import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by root on 10/28/16.
 */
public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean running = true;
        Methods methods = new Methods();
        Memory memory = new Memory();
        System.out.println("Welcome! " +
                "\nMy name is SLDb, short for \"Short Lived Database\"." +
                "\nI will now state you the options you have to interact with me.");
        methods.help();
        while (running) {
            try {
                System.out.println("What would you like to do?");
                methods.action(reader.readLine(), memory, reader);
            } catch (Exception e) {
            }
        }
    }
}
