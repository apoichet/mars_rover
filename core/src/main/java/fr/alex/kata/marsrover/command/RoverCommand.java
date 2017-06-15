package fr.alex.kata.marsrover.command;

import fr.alex.kata.marsrover.domain.Rover;

public interface RoverCommand {

	Rover execute(Rover rover);

}
