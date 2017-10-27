package com.example.administrator.nfl1;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by jw76577 on 6/9/2016.
 */
public class NFLPlayer implements Serializable {

    private UUID mId;
    private String mName;
    private String mTeam;
    private String mPos;
    private double mPFP;
    private double mAFP;
    private double mMINFP;
    private double mMAXFP;
    private double mAVG;
    private int mSalary;

   public NFLPlayer(UUID mId) {
       mId = UUID.randomUUID();
       this.mId = mId;
   }

   public NFLPlayer(String name, String pos, String team,
                    double afp, double pfp, double minfp,
                    double maxfp, double avgfp, int salary) {
       //this.mId = UUID.randomUUID();
       mName = name;
       mPos = pos;
       mTeam = team;
       mAFP = afp;
       mPFP = pfp;
       mMINFP = minfp;
       mMAXFP = maxfp;
       mAVG = avgfp;
       mSalary = salary;
   }


    /**
     * Method to get unique Identifier for a player.
     */
    public UUID getID() {
        return mId;
    }

    /**
     * Method to get name of a player.
     */
    public String getName() {
        return mName;
    }

    /**
     * Method to set name of a player.
     */
    public void setName(String mName) {
        this.mName = mName;
    }

    /**
     * Method to get position of a player;.
     */
    public String getPos() {
        return mPos;
    }

    /**
     * Method to set position of a player.
     */
    public void setPos(String mPos) {
        this.mPos = mPos;
    }

    /**
     * Method to get team player belongs to.
     */
    public String getTeam() {
        return mTeam;
    }

    /**
     * Method to set team player belongs to.
     */
    public void setTeam(String mTeam) {
        this.mTeam = mTeam;
    }

    /**
     * Method to get ACTUAL fantasy points a player achieves.
     */
    public double getAFP() {
        return mAFP;
    }

    /**
     * Method to set ACTUAL fantasy points a player achieves.
     */
    public void setAFP(double mAFP) {
        this.mAFP = mAFP;
    }

    /**
     * Method to get projected fantasy points for a player that week.
     */
    public double getPFP() {
        return mPFP;
    }

    /**
     * Method to set projected fantasy points for a player that week.
     */
    public void setPFP(double mPFP) {
        this.mPFP = mPFP;
    }

    /**
     * Method to get minimum average fantasy points a player ever achieves.
     */
    public double getMINFP() {
        return mMINFP;
    }

    /**
     * Method to set minimum average fantasy points a player ever achieves.
     */
    public void setMINFP(double mMINFP) {
        this.mMINFP = mMINFP;
    }

    /**
     * Method to get max average fantasy points a player ever achieves.
     */
    public double getMAXFP() {
        return mMAXFP;
    }

    /**
     * Method to set max average fantasy points a player ever achieves.
     */
    public void setMAXFP(double mMAXFP) {
        this.mMAXFP = mMAXFP;
    }
    /**
     * Method to get average fantasy points a player achieves.
     */
    public double getAVG() {
        return mAVG;
    }

    /**
     * Method to set average fantasy points a player achieves.
     */
    public void setAVG(double mAVG) {
        this.mAVG = mAVG;
    }

    /**
     * Method to get salary for player.
     */
    public int getSalary() {
        return mSalary;
    }

    /**
     * Method to set salary for player.
     */
    public void setSalary(int mSalary) {
        this.mSalary = mSalary;
    }


}
