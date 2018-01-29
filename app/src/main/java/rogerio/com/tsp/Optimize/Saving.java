package rogerio.com.tsp.Optimize;

/**
 * Created by ROGERIO on 26/01/2018.
 */

public class Saving implements Comparable <Saving> {

    private int i;
    private int j;
    private double saving;

    public Saving(int i, int j, double saving) {
        this.i = i;
        this.j = j;
        this.saving = saving;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public double getSaving() {
        return saving;
    }

    public void setSaving(double saving) {
        this.saving = saving;
    }

    @Override
    public String toString() {
        return "Saving{" +
                "i=" + i +
                ", j=" + j +
                ", saving=" + saving +
                '}';
    }


    @Override
    public int compareTo(Saving otherSaving) {
        return Double.compare(this.saving, otherSaving.getSaving());
    }
}
