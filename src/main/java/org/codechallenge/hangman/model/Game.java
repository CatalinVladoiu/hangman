package org.codechallenge.hangman.model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by catalin.vladoiu on 10/25/2014.
 */
@Entity
@Table(name = "game")
public class Game extends BaseEntity<Integer> {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game", fetch = FetchType.EAGER)
    @Where(clause = "isGuessed = 1")
    private List<Attempt> correctAttempts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game", fetch = FetchType.EAGER)
    @Where(clause = "isGuessed = 0")
    private List<Attempt> failedAttempts;

    @Enumerated(EnumType.STRING)
    private GameStatus gameStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "syllabus_id")
    private Syllabus syllabus;

    //TODO Mode this to a configuration file outside the .war
    @Column(name = "maxAttempts", columnDefinition = "default 6")
    private Integer maxAttempts;

    public List<Attempt> getCorrectAttempts() {
        return correctAttempts;
    }

    public void setCorrectAttempts(List<Attempt> correctAttempts) {
        this.correctAttempts = correctAttempts;
    }

    public List<Attempt> getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(List<Attempt> failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(Integer maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public void addAttempt(Attempt attempt) {
        if (attempt.isGuessed()) {
            addCorrectAttempt(attempt);
        } else {
            addFailedAttempt(attempt);
        }
    }

    private void addCorrectAttempt(Attempt correctAttempt) {
        this.correctAttempts.add(correctAttempt);
        setAttemptGame(correctAttempt);
    }

    private void addFailedAttempt(Attempt failedAttempt) {
        this.failedAttempts.add(failedAttempt);
        setAttemptGame(failedAttempt);
    }

    private void setAttemptGame(Attempt failedAttempt) {
        if (failedAttempt.getGame() != this) {
            failedAttempt.setGame(this);
        }
    }

    public boolean isWan() {
        int guessedLettersCount = 0;
        if (null != correctAttempts) {
            for (Attempt attempt : correctAttempts) {
                guessedLettersCount += syllabus.getLetterPositions(attempt.getLetter()).size();
            }
        }

        return guessedLettersCount == syllabus.getPhrase().length();
    }

    public boolean isLost() {
        if (null != correctAttempts) {
            return failedAttempts.size() == maxAttempts;
        }
        return Boolean.FALSE;
    }
}
