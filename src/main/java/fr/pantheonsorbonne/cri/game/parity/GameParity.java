package fr.pantheonsorbonne.cri.game.parity;

import fr.pantheonsorbonne.cri.game.GameAlternateTurn;
import fr.pantheonsorbonne.cri.game.LineColDiaWinninGame;
import fr.pantheonsorbonne.cri.grid.Grid;
import fr.pantheonsorbonne.cri.player.Player;

public class GameParity extends GameAlternateTurn implements LineColDiaWinninGame {
    Grid grid;

    public GameParity(Grid grid, Player player1, Player player2) {
        super(player1, player2);
        this.grid = grid;
    }


    @Override
    public Grid getGrid() {
        return this.grid;
    }
}

