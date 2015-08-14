package model;

/**
 * Klasa reprezentuje pojedy�cz� drog� mi�dzy punktem startowym a docelowym
 */
public class Road {

    /**
     * Reprezentuje punkt startowy
     */
    private Integer start;

    /**
     * Reprezentuje punkt ko�cowy
     */
    private Integer end;

    /**
     * Reprezentuje drog� pomi�dzy punktem startowym a ko�cowym
     */
    private Integer distance;


    public Road(Integer start, Integer end, Integer distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }


    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }


}
