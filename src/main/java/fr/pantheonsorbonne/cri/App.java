package fr.pantheonsorbonne.cri;

import fr.pantheonsorbonne.cri.game.Game;
import fr.pantheonsorbonne.cri.game.parity.ParityGame;
import fr.pantheonsorbonne.cri.game.sum.Sum10Game;
import fr.pantheonsorbonne.cri.game.sum.Sum15Game;
import fr.pantheonsorbonne.cri.player.parity.ParityDumbPlayer;
import fr.pantheonsorbonne.cri.player.sum.SumPlayerDumb;
import fr.pantheonsorbonne.cri.player.sum.SumPlayerSmart10;
import fr.pantheonsorbonne.cri.player.sum.SumPlayerSmart15;

/**
 * The main class for the application.
 */
public final class App {

    private App() {

    }

    ;

    /**
     * main entrypoint for my class.
     *
     * @param args a bunch of string from the cli
     */
    public static void main(final String[] args) {



        Game game15 = new Sum15Game( new SumPlayerSmart15("nicolas"), new SumPlayerDumb("toto"));
        game15.play();

        Game game10 = new Sum10Game( new SumPlayerSmart10("nicolas"), new SumPlayerDumb("toto"));
        game10.play();

        Game game = new ParityGame(new ParityDumbPlayer("nicolas",true),new ParityDumbPlayer("toto",false));
        game.play();


    }
}
