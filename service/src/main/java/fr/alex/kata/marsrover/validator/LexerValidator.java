package fr.alex.kata.marsrover.validator;

public class LexerValidator implements CommandValidator<String>{

  @Override
  public void validate(String command) throws IllegalArgumentException {

    final boolean matches = command.matches("[LRFB]*");

    if (!matches){
      throw new IllegalArgumentException("command invalide");
    }


  }
}
