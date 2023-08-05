package org.designpatterns;

import org.designpatterns.model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    public Deque<Player> playerList;
    public Board Gboard;

    void init(){
         Gboard = new Board(3);

         Player player1 = new Player(new PieceX(), "Jatin");
         Player player2 = new Player(new PieceO(),"Suraj");

         playerList = new LinkedList<>();
         playerList.add(player1);
         playerList.add(player2);
    }

    public String startGame(){
        boolean isWinner = true;
        while (isWinner){

            Player playerTurn = playerList.removeFirst();

            Gboard.printBoard();

            List<List<Integer>> getFreeCellList = Gboard.getFreeCells();

            if(getFreeCellList.isEmpty()){
                isWinner = false;
                continue;
            }
            //read the user input
            System.out.print("Player:" + playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean isPieceAddedSuccessfully = Gboard.addPiece(inputRow,inputColumn,playerTurn.piece);
            if(!isPieceAddedSuccessfully) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Invalid entry, try again");
                playerList.addFirst(playerTurn);
                continue;
            }
            playerList.addLast(playerTurn);

            boolean isWinnerAvailable = checkWinner(inputRow,inputColumn,playerTurn.piece);
            if (isWinnerAvailable){
                return playerTurn.name;
            }
        }
        return "tie";
    }

    private boolean checkWinner(int inputRow, int inputColumn, Piece piece) {

        boolean rowWin = true;
        boolean columnWin = true;
        boolean digWin = true;
        boolean antiDigWin = true;


        for(int i = 0 ; i < Gboard.size; i++){
            if(Gboard.board[inputRow][i] == null || Gboard.board[inputRow][i].pieceType != piece.pieceType){
                rowWin = false;
                break;
            }
        }

        for(int i = 0 ; i < Gboard.size; i++){
            if(Gboard.board[i][inputColumn] == null || Gboard.board[i][inputColumn].pieceType != piece.pieceType){
                columnWin = false;
                break;
            }
        }

        for(int i = 0, j =0 ; i < Gboard.size && j < Gboard.size; i++,j++){
            if(Gboard.board[i][j] == null || Gboard.board[i][j].pieceType != piece.pieceType){
                digWin = false;
                break;
            }
        }

        for(int i = 0, j = Gboard.size-1 ; i < Gboard.size && j >=0 ; i++,j--){
            if(Gboard.board[i][j] == null || Gboard.board[i][j].pieceType != piece.pieceType){
                antiDigWin = false;
                break;
            }
        }

        return rowWin || columnWin || digWin || antiDigWin;
    }


}
