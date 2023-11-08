package fr.pantheonsorbonne.cri.grid;

import java.util.HashSet;
import java.util.Set;

public abstract class Grid {

    public static final int size = 3;
    protected Integer[][] grid = new Integer[size][size];

    public Integer get(int x, int y) {
        return grid[x][y];
    }

    public Iterable<Integer> getValues() {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                values.add(this.grid[i][j]);
            }
        }
        return values;
    }

    public boolean isFull() {
        return !contains(null);
    }

    public boolean contains(Integer integer) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (this.grid[i][j] == integer) {
                    return true;
                }
            }
        }
        return false;
    }

    public void set(int x, int y, Integer value) {
        grid[x][y] = value;
    }

    public void fill(Integer value) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                this.set(i, j, value);
            }
        }
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                stringBuilder.append((grid[i][j] == null ? "0" : grid[i][j]) + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    public boolean isEmpty() {
        for (int i = 0; i < Grid.size; i++) {
            if (this.getLine(i).countNull() != Grid.size) {
                return false;
            }

        }
        return true;
    }

    public abstract Triple getLine(int line);

    public abstract Triple getCol(int line);

    public abstract Triple getDiag(DiagonalSpec spec);
}
