package service;


import model.DataObject;
import model.Road;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa implementuje algorytm tworzacy cykl Hamiltona na podstawie tablicy asocjacyjnej
 */
public class ProblemSolver {

    /**
     * Metoda odpowiadajaca za konwersje danych z pliku JSON na tablice asocjacyjna
     * <p>
     *
     * @return tablica asocjacyjna
     */
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

    /**
     * Metoda odpowiada za wyszukiwanie cykli Hamiltona
     * <p>
     *
     * @param k       zmienna pomocniczna algorytmu
     * @param G       tablica asocjacyjna
     * @param x       tablica z aktualnie rozpatrywana kombinacja wierzcholkow
     * @param n       ilosc wierzcholkow grafu
     * @param tabList tablica zawierajaca otrzymane rozwiazania
     */
    private static void Hamiltonian(int k, Integer G[][], Integer x[], Integer n, List<Integer[]> tabList) {

        while (true) {
            NextValue(k, G, x, n);
            if (x[k] == 0)
                return;
            if (k == n) {
                for (int i = 1; i <= k; i++)
                    System.out.print(x[i] + " ");
                System.out.println();
                Integer[] dest = new Integer[x.length + 1];
                System.arraycopy(x, 0, dest, 0, x.length);
                dest[x.length] = x[1];
                tabList.add(dest);
                return;
            } else
                Hamiltonian(k + 1, G, x, n, tabList);
        }
    }

    /**
     * Metoda pomocnicza algorytmu
     * <p>
     */
    private static void NextValue(int k, Integer G[][], Integer x[], Integer n) {
        while (true) {
            x[k] = (x[k] + 1) % (n + 1);
            if (x[k] == 0)
                return;
            if (G[x[k - 1]][x[k]] != 0) {
                int j;
                for (j = 1; j < k; j++)
                    if (x[k] == x[j])
                        break;
                if (j == k)
                    if ((k < n) || ((k == n) && G[x[n]][x[1]] != 0))
                        return;
            }
        }
    }

    /**
     * Metoda publiczna udostepniajaca funkcjonalnosc algorytmu
     * <p>
     *
     * @return DataObject
     * @see DataObject
     */
    public static List<Integer[]> findCycles(int k, Integer G[][], Integer x[], Integer n) {
        List<Integer[]> tabList = new ArrayList<>();
        System.out.println("\nSolution:");
        Hamiltonian(2, G, x, n, tabList);
        System.out.println("");
        if (tabList.isEmpty())
            System.out.println("No Solution possible!");
        return tabList;

    }

}
