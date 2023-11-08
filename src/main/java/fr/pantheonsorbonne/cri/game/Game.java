package fr.pantheonsorbonne.cri.game;

import fr.pantheonsorbonne.cri.grid.Grid;
import fr.pantheonsorbonne.cri.player.Player;

public interface Game {
    GameResult gameStatus();

    Player getNextPlayer();

    void play();

    Grid getGrid();
}
