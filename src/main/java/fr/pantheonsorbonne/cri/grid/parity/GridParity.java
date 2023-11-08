package fr.pantheonsorbonne.cri.grid.parity;

import fr.pantheonsorbonne.cri.grid.DiagonalSpec;
import fr.pantheonsorbonne.cri.grid.Grid;
import fr.pantheonsorbonne.cri.grid.parity.TripleParity;

public class GridParity extends Grid {
    public TripleParity getLine(int line) {
        return new TripleParity(this.grid[line][0], this.grid[line][1], this.grid[line][2]);
    }

    public TripleParity getCol(int line) {
        return new TripleParity(this.grid[0][line], this.grid[1][line], this.grid[2][line]);
    }

    public TripleParity getDiag(DiagonalSpec diagSpec) {
        return new TripleParity(
                this.get(diagSpec.coordinates[0][0], diagSpec.coordinates[0][1]),
                this.get(diagSpec.coordinates[1][0], diagSpec.coordinates[1][1]),
                this.get(diagSpec.coordinates[2][0], diagSpec.coordinates[2][1])
        );
    }
}
