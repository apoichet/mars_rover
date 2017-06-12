package fr.alex.kata.marsrover.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by alex on 02/06/17.
 */
public class MarsMap {
    private int width;
    private int height;
    private List<Rover> rovers;
    private static MarsMap INSTANCE = null;

    public MarsMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static MarsMap getInstance(){
        if (INSTANCE == null){
            INSTANCE = new MarsMap(10, 10);
        }
        return INSTANCE;
    }

    public Optional<Rover> findRover(int idRover){
        return rovers.stream()
                .filter(rover -> rover.getId() == idRover)
                .findFirst();
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Rover> getRovers() {
        return rovers != null ? rovers : new ArrayList<>();
    }

    public void setRovers(List<Rover> rovers) {
        this.rovers.addAll(rovers);
    }
}
