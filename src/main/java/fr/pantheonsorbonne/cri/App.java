package fr.pantheonsorbonne.cri;

import fr.pantheonsorbonne.cri.game.Game;
import fr.pantheonsorbonne.cri.game.parity.ParityGame;
import fr.pantheonsorbonne.cri.game.sum.Sum10Game;
import fr.pantheonsorbonne.cri.game.sum.Sum15Game;
import fr.pantheonsorbonne.cri.player.parity.ParityDumbPlayer;
import fr.pantheonsorbonne.cri.player.parity.ParitySmartPlayer;
import fr.pantheonsorbonne.cri.player.sum.DumbSumPlayer;
import fr.pantheonsorbonne.cri.player.sum.Smart10SumPlayer;
import fr.pantheonsorbonne.cri.player.sum.Smart15SumPlayer;

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



        Game game15 = new Sum15Game( new Smart15SumPlayer("nicolas"), new DumbSumPlayer("toto"));
       // game15.play();

        Game game10 = new Sum10Game( new Smart10SumPlayer("nicolas"), new DumbSumPlayer("toto"));
        //game10.play();

        Game game = new ParityGame(new ParityDumbPlayer("sara", true), new ParitySmartPlayer("noam", false));
        game.play();


    }
}
