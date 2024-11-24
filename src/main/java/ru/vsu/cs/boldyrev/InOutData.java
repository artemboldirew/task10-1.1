package ru.vsu.cs.boldyrev;

import java.util.List;
import ru.vsu.cs.boldyrev.Program.Triangle;
public class InOutData {
    public static void getPrintArray(List<List<Triangle>> list) {
        int maxSize = 0;
        for (int j = 0; j < list.size(); j++) {
            maxSize = Math.max(list.get(j).size(), maxSize);
        }
        String[][] res = new String[list.size()][maxSize];
        for (int i = 0; i < list.size(); i++) {
            List<Triangle> curList = list.get(i);
            for (int k = 0; k < curList.size(); k++) {

            }
        }
    }
}
