package fr.alex.kata.marsrover.domain;

import java.util.ArrayList;

public class CartesianObstacles extends ArrayList<CartesianObstacle>{

  public boolean contains(CartesianCoordinate coordinate){

    return stream()
      .anyMatch(cartesianObstacle -> cartesianObstacle.getCoordinate().equals(coordinate));

  }

  
}
