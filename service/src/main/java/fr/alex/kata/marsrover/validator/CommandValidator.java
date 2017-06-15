package fr.alex.kata.marsrover.validator;

public interface CommandValidator<T> {

  void validate(T command) throws IllegalArgumentException;

}


