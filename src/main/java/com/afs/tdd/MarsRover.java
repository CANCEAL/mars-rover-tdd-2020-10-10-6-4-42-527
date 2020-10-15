package com.afs.tdd;

import java.util.Arrays;

public class MarsRover {
    private int locationX;
    private int locationY;
    private String heading;

    public MarsRover(int locationX, int locationY, String heading) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.heading = heading;
    }

    public void executeCommand(String command) {
        if (command.equals("M")) {
            move();
        }
        if (command.equals("L")) {
            turnLeft();
        }
        if (command.equals("R")) {
            turnRight();
        }
    }

    public void executeCommands(String commands) {
        Arrays.asList(commands.split("")).forEach(command -> this.executeCommand(command));
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
        if (heading.equals("N")) {
            heading = "E";
        }
        else if (heading.equals("S")) {
            heading = "W";
        }
        else if (heading.equals("E")) {
            heading = "S";
        }
        else if (heading.equals("W")) {
            heading = "N";
        }
    }

    private void turnLeft() {
        if (heading.equals("N")) {
            heading = "W";
        }
        else if (heading.equals("S")) {
            heading = "E";
        }
        else if (heading.equals("E")) {
            heading = "N";
        }
        else if (heading.equals("W")) {
            heading = "S";
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
