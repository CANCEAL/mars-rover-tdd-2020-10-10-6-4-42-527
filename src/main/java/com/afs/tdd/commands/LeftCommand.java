package com.afs.tdd.commands;

import com.afs.tdd.Command;
import com.afs.tdd.RoverPosition;

public class LeftCommand implements Command {
    @Override
    public RoverPosition execute(RoverPosition roverPosition) {
        String heading = roverPosition.getHeading();
        int locationX = roverPosition.getLocationX();
        int locationY = roverPosition.getLocationY();

        switch (heading) {
            case "N":
                roverPosition.setHeading(heading = "W");
                break;
            case "S":
                roverPosition.setHeading(heading = "E");
                break;
            case "E":
                roverPosition.setHeading(heading = "N");
                break;
            case "W":
                roverPosition.setHeading(heading = "S");
                break;
        }
        return new RoverPosition(locationX, locationY, heading);
    }
}
