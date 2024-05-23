package com.ie.ebingo21.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {
    @Id
    private String id;
    @OneToMany
    private List<Card> card;
    @ElementCollection
    private List<Integer> pulledNumbers;

    public Game() {
    }

    public Game(String id) {
        this.id = id;
        card = new ArrayList<Card>();
        pulledNumbers = new ArrayList<Integer>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    public List<Integer> getPulledNumbers() {
        return pulledNumbers;
    }

    public void setPulledNumbers(List<Integer> pulledNumbers) {
        this.pulledNumbers = pulledNumbers;
    }
}
