package fr.pantheonsorbonne.cri.game.sum;

import fr.pantheonsorbonne.cri.game.GameAlternateTurn;
import fr.pantheonsorbonne.cri.game.LineColDiaWinninGame;
import fr.pantheonsorbonne.cri.player.Player;
import fr.pantheonsorbonne.cri.grid.sum.GridSum;

public class Sum15Game extends GameAlternateTurn implements LineColDiaWinninGame {

    GridSum grid;

    public Sum15Game(Player player1, Player player2) {
        super(player1, player2);
        this.grid = new GridSum(15);
    }


    @Override
    public GridSum getGrid() {
        return this.grid;
    }


}
