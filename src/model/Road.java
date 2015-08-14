package model;

/**
 * Klasa reprezentuje pojedyñcz¹ drogê miêdzy punktem startowym a docelowym
 */
public class Road {

    /**
     * Reprezentuje punkt startowy
     */
    private Integer start;

    /**
     * Reprezentuje punkt koñcowy
     */
    private Integer end;

    /**
     * Reprezentuje drogê pomiêdzy punktem startowym a koñcowym
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
