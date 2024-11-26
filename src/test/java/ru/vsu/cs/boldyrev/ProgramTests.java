package ru.vsu.cs.boldyrev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.boldyrev.util.ArrayUtils;

public class ProgramTests {
    private static final String path = "src/test/java/ru/vsu/cs/boldyrev/";
    @Test
    void Test01() {
        double[][] input01 = ArrayUtils.readDoubleArray2FromFile(path + "inputs/input01.txt");
        int[][] output01 = ArrayUtils.readIntArray2FromFile(path + "outputs/output01.txt");
        int[][] res01 = InOutData.interfaceResult(input01);
        System.out.println(System.getProperty("user.dir"));
        Assertions.assertArrayEquals(output01, res01);
    }

    @Test
    void Test02() {
        double[][] input02 = ArrayUtils.readDoubleArray2FromFile(path + "inputs/input02.txt");
        int[][] output02 = ArrayUtils.readIntArray2FromFile(path + "outputs/output02.txt");
        int[][] res02 = InOutData.interfaceResult(input02);
        Assertions.assertArrayEquals(output02, res02);
    }

    @Test
    void Test03() {
        double[][] input03 = ArrayUtils.readDoubleArray2FromFile(path + "inputs/input03.txt");
        int[][] output03 = ArrayUtils.readIntArray2FromFile(path + "outputs/output03.txt");
        int[][] res03 = InOutData.interfaceResult(input03);
        Assertions.assertArrayEquals(output03, res03);
    }

    @Test
    void Test04() {
        double[][] input04 = ArrayUtils.readDoubleArray2FromFile(path + "inputs/input04.txt");
        int[][] output04 = ArrayUtils.readIntArray2FromFile(path + "outputs/output04.txt");
        int[][] res04 = InOutData.interfaceResult(input04);
        Assertions.assertArrayEquals(output04, res04);
    }

    @Test
    void Test05() {
        double[][] input05 = ArrayUtils.readDoubleArray2FromFile(path + "inputs/input05.txt");
        int[][] output05 = ArrayUtils.readIntArray2FromFile(path + "outputs/output05.txt");
        int[][] res05 = InOutData.interfaceResult(input05);
        Assertions.assertArrayEquals(output05, res05);
    }
}
