package fr.pantheonsorbonne.cri.player;

import fr.pantheonsorbonne.cri.grid.Grid;

import java.util.Random;

public abstract class DumbPlayer extends Player {

    Random random = new Random();
    public DumbPlayer(String name) {
        super(name);
    }

    @Override
    public void play(Grid grid) {
        Integer playable[] = getPlayables();
        for(int i = 0 ; i< playable.length;i++){
            if(grid.contains(playable[i])){
                playable[i]=-1;
            }
        }
        Integer p = -1;
        while (p == -1) {
            p = playable[random.nextInt(0, playable.length)];
        }


        while (true) {
            int x = random.nextInt(0, Grid.size);
            int y = random.nextInt(0, Grid.size);
            if (grid.get(x, y) == null) {
                grid.set(x, y, p);
                break;
            }
        }
    }

    protected abstract Integer[] getPlayables();
}
