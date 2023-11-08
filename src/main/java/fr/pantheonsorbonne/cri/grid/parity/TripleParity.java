package fr.pantheonsorbonne.cri.grid.parity;

import fr.pantheonsorbonne.cri.grid.Triple;

public class TripleParity extends Triple {
    public TripleParity(Integer x, Integer y, Integer z) {
        super(x, y, z);
    }

    @Override
    public boolean winningTriple() {
        return this.hasNull() == false && (this.allOdd() || this.allEven());
    }

    public boolean allOdd() {
        return x % 2 + y % 2 + z % 2 == 0;
    }

    public boolean allEven() {
        return x % 2 != 0 && y % 2 != 0 && z % 2 != 0;
    }
}
