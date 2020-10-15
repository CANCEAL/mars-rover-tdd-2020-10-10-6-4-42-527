package com.afs.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarsRoverTest {
    public void newPosition(int locationX, int locationY, String heading, String command, int expectedLocationX, int expectedLocationY, String expectedHeading) {
        //given
        MarsRover marsRover = new MarsRover(locationX, locationY, heading);
        //when
        marsRover.executeCommands(command);
        //then
        assertEquals(expectedLocationX, marsRover.getLocationX());
        assertEquals(expectedLocationY, marsRover.getLocationY());
        assertEquals(expectedHeading, marsRover.getHeading());
    }

    @Test
    void should_return_x_0_y_1_heading_N_when_execute_command_given_x_0_y_0_heading_n_and_command_M() {
        newPosition(0, 0, "N", "M", 0, 1, "N");
    }

    @Test
    void should_return_x_0_y_0_heading_W_when_execute_command_given_x_0_y_0_heading_n_and_command_L() {
        newPosition(0, 0, "N", "L", 0, 0, "W");
    }

    @Test
    void should_return_x_0_y_0_heading_W_when_execute_command_given_x_0_y_0_heading_n_and_command_R() {
        newPosition(0, 0, "N", "R", 0, 0, "E");
    }

    @Test
    void should_return_x_0_y_negative_1_heading_S_when_execute_command_given_x_0_y_0_heading_S_and_command_M() {
        newPosition(0, 0, "S", "M", 0, -1, "S");
    }

    @Test
    void should_return_x_0_y_0_heading_E_when_execute_command_given_x_0_y_0_heading_S_and_command_L() {
        newPosition(0, 0, "S", "L", 0, 0, "E");
    }

    @Test
    void should_return_x_0_y_0_heading_W_when_execute_command_given_x_0_y_0_heading_S_and_command_R() {
        newPosition(0, 0, "S", "R", 0, 0, "W");
    }

    @Test
    void should_return_x_1_y_0_heading_E_when_execute_command_given_x_0_y_0_heading_E_and_command_M() {
        newPosition(0, 0, "E", "M", 1, 0, "E");
    }

    @Test
    void should_return_x_0_y_0_heading_N_when_execute_command_given_x_0_y_0_heading_E_and_command_L() {
        newPosition(0, 0, "E", "L", 0, 0, "N");
    }

    @Test
    void should_return_x_0_y_0_heading_S_when_execute_command_given_x_0_y_0_heading_E_and_command_R() {
        newPosition(0, 0, "E", "R", 0, 0, "S");
    }

    @Test
    void should_return_x_negative_1_y_0_heading_W_when_execute_command_given_x_0_y_0_heading_W_and_command_M() {
        newPosition(0, 0, "W", "M", -1, 0, "W");
    }

    @Test
    void should_return_x_0_y_0_heading_S_when_execute_command_given_x_0_y_0_heading_W_and_command_L() {
        newPosition(0, 0, "W", "L", 0, 0, "S");
    }

    @Test
    void should_return_x_0_y_0_heading_N_when_execute_command_given_x_0_y_0_heading_W_and_command_R() {
        newPosition(0, 0, "W", "R", 0, 0, "N");
    }

    @Test
    void should_return_x_negative_1_y_0_heading_N_when_execute_command_given_x_0_y_0_heading_n_and_command_MLMR() {
        newPosition(0, 0, "N", "MLMR", -1, 1, "N");
    }
}
