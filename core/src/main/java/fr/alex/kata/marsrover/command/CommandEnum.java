package fr.alex.kata.marsrover.command;

public enum CommandEnum {

    LEFT,RIGHT, BACKWARD,FORWARD,UNKNOWN;

    public static CommandEnum getCommand(String command){
        switch (command){
            case "L":return LEFT;
            case "R":return RIGHT;
            case "B":return BACKWARD;
            case "F":return FORWARD;
        }

        return UNKNOWN;
    }


}
