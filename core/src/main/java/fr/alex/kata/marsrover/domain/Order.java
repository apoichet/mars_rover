package fr.alex.kata.marsrover.domain;

import fr.alex.kata.marsrover.domain.exception.AbstractBusinessException;

/**
 * Created by alex on 01/06/17.
 */
public interface Order {

    Rover execute() throws AbstractBusinessException;

}
