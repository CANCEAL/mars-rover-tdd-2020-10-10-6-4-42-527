package com.afs.tdd;

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private int locationX;
    private int locationY;
    private String heading;

    public MarsRover(int locationX, int locationY, String heading) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.heading = heading;
    }

    public void isValidCommand(String commands) throws CommandNotDefinedException {
        List<String> validCommands = Arrays.asList(Constants.MOVE, Constants.TURN_LEFT,  Constants.TURN_RIGHT);
        List<String> givenCommands = Arrays.asList(commands.split(""));

        if (validCommands.containsAll(givenCommands)) {
            Arrays.asList(commands.split("")).forEach(this::executeCommand);
        } else {
            throw new CommandNotDefinedException("CommandNotDefinedException");
        }
    }

    private void executeCommand(String command) {
        switch (command) {
            case Constants.MOVE:
                move();
                break;
            case Constants.TURN_LEFT:
                turnLeft();
                break;
            case Constants.TURN_RIGHT:
                turnRight();
                break;
        }
    }

    private void move() {
        switch (heading) {
                case Constants.HEADING_N:
                    locationY += 1;
                    break;
                case Constants.HEADING_S:
                    locationY -= 1;
                    break;
                case Constants.HEADING_E:
                    locationX += 1;
                    break;
                case Constants.HEADING_W:
                    locationX -= 1;
                    break;
        }
    }

    private void turnRight() {
        switch (heading) {
            case Constants.HEADING_N: heading = Constants.HEADING_E; break;
            case Constants.HEADING_S: heading = Constants.HEADING_W; break;
            case Constants.HEADING_E: heading = Constants.HEADING_S; break;
            case Constants.HEADING_W: heading = Constants.HEADING_N; break;
        }
    }

    private void turnLeft() {
        switch (heading) {
            case Constants.HEADING_N: heading = Constants.HEADING_W; break;
            case Constants.HEADING_S: heading = Constants.HEADING_E; break;
            case Constants.HEADING_E: heading = Constants.HEADING_N; break;
            case Constants.HEADING_W: heading = Constants.HEADING_S; break;
        }
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public String getHeading() {
        return heading;
    }
}
