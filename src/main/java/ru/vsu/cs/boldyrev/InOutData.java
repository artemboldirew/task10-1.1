package ru.vsu.cs.boldyrev;

import java.util.Arrays;
import java.util.List;

import com.sun.pisces.Transform6;
import ru.vsu.cs.boldyrev.Program.Triangle;

public class InOutData {
    public static int[][] getPrintArray(List<List<Triangle>> list) {
        int maxSize = 0;
        for (int j = 0; j < list.size(); j++) {
            maxSize = Math.max(list.get(j).size(), maxSize);
        }
        int cntOut = 0;
        int[][] res = new int[list.size()][maxSize];
        for (int i = 0; i < list.size(); i++) {
            List<Triangle> curList = list.get(i);
            int[] curArr = new int[curList.size()];
            int cnt = 0;
            for (int k = 0; k < curList.size(); k++) {
                int curIndex = curList.get(k).index;
                curArr[cnt] = curIndex;
                cnt++;
            }
            res[cntOut] = curArr;
            cntOut++;
        }
        return res;
    }

    public static void printArr(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static boolean inspectArr(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            double[] cur = arr[i];
            if (cur.length != 6) {
                return false;
            }
            double l1 = Math.sqrt(Math.pow(cur[2] - cur[0], 2) + Math.pow(cur[1] - cur[3], 2));
            double l2 = Math.sqrt(Math.pow(cur[4] - cur[0], 2) + Math.pow(cur[5] - cur[1], 2));
            double l3 = Math.sqrt(Math.pow(cur[2] - cur[4], 2) + Math.pow(cur[5] - cur[3], 2));
            double flag = l1 * l2 * l3;
            if (Program.equelD(flag, 0.0)) {
                return false;
            }
        }
        return true;
    }

    public static String[][] interfaceResult(double[][] arr) {
        if (InOutData.inspectArr(arr)) {
            List<List<Triangle>> res = Program.Solution(arr);
            return getStringResult(res);
        }
        else {
            return new String[][]{{"-1"}};
        }
    }

    public static String[][] getStringResult(List<List<Triangle>> list) {
        int maxSize = 0;
        for (int j = 0; j < list.size(); j++) {
            maxSize = Math.max(list.get(j).size(), maxSize);
        }
        int cntOut = 0;
        String[][] res = new String[list.size()][maxSize];
        for (int i = 0; i < list.size(); i++) {
            List<Triangle> curList = list.get(i);
            String[] curArr = new String[curList.size()];
            int cnt = 0;
            for (int k = 0; k < curList.size(); k++) {
                String g = getStringTriangle(curList.get(k));
                curArr[cnt] = g;
                cnt++;
            }
            res[cntOut] = curArr;
            cntOut++;
        }
        return res;
    }

    public static String getStringTriangle(Triangle fig) {
        return Double.toString(fig.t1[0]) + "  " + Double.toString(fig.t1[1]) + "  " + Double.toString(fig.t2[0]) + "  " + Double.toString(fig.t2[1]) + "  " + Double.toString(fig.t3[0]) + "  " + Double.toString(fig.t3[1]);
    }

}
