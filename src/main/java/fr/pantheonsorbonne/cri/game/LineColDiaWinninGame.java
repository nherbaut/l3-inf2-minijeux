package fr.pantheonsorbonne.cri.game;

import fr.pantheonsorbonne.cri.game.Game;
import fr.pantheonsorbonne.cri.game.GameResult;
import fr.pantheonsorbonne.cri.grid.DiagonalSpec;
import fr.pantheonsorbonne.cri.grid.Grid;

public interface LineColDiaWinninGame extends Game {

    default public GameResult gameStatus() {
        for (int i = 0; i < Grid.size; i++) {
            if (!this.getGrid().getLine(i).hasNull() && this.getGrid().getLine(i).winningTriple()) {
                return GameResult.WIN;
            }
        }

        for (int i = 0; i < Grid.size; i++) {
            if (!this.getGrid().getCol(i).hasNull() && this.getGrid().getCol(i).winningTriple()) {
                return GameResult.WIN;
            }
        }

        for (DiagonalSpec spec : DiagonalSpec.values()) {
            if (!this.getGrid().getDiag(spec).hasNull() && this.getGrid().getDiag(spec).winningTriple()) {
                return GameResult.WIN;
            }
        }

        if (!this.getGrid().isFull()) {
            return GameResult.ONGOING;
        } else {
            return GameResult.DRAW;
        }
    }
}
