package ru.vsu.cs.boldyrev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.boldyrev.util.ArrayUtils;

import java.util.Locale;

public class ProgramTests {
    private static final String path = "src/test/java/ru/vsu/cs/boldyrev/";

    @Test
    void Test01() {
        double[][] input01 = ArrayUtils.readDoubleArray2FromFile(path + "inputs/input01.txt");
        String[][] output01 = new String[][]{{"0 0 | 1 0 | 0 1"},{"0 0 | 0 1 | 2 0"}};
        String[][] res01 = InOutData.interfaceResult(input01);
        Assertions.assertArrayEquals(output01, res01);
    }

    @Test
    void Test02() {
        double[][] input02 = ArrayUtils.readDoubleArray2FromFile(path + "inputs/input02.txt");
        String[][] output02 = new String[][]{{"-1"}};
        String[][] res02 = InOutData.interfaceResult(input02);
        Assertions.assertArrayEquals(output02, res02);
    }

    @Test
    void Test03() {
        double[][] input03 = ArrayUtils.readDoubleArray2FromFile(path + "inputs/input03.txt");
        String[][] output03 = new String[][]{{"-1"}};
        String[][] res03 = InOutData.interfaceResult(input03);
        Assertions.assertArrayEquals(output03, res03);
    }

    @Test
    void Test04() {
        double[][] input04 = ArrayUtils.readDoubleArray2FromFile(path + "inputs/input04.txt");
        String[][] output04 = new String[][]{{"0 0 | 0 2 | 2 0", "0 0 | 3 0 | 0 3", "2 4 | 3 5 | 4 4"}, {"-1 0 | 5 4 | 5 0", "2 0 | 5 0 | 5 2"}};
        String[][] res04 = InOutData.interfaceResult(input04);
        Assertions.assertArrayEquals(output04, res04);
    }

    @Test
    void Test05() {
        double[][] input05 = ArrayUtils.readDoubleArray2FromFile(path + "inputs/input05.txt");
        String[][] output05 = new String[][]{{"0 0 | 2.5 0 | 0 2.5", "0 0 | 1 0 | 0 1"}, {"0 0 | 3 0 | 3 2", "0 0 | 5 0 | 5 3.3333"}};
        String[][] res05 = InOutData.interfaceResult(input05);
        Assertions.assertArrayEquals(output05, res05);
    }
}
