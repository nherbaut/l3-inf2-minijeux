package fr.pantheonsorbonne.cri.game;

import fr.pantheonsorbonne.cri.player.Player;

import java.util.Random;

public abstract class GameAlternateTurn extends GameImpl {

    private final Random random = new Random();

    protected Player currentPlayer;

    public GameAlternateTurn(Player player1, Player player2) {
        super( player1, player2);
    }

    @Override
    public Player getNextPlayer() {
        if (currentPlayer == null) {
            if (random.nextBoolean()) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }

        } else {
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
        return currentPlayer;
    }
}
