import java.io.BufferedReader;
import java.util.Map;

/**
 * Created by root on 10/28/16.
 */
public class Methods {

    public void action(String line, Memory memory, BufferedReader reader) {
        switch (line.toLowerCase()) {
            case ("add"):
                add(memory, reader);
                break;
            case ("show"):
                show(memory);
                break;
            case ("change"):
                change(memory, reader);
                break;
            case ("help"):
                help();
                break;
            case ("delete"):
                delete(memory, reader);
                break;
            case ("save"):
                new Writer().saveMapToJsonFile(memory);
                break;
            case ("load"):
                new Reader().readJsonToMap(memory);
                break;
        }

    }

    public void add(Memory memory, BufferedReader reader) {
        try {
            System.out.println("What \"Key\" Should your \"Value\" have?");
            String key = reader.readLine();
            System.out.println("What \"Value\" do you want to add?");
            String value = reader.readLine();
            System.out.println("Would you like to add(" + key + ":" + value + ")? (Y/N)");
            String answer = reader.readLine();
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                memory.getMemoryMap().put(key, value);
                System.out.println("Added: (" + key + ":" + value + ") to the memory");
                System.out.println("Returning to menu...");
            } else {
                System.out.println("Could not resolve issue, returning to menu...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void change(Memory memory, BufferedReader reader) {
        System.out.println("What KEY does the VALUE you would like to change have?");
        try {
            String key = reader.readLine();
            if (memory.getMemoryMap().containsKey(key)) {
                System.out.println("What's the new value you would like to insert?");
                String value = reader.readLine();
                System.out.println("Do you want to update.... (Y/N)" +
                        "\n(" + key + ":" + memory.getMemoryMap().get(key) + ") --> (" + key + ":" + value + ")");
                if (reader.readLine().equalsIgnoreCase("yes")) {
                    memory.getMemoryMap().replace(key, value);
                    System.out.println("Value updated, returning to menu...");
                } else {
                    System.out.println("Change aborted, returning to menu...");
                }
            } else {
                System.out.println("Key not found, returning to menu...");
            }
        } catch (Exception e) {

        }
    }


    public void show(Memory memory) {
        System.out.println("The Database contains the following...");
        for (Map.Entry<String, String> entry : memory.getMemoryMap().entrySet()) {
            System.out.println("Key : " + entry.getKey() + " | Value: " + entry.getValue());
        }
    }

    public void delete(Memory memory, BufferedReader reader) {
        System.out.println("What KEY does the VALUE you would like to delete have?");
        try {
            String key = reader.readLine();
            if (memory.getMemoryMap().containsKey(key)) {
                System.out.println("The Database contains(" + key + ":" + memory.getMemoryMap().get(key) + ")");
                System.out.println("Would you like to remove this key:value from the Database? (Y/N)");
                String answer = reader.readLine();
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                    System.out.println("REMOVING...(" + key + ":" + memory.getMemoryMap().get(key) + ")");
                    memory.getMemoryMap().remove(key);
                    System.out.println("Process complete, returning to menu...");
                } else {
                    System.out.println("Aborting delete, returning to menu...");
                }
            } else {
                System.out.println("The key: \"" + key + "\" have not been found in the Database, returning to menu...");
            }
        } catch (Exception e) {

        }

    }

    public void help() {
        System.out.println("\n---METHODS---" +
                "\n\"add\": Gives you the possibility to add something to the Database." +
                "\n\"help\": Shows you the available methods." +
                "\n\"show\": Shows you the current SLDb." +
                "\n\"save\": Saves the SLDb instance for another run" +
                "\n\"load\": Gets the latest saved instance of SLDb" +
                "\n\"delete\": Gives you the possibility to delete something from the Database" +
                "\n\"change\": You can alter a existing post if you have the key");
    }

    public void showSpecific() {

    }
}
