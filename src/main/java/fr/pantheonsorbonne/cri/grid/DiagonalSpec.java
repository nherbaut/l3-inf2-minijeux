package fr.pantheonsorbonne.cri.grid;

public enum DiagonalSpec {
    NORTH_WEST_SUD_EAST(new Integer[][]{{0, 0}, {1, 1}, {2, 2}}),
    SUD_WEST_NORTH_EAST(new Integer[][]{{2, 0}, {1, 1}, {0, 2}});

    public Integer[][] getCoordinates() {
        return coordinates;
    }

    final public Integer[][] coordinates;

    DiagonalSpec(Integer[][] coordinates) {
        this.coordinates = coordinates;
    }


}
