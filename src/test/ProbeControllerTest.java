package com.interview.probe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class ProbeControllerTest {
	
	@InjectMocks
	ProbeController probeController;
	
	@Test
	public void testMoveForward() {
		Command command = new Command();
		command.setAction("forward");
		String response = probeController.controlProbe("forward");
		assertTrue(response.contains("forward"));
	}
}
