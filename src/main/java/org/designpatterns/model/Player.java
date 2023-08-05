package org.designpatterns.model;

public class Player {
    public Piece piece;
    public String name;

    public Player(Piece piece, String name) {
        this.piece = piece;
        this.name = name;
    }
}
