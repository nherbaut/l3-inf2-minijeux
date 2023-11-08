package fr.pantheonsorbonne.cri.game;

import fr.pantheonsorbonne.cri.player.Player;

public abstract class GameImpl implements Game {

    protected final Player player1;
    protected final Player player2;

    public GameImpl(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    @Override
    public void play() {
        for (; ; ) {
            Player p = getNextPlayer();
            p.play(this.getGrid());
            System.out.println(p.getName());
            System.out.println(this.getGrid().toString());
            switch (gameStatus()) {

                case ONGOING -> {
                    continue;
                }
                case DRAW -> {
                    System.out.println("It's a Draw");
                    return;
                }
                case WIN -> {
                    System.out.println(p.getName() + " won!");
                    return;
                }
            }
        }
    }

}
