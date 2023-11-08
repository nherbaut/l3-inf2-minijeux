package fr.pantheonsorbonne.cri.grid.sum;

import fr.pantheonsorbonne.cri.grid.Triple;

import java.util.Objects;

public class TripleSummation extends Triple {
    int winningSum;
    public TripleSummation(int winningSum,Integer x, Integer y, Integer z) {
        super(x, y, z);
        this.winningSum=winningSum;
    }

    @Override
    public boolean winningTriple() {
        if (Objects.equals(this.sum(false), winningSum)) {
            return true;
        }
        return false;
    }

    public Integer sum(boolean nullAsZeros) {
        Integer res = 0;
        for (Integer item : new Integer[]{x, y, z}) {
            if (item == null) {
                if (!nullAsZeros) {
                    return null;
                }
            } else {
                res += item;
            }

        }
        return res;
    }
}
