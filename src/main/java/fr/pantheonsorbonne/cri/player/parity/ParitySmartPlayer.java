package fr.pantheonsorbonne.cri.player.parity;

import fr.pantheonsorbonne.cri.grid.DiagonalSpec;
import fr.pantheonsorbonne.cri.grid.Grid;
import fr.pantheonsorbonne.cri.grid.Triple;
import fr.pantheonsorbonne.cri.grid.parity.ParityGrid;
import fr.pantheonsorbonne.cri.grid.parity.ParityTriple;
import fr.pantheonsorbonne.cri.player.DumbPlayer;
import fr.pantheonsorbonne.cri.player.Player;


import java.util.Arrays;
import java.util.Random;

public class ParitySmartPlayer extends ParityDumbPlayer {
    private int oddOrEven;  // true si le joueur utilise les chiffres impairs, false sinon
    private boolean haveOdds;
    public ParitySmartPlayer(String name, boolean haveOdds) {
        super(name,haveOdds);
        this.oddOrEven = haveOdds?1:0; //0 si il joue pair, 1 si il joue impair
    }
    protected Integer[] getPlayables(Grid grid) {
        // Utiliser la grille pour déterminer les mouvements valides
        Integer[] allMoves = new Integer[Grid.size * Grid.size];
        for (int i = 0; i < allMoves.length; i++) {
            allMoves[i] = i + 1;
        }

        return Arrays.stream(allMoves)
                .filter(move -> !grid.contains(move))
                .toArray(Integer[]::new);
    }

    protected int[] chooseSmartMove(Grid grid, Integer[] playable) {
        // Logique spécifique pour choisir un mouvement intelligent en fonction des règles du jeu
        int[]smartMove = new int[3];
        if (grid.get(1, 1)==null) {
            return new int[]{1,1}; //jouer au centre en priorité
        }
        //check si on peut bloquer une win
        smartMove=this.checkPositionAJouer(grid,playable,haveOdds);
        if (smartMove!=null)
            return smartMove;
        //et si il y a rien a bloquer, check pour une win a nous
        smartMove = this.checkPositionAJouer(grid,playable,!haveOdds);
        if (smartMove!=null) {
            return smartMove;}
        return null;
        
    }
        

    protected int getPlayerNumber() {
        // Retourner le numéro du joueur spécifique à cette instance de ParitySmartPlayer
        return oddOrEven;
    }

    @Override
    public void play(Grid grid){
        Random random =new Random();
        Integer playable [] = getPlayables(grid);
        if (playable.length==0) {
            System.out.println("No valid moves available");
            return;
        }
        int[] smartMove = chooseSmartMove(grid,playable);
        if (smartMove!=null)
        grid.set(smartMove[0],smartMove[1],playable[random.nextInt(0,playable.length)]);
        else 
            super.play(grid);
    }
    private int[] checkPositionAJouer(Grid grid,Integer[]playable,boolean oddsEvens) {
        if (oddsEvens) {
            for (int i = 0;i<3;i++) {
                ParityTriple triple = ((ParityGrid) grid).getCol(i);
                if (triple.countNull()==1&&triple.allEvenUseful()) {
                    return new int[]{triple.firstNullIndex(),i,playable[(int) Math.random()*playable.length]};
                }
                triple = ((ParityGrid) grid).getLine(i);
                if (triple.countNull()==1&&triple.allEvenUseful()) {
                    return new int[]{i,triple.firstNullIndex(),playable[(int) Math.random()*playable.length]};
                }
            }
            ParityTriple triple = ((ParityGrid)grid).getDiag(DiagonalSpec.NORTH_WEST_SUD_EAST);
            if (triple.countNull()==1&&triple.allEvenUseful()) {
                return new int[] {triple.firstNullIndex(),triple.firstNullIndex(),(int) Math.random()*playable.length};
            }
            triple = ((ParityGrid)grid).getDiag(DiagonalSpec.SUD_WEST_NORTH_EAST);
            if (triple.countNull()==1&&triple.allEvenUseful()) {
                return new int[] {3-triple.firstNullIndex(),triple.firstNullIndex(),(int) Math.random()*playable.length};
            }
        }
        else {
            for (int i = 0;i<3;i++) {
                ParityTriple triple = ((ParityGrid) grid).getCol(i);
                if (triple.countNull()==1&&triple.allOddUseful()) {
                    return new int[]{triple.firstNullIndex(),i,playable[(int) Math.random()*playable.length]};
                }
                triple = ((ParityGrid) grid).getLine(i);
                if (triple.countNull()==1&&triple.allOddUseful()) {
                    return new int[]{i,triple.firstNullIndex(),playable[(int) Math.random()*playable.length]};
                }
            }
            ParityTriple triple = ((ParityGrid)grid).getDiag(DiagonalSpec.NORTH_WEST_SUD_EAST);
            if (triple.countNull()==1&&triple.allOddUseful()) {
                return new int[] {triple.firstNullIndex(),triple.firstNullIndex(),(int) Math.random()*playable.length};
            }
            triple = ((ParityGrid)grid).getDiag(DiagonalSpec.SUD_WEST_NORTH_EAST);
            if (triple.countNull()==1&&triple.allOddUseful()) {
                return new int[] {3-triple.firstNullIndex(),triple.firstNullIndex(),(int) Math.random()*playable.length};
            }
        }
        return null;
    }

       
    
}
