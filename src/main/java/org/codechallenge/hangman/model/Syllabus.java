package org.codechallenge.hangman.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by catalin.vladoiu on 10/26/2014.
 */
@Entity
@Table(name = "syllabus")
public class Syllabus extends BaseEntity<Integer> {

    @Column(name="phrase")
    private String phrase;

    public Syllabus() {}

    public Syllabus(String phrase) { this.phrase = phrase; }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public boolean containsLetter(String letter) {
        return phrase.toLowerCase().contains(letter.toLowerCase());
    }

    public List<Integer> getLetterPositions(String letter) {
        List<Integer> positions = new ArrayList<>();
        for(int i = 0; i < phrase.length(); i++){
            if(String.valueOf(phrase.charAt(i)).equalsIgnoreCase(letter)){
                positions.add(i);
            }
        }
        return positions;
    }
}
