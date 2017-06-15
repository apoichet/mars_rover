package fr.alex.kata.marsrover.adapter;

import fr.alex.kata.marsrover.command.CommandEnum;

public class LexerAdapter implements CommandAdapter<String>{

  @Override
  public CommandEnum adapt(String command) {
    return CommandEnum.getCommand(command);
  }
  

}
