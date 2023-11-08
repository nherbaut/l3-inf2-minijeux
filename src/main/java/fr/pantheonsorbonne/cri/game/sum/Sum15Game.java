package fr.pantheonsorbonne.cri.game.sum;

import fr.pantheonsorbonne.cri.game.AlternateTurnGame;
import fr.pantheonsorbonne.cri.game.LineColDiaWinninGame;
import fr.pantheonsorbonne.cri.player.Player;
import fr.pantheonsorbonne.cri.grid.sum.SumGrid;

public class Sum15Game extends AlternateTurnGame implements LineColDiaWinninGame {

    SumGrid grid;

    public Sum15Game(Player player1, Player player2) {
        super(player1, player2);
        this.grid = new SumGrid(15);
    }


    @Override
    public SumGrid getGrid() {
        return this.grid;
    }


}
