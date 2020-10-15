package com.afs.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {
    @Test
    void should_return_x_0_y_1_heading_N_when_execute_command_given_x_0_y_0_heading_n_and_command_M() {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "N");
        //when
        marsRover.executeCommand("M");
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
        marsRover.executeCommand("L");
        //then
        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("W", marsRover.getHeading());
    }

    @Test
    void should_return_x_0_y_0_heading_W_when_execute_command_given_x_0_y_0_heading_n_and_command_R() {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "N");
        //when
        marsRover.executeCommand("R");
        //then
        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("E", marsRover.getHeading());
    }

    @Test
    void should_return_x_0_y_negative_1_heading_S_when_execute_command_given_x_0_y_0_heading_S_and_command_M() {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "S");
        //when
        marsRover.executeCommand("M");
        //then
        assertEquals(0, marsRover.getLocationX());
        assertEquals(-1, marsRover.getLocationY());
        assertEquals("S", marsRover.getHeading());
    }

    @Test
    void should_return_x_0_y_0_heading_E_when_execute_command_given_x_0_y_0_heading_S_and_command_L() {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "S");
        //when
        marsRover.executeCommand("L");
        //then
        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("E", marsRover.getHeading());
    }

    @Test
    void should_return_x_0_y_0_heading_W_when_execute_command_given_x_0_y_0_heading_S_and_command_R() {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "S");
        //when
        marsRover.executeCommand("R");
        //then
        assertEquals(0, marsRover.getLocationX());
        assertEquals(0, marsRover.getLocationY());
        assertEquals("W", marsRover.getHeading());
    }
}
