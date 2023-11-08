package fr.pantheonsorbonne.cri.player.sum;

import fr.pantheonsorbonne.cri.grid.DiagonalSpec;
import fr.pantheonsorbonne.cri.grid.Grid;
import fr.pantheonsorbonne.cri.grid.sum.GridSum;

public abstract class SumPlayerSmart extends SumPlayerDumb {

    public SumPlayerSmart(String name) {
        super(name);
    }

    @Override
    public void play(Grid g) {
        if (!(g instanceof GridSum)) {
            throw new RuntimeException("unsupported grid type");
        }
        GridSum grid = (GridSum) g;

        if(playOpening(grid)){
            return;
        }
        Integer playable[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (Integer i : grid.getValues()) {
            if (i != null) {
                playable[i - 1] = -1;
            }
        }

        int[] nextNumber = getNextWinningMove(grid, playable);
        if (nextNumber != null) { //i've won!
            grid.set(nextNumber[0], nextNumber[1], nextNumber[2]);
            return;
        }

        for (int i = 0; i < Grid.size; i++) {
            for (int j = 0; i < Grid.size; i++) {
                if (grid.get(i, j) == null) {
                    for (Integer p : playable) {
                        if (p != -1) {

                            grid.set(i, j, p);
                            Integer[] nextPlayable = getNextOtherPlayable(p, playable);
                            nextNumber = getNextWinningMove(grid, nextPlayable);
                            if (nextNumber == null) {

                                return;
                            } else {
                                //don't play that or they win!
                                grid.set(i, j, null);
                            }
                        }
                    }
                }
            }
        }

        //play dumb
        super.play(grid);

    }

    protected abstract boolean playOpening(GridSum gridSum);

    private static Integer[] getNextOtherPlayable(Integer p, Integer[] playable) {
        Integer nextPlayable[] = new Integer[playable.length];
        for (int k = 0; k < nextPlayable.length; k++) {
            nextPlayable[k] = (playable[k] != p ? playable[k] : -1);
        }
        return nextPlayable;
    }

    private int[] getNextWinningMove(GridSum grid, Integer[] playable) {
        //look for winning lines
        for (int i = 0; i < Grid.size; i++) {
            int leftToWin = getTargetSum() - grid.getLine(i).sum(true);
            if (grid.getLine(i).countNull() == 1 && grid.getLine(i).sum(true) < getTargetSum() && leftToWin >= 1 && leftToWin <= 9 && playable[leftToWin - 1] != -1) {


                return new int[]{i, grid.getLine(i).firstNullIndex(), leftToWin};
            }
        }

        //look for winning Col
        for (int i = 0; i < Grid.size; i++) {
            int leftToWin = getTargetSum() - grid.getCol(i).sum(true);
            if (grid.getCol(i).countNull() == 1 && grid.getCol(i).sum(true) < getTargetSum() && leftToWin >= 1 && leftToWin <= 9 && playable[leftToWin - 1] != -1) {

                return new int[]{grid.getCol(i).firstNullIndex(), i, leftToWin};

            }
        }

        //look for winning Diag
        for (DiagonalSpec spec : DiagonalSpec.values()) {
            int leftToWin = getTargetSum() - grid.getDiag(spec).sum(true);
            if (grid.getDiag(spec).countNull() == 1 && grid.getDiag(spec).sum(true) < getTargetSum() && leftToWin >= 1 && leftToWin <= 9 && playable[leftToWin - 1] != -1) {

                Integer[] coordinates = spec.getCoordinates()[grid.getDiag(spec).firstNullIndex()];

                return new int[]{coordinates[0], coordinates[1], leftToWin};
            }
        }

        return null;
    }

    protected abstract int getTargetSum();
}
