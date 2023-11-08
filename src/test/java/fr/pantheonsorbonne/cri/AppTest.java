package fr.pantheonsorbonne.cri;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.pantheonsorbonne.cri.game.GameResult;
import fr.pantheonsorbonne.cri.game.parity.ParityGame;
import fr.pantheonsorbonne.cri.grid.Grid;
import fr.pantheonsorbonne.cri.grid.parity.GridParity;
import fr.pantheonsorbonne.cri.grid.sum.GridSum;
import fr.pantheonsorbonne.cri.player.Player;
import fr.pantheonsorbonne.cri.player.sum.SumPlayerSmart15;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void winOnLine() {


        Grid grid = new GridSum(15);
        grid.set(0, 0, 1);
        grid.set(0, 1, 6);
        Player smart = new SumPlayerSmart15("smarty");
        smart.play(grid);
        assertEquals(8, grid.get(0, 2));


    }

    @Test
    public void winOnCol() {


        Grid grid = new GridSum(15);
        grid.set(0, 0, 1);
        grid.set(1, 0, 6);
        Player smart = new SumPlayerSmart15("smarty");
        smart.play(grid);
        assertEquals(8, grid.get(2, 0));


    }

    @Test
    public void winOnDiag() {


        Grid grid = new GridSum(15);
        grid.set(0, 0, 1);
        grid.set(1, 1, 6);
        Player smart = new SumPlayerSmart15("smarty");
        smart.play(grid);
        assertEquals(8, grid.get(2, 2));
    }

    @Test
    public void Play9OnNullGrid() {


        Grid grid = new GridSum(15);
        grid.fill(null);
        Player smart = new SumPlayerSmart15("smarty");
        smart.play(grid);
        assertEquals(9, grid.get(1, 1));
    }

    @Test
    public void testGrid1() {
        Grid grid = new GridSum(15);
        grid.set(1, 1, 9);
        grid.set(1, 2, 5);
        grid.set(2, 2, 8);
        Player smart = new SumPlayerSmart15("smarty");
        smart.play(grid);
        assertEquals(1, grid.get(1, 0));

    }

    @Test
    public void testGrid2() {
        Grid grid = new GridSum(15);
        grid.set(0, 0, 1);
        grid.set(1, 0, 7);
        grid.set(2, 0, 3);
        grid.set(1, 2, 5);
        grid.set(2, 2, 8);

        Player smart = new SumPlayerSmart15("smarty");
        smart.play(grid);
        assertEquals(4, grid.get(2, 1));

    }

    @Test
    public void testGrid3() {
        Grid grid = new GridParity();
        grid.set(0, 0, 5);
        grid.set(1, 0, null);
        grid.set(2, 0, 2);
        grid.set(0, 1, 3);
        grid.set(1, 1, null);
        grid.set(2, 1, 6);
        grid.set(0, 2, 7);
        grid.set(1, 2, 4);
        grid.set(2, 2, 9);

        ParityGame game = new ParityGame(null,null);
        assertEquals(GameResult.ONGOING,game.gameStatus());

    }






}
