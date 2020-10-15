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
        List<String> validCommands = Arrays.asList("M", "L", "R");
        List<String> givenCommands = Arrays.asList(commands.split(""));

        for (int i = 0; i <= givenCommands.size()-1; i++) {
            if (validCommands.contains(givenCommands.get(i))) {
                executeCommand(givenCommands.get(i));
            } else {
                throw new CommandNotDefinedException("CommandNotDefinedException");
            }
        }
    }

    private void executeCommand(String command) {
        switch (command) {
            case "M":
                move();
                break;
            case "L":
                turnLeft();
                break;
            case "R":
                turnRight();
                break;
        }
    }

    private void move() {
        if (heading.equals("N")) {
            locationY += 1;
        }
        if (heading.equals("S")) {
            locationY -= 1;
        }
        if (heading.equals("E")) {
            locationX += 1;
        }
        if (heading.equals("W")) {
            locationX -= 1;
        }
    }

    private void turnRight() {
        heading = heading.equals("N") ? "E" :
                  heading.equals("S") ? "W" :
                  heading.equals("E") ? "S" :
                  heading.equals("W") ? "N" :
                  null;
    }

    private void turnLeft() {
        heading = heading.equals("N") ? "W" :
                  heading.equals("S") ? "E" :
                  heading.equals("E") ? "N" :
                  heading.equals("W") ? "S" :
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
