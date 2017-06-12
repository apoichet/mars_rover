package fr.alex.kata.marsrover.domain;

/**
 * Created by alex on 01/06/17.
 */
public abstract class Rover {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract Rover copyOf();

    public abstract boolean isOut(MarsMap marsMap);

    public abstract String getPosition();

    public abstract Rover backward();

    public abstract Rover forward();

    public abstract Rover turnLeft();

    public abstract Rover turnRight();

}
