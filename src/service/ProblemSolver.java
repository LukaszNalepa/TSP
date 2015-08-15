package service;


import model.DataObject;
import model.Road;


public class ProblemSolver {

    public static Integer[][] converseToTable(DataObject object) {

        int size = 0;

        for (Road r : object.getRoads()) {
            if (r.getStart() > size) size = r.getStart();
            else if (r.getEnd() > size) size = r.getEnd();
        }
        size += 1;

        Integer[][] tab = new Integer[size][size];

        for (int i = 0; i < tab.length; i++)
            for (int j = 0; j < tab[i].length; j++)
                tab[i][j] = 0;


        for (Road r : object.getRoads()) {
            tab[r.getStart()][r.getEnd()] = r.getDistance();
            tab[r.getEnd()][r.getStart()] = r.getDistance();
        }


        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++)
                System.out.print(tab[i][j]);
            System.out.println();
        }

        return tab;

    }

}
