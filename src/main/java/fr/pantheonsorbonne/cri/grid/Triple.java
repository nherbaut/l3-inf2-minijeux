package fr.pantheonsorbonne.cri.grid;

public abstract class Triple {
    protected Integer x;
    protected Integer y;
    protected Integer z;

    public Triple(Integer x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public boolean hasNull() {
        return countNull() != 0;
    }

    public int countNull() {
        return (x == null ? 1 : 0) + (y == null ? 1 : 0) + (z == null ? 1 : 0);
    }

    public int firstNullIndex() {
        if (x == null) return 0;
        if (y == null) return 1;
        if (z == null) return 2;
        else return -1;
    }

    public abstract boolean winningTriple();


}


