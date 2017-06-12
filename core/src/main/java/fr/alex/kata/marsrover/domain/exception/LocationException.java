package fr.alex.kata.marsrover.domain.exception;

/**
 * Created by alex on 26/05/17.
 */
public class LocationException extends AbstractBusinessException{

    public static final String STOP_BACKWARD = "Rover could not backward more !";
    public static final String STOP_FORWARD = "Rover could not forward more !";


    public LocationException(String msg) {
        super(msg);
    }
}
