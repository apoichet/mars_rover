package fr.alex.kata.marsrover.service.common;

/**
 * Created by alex on 26/05/17.
 */
public interface CommandValidator<S> {

    void validate(S input) throws AbstractAdaptorException;


}
