package fr.alex.kata.marsrover.function.move.cartesian;

import fr.alex.kata.marsrover.domain.common.RotationEnum;

import static fr.alex.kata.marsrover.domain.common.OrientationEnum.*;
import static fr.alex.kata.marsrover.domain.common.RotationEnum.Left;
import static fr.alex.kata.marsrover.domain.common.RotationEnum.Right;

/**
 * Created by alex on 02/06/17.
 */
public class CartesianRotate {

    public RoverCartesian rotate(RoverCartesian roverCartesian, RotationEnum rotation){

        RoverCartesian roverCopy = roverCartesian.copyOf();

        switch (roverCopy.orientationEnum){
            case North:
                if (rotation.equals(Left)){ roverCopy.orientationEnum = West; break; }
                else if(rotation.equals(Right)){ roverCopy.orientationEnum = East; break; }
            case South:
                if (rotation.equals(Left)){ roverCopy.orientationEnum = East; break; }
                else if(rotation.equals(Right)){ roverCopy.orientationEnum = West; break; }
            case East:
                if (rotation.equals(Left)){ roverCopy.orientationEnum = North; break; }
                else if(rotation.equals(Right)){ roverCopy.orientationEnum = South; break; }
            case West:
                if (rotation.equals(Left)){ roverCopy.orientationEnum = South; break; }
                else if(rotation.equals(Right)){ roverCopy.orientationEnum = North; break; }
        }

        return roverCopy;
    }

}
