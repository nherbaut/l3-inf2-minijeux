package fr.pantheonsorbonne.cri.grid.parity;

import fr.pantheonsorbonne.cri.grid.DiagonalSpec;
import fr.pantheonsorbonne.cri.grid.Grid;

public class ParityGrid extends Grid {
    public ParityTriple getLine(int line) {
        return new ParityTriple(this.grid[line][0], this.grid[line][1], this.grid[line][2]);
    }

    public ParityTriple getCol(int line) {
        return new ParityTriple(this.grid[0][line], this.grid[1][line], this.grid[2][line]);
    }

    public ParityTriple getDiag(DiagonalSpec diagSpec) {
        return new ParityTriple(
                this.get(diagSpec.coordinates[0][0], diagSpec.coordinates[0][1]),
                this.get(diagSpec.coordinates[1][0], diagSpec.coordinates[1][1]),
                this.get(diagSpec.coordinates[2][0], diagSpec.coordinates[2][1])
        );
    }
}
