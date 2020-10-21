package com.afs.tdd.commands;

import com.afs.tdd.Command;
import com.afs.tdd.RoverPosition;

public class RightCommand implements Command {
    @Override
    public RoverPosition execute(RoverPosition roverPosition) {
        String heading = roverPosition.getHeading();
        int locationX = roverPosition.getLocationX();
        int locationY = roverPosition.getLocationY();

        switch (heading) {
            case "N":
                roverPosition.setHeading(heading = "E");
                break;
            case "S":
                roverPosition.setHeading(heading = "W");
                break;
            case "E":
                roverPosition.setHeading(heading = "S");
                break;
            case "W":
                roverPosition.setHeading(heading = "N");
                break;
        }
        return new RoverPosition(locationX, locationY, heading);
    }
}
