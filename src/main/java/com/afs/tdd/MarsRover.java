package com.afs.tdd;

import com.afs.tdd.commands.LeftCommand;
import com.afs.tdd.commands.MoveCommand;
import com.afs.tdd.commands.RightCommand;
import com.afs.tdd.exceptions.CommandNotDefinedException;

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private RoverPosition roverPosition;

    public MarsRover(int locationX, int locationY, String heading) {
        this.roverPosition = new RoverPosition(locationX, locationY, heading);
    }

    public void isValidCommand(String commands) throws CommandNotDefinedException {
        List<String> validCommands = Arrays.asList(Constants.MOVE, Constants.TURN_LEFT,  Constants.TURN_RIGHT);
        List<String> givenCommands = Arrays.asList(commands.split(""));

        if (validCommands.containsAll(givenCommands)) {
            Arrays.asList(commands.split("")).forEach(command -> executeCommand(command));
        } else {
            throw new CommandNotDefinedException("CommandNotDefinedException");
        }
    }

    private void executeCommand(String command) {
        switch (command) {
            case Constants.MOVE:
                new MoveCommand().execute(roverPosition);
                break;
            case Constants.TURN_LEFT:
                new LeftCommand().execute(roverPosition);
                break;
            case Constants.TURN_RIGHT:
                new RightCommand().execute(roverPosition);
                break;
        }
    }

    public int getLocationX() {
        return roverPosition.getLocationX();
    }

    public int getLocationY() {
        return roverPosition.getLocationY();
    }

    public String getHeading() {
        return roverPosition.getHeading();
    }
}
