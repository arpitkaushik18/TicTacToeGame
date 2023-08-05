package org.designpatterns;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        TicTacToe game = new TicTacToe();
        game.init();
        System.out.println("game winner is: " + game.startGame());

    }
}
