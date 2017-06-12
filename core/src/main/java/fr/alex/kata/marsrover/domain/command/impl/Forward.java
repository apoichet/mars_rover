package fr.alex.kata.marsrover.domain.command.impl;

import fr.alex.kata.marsrover.domain.MarsMap;
import fr.alex.kata.marsrover.domain.Order;
import fr.alex.kata.marsrover.domain.Rover;
import fr.alex.kata.marsrover.domain.exception.AbstractBusinessException;
import fr.alex.kata.marsrover.domain.exception.LocationException;

import static fr.alex.kata.marsrover.domain.exception.LocationException.STOP_FORWARD;

/**
 * Created by alex on 01/06/17.
 */
public class Forward implements Order {

    Rover rover;

    public Forward(Rover rover) {
        this.rover = rover;
    }

    @Override
    public Rover execute() throws AbstractBusinessException {
        Rover roverForward = rover.forward();
        if (roverForward.isOut(MarsMap.getInstance())){
            throw new LocationException(STOP_FORWARD);
        }
        return roverForward;
    }
}
