

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
	private JSONArray didMissNotificationsArray = new JSONArray();
	private JSONArray notificationTimesArray = new JSONArray();
	private int notificationsCount;
	
	
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
			result.put("HelloTo", this.mHelloTo);
		} catch (JSONException e) {
		}
		
		return result;
	}
	
	//whereas the setConfig() will take a JSONObject as a parameter FROM your JavaScript
	//and then set your java properties with it. 
	@Override
	protected void setConfig(JSONObject config) {
		try {
			if (config.has("HelloTo"))
				this.mHelloTo = config.getString("HelloTo");
		} catch (JSONException e) {
		}
		
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
