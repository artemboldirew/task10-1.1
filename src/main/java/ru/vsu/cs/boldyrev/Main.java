package ru.vsu.cs.boldyrev;

import ru.vsu.cs.boldyrev.FrameMain.FrameMain;
import ru.vsu.cs.boldyrev.util.ArrayUtils;
import ru.vsu.cs.boldyrev.util.SwingUtils;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    static String path = "src/main/java/ru/vsu/cs/boldyrev/";
    public static class InputArgs {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean window;
    }

    public static InputArgs parseCmdArgs(String[] args) {
        InputArgs params = new InputArgs();

        if (args.length == 1 && args[0].equals("--window")) {
            params.window = true;
        }
        else if (args.length == 2) {
            params.inputFile = args[0];
            params.outputFile = args[1];
        }
        else {
            params.error = true;
        }
        return params;
    }

    public static void winMain() throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        InputArgs params = parseCmdArgs(args);
        if (params.window) {
            winMain();
        } else {
            int[][] arr2 = ArrayUtils.readIntArray2FromFile(path + params.inputFile);
            if (arr2 == null) {
                System.err.printf("Can't read array from \"%s\"%n", params.inputFile);
                System.exit(2);
            }
            //int[] result = Logic.Solution(arr2);
            int[] result = new int[]{0, 0, 0, 0};
            System.out.println(Arrays.toString(result));
            PrintStream out = (params.outputFile != null) ? new PrintStream(path + params.outputFile) : System.out;
            out.println(ArrayUtils.toString(result));
            out.close();
        }
    }
}
