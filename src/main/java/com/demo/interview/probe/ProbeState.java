package com.demo.interview.probe;

import java.util.Arrays;

public class ProbeState {
	
	private int batteryLevel = 100;
	private int depth = 0;
	private double temparature = 15.0;
	private int[] position = {0, 0, 0};
	private int[] cameraAngle = {0, 0};
	
	public int getBatteryLevel() { 
		return batteryLevel; 
		}
	
	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}
	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public double getTemparature() {
		return temparature;
	}

	public void setTemparature(double temparature) {
		this.temparature = temparature;
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public int[] getCameraAngle() {
		return cameraAngle;
	}

	public void setCameraAngle(int[] cameraAngle) {
		this.cameraAngle = cameraAngle;
	}
	
	@Override
	public String toString() {
		
		return "Battery: " + batteryLevel + " Depth: " + depth + " Position: " + Arrays.toString(position) +
				" Camera: " + Arrays.toString(cameraAngle);
	}
	
}
