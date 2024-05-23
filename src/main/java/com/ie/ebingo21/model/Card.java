package com.ie.ebingo21.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

@Entity
public class Card {
    @Id
    private String id;
    /*@ManyToOne
    private Game game;*/
    private String game_id;
    @ElementCollection
    private List<Integer> b;
    @ElementCollection
    private List<Integer> i;
    @ElementCollection
    private List<Integer> n;
    @ElementCollection
    private List<Integer> g;
    @ElementCollection
    private List<Integer> o;

    public Card() {
    }

    /*public Card(String id, Game game, List<Integer> b, List<Integer> i, List<Integer> n, List<Integer> g, List<Integer> o) {
        this.id = id;
        this.game = game;
        this.b = b;
        this.i = i;
        this.n = n;
        this.g = g;
        this.o = o;
    }*/

    public Card(String id, Game game, List<Integer> b, List<Integer> i, List<Integer> n, List<Integer> g, List<Integer> o) {
        this.id = id;
        this.game_id = game.getId();
        this.b = b;
        this.i = i;
        this.n = n;
        this.g = g;
        this.o = o;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }*/

    public List<Integer> getB() {
        return b;
    }

    public void setB(List<Integer> b) {
        this.b = b;
    }

    public List<Integer> getI() {
        return i;
    }

    public void setI(List<Integer> i) {
        this.i = i;
    }

    public List<Integer> getN() {
        return n;
    }

    public void setN(List<Integer> n) {
        this.n = n;
    }

    public List<Integer> getG() {
        return g;
    }

    public void setG(List<Integer> g) {
        this.g = g;
    }

    public List<Integer> getO() {
        return o;
    }

    public void setO(List<Integer> o) {
        this.o = o;
    }
}
