package org.designpatterns.model;




import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public Piece[][] board;

    public Board(int size) {
        this.size = size;
        board = new Piece[size][size];
    }

   public boolean addPiece(int row,int column,Piece playingPiece){
        if(board[row][column] != null)
        {
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }

   public List<List<Integer>> getFreeCells(){
        List<List<Integer>> freeCellList = new ArrayList<>();
        for(int i = 0 ; i<size; i++){
            List<Integer> pairList = new ArrayList<>();
            for(int j = 0 ; j<size;j++){
                if(board[i][j] == null){
                    pairList.add(i);
                    pairList.add(j);
                    freeCellList.add(pairList);
                }
            }
        }
        return freeCellList;
   }

   public void printBoard(){
       for(int i = 0 ; i<size; i++){
           for(int j = 0 ; j<size;j++){
               if(board[i][j] == null){
                   System.out.print(" ___ ");
               }
               else System.out.print(" " + board[i][j].pieceType.toString()+ " ");
           }
           System.out.println();
       }
   }


}
