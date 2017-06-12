package fr.alex.kata.marsrover.domain.exception;

/**
 * Created by alex on 26/05/17.
 */
public abstract class AbstractBusinessException extends Exception{

    public AbstractBusinessException(String msg){
        super(msg);
    }

}
