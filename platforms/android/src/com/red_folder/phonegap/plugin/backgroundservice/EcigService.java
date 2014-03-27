

/* This Service needs to cancel notifications after three minutes of them firing
 * Need to have notificaitons play one of two audio files
 * Need to record missed notification if a user has not accessed a triggered notification
 */

package com.red_folder.phonegap.plugin.backgroundservice;

import de.appplant.cordova.plugin.localnotification.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EcigService extends BackgroundService{

	private final static String TAG = EcigService.class.getSimpleName();
	
	private String userID;
	private JSONArray didMissNotificationArr = new JSONArray();
	private JSONArray notificationTimes = new JSONArray();
	private int notificationCount;
	private int currentState;
	private boolean startedRandomPromptSurvey;
	private boolean finishedRandomPromptSurvey;
	private boolean hasMissedNotification;
	private boolean didMissDelayedNotification;
	private boolean didMissWakeUp;
	private boolean wakeUpFiring;
	private int surveysInADay;
	private int missedNotifications;
	private int timeAsleep;
	private int timeAwake;
	private Date resumeTime;
	private Date wakeTimDate;
	private Date bedTimeDate;
	
	@Override
	protected JSONObject doWork() {
		Log.d(TAG, "This is doWork()");
		
		JSONObject result = new JSONObject();		
		
		
		
		return result;
	}
	
	//The two next functions
	//getConfig() and setConfig() will allow you to pass parameters and 
	
	//set your properties from JavasScript. 
	//In the actual state, getConfig() will return the values of your Java properties TO your JavaScript as a JSONObject
	@Override
	protected JSONObject getConfig() {
		JSONObject result = new JSONObject();
		
		try {
			result.put("bedTimeDate", this.bedTimeDate);
		} catch (JSONException e) {}
		try {
			result.put("wakeTimeDate", this.wakeTimDate);
		} catch (JSONException e) {}
		try {
			result.put("resumeTime", this.resumeTime);
		} catch (JSONException e) {}
		try {
			result.put("currentState", this.currentState);
		} catch (JSONException e) {}
		try {
			result.put("didMissDelayedNotification", this.didMissDelayedNotification);
		} catch (JSONException e) {}
		try {
			result.put("didMissWakeUp", this.didMissWakeUp);
		} catch (JSONException e) {}
		try {
			result.put("finishedRandomPromptSurvey", this.finishedRandomPromptSurvey);
		} catch (JSONException e) {}
		try {
			result.put("hasMissedNotification", this.hasMissedNotification);
		} catch (JSONException e) {}
		try {
			result.put("missedNotifications", this.missedNotifications);
		} catch (JSONException e) {}
		try {
			result.put("notificationCount", this.notificationCount);
		} catch (JSONException e) {}
		try {
			result.put("startedRandomPromptSurvey", this.startedRandomPromptSurvey);
		} catch (JSONException e) {}
		try {
			result.put("surveysInADay", this.surveysInADay);
		} catch (JSONException e) {}
		try {
			result.put("timeAsleep", this.timeAsleep);
		} catch (JSONException e) {}
		try {
			result.put("timeAwake", this.timeAwake);
		} catch (JSONException e) {}
		try {
			result.put("wakeUpFiring", this.wakeUpFiring);
		} catch (JSONException e) {}

		return result;
	}
	
	//whereas the setConfig() will take a JSONObject as a parameter FROM your JavaScript
	//and then set your java properties with it. 
	@Override
	protected void setConfig(JSONObject config) {
		
		try {
			if (config.has("bedTimeDate"))
				this.bedTimeDate = (Date)config.get("bedTimeDate");
		} catch (JSONException e) {}
		try {
			if (config.has("wakeTimDate"))
				this.wakeTimDate = (Date)config.get("wakeTimDate");
		} catch (JSONException e) {}
		try {
			if (config.has("resumeTime"))
				this.resumeTime = (Date)config.get("resumeTime");
		} catch (JSONException e) {}
		try {
			if (config.has("currentState"))
				this.currentState = config.getInt("currentState");
		} catch (JSONException e) {}
		try {
			if (config.has("didMissDelayedNotification"))
				this.didMissDelayedNotification = config.getBoolean("didMissDelayedNotification");
		} catch (JSONException e) {}
		try {
			if (config.has("didMissNotificationArr"))
				this.didMissNotificationArr = config.getJSONArray("didMissNotificationArr");
		} catch (JSONException e) {}
		try {
			if (config.has("didMissWakeUp"))
				this.didMissWakeUp = config.getBoolean("didMissWakeUp");
		} catch (JSONException e) {}
		try {
			if (config.has("finishedRandomPromptSurvey"))
				this.finishedRandomPromptSurvey = config.getBoolean("finishedRandomPromptSurvey");
		} catch (JSONException e) {}
		try {
			if (config.has("hasMissedNotification"))
				this.hasMissedNotification = config.getBoolean("hasMissedNotification");
		} catch (JSONException e) {}
		try {
			if (config.has("missedNotifications"))
				this.missedNotifications = config.getInt("missedNotifications");
		} catch (JSONException e) {}
		try {
			if (config.has("notificationCount"))
				this.notificationCount = config.getInt("notificationCount");
		} catch (JSONException e) {}
		try {
			if (config.has("notificationTimes"))
				this.notificationTimes = config.getJSONArray("notificationTimes");
		} catch (JSONException e) {}
		try {
			if (config.has("startedRandomPromptSurvey"))
				this.startedRandomPromptSurvey = config.getBoolean("startedRandomPromptSurvey");
		} catch (JSONException e) {}
		try {
			if (config.has("surveysInADay"))
				this.surveysInADay = config.getInt("surveysInADay");
		} catch (JSONException e) {}
		try {
			if (config.has("timeAsleep"))
				this.timeAsleep = config.getInt("timeAsleep");
		} catch (JSONException e) {}
		try {
			if (config.has("timeAwake"))
				this.timeAwake = config.getInt("timeAwake");
		} catch (JSONException e) {}
		try {
			if (config.has("userID"))
				this.userID = config.getString("userID");
		} catch (JSONException e) {}
		try {
			if (config.has("wakeUpFiring"))
				this.wakeUpFiring = config.getBoolean("wakeUpFiring");
		} catch (JSONException e) {}
				
	}     
	
	@Override
	protected JSONObject initialiseLatestResult() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private void writeToFile(String data, String fileName) {
	        try {
	            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE));
	            outputStreamWriter.write(data);
	            outputStreamWriter.close();
	        }
	        catch (IOException e) {
	            Log.e(TAG, "File write failed: " + e.toString());
	    } 
	     
	}
	
	private String readFromFile(String fileName) {
        
        String ret = "";
         
        try {
            InputStream inputStream = openFileInput(fileName);
             
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                 
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                 
                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
        }
 
        return ret;
    }
	
	
	 


}
