package fr.alex.kata.marsrover.domain;

import fr.alex.kata.marsrover.domain.exception.AbstractBusinessException;

/**
 * Created by alex on 01/06/17.
 */
public class RemoteOrder {

    private Order order;

    public RemoteOrder(Order order) {
        this.order = order;
    }

    public Rover execute() throws AbstractBusinessException{
        return order.execute();
    }
}
