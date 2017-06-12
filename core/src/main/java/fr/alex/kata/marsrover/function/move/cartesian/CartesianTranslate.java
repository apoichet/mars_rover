package fr.alex.kata.marsrover.function.move.cartesian;

import fr.alex.kata.marsrover.domain.common.DirectionEnum;
import fr.alex.kata.marsrover.domain.common.OrientationEnum;

import static fr.alex.kata.marsrover.domain.common.DirectionEnum.Back;
import static fr.alex.kata.marsrover.domain.common.DirectionEnum.Front;

/**
 * Created by alex on 02/06/17.
 */
public class CartesianTranslate {

    public RoverCartesian translate(RoverCartesian roverCartesian, DirectionEnum direction){

        RoverCartesian roverCopy = roverCartesian.copyOf();

        switch (roverCopy.orientationEnum){
            case North:
                if (direction.equals(Front)){ roverCopy.positionY++; break; }
                else if(direction.equals(Back)){ roverCopy.positionY--; break; }
            case South:
                if (direction.equals(Front)){ roverCopy.positionY--; break; }
                else if(direction.equals(Back)){ roverCopy.positionY++; break; }
            case East:
                if (direction.equals(Front)){ roverCopy.positionX++; break; }
                else if(direction.equals(Back)){ roverCopy.positionX--; break; }
            case West:
                if (direction.equals(Front)){ roverCopy.positionX--; break; }
                else if(direction.equals(Back)){ roverCopy.positionX++; break; }
        }

        return roverCopy;
    }

}
