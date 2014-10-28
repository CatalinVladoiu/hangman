package org.codechallenge.hangman.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by catalin.vladoiu on 10/25/2014.
 */
@Entity
@Table(name = "attempt")
public class Attempt extends BaseEntity<Integer> {

    @Column(name="letter", length = 1)
    private String letter;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="game_id")
    @JsonIgnore
    private Game game;

    @Column(name = "isGuessed")
    private Boolean isGuessed;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isGuessed() {
        return isGuessed;
    }

    public void setGuessed(boolean isGuessed) {
        this.isGuessed = isGuessed;
    }
}
