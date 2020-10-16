package com.afs.tdd;

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    //refactor to use enum
    //if use enum, how to eliminate if statements
    private int locationX;
    private int locationY;
    private String heading;
    private static final String HEADING_N = "N";
    private static final String HEADING_S = "S";
    private static final String HEADING_E = "E";
    private static final String HEADING_W = "W";
    private static final String MOVE = "M";
    private static final String TURN_LEFT = "L";
    private static final String TURN_RIGHT = "R";

    public MarsRover(int locationX, int locationY, String heading) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.heading = heading;
    }

    public void isValidCommand(String commands) throws CommandNotDefinedException {
        List<String> validCommands = Arrays.asList(MOVE, TURN_LEFT, TURN_RIGHT);
        List<String> givenCommands = Arrays.asList(commands.split(""));

        if (validCommands.containsAll(givenCommands)) {
            Arrays.asList(commands.split("")).forEach(this::executeCommand);
        } else {
            throw new CommandNotDefinedException("CommandNotDefinedException");
        }
    }

    private void executeCommand(String command) {
        switch (command) {
            case MOVE:
                move();
                break;
            case TURN_LEFT:
                turnLeft();
                break;
            case TURN_RIGHT:
                turnRight();
                break;
        }
    }
    //create and place on their own class
    private void move() {
        switch (heading) {
            case HEADING_N: locationY += 1; break;
            case HEADING_S: locationY -= 1; break;
            case HEADING_E: locationX += 1; break;
            case HEADING_W: locationX -= 1; break;
        }
    }
    //create and place on their own class
    private void turnRight() {
        switch (heading) {
            case HEADING_N: heading = HEADING_E; break;
            case HEADING_S: heading = HEADING_W; break;
            case HEADING_E: heading = HEADING_S; break;
            case HEADING_W: heading = HEADING_N; break;
        }
    }
    //create and place on their own class
    private void turnLeft() {
        switch (heading) {
            case HEADING_N: heading = HEADING_W; break;
            case HEADING_S: heading = HEADING_E; break;
            case HEADING_E: heading = HEADING_N; break;
            case HEADING_W: heading = HEADING_S; break;
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
