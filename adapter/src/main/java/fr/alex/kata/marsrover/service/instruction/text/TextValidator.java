package fr.alex.kata.marsrover.service.instruction.text;

import fr.alex.kata.marsrover.service.common.AbstractAdaptorException;
import fr.alex.kata.marsrover.service.common.CommandValidator;

/**
 * Created by alex on 26/05/17.
 */
public class TextValidator implements CommandValidator<String> {

    private final static String PATTERN = "";

    @Override
    public void validate(String input) throws AbstractAdaptorException {

        if (!input.matches(PATTERN)){
            throw new ValidatorTextException("Input text is not valid !");
        }
    }
}
