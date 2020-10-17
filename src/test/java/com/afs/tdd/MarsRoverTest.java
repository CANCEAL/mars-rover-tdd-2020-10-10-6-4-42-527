package com.afs.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarsRoverTest {
    private int locationX;
    private int locationY;

    @BeforeEach
    void setup() {
        locationX = 0;
        locationY = 0;
    }

    private void getMarsRoverNewPosition(String heading, String command, int expectedLocationX, int expectedLocationY, String expectedHeading) throws CommandNotDefinedException {
        //given
        MarsRover marsRover = new MarsRover(locationX, locationY, heading);
        //when
        marsRover.isValidCommand(command);
        //then
        assertEquals(expectedLocationX, marsRover.getLocationX());
        assertEquals(expectedLocationY, marsRover.getLocationY());
        assertEquals(expectedHeading, marsRover.getHeading());
    }

    @Test
    void should_return_x_0_y_1_heading_N_when_execute_command_given_x_0_y_0_heading_n_and_command_M() throws CommandNotDefinedException {
        getMarsRoverNewPosition("N", "M", 0, 1, "N");
    }

    @Test
    void should_return_x_0_y_0_heading_W_when_execute_command_given_x_0_y_0_heading_n_and_command_L() throws CommandNotDefinedException {
        getMarsRoverNewPosition("N", "L", 0, 0, "W");
    }

    @Test
    void should_return_x_0_y_0_heading_W_when_execute_command_given_x_0_y_0_heading_n_and_command_R() throws CommandNotDefinedException {
        getMarsRoverNewPosition("N", "R", 0, 0, "E");
    }

    @Test
    void should_return_x_0_y_negative_1_heading_S_when_execute_command_given_x_0_y_0_heading_S_and_command_M() throws CommandNotDefinedException {
        getMarsRoverNewPosition( "S", "M", 0, -1, "S");
    }

    @Test
    void should_return_x_0_y_0_heading_E_when_execute_command_given_x_0_y_0_heading_S_and_command_L() throws CommandNotDefinedException {
        getMarsRoverNewPosition("S", "L", 0, 0, "E");
    }

    @Test
    void should_return_x_0_y_0_heading_W_when_execute_command_given_x_0_y_0_heading_S_and_command_R() throws CommandNotDefinedException {
        getMarsRoverNewPosition( "S", "R", 0, 0, "W");
    }

    @Test
    void should_return_x_1_y_0_heading_E_when_execute_command_given_x_0_y_0_heading_E_and_command_M() throws CommandNotDefinedException {
        getMarsRoverNewPosition("E", "M", 1, 0, "E");
    }

    @Test
    void should_return_x_0_y_0_heading_N_when_execute_command_given_x_0_y_0_heading_E_and_command_L() throws CommandNotDefinedException {
        getMarsRoverNewPosition( "E", "L", 0, 0, "N");
    }

    @Test
    void should_return_x_0_y_0_heading_S_when_execute_command_given_x_0_y_0_heading_E_and_command_R() throws CommandNotDefinedException {
        getMarsRoverNewPosition( "E", "R", 0, 0, "S");
    }

    @Test
    void should_return_x_negative_1_y_0_heading_W_when_execute_command_given_x_0_y_0_heading_W_and_command_M() throws CommandNotDefinedException {
        getMarsRoverNewPosition( "W", "M", -1, 0, "W");
    }

    @Test
    void should_return_x_0_y_0_heading_S_when_execute_command_given_x_0_y_0_heading_W_and_command_L() throws CommandNotDefinedException {
        getMarsRoverNewPosition( "W", "L", 0, 0, "S");
    }

    @Test
    void should_return_x_0_y_0_heading_N_when_execute_command_given_x_0_y_0_heading_W_and_command_R() throws CommandNotDefinedException {
        getMarsRoverNewPosition( "W", "R", 0, 0, "N");
    }

    @Test
    void should_return_x_negative_1_y_0_heading_N_when_execute_command_given_x_0_y_0_heading_n_and_command_MLMR() throws CommandNotDefinedException {
        getMarsRoverNewPosition( "N", "MLMR", -1, 1, "N");
    }

    @Test
    void should_return_CommandNotDefinedException_when_execute_command_given_x_0_y_0_heading_n_and_command_MLMRF() throws CommandNotDefinedException {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "N");
        //then
        assertThrows(CommandNotDefinedException.class, () -> {
            //when
            marsRover.isValidCommand("MLMRF");
        });
    }
}
