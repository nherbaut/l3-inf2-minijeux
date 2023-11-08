package fr.pantheonsorbonne.cri.game.parity;

import fr.pantheonsorbonne.cri.game.AlternateTurnGame;
import fr.pantheonsorbonne.cri.game.LineColDiaWinninGame;
import fr.pantheonsorbonne.cri.grid.Grid;
import fr.pantheonsorbonne.cri.grid.parity.ParityGrid;
import fr.pantheonsorbonne.cri.player.Player;

public class ParityGame extends AlternateTurnGame implements LineColDiaWinninGame {

    ParityGrid gridParity;

    public ParityGame(Player player1, Player player2) {
        super(player1, player2);
        this.gridParity=new ParityGrid();
    }

    @Override
    public Grid getGrid() {
        return gridParity;
    }

    @Override
    public Player getNextPlayer() {
        if (currentPlayer == null) {
            currentPlayer = player1;

        }
        return super.getNextPlayer();
    }


}
