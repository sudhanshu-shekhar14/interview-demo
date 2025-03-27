package com.demo.interview.probe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/probe")
public class ProbeController {
	
	private final ProbeState probeState = new ProbeState();
	
	private static final Set<String> movement_command = new HashSet<>(Arrays.asList("forward", "backward", "left", "right", "up", "down"));
	private static final Set<String> camera_command = new HashSet<>(Arrays.asList("tilt_up", "tilt_down", "rotate_left", "rotate_right"));
	
	@PostMapping("/control")
	public String controlProbe(@RequestBody Command command) {
		String action = command.getAction().toLowerCase();
		
		if(movement_command.contains(action)) {
			return moveProbe(action);
		} else if(camera_command.contains(action)) {
			return controlCamera(action);
		} else {
			return "Invalid Command";
		}
	}
	
	private String moveProbe(String direction) {
		if(probeState.getBatteryLevel()<=0) {
			return "Battery low. Cannot Move";
		}
		
		int[] position = probeState.getPosition();
		
		switch(direction) {
		case "forward" : position[0] += 1; break;
		case "backward" : position[0] -= 1; break;
		case "left" : position[1] -= 1; break;
		case "right" : position[1] += 1; break;
		case "up" : position[2] += 1; break;
		case "down" : position[2] -= 1; break;
		}
		probeState.setBatteryLevel(probeState.getBatteryLevel() - 1);
		probeState.setPosition(position);
		
		return "Probe move: "+ direction + " Position " + Arrays.toString(position);
 	}
	
	private String controlCamera(String action) {
		int[] cameraAngle = probeState.getCameraAngle();
		
		switch(action) {
		case "tilt_up" : cameraAngle[0] += 10; break;
		case "tilt_down" : cameraAngle[0] -= 10; break;
		case "rotate_left" : cameraAngle[1] -= 10; break;
		case "rotate_right" : cameraAngle[1] += 10; break;
		}
		probeState.setCameraAngle(cameraAngle);
		return "Camera adjusted " +action + " Camera Angle: " + Arrays.toString(cameraAngle);
	}
}
