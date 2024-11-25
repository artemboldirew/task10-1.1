package ru.vsu.cs.boldyrev;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static class Triangle {
        public int index;
        public double[] t1;
        public double[] t2;
        public double[] t3;
        public double maxCos;
        public double minCos;

        public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
            this.t1 = new double[]{x1, y1};
            this.t2 = new double[]{x2, y2};
            this.t3 = new double[]{x3, y3};
        }
    }

    public static boolean equelD(double a, double b) {
        double epsilon = 0.000001;
        return Math.abs(a - b) < epsilon;
    }

    public static List<List<Triangle>> Solution(double[][] arr) {
        List<List<Triangle>> result = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            double[] cur = arr[i];
            Triangle curTriangle = new Triangle(cur[0], cur[1], cur[2], cur[3], cur[4], cur[5]);
            findDegrees(curTriangle);
            curTriangle.index = cnt;
            cnt++;
            boolean flag = true;
            for (int j = 0; j < result.size(); j++) {
                double curMaxCos = result.get(j).getFirst().maxCos;
                double curMinCos = result.get(j).getFirst().minCos;
                if (equelD(curMaxCos, curTriangle.maxCos) && equelD(curMinCos, curTriangle.minCos)) {
                    result.get(j).add(curTriangle);
                    flag = false;
                }
            }
            if (flag) {
                List<Triangle> newTriangleList = new ArrayList<>();
                newTriangleList.add(curTriangle);
                result.add(newTriangleList);
            }
        }
        return result;
    }

    private static double getCos(double main, double b, double c) {
        return (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(main, 2)) / (2 * b * c);
    }

    private static double getLength(double[] t1, double[] t2) {
        return Math.sqrt(Math.pow(t2[0] - t1[0], 2) + Math.pow(t2[1] - t1[1], 2));
    }

    public static void findDegrees(Triangle fig) {
        double l1 = getLength(fig.t1, fig.t2);
        double l2 = getLength(fig.t2, fig.t3);
        double l3 = getLength(fig.t3, fig.t1);
        double cos1 = getCos(l1, l2, l3);
        double cos2 = getCos(l2, l1, l3);
        double cos3 = getCos(l3, l2, l1);
        fig.maxCos = Math.max(Math.max(cos1, cos2), cos3);
        fig.minCos = Math.min(Math.min(cos1, cos2), cos3);
    }
}
