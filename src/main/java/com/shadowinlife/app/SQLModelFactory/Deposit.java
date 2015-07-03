package com.shadowinlife.app.SQLModelFactory;
import java.io.*;
import java.sql.*;

public class Deposit extends BaseBean implements Serializable {
    public Deposit() {
        super();
    }
    private Long iAccountType;
    private Long iGameId;
    private Long iWorldId;
    public Long getiAccountType() {
        return iAccountType;
    }
    public Long getiGameId() {
        return iGameId;
    }
    public Long getiWorldId() {
        return iWorldId;
    }
    public void setiAccountType(Long iAccountType) {
        this.iAccountType = iAccountType;
    }
    public void setiGameId(Long iGameId) {
        this.iGameId = iGameId;
    }
    public void setiWorldId(Long iWorldId) {
        this.iWorldId = iWorldId;
    }
    private Timestamp dtEventTime;
    public void setdtEventTime(Timestamp dtEventTime){
        this.dtEventTime=dtEventTime;
    }
   public Timestamp getdtEventTime() {
        return dtEventTime;
    }

    private Long iEventId;
    public void setiEventId(Long iEventId){
        this.iEventId=iEventId;
    }
   public Long getiEventId() {
        return iEventId;
    }

    private String vVersionId;
    public void setvVersionId(String vVersionId){
        this.vVersionId=vVersionId;
    }
   public String getvVersionId() {
        return vVersionId;
    }

    private String vUin;
    public void setvUin(String vUin){
        this.vUin=vUin;
    }
   public String getvUin() {
        return vUin;
    }

    private Long iRoleId;
    public void setiRoleId(Long iRoleId){
        this.iRoleId=iRoleId;
    }
   public Long getiRoleId() {
        return iRoleId;
    }

    private String vRoleName;
    public void setvRoleName(String vRoleName){
        this.vRoleName=vRoleName;
    }
   public String getvRoleName() {
        return vRoleName;
    }

    private Long iRoleJob;
    public void setiRoleJob(Long iRoleJob){
        this.iRoleJob=iRoleJob;
    }
   public Long getiRoleJob() {
        return iRoleJob;
    }

    private Long iRoleGender;
    public void setiRoleGender(Long iRoleGender){
        this.iRoleGender=iRoleGender;
    }
   public Long getiRoleGender() {
        return iRoleGender;
    }

    private Long iRoleLevel;
    public void setiRoleLevel(Long iRoleLevel){
        this.iRoleLevel=iRoleLevel;
    }
   public Long getiRoleLevel() {
        return iRoleLevel;
    }

    private Long iRoleVipLevel;
    public void setiRoleVipLevel(Long iRoleVipLevel){
        this.iRoleVipLevel=iRoleVipLevel;
    }
   public Long getiRoleVipLevel() {
        return iRoleVipLevel;
    }

    private Long iRoleReputationLevel;
    public void setiRoleReputationLevel(Long iRoleReputationLevel){
        this.iRoleReputationLevel=iRoleReputationLevel;
    }
   public Long getiRoleReputationLevel() {
        return iRoleReputationLevel;
    }

    private String vRoleElse1;
    public void setvRoleElse1(String vRoleElse1){
        this.vRoleElse1=vRoleElse1;
    }
   public String getvRoleElse1() {
        return vRoleElse1;
    }

    private String vRoleElse2;
    public void setvRoleElse2(String vRoleElse2){
        this.vRoleElse2=vRoleElse2;
    }
   public String getvRoleElse2() {
        return vRoleElse2;
    }

    private Long iArea;
    public void setiArea(Long iArea){
        this.iArea=iArea;
    }
   public Long getiArea() {
        return iArea;
    }

    private String vDstUin;
    public void setvDstUin(String vDstUin){
        this.vDstUin=vDstUin;
    }
   public String getvDstUin() {
        return vDstUin;
    }

    private Long iSourceWay;
    public void setiSourceWay(Long iSourceWay){
        this.iSourceWay=iSourceWay;
    }
   public Long getiSourceWay() {
        return iSourceWay;
    }

    private String vClientIp;
    public void setvClientIp(String vClientIp){
        this.vClientIp=vClientIp;
    }
   public String getvClientIp() {
        return vClientIp;
    }

    private String vReMarks;
    public void setvReMarks(String vReMarks){
        this.vReMarks=vReMarks;
    }
   public String getvReMarks() {
        return vReMarks;
    }

    private Long iPayBefore;
    public void setiPayBefore(Long iPayBefore){
        this.iPayBefore=iPayBefore;
    }
   public Long getiPayBefore() {
        return iPayBefore;
    }

    private Long iPayDelta;
    public void setiPayDelta(Long iPayDelta){
        this.iPayDelta=iPayDelta;
    }
   public Long getiPayDelta() {
        return iPayDelta;
    }

    private Long iPayAfter;
    public void setiPayAfter(Long iPayAfter){
        this.iPayAfter=iPayAfter;
    }
   public Long getiPayAfter() {
        return iPayAfter;
    }

    private String vDesc;
    public void setvDesc(String vDesc){
        this.vDesc=vDesc;
    }
   public String getvDesc() {
        return vDesc;
    }

    private String vLoginWay;
    public void setvLoginWay(String vLoginWay){
        this.vLoginWay=vLoginWay;
    }
   public String getvLoginWay() {
        return vLoginWay;
    }

    public Deposit parseFromLogFile(String[] args, String GameId, String AccountType, String WorldId){
        return new Deposit(GameId, AccountType, WorldId, args[1],args[2],args[3],args[4],args[5],args[6],args[7],args[8],args[9],args[10],args[11],args[12],args[13],args[14],args[15],args[16],args[17],args[18],args[19],args[20],args[21],args[22],args[23]);
    }

    public Deposit(String GameId, String AccountType, String WorldId, String dtEventTime,String iEventId,String vVersionId,String vUin,String iRoleId,String vRoleName,String iRoleJob,String iRoleGender,String iRoleLevel,String iRoleVipLevel,String iRoleReputationLevel,String vRoleElse1,String vRoleElse2,String iArea,String vDstUin,String iSourceWay,String vClientIp,String vReMarks,String iPayBefore,String iPayDelta,String iPayAfter,String vDesc,String vLoginWay){
        this.iGameId = Long.valueOf(GameId);
        this.iAccountType = Long.valueOf(AccountType);
        this.iWorldId = Long.valueOf(WorldId);
        this.dtEventTime = Timestamp.valueOf(dtEventTime);
        this.iEventId = Long.valueOf(iEventId);
        this.vVersionId = String.valueOf(vVersionId);
        this.vUin = String.valueOf(vUin);
        this.iRoleId = Long.valueOf(iRoleId);
        this.vRoleName = String.valueOf(vRoleName);
        this.iRoleJob = Long.valueOf(iRoleJob);
        this.iRoleGender = Long.valueOf(iRoleGender);
        this.iRoleLevel = Long.valueOf(iRoleLevel);
        this.iRoleVipLevel = Long.valueOf(iRoleVipLevel);
        this.iRoleReputationLevel = Long.valueOf(iRoleReputationLevel);
        this.vRoleElse1 = String.valueOf(vRoleElse1);
        this.vRoleElse2 = String.valueOf(vRoleElse2);
        this.iArea = Long.valueOf(iArea);
        this.vDstUin = String.valueOf(vDstUin);
        this.iSourceWay = Long.valueOf(iSourceWay);
        this.vClientIp = String.valueOf(vClientIp);
        this.vReMarks = String.valueOf(vReMarks);
        this.iPayBefore = Long.valueOf(iPayBefore);
        this.iPayDelta = Long.valueOf(iPayDelta);
        this.iPayAfter = Long.valueOf(iPayAfter);
        this.vDesc = String.valueOf(vDesc);
        this.vLoginWay = String.valueOf(vLoginWay);
    }
}