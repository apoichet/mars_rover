package fr.alex.kata.marsrover.function.move.cartesian;

import fr.alex.kata.marsrover.domain.MarsMap;
import fr.alex.kata.marsrover.domain.Rover;
import fr.alex.kata.marsrover.domain.common.OrientationEnum;

import static fr.alex.kata.marsrover.domain.common.DirectionEnum.Back;
import static fr.alex.kata.marsrover.domain.common.DirectionEnum.Front;
import static fr.alex.kata.marsrover.domain.common.RotationEnum.Left;
import static fr.alex.kata.marsrover.domain.common.RotationEnum.Right;

/**
 * Created by alex on 01/06/17.
 */
public class RoverCartesian extends Rover{

    public int positionX;
    public int positionY;
    public OrientationEnum orientationEnum;
    private CartesianRotate cartesianRotate;
    private CartesianTranslate cartesianTranslate;

    public RoverCartesian(int positionX, int positionY, OrientationEnum orientationEnum) {
        cartesianRotate = new CartesianRotate();
        cartesianTranslate = new CartesianTranslate();
        this.setId(super.getId());
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientationEnum = orientationEnum;
    }

    @Override
    public RoverCartesian copyOf() {
        return new RoverCartesian(positionX, positionY, orientationEnum);
    }

    @Override
    public boolean isOut(MarsMap marsMap) {
        return positionX >= marsMap.getWidth() && positionY >= marsMap.getHeight();
    }

    @Override
    public String getPosition() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rover numero ");
        stringBuilder.append(this.getId());
        stringBuilder.append(" /n position X : ");
        stringBuilder.append(this.positionX);
        stringBuilder.append(" /n position Y : ");
        stringBuilder.append(this.positionY);
        stringBuilder.append(" /n orientation : ");
        stringBuilder.append(this.orientationEnum.name());
        return stringBuilder.toString();
    }

    @Override
    public Rover backward() {
        return cartesianTranslate.translate(this, Back);
    }

    @Override
    public Rover forward() {
        return cartesianTranslate.translate(this, Front);
    }

    @Override
    public Rover turnLeft() {
        return cartesianRotate.rotate(this, Left);
    }

    @Override
    public Rover turnRight() {
        return cartesianRotate.rotate(this, Right);
    }
}
