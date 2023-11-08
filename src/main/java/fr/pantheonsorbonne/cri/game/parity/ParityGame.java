package fr.pantheonsorbonne.cri.game.parity;

import fr.pantheonsorbonne.cri.game.GameAlternateTurn;
import fr.pantheonsorbonne.cri.game.LineColDiaWinninGame;
import fr.pantheonsorbonne.cri.grid.Grid;
import fr.pantheonsorbonne.cri.grid.parity.GridParity;
import fr.pantheonsorbonne.cri.player.Player;

public class ParityGame extends GameAlternateTurn implements LineColDiaWinninGame {

    GridParity gridParity;

    public ParityGame(Player player1, Player player2) {
        super(player1, player2);
        this.gridParity=new GridParity();
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
