package fr.alex.kata.marsrover.domain;

import static fr.alex.kata.marsrover.command.CommandEnum.BACKWARD;
import static fr.alex.kata.marsrover.command.CommandEnum.FORWARD;
import static fr.alex.kata.marsrover.command.CommandEnum.LEFT;
import static fr.alex.kata.marsrover.command.CommandEnum.RIGHT;
import static fr.alex.kata.marsrover.domain.OrientationEnum.EAST;
import static fr.alex.kata.marsrover.domain.OrientationEnum.NORTH;
import static fr.alex.kata.marsrover.domain.OrientationEnum.WEST;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RoverMapTest {

  private RoverMap map;
  private Rover roverInit;

  @Test
  public void should_turn_left_with_command_L(){
    //Given
    givenMapWithRover(0,0, NORTH);

    //When
    Rover rover = map.executeCommand(LEFT);

    //Then
    assertThat(rover.getOrientation()).isEqualTo(WEST);
  }

  @Test
  public void should_turn_right_with_command_R(){
    //Given
    givenMapWithRover(0,0, NORTH);

    //When
    Rover rover = map.executeCommand(RIGHT);

    //Then
    assertThat(rover.getOrientation()).isEqualTo(EAST);
  }

  @Test
  public void should_have_same_orientation_with_360_rotation(){
    //Given
    givenMapWithRover(0,0, NORTH);

    //When
    Rover rover = map.executeCommand(LEFT,LEFT,LEFT,LEFT);

    //Then
    assertThat(rover.getOrientation()).isEqualTo(NORTH);
  }

  @Test
  public void should_move_forward_with_command_F(){
    //Given
    givenMapWithRover(0,0, NORTH);
    withEdgeLinks(1,1);

    //When
    Rover rover = map.executeCommand(FORWARD);

    //Then
    assertThat(rover.coordinate.y).isEqualTo(1);
  }

  @Test
  public void should_move_backward_with_command_B(){
    //Given
    givenMapWithRover(0,0, NORTH);
    withEdgeLinks(1,1);

    //When
    Rover rover = map.executeCommand(BACKWARD);

    //Then
    assertThat(rover.coordinate.y).isEqualTo(1);
  }

  @Test
  public void should_combine_rotation_and_translation(){
    //Given
    givenMapWithRover(0,0, NORTH);
    withEdgeLinks(3,3);

    //When
    Rover rover = map.executeCommand(LEFT,FORWARD,RIGHT,BACKWARD);

    //Then
    assertThat(rover.coordinate.x).isEqualTo(3);
    assertThat(rover.coordinate.y).isEqualTo(3);
  }

  @Test
  public void should_detect_colision(){
    //Given
    givenMapWithRover(0,0, NORTH);
    withEdgeLinks(2,2);
    withObstacle(0,1);

    //When
    Rover rover = map.executeCommand(FORWARD);

    //Then
    assertThat(rover).isEqualTo(roverInit);
  }


  private void givenMapWithRover(int x, int y, OrientationEnum orientationEnum){
    roverInit = new Rover(orientationEnum, new CartesianCoordinate(x,y));
    map = new RoverMap(roverInit);
  }

  private void withEdgeLinks(int dimensionX, int dimensionY){
    map.dimension(dimensionX, dimensionY);
  }

  private void withObstacle(int x, int y){
    map.cartesianObstacles.add(new CartesianObstacle(new CartesianCoordinate(x,y)));
  }


}