import gui.windows.primary.PrimaryWindow;

public class ScopeMain {

    private static boolean projectExists = false;

    public static void main(String[] args) {
        // Open up application, new thread?
        Thread open = new Thread() {
            @Override
            public void run() {
                super.run();
                PrimaryWindow.createWindow();
                //SelectProject.createWindow();
            }
        };
        open.start();

        System.out.println("You're welcome to scope :)");




        // If project doesn't exist, open a new one.
        /*
        if(projectExists) {

        } else {
            //System.out.println("Enter the path to an existing project's source directory.");
            System.out.println("Opening a meta project: scope");

            // check legitness

            // parse file tree
            RootNode tree = RootNode.initFromDirectory("Scope", "src");
            System.out.println(tree.toTree());
        }
        */
    }
}
