package fr.alex.kata.marsrover.domain.command.impl;

import fr.alex.kata.marsrover.domain.Order;
import fr.alex.kata.marsrover.domain.Rover;

/**
 * Created by alex on 01/06/17.
 */
public class TurnLeft implements Order{

    Rover rover;

    public TurnLeft(Rover rover) {
        this.rover = rover;
    }

    @Override
    public Rover execute() {
        return rover.turnLeft();
    }
}
