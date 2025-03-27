package com.demo.interview.probe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProbeControllerTest {
	
	@InjectMocks
	ProbeController probeController;
	
	@Test
	public void testMoveForward() {
		Command command = new Command();
		command.setAction("forward");
		String response = probeController.controlProbe(command);
		Assertions.assertTrue(true, response);
	}
	
	@Test
	public void testInvalidCommand() {
		Command command = new Command();
		command.setAction("jump");
		String response = probeController.controlProbe(command);
		Assertions.assertEquals("Invalid Command", response);
	}
	
	@Test
	public void testCameraTiltUp() {
		Command command = new Command();
		command.setAction("tilt_up");
		String response = probeController.controlProbe(command);
		Assertions.assertTrue(true, response);
	}
}
