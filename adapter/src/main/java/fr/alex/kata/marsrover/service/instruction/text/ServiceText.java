package fr.alex.kata.marsrover.service.instruction.text;

import fr.alex.kata.marsrover.domain.MarsMap;
import fr.alex.kata.marsrover.domain.Order;
import fr.alex.kata.marsrover.domain.RemoteOrder;
import fr.alex.kata.marsrover.domain.Rover;
import fr.alex.kata.marsrover.domain.exception.AbstractBusinessException;
import fr.alex.kata.marsrover.service.ServiceOrder;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * Created by alex on 21/05/17.
 */
class ServiceText implements ServiceOrder<String> {


    @Override
    public Rover execute(final int idRover, final String instructions) throws AbstractBusinessException {
        MarsMap marsMap = MarsMap.getInstance();
        Optional<Rover> rover = marsMap.findRover(idRover);
        Rover output = rover.get();
        if (rover.isPresent()){
            String[] instructTab = StringUtils.split(instructions);
            for (String instruction : instructTab) {
                Optional<Order> order = OrderFactory.createOrder(output, instruction);
                if (order.isPresent()){
                    RemoteOrder remoteOrder = new RemoteOrder(order.get());
                    output = remoteOrder.execute();
                }
            }
        }
        else{
            //throw new exception
        }

        return output;

    }
}
