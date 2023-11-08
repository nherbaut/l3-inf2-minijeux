package fr.pantheonsorbonne.cri.grid.sum;

import fr.pantheonsorbonne.cri.grid.DiagonalSpec;
import fr.pantheonsorbonne.cri.grid.Grid;

public  class SumGrid extends Grid {

    public int getWinningSum() {
        return winningSum;
    }

    private final int winningSum;
    public SumGrid(int winningSum){
        this.winningSum=winningSum;
    }


    public SumTriple getLine(int line) {
        return new SumTriple(getWinningSum(), this.grid[line][0], this.grid[line][1], this.grid[line][2]);
    }

    public SumTriple getCol(int line) {
        return new SumTriple(getWinningSum(), this.grid[0][line], this.grid[1][line], this.grid[2][line]);
    }

    public SumTriple getDiag(DiagonalSpec diagSpec) {
        return new SumTriple(getWinningSum(),
                this.get(diagSpec.coordinates[0][0], diagSpec.coordinates[0][1]),
                this.get(diagSpec.coordinates[1][0], diagSpec.coordinates[1][1]),
                this.get(diagSpec.coordinates[2][0], diagSpec.coordinates[2][1])
        );
    }
}
