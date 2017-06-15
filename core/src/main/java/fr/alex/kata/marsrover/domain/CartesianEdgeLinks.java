package fr.alex.kata.marsrover.domain;

import java.util.Map;
import java.util.HashMap;

public class CartesianEdgeLinks {

	public Map<CartesianCoordinate, CartesianCoordinate> links = new HashMap<>();

	/**
	 * when interract with originLink, consider interract with destinationLink
	 * @param originLink the edge who are after map limit
	 * @param destinationLink the edge we really are
	 */
	public void addLinkBetweenEdges(CartesianCoordinate originLink, CartesianCoordinate destinationLink){
		links.put(originLink,destinationLink);
	}

}
