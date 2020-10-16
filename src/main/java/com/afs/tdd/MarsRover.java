package com.afs.tdd;

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private int locationX, locationY;
    private String heading;
    private static final String HEADING_N = "N", HEADING_S = "S", HEADING_E = "E", HEADING_W = "W";
    private static final String MOVE = "M";
    private static final String TURN_LEFT = "L", TURN_RIGHT = "R";

    public MarsRover(int locationX, int locationY, String heading) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.heading = heading;
    }

    public void isValidCommand(String commands) throws CommandNotDefinedException {
        List<String> validCommands = Arrays.asList(MOVE, TURN_LEFT, TURN_RIGHT);
        List<String> givenCommands = Arrays.asList(commands.split(""));

        for (int command = 0; command <= givenCommands.size()-1; command++) {
            if (validCommands.contains(givenCommands.get(command))) {
                executeCommand(givenCommands.get(command));
            } else {
                throw new CommandNotDefinedException("CommandNotDefinedException");
            }
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

    private void move() {
        if (heading.equals(HEADING_N)) {
            locationY += 1;
        }
        if (heading.equals(HEADING_S)) {
            locationY -= 1;
        }
        if (heading.equals(HEADING_E)) {
            locationX += 1;
        }
        if (heading.equals(HEADING_W)) {
            locationX -= 1;
        }
    }

    private void turnRight() {
        heading = heading.equals(HEADING_N) ? HEADING_E :
                  heading.equals(HEADING_S) ? HEADING_W :
                  heading.equals(HEADING_E) ? HEADING_S :
                  heading.equals(HEADING_W) ? HEADING_N :
                  null;
    }

    private void turnLeft() {
        heading = heading.equals(HEADING_N) ? HEADING_W :
                  heading.equals(HEADING_S) ? HEADING_E :
                  heading.equals(HEADING_E) ? HEADING_N :
                  heading.equals(HEADING_W) ? HEADING_S :
                  null;
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
