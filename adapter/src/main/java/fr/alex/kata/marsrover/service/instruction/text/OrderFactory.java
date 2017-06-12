package fr.alex.kata.marsrover.service.instruction.text;

import fr.alex.kata.marsrover.domain.Order;
import fr.alex.kata.marsrover.domain.Rover;
import fr.alex.kata.marsrover.domain.command.impl.Backward;
import fr.alex.kata.marsrover.domain.command.impl.Forward;
import fr.alex.kata.marsrover.domain.command.impl.TurnLeft;
import fr.alex.kata.marsrover.domain.command.impl.TurnRight;

import java.util.Optional;

/**
 * Created by alex on 09/06/17.
 */
public class OrderFactory {

    static final String LEFT_COMMAND = "L";
    public static final String RIGHT_COMMAND = "R";
    public static final String FORWARD_COMMAND = "F";
    public static final String BACK_COMMAND = "B";

    public static Optional<Order> createOrder(Rover rover, String instruction){

        Order order = null;

        switch (instruction){
            case LEFT_COMMAND: order = new TurnLeft(rover); break;
            case RIGHT_COMMAND: order = new TurnRight(rover); break;
            case FORWARD_COMMAND: order = new Forward(rover); break;
            case BACK_COMMAND: order = new Backward(rover); break;
        }

        return Optional.ofNullable(order);

    }

}
