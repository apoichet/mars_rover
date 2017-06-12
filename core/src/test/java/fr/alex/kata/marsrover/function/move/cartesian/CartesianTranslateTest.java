package fr.alex.kata.marsrover.function.move.cartesian;

import fr.alex.kata.marsrover.domain.common.DirectionEnum;
import fr.alex.kata.marsrover.domain.common.OrientationEnum;
import org.junit.Test;

import static fr.alex.kata.marsrover.domain.common.DirectionEnum.Back;
import static fr.alex.kata.marsrover.domain.common.DirectionEnum.Front;
import static fr.alex.kata.marsrover.domain.common.OrientationEnum.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alex on 02/06/17.
 */
public class CartesianTranslateTest {

    private CartesianTranslate translate = new CartesianTranslate();
    private RoverCartesian roverResult;
    private RoverCartesian roverInit;

    @Test
    public void should_rover_forward_for_north_direction(){
        give_an_init_rover(0,0, North);
        when_translate_rover(Front);
        then_assert_rover_is_positionning(0,1);
    }

    @Test
    public void should_rover_backward_for_south_direction(){
        give_an_init_rover(0,0, South);
        when_translate_rover(Back);
        then_assert_rover_is_positionning(0,1);
    }

    @Test
    public void should_rover_forward_for_east_direction(){
        give_an_init_rover(0,0, East);
        when_translate_rover(Front);
        then_assert_rover_is_positionning(1,0);
    }

    @Test
    public void should_rover_backward_for_west_direction(){
        give_an_init_rover(0,0, West);
        when_translate_rover(Back);
        then_assert_rover_is_positionning(1,0);
    }

    @Test
    public void should_rover_backward_for_north_direction(){
        give_an_init_rover(5,5, North);
        when_translate_rover(Back);
        then_assert_rover_is_positionning(5,4);
    }

    @Test
    public void should_rover_forward_for_south_direction(){
        give_an_init_rover(5,5, South);
        when_translate_rover(Front);
        then_assert_rover_is_positionning(5,4);
    }

    @Test
    public void should_rover_backward_for_east_direction(){
        give_an_init_rover(5,5, East);
        when_translate_rover(Back);
        then_assert_rover_is_positionning(4,5);
    }

    @Test
    public void should_rover_forward_for_west_direction(){
        give_an_init_rover(5,5, West);
        when_translate_rover(Front);
        then_assert_rover_is_positionning(4,5);
    }


    private void then_assert_rover_is_positionning(int positionX, int positionY){
        assertThat(roverResult.positionY).isEqualTo(positionY);
        assertThat(roverResult.positionX).isEqualTo(positionX);
    }

    private void give_an_init_rover(int positionX, int positionY, OrientationEnum orientation){
        roverInit = new RoverCartesian(positionX, positionY, orientation);
    }

    private void when_translate_rover(DirectionEnum direction){
        roverResult = translate.translate(roverInit, direction);
    }



}