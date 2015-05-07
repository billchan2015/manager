package com.shadowinlife.app.LogAnalyse;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * FileSplit is used as the Map Class split log into different Files Based on
 * the eventTAG Login/Logout/Levelup
 * 
 * @author shadowinlife
 * @since 2015-04-01
 */

public class FileSplit {

    private String keyName = "Default";
    private String[] lineValues;
    private String dtEvetnTime;
    private String fileValue;
    private FileSplit(String keyName, String[] lineValues) {
        this.keyName = keyName;
        this.lineValues = lineValues;
        
    }
    private FileSplit(String dtEventTime, String fileValue) {
        this.dtEvetnTime = dtEventTime;
        this.fileValue = fileValue;
    }
    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String[] getLineValues() {
        return lineValues;
    }

    public void setLineValues(String[] lineValues) {
        this.lineValues = lineValues;
    }

    public String getDtEvetnTime() {
        return dtEvetnTime;
    }

    public void setDtEvetnTime(String dtEvetnTime) {
        this.dtEvetnTime = dtEvetnTime;
    }

    public static FileSplit parseFromLogFile(String logline) {
        String[] splitIndex = logline.split("\\|", 25);
        if (splitIndex.length > 2) {
            
            return new FileSplit(splitIndex[0], splitIndex);

        } else {
            return new FileSplit("null", logline);
        }
    }
    
    public static FileSplit parseLogFileToKV(String logline) {
        String[] splitIndex = logline.split("\\|", 25);
        if (splitIndex.length > 2) {
            if(splitIndex[3].length()<10) {
                return new FileSplit(splitIndex[0]+"0000-00-00",logline);
            }
            String key = splitIndex[0]+splitIndex[3].substring(0, 10);
            return new FileSplit(key, logline);

        } else {
            return new FileSplit("null", logline);
        }
    }
    public String getFileValue() {
        return fileValue;
    }
    public void setFileValue(String fileValue) {
        this.fileValue = fileValue;
    }

}
