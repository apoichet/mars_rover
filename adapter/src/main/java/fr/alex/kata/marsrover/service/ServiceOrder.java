package fr.alex.kata.marsrover.service;

import fr.alex.kata.marsrover.domain.Rover;
import fr.alex.kata.marsrover.domain.exception.AbstractBusinessException;

/**
 * Created by alex on 26/05/17.
 */
public interface ServiceOrder<S> {

    <R extends Rover> R execute(final int idRover, final S instructions) throws AbstractBusinessException;

}
