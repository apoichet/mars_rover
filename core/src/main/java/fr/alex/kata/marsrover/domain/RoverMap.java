package fr.alex.kata.marsrover.domain;

import fr.alex.kata.marsrover.command.CommandEnum;
import fr.alex.kata.marsrover.command.CommandFactory;
import fr.alex.kata.marsrover.command.RoverCommand;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class RoverMap {

  CartesianObstacles cartesianObstacles = new CartesianObstacles();
  private CartesianEdgeLinks edgeLinks = new CartesianEdgeLinks();
  private Rover roverInit;

  RoverMap(Rover roverInit) {
    this.roverInit = roverInit;
  }

  void dimension(int dimensionX, int dimensionY){
    for (int y = 0; y <= dimensionY; y++) {
      this.edgeLinks.links.put(new CartesianCoordinate(dimensionX+1,y), new CartesianCoordinate(0,y));
      this.edgeLinks.links.put(new CartesianCoordinate(-1,y), new CartesianCoordinate(dimensionX,y));
    }
    for (int x = 0; x <= dimensionX; x++) {
      this.edgeLinks.links.put(new CartesianCoordinate(x,dimensionY+1), new CartesianCoordinate(x,0));
      this.edgeLinks.links.put(new CartesianCoordinate(x,-1), new CartesianCoordinate(x,dimensionY));
    }
  }

  Rover executeCommand(CommandEnum... commands){
    return executeCommand(roverInit, commands);
  }

  private Rover executeCommand(Rover roverInit, CommandEnum... commands){
    return Stream.of(commands)
      .map(CommandFactory::create)
      .reduce(roverInit, executingCommand, rejectParallelStream);
  }

  private BiFunction<Rover, RoverCommand, Rover> executingCommand = (roverInput, roverCommand) -> {
    Rover roverOutput = roverCommand.execute(roverInput);
    return manageRover(roverInput, roverOutput);
  };

  private BinaryOperator<Rover> rejectParallelStream = (roverInput, roverOutput) -> {
    //when you use parallel the chain order maybe changed, and the result is wrong.
    throw new IllegalStateException("Can't be used in parallel stream!");
  };

  private Rover manageRover(Rover roverInput, Rover roverOutput) {

    if (edgeLinks.links.containsKey(roverOutput.coordinate)){
      System.out.println("Rover coordinate adjusting : "+roverOutput.coordinate.getPosition());
      roverOutput.coordinate = edgeLinks.links.get(roverOutput.coordinate);
    }
    if (cartesianObstacles.contains(roverOutput.coordinate)){
      System.out.println("Colision aborted with obstacle : "+roverOutput.coordinate.getPosition());
      return roverInput;
    }

    return roverOutput;
  }



}
