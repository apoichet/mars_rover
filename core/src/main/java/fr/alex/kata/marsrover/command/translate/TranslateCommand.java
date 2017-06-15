package fr.alex.kata.marsrover.command.translate;

import static fr.alex.kata.marsrover.command.translate.DirectionEnum.BACK;
import static fr.alex.kata.marsrover.command.translate.DirectionEnum.FRONT;

import fr.alex.kata.marsrover.command.RoverCommand;
import fr.alex.kata.marsrover.domain.Rover;

public abstract class TranslateCommand implements RoverCommand {

  public Rover translate(Rover rover, DirectionEnum direction){

    Rover newRover = rover.copyOf();

    switch (newRover.getOrientation()){
      case NORTH:
        if (direction.equals(BACK)){ newRover.coordinate.y--; break; }
        else if(direction.equals(FRONT)){ newRover.coordinate.y++; break; }
      case SOUTH:
        if (direction.equals(BACK)){ newRover.coordinate.y++; break; }
        else if(direction.equals(FRONT)){ newRover.coordinate.y--; break; }
      case EAST:
        if (direction.equals(BACK)){ newRover.coordinate.x--; break; }
        else if(direction.equals(FRONT)){ newRover.coordinate.x++; break; }
      case WEST:
        if (direction.equals(BACK)){ newRover.coordinate.x++; break; }
        else if(direction.equals(FRONT)){ newRover.coordinate.x--; break; }
    }

    return newRover;

  }


}
