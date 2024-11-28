package ru.vsu.cs.boldyrev;

public class Triangle {
    public Point t1;
    public Point t2;
    public Point t3;
    public double maxCos;
    public double minCos;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.t1 = new Point(x1, y1);
        this.t2 = new Point(x2, y2);
        this.t3 = new Point(x3, y3);
    }
}
