package fr.alex.kata.marsrover.command.rotate;

import static fr.alex.kata.marsrover.domain.OrientationEnum.EAST;
import static fr.alex.kata.marsrover.domain.OrientationEnum.NORTH;
import static fr.alex.kata.marsrover.domain.OrientationEnum.SOUTH;
import static fr.alex.kata.marsrover.domain.OrientationEnum.WEST;
import static fr.alex.kata.marsrover.command.rotate.RotationEnum.LEFT;
import static fr.alex.kata.marsrover.command.rotate.RotationEnum.RIGHT;

import fr.alex.kata.marsrover.domain.Rover;
import fr.alex.kata.marsrover.command.RoverCommand;

public abstract class RotateCommand implements RoverCommand{

    public Rover turn(Rover rover, RotationEnum rotation){

        Rover newRover = rover.copyOf();

        switch (newRover.getOrientation()){
            case NORTH:
                if (rotation.equals(LEFT)){ newRover.setOrientation(WEST); break; }
                else if(rotation.equals(RIGHT)){ newRover.setOrientation(EAST); break; }
            case SOUTH:
                if (rotation.equals(LEFT)){ newRover.setOrientation(EAST); break; }
                else if(rotation.equals(RIGHT)){ newRover.setOrientation(WEST); break; }
            case EAST:
                if (rotation.equals(LEFT)){ newRover.setOrientation(NORTH); break; }
                else if(rotation.equals(RIGHT)){ newRover.setOrientation(SOUTH); break; }
            case WEST:
                if (rotation.equals(LEFT)){ newRover.setOrientation(SOUTH); break; }
                else if(rotation.equals(RIGHT)){ newRover.setOrientation(NORTH); break; }
        }

        return newRover;
    }
}
