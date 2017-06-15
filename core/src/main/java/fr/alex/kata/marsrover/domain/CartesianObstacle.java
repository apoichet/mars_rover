package fr.alex.kata.marsrover.domain;

public class CartesianObstacle {

	private CartesianCoordinate coordinate;

  public CartesianCoordinate getCoordinate() {
    return coordinate;
  }

  public CartesianObstacle(CartesianCoordinate coordinate) {
    this.coordinate = coordinate;
  }
}
