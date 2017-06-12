package fr.alex.kata.marsrover.service.instruction.text;

import fr.alex.kata.marsrover.domain.Order;
import fr.alex.kata.marsrover.domain.command.impl.Backward;
import fr.alex.kata.marsrover.domain.command.impl.Forward;
import fr.alex.kata.marsrover.domain.command.impl.TurnLeft;
import fr.alex.kata.marsrover.domain.command.impl.TurnRight;
import org.junit.Test;

import java.util.Optional;

import static fr.alex.kata.marsrover.service.instruction.text.OrderFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alex on 25/05/17.
 */
public class OrderFactoryTest {

    private StringBuilder commandInput = new StringBuilder();
    private Optional<Order> order;

    @Test
    public void should_transform_turn_left_command_from_string_L(){
        give_input_command(LEFT_COMMAND);
        when_adapt_command_input();
        then_assert_that_output_contains_command(TurnLeft.class, 0);
    }

    @Test
    public void should_transform_turn_right_command_from_string_R(){
        give_input_command(RIGHT_COMMAND);
        when_adapt_command_input();
        then_assert_that_output_contains_command(TurnRight.class, 0);
    }

    @Test
    public void should_transform_backward_command_from_string_B(){
        give_input_command(BACK_COMMAND);
        when_adapt_command_input();
        then_assert_that_output_contains_command(Backward.class, 0);
    }

    @Test
    public void should_transform_forward_command_from_string_F(){
        give_input_command(FORWARD_COMMAND);
        when_adapt_command_input();
        then_assert_that_output_contains_command(Forward.class, 0);
    }

    private void give_input_command(String commandStr){
        commandInput.append(commandStr);
    }

    private void when_adapt_command_input(){
        order = OrderFactory.createOrder(null, commandInput.toString());
    }

    private void then_assert_that_output_contains_command(Class<?> commandClass, int position){
        assertThat(order).isNotNull();
        assertThat(order.get().getClass()).isEqualTo(commandClass);
    }



}
