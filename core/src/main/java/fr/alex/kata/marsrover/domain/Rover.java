package fr.alex.kata.marsrover.domain;

import static fr.alex.kata.marsrover.domain.OrientationEnum.NORTH;

public class Rover {

    private OrientationEnum orientation;
    public CartesianCoordinate coordinate;

    public Rover(OrientationEnum orientation, CartesianCoordinate coordinate) {
        this.orientation = orientation;
        this.coordinate = coordinate;
    }

    public Rover(CartesianCoordinate coordinate) {
        this.orientation = NORTH;
        this.coordinate = coordinate;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationEnum orientation) {
        this.orientation = orientation;
    }

    public Rover copyOf(){
        return new Rover(orientation, coordinate.copyOf());


    }

}
