package com.afs.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {
    public void newPosition(int x, int y, String heading) {

    }

    @Test
    void should_return_x_0_y_1_heading_N_when_execute_command_given_x_0_y_0_heading_n_and_command_M() {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "N");

        //when
        marsRover.executeCommands("M");

        //then
        assertEquals(0, marsRover.getLocationX());
        assertEquals(1, marsRover.getLocationY());
        assertEquals("N", marsRover.getHeading());
    }

    @Test
    void should_return_x_0_y_0_heading_W_when_execute_command_given_x_0_y_0_heading_n_and_command_L() {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "N");

        //when
        marsRover.executeCommands("L");

        //then
        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("W", marsRover.getHeading());
    }
}
