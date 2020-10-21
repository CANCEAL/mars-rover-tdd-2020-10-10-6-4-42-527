package com.afs.tdd.commands;

import com.afs.tdd.Command;
import com.afs.tdd.RoverPosition;

public class MoveCommand implements Command {
    @Override
    public RoverPosition execute(RoverPosition roverPosition) {
        int locationX = roverPosition.getLocationX();
        int locationY = roverPosition.getLocationY();
        String heading = roverPosition.getHeading();

        switch (heading) {
            case "N":
                roverPosition.setLocationY(locationY += 1);
                break;
            case "S":
                roverPosition.setLocationY(locationY -= 1);;
                break;
            case "E":
                roverPosition.setLocationX(locationX += 1);
                break;
            case "W":
                roverPosition.setLocationX(locationX -= 1);
                break;
        }
        return new RoverPosition(locationX, locationY, heading);
    }
}