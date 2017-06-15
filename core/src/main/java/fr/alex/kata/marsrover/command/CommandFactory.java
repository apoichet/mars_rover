package fr.alex.kata.marsrover.command;

import fr.alex.kata.marsrover.command.rotate.Left;
import fr.alex.kata.marsrover.command.rotate.Right;
import fr.alex.kata.marsrover.command.translate.Backward;
import fr.alex.kata.marsrover.command.translate.Forward;

public class CommandFactory {

    public static RoverCommand create(CommandEnum command){

        switch (command){

            case LEFT:return new Left();
            case RIGHT:return new Right();
            case BACKWARD:return new Backward();
            case FORWARD:return new Forward();

        }

        throw new IllegalArgumentException("Command Unknown !");


    }


}
