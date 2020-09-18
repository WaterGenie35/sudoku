import java.io.PrintStream;

public class ConsoleMenu {

    // Singleton
    private static final ConsoleMenu INSTANCE = new ConsoleMenu();
    private ConsoleMenu () {
        String operatingSystem = System.getProperty("os.name");
        isWindows = operatingSystem.contains("Windows");
    }
    public static ConsoleMenu getInstance () {
        return INSTANCE;
    }

    private boolean isWindows;

    public void init () throws Exception {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
    }

    public void clearConsole () throws Exception {
        if (isWindows) {
            // Runtime.getRuntime().exec("cls") didn't work
            // See https://stackoverflow.com/a/33525703/
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }

}
