package ru.vsu.cs.boldyrev;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.sun.pisces.Transform6;
import ru.vsu.cs.boldyrev.Triangle;

public class InOutData {

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
        Locale.setDefault(Locale.ROOT);
        if (InOutData.inspectArr(arr)) {
            List<List<Triangle>> res = Program.Solution(arr);
            return getStringResult(res);
        } else {
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

    public static String getNormalDouble(double number) {
        DecimalFormat df = new DecimalFormat("#.####");
        return df.format(number);
    }
    public static String getStringTriangle(Triangle fig) {
        return getNormalDouble(fig.t1.x) + " " + getNormalDouble(fig.t1.y) + " | " + getNormalDouble(fig.t2.x) + " " + getNormalDouble(fig.t2.y) + " | " + getNormalDouble(fig.t3.x) + " " + getNormalDouble(fig.t3.y);
    }

}
