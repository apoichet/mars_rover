package fr.alex.kata.marsrover.service.in;

/**
 * Created by alex on 10/06/17.
 */
public class RoverInput {

    private int id;
    private String instructions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public RoverInput(int id, String instructions) {
        this.id = id;
        this.instructions = instructions;
    }
}
