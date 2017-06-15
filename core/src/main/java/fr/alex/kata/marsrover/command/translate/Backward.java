package fr.alex.kata.marsrover.command.translate;

import static fr.alex.kata.marsrover.command.translate.DirectionEnum.BACK;

import fr.alex.kata.marsrover.domain.Rover;

public class Backward extends TranslateCommand{

    @Override
    public Rover execute(Rover rover) {
        return super.translate(rover, BACK);
    }
}
