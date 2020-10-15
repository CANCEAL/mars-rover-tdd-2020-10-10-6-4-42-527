package com.afs.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoTest {
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
}
