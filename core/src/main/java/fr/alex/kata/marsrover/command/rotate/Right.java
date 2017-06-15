package fr.alex.kata.marsrover.command.rotate;

import static fr.alex.kata.marsrover.command.rotate.RotationEnum.RIGHT;

import fr.alex.kata.marsrover.domain.Rover;

public class Right extends RotateCommand {

    @Override
    public Rover execute(Rover rover) {
        return super.turn(rover, RIGHT);
    }
}
