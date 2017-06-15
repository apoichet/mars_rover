package fr.alex.kata.marsrover.command.rotate;

import static fr.alex.kata.marsrover.command.rotate.RotationEnum.LEFT;

import fr.alex.kata.marsrover.domain.Rover;

public class Left extends RotateCommand{

    @Override
    public Rover execute(Rover rover) {
        return super.turn(rover, LEFT);
    }
}
