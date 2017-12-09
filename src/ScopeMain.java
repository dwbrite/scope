import gui.windows.SelectProject;
import gui.windows.primary.PrimaryWindow;

public class ScopeMain {

    private static boolean projectExists = false;

    public static void main(String[] args) {
        // Open up application, new thread
        Thread open = new Thread() {
            @Override
            public void run() {
                super.run();
                //*/ You can toggle which statement is commented out by changing...
                // ...the beginning of the line above between //*/ and /*/
                PrimaryWindow.createWindow();
                /*/
                SelectProject.createWindow();
                //*/
            }
        };
        open.start();

        System.out.println("You're welcome to scope :)");
    }
}
