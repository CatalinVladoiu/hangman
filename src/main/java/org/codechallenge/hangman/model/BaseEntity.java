package org.codechallenge.hangman.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by catalin.vladoiu on 10/26/2014.
 */
@MappedSuperclass
public class BaseEntity<T> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected T id;


    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
