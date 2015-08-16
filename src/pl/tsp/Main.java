package pl.tsp;

import model.DataObject;
import model.Road;
import service.JsonParser;
import service.ProblemSolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Glowna klasa programu, ktora oblicza koszty tras wyznaczonych przez algorytm
 * po czym wyswietla najbardziej optymalna z nich
 */
public class Main {

    public static void main(String[] args) {


        DataObject object = JsonParser.fromJson();
        Integer tab[][] = ProblemSolver.converseToTable(object);


        Integer n = tab.length - 1;


        Integer x[] = new Integer[n + 1];

        for (int i = 1; i <= n; i++)
            x[i] = 0;
        x[1] = 1;

        List<Integer[]> tabList = ProblemSolver.findCycles(2, tab, x, n);

        Map<Integer, Integer[]> resultCosts = new HashMap<Integer, Integer[]>();

        Integer[] bestResult = new Integer[tabList.get(0).length];
        bestResult[0] = -1;
        for (Integer[] table : tabList) {
            table[0] = -1;
            int roadCost = 0;
            for (int i = 0; i < table.length - 1; i++) {
                for (Road r : object.getRoads()) {
                    if (r.getStart() == table[i] && r.getEnd() == table[i + 1]) {
                        roadCost = roadCost + r.getDistance();
                    } else if (r.getStart() == table[i + 1] && r.getEnd() == table[i]) {
                        roadCost = roadCost + r.getDistance();
                    }
                }
            }
            if (bestResult[0] == -1) {
                System.arraycopy(table, 0, bestResult, 0, table.length);
                bestResult[0] = roadCost;
            } else if (roadCost < bestResult[0]) {
                System.arraycopy(table, 0, bestResult, 0, table.length);
                bestResult[0] = roadCost;
            }
            resultCosts.put(roadCost, table);
        }
        for (int z = 0; z < bestResult.length; z++) {
            if (z == 0) {
                System.out.println("Lowest cost is : " + bestResult[z] + "\n");
                System.out.println("Best track:");
            } else {
                System.out.print(bestResult[z] + " ");
            }
        }
    }
}
