package fr.alex.kata.marsrover.function.move.cartesian;

import fr.alex.kata.marsrover.domain.common.OrientationEnum;
import fr.alex.kata.marsrover.domain.common.RotationEnum;
import org.junit.Test;

import static fr.alex.kata.marsrover.domain.common.OrientationEnum.*;
import static fr.alex.kata.marsrover.domain.common.RotationEnum.Left;
import static fr.alex.kata.marsrover.domain.common.RotationEnum.Right;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alex on 02/06/17.
 */
public class CartesianRotateTest {

    private CartesianRotate rotate = new CartesianRotate();
    private RoverCartesian roverResult;
    private RoverCartesian roverInit;


    @Test
    public void should_rover_rotate_to_the_left_from_North_direction(){
        give_an_init_rover(0, 0, North);
        when_rotate_rover(Left);
        then_assert_rover_is_oriented(West);
    }

    @Test
    public void should_rover_rotate_to_the_right_from_North_direction(){
        give_an_init_rover(0, 0, North);
        when_rotate_rover(Right);
        then_assert_rover_is_oriented(East);
    }

    @Test
    public void should_rover_rotate_to_the_left_from_South_direction(){
        give_an_init_rover(0, 0, South);
        when_rotate_rover(Left);
        then_assert_rover_is_oriented(East);
    }

    @Test
    public void should_rover_rotate_to_the_right_from_South_direction(){
        give_an_init_rover(0, 0, South);
        when_rotate_rover(Right);
        then_assert_rover_is_oriented(West);
    }

    @Test
    public void should_rover_rotate_to_the_left_from_East_direction(){
        give_an_init_rover(0, 0, East);
        when_rotate_rover(Left);
        then_assert_rover_is_oriented(North);
    }

    @Test
    public void should_rover_rotate_to_the_right_from_East_direction(){
        give_an_init_rover(0, 0, East);
        when_rotate_rover(Right);
        then_assert_rover_is_oriented(South);
    }

    @Test
    public void should_rover_rotate_to_the_left_from_West_direction(){
        give_an_init_rover(0, 0, West);
        when_rotate_rover(Left);
        then_assert_rover_is_oriented(South);
    }

    @Test
    public void should_rover_rotate_to_the_right_from_West_direction(){
        give_an_init_rover(0, 0, West);
        when_rotate_rover(Right);
        then_assert_rover_is_oriented(North);
    }


    private void then_assert_rover_is_oriented(OrientationEnum orientationEnum){
        assertThat(roverResult.orientationEnum).isEqualTo(orientationEnum);
    }

    private void give_an_init_rover(int positionX, int positionY, OrientationEnum orientation){
        roverInit = new RoverCartesian(positionX, positionY, orientation);
    }

    private void when_rotate_rover(RotationEnum rotation){
        roverResult = rotate.rotate(roverInit, rotation);
    }



}