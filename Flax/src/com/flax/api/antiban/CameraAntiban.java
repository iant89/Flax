package com.flax.api.antiban;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.input.Camera;

import com.flax.api.Flax;

public class CameraAntiban implements Runnable {

	private Thread camera_thread;
	private boolean camera_enabled = false;
	private boolean camera_moving = false;
	private int camera_max_pitch = 0;
	private int camera_min_pitch = 0;
	private int camera_max_yaw = 0;
	private int camera_min_yaw = 0;
	
	public CameraAntiban(boolean enabled) {
		camera_thread = new Thread(this);
		
		this.setEnabled(enabled);
	}
	
	public void setPitchYawDefaults(int min_pitch, int max_pitch, int min_yaw, int max_yaw) {
		camera_min_pitch = min_pitch;
		camera_max_pitch = max_pitch;
		camera_min_yaw = min_yaw;
		camera_max_yaw = max_yaw;
	}
	
	public void setMaxPitch(int pitch) {
		camera_max_pitch = pitch;
	}
	
	public void setMinPitch(int pitch) {
		camera_min_pitch = pitch;
	}
	
	public void setMaxYaw(int yaw) {
		camera_max_yaw = yaw;
	}
	
	public void setMinYaw(int yaw) {
		camera_min_yaw = yaw;
	}
	
	public void setEnabled(boolean enabled) {
		camera_enabled = enabled;
		
		if(camera_enabled) {
			camera_thread.start();
		}
	}
	
	public void destory() {
		try {
			camera_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		camera_enabled = false;
	}
	
	public boolean isCameraMoving() {
		return camera_moving;
	}
	
	@Override
	public void run() {
		while(true) {
			
			// Check to see if the Camera is active
			if(!camera_enabled) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

				}
				return;
			}
				
		}
	}

	
	
	public void rotateRandom() {
	    int p = Calculations.random(camera_min_pitch, camera_max_pitch);
	    int y = Calculations.random(camera_min_yaw, camera_max_yaw);
	    Flax.debug("[CameraAntiban] Moving Camera Randomly. P:" + p + ", Y:"+y);
	    Flax.getContext().getCamera().rotateToPitch(p);
	    Flax.getContext().getCamera().rotateToYaw(y);
	}
	
}
