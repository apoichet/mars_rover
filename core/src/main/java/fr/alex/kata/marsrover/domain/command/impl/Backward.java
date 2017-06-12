package fr.alex.kata.marsrover.domain.command.impl;

import fr.alex.kata.marsrover.domain.MarsMap;
import fr.alex.kata.marsrover.domain.Order;
import fr.alex.kata.marsrover.domain.Rover;
import fr.alex.kata.marsrover.domain.exception.AbstractBusinessException;
import fr.alex.kata.marsrover.domain.exception.LocationException;

import static fr.alex.kata.marsrover.domain.exception.LocationException.STOP_BACKWARD;

/**
 * Created by alex on 01/06/17.
 */
public class Backward implements Order {

    Rover rover;

    public Backward(Rover rover) {
        this.rover = rover;
    }

    @Override
    public Rover execute() throws AbstractBusinessException{
        Rover roverBackward = rover.backward();
        if (roverBackward.isOut(MarsMap.getInstance())){
            throw new LocationException(STOP_BACKWARD);
        }
        return roverBackward;
    }
}
