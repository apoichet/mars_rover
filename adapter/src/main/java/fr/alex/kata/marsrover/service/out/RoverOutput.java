package fr.alex.kata.marsrover.service.out;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 10/06/17.
 */
public class RoverOutput {

    private int positionX;
    private int positionY;
    private String orientation;
    private List<String> warnings;

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public List<String> getWarnings() {
        return warnings != null ? warnings : new ArrayList<>();
    }

    public void setWarnings(List<String> warnings) {
        this.warnings.addAll(warnings);
    }

    public RoverOutput(int positionX, int positionY, String orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }
}
