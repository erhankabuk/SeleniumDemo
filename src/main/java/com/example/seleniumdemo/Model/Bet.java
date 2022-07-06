package com.example.seleniumdemo.Model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "BetList")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Match_Number")
    private String matchNumber;

    @Column(name = "Match_Time")
    private String matchTime;

    @Column(name = "League")
    private String leagueName;

    @Column(name = "Match_Name")
    private String matchName;

    // Update Time
    @Column(name="Update_Time")
    private LocalDateTime  updateTime;

    //Match Score
    @Column(name = "Match_Score_1")
    private double matchScore1;

    @Column(name = "Match_Score_0")
    private double matchScore0;

    @Column(name = "Match_Score_2")
    private double matchScore2;

    //First Half Score
    @Column(name = "First_Half_1")
    private double firstHalfScore1;

    @Column(name = "First_Half_0")
    private double firstHalfScore0;

    @Column(name = "First_Half_2")
    private double firstHalfScore2;

    //Handicaped Matches
    @Column(name = "Handicaped_Match_Score_H")
    private String handicapedMatchScoreH;

    @Column(name = "Handicaped_Match_Score_1")
    private double handicapedMatchScore1;

    @Column(name = "Handicaped_Match_Score_0")
    private double handicapedMatchScore0;

    @Column(name = "Handicaped_Match_Score_2")
    private double handicapedMatchScore2;

    //Opposite Goals
    @Column(name = "Opposite_Goals_NO")
    private double oppositeGoalsNo;

    @Column(name = "Opposite_Goals_YES")
    private double oppositeGoalsYes;

    //Lower/Upper
    @Column(name = "Lower_Upper_05_Lower")
    private double lowerUpper0_5Lower;

    @Column(name = "Lower_Upper_05_Upper")
    private double lowerUpper0_5Upper;

    @Column(name = "Lower_Upper_15_Lower")
    private double lowerUpper1_5Lower;

    @Column(name = "Lower_Upper_15_Upper")
    private double lowerUpper1_5Upper;

    @Column(name = "Lower_Upper_25_Lower")
    private double lowerUpper2_5Lower;

    @Column(name = "Lower_Upper_25_Upper")
    private double lowerUpper2_5Upper;

    @Column(name = "Lower_Upper_35_Lower")
    private double lowerUpper3_5Lower;

    @Column(name = "Lower_Upper_35_Upper")
    private double lowerUpper3_5Upper;

    @Column(name = "Lower_Upper_45_Lower")
    private double lowerUpper4_5Lower;

    @Column(name = "Lower_Upper_45_Upper")
    private double lowerUpper4_5Upper;

    //Double Chance
    @Column(name = "DoubleChance_02")
    private double doubleChange0_2;

    @Column(name = "DoubleChance_10")
    private double doubleChange1_0;

    @Column(name = "DoubleChance_12")
    private double doubleChange1_2;

    //First Half Double Chance
    @Column(name = "First_Half_Double_Chance_10")
    private double firstHalfDoubleChance1_0;

    @Column(name = "First_Half_Double_Chance_12")
    private double firstHalfDoubleChance1_2;

    @Column(name = "First_Half_Double_Chance_02")
    private double firstHalfDoubleChance0_2;

    //First Half Lower/Upper
    @Column(name = "First_Half_Lower_Upper_05_Lower")
    private double firstHalfLowerUpper0_5Lower;

    @Column(name = "First_Half_Lower_Upper_05_Upper")
    private double firstHalfLowerUpper0_5Upper;

    @Column(name = "First_Half_Lower_Upper_15_Lower")
    private double firstHalfLowerUpper1_5Lower;

    @Column(name = "First_Half_Lower_Upper_15_Upper")
    private double firstHalfLowerUpper1_5Upper;

    @Column(name = "First_Half_Lower_Upper_25_Lower")
    private double firstHalfLowerUpper2_5Lower;

    @Column(name = "First_Half_Lower_Upper_25_Upper")
    private double firstHalfLowerUpper2_5Upper;

    @Column(name = "First_Half_Lower_Upper_35_Lower")
    private double firstHalfLowerUpper3_5Lower;

    @Column(name = "First_Half_Lower_Upper_35_Upper")
    private double firstHalfLowerUpper3_5Upper;

    @Column(name = "First_Half_Lower_Upper_45_Lower")
    private double firstHalfLowerUpper4_5Lower;

    @Column(name = "First_Half_Lower_Upper_45_Upper")
    private double firstHalfLowerUpper4_5Upper;

    //Home Lower/Upper
    @Column(name = "Home_Lower_Upper_05_Lower")
    private double homeLowerUpper0_5Lower;

    @Column(name = "Home_Lower_Upper_05_Upper")
    private double homeLowerUpper0_5Upper;

    @Column(name = "Home_Lower_Upper_15_Lower")
    private double homeLowerUpper1_5Lower;

    @Column(name = "Home_Lower_Upper_15_Upper")
    private double homeLowerUpper1_5Upper;

    @Column(name = "Home_Lower_Upper_25_Lower")
    private double homeLowerUpper2_5Lower;

    @Column(name = "Home_Lower_Upper_25_Upper")
    private double homeLowerUpper2_5Upper;

    @Column(name = "Home_Lower_Upper_35_Lower")
    private double homeLowerUpper3_5Lower;

    @Column(name = "Home_Lower_Upper_35_Upper")
    private double homeLowerUpper3_5Upper;

    @Column(name = "Home_Lower_Upper_45_Lower")
    private double homeLowerUpper4_5Lower;

    @Column(name = "Home_Lower_Upper_45_Upper")
    private double homeLowerUpper4_5Upper;

    public Bet() {
    }

    public Bet(Long id, String matchNumber, String matchTime, String leagueName, String matchName, LocalDateTime updateTime, double matchScore1, double matchScore0, double matchScore2, double firstHalfScore1, double firstHalfScore0, double firstHalfScore2, String handicapedMatchScoreH, double handicapedMatchScore1, double handicapedMatchScore0, double handicapedMatchScore2, double oppositeGoalsNo, double oppositeGoalsYes, double lowerUpper0_5Lower, double lowerUpper0_5Upper, double lowerUpper1_5Lower, double lowerUpper1_5Upper, double lowerUpper2_5Lower, double lowerUpper2_5Upper, double lowerUpper3_5Lower, double lowerUpper3_5Upper, double lowerUpper4_5Lower, double lowerUpper4_5Upper, double doubleChange0_2, double doubleChange1_0, double doubleChange1_2, double firstHalfDoubleChance1_0, double firstHalfDoubleChance1_2, double firstHalfDoubleChance0_2, double firstHalfLowerUpper0_5Lower, double firstHalfLowerUpper0_5Upper, double firstHalfLowerUpper1_5Lower, double firstHalfLowerUpper1_5Upper, double firstHalfLowerUpper2_5Lower, double firstHalfLowerUpper2_5Upper, double firstHalfLowerUpper3_5Lower, double firstHalfLowerUpper3_5Upper, double firstHalfLowerUpper4_5Lower, double firstHalfLowerUpper4_5Upper, double homeLowerUpper0_5Lower, double homeLowerUpper0_5Upper, double homeLowerUpper1_5Lower, double homeLowerUpper1_5Upper, double homeLowerUpper2_5Lower, double homeLowerUpper2_5Upper, double homeLowerUpper3_5Lower, double homeLowerUpper3_5Upper, double homeLowerUpper4_5Lower, double homeLowerUpper4_5Upper) {
        this.id = id;
        this.matchNumber = matchNumber;
        this.matchTime = matchTime;
        this.leagueName = leagueName;
        this.matchName = matchName;
        this.updateTime = updateTime;
        this.matchScore1 = matchScore1;
        this.matchScore0 = matchScore0;
        this.matchScore2 = matchScore2;
        this.firstHalfScore1 = firstHalfScore1;
        this.firstHalfScore0 = firstHalfScore0;
        this.firstHalfScore2 = firstHalfScore2;
        this.handicapedMatchScoreH = handicapedMatchScoreH;
        this.handicapedMatchScore1 = handicapedMatchScore1;
        this.handicapedMatchScore0 = handicapedMatchScore0;
        this.handicapedMatchScore2 = handicapedMatchScore2;
        this.oppositeGoalsNo = oppositeGoalsNo;
        this.oppositeGoalsYes = oppositeGoalsYes;
        this.lowerUpper0_5Lower = lowerUpper0_5Lower;
        this.lowerUpper0_5Upper = lowerUpper0_5Upper;
        this.lowerUpper1_5Lower = lowerUpper1_5Lower;
        this.lowerUpper1_5Upper = lowerUpper1_5Upper;
        this.lowerUpper2_5Lower = lowerUpper2_5Lower;
        this.lowerUpper2_5Upper = lowerUpper2_5Upper;
        this.lowerUpper3_5Lower = lowerUpper3_5Lower;
        this.lowerUpper3_5Upper = lowerUpper3_5Upper;
        this.lowerUpper4_5Lower = lowerUpper4_5Lower;
        this.lowerUpper4_5Upper = lowerUpper4_5Upper;
        this.doubleChange0_2 = doubleChange0_2;
        this.doubleChange1_0 = doubleChange1_0;
        this.doubleChange1_2 = doubleChange1_2;
        this.firstHalfDoubleChance1_0 = firstHalfDoubleChance1_0;
        this.firstHalfDoubleChance1_2 = firstHalfDoubleChance1_2;
        this.firstHalfDoubleChance0_2 = firstHalfDoubleChance0_2;
        this.firstHalfLowerUpper0_5Lower = firstHalfLowerUpper0_5Lower;
        this.firstHalfLowerUpper0_5Upper = firstHalfLowerUpper0_5Upper;
        this.firstHalfLowerUpper1_5Lower = firstHalfLowerUpper1_5Lower;
        this.firstHalfLowerUpper1_5Upper = firstHalfLowerUpper1_5Upper;
        this.firstHalfLowerUpper2_5Lower = firstHalfLowerUpper2_5Lower;
        this.firstHalfLowerUpper2_5Upper = firstHalfLowerUpper2_5Upper;
        this.firstHalfLowerUpper3_5Lower = firstHalfLowerUpper3_5Lower;
        this.firstHalfLowerUpper3_5Upper = firstHalfLowerUpper3_5Upper;
        this.firstHalfLowerUpper4_5Lower = firstHalfLowerUpper4_5Lower;
        this.firstHalfLowerUpper4_5Upper = firstHalfLowerUpper4_5Upper;
        this.homeLowerUpper0_5Lower = homeLowerUpper0_5Lower;
        this.homeLowerUpper0_5Upper = homeLowerUpper0_5Upper;
        this.homeLowerUpper1_5Lower = homeLowerUpper1_5Lower;
        this.homeLowerUpper1_5Upper = homeLowerUpper1_5Upper;
        this.homeLowerUpper2_5Lower = homeLowerUpper2_5Lower;
        this.homeLowerUpper2_5Upper = homeLowerUpper2_5Upper;
        this.homeLowerUpper3_5Lower = homeLowerUpper3_5Lower;
        this.homeLowerUpper3_5Upper = homeLowerUpper3_5Upper;
        this.homeLowerUpper4_5Lower = homeLowerUpper4_5Lower;
        this.homeLowerUpper4_5Upper = homeLowerUpper4_5Upper;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(String matchNumber) {
        this.matchNumber = matchNumber;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public double getMatchScore1() {
        return matchScore1;
    }

    public void setMatchScore1(double matchScore1) {
        this.matchScore1 = matchScore1;
    }

    public double getMatchScore0() {
        return matchScore0;
    }

    public void setMatchScore0(double matchScore0) {
        this.matchScore0 = matchScore0;
    }

    public double getMatchScore2() {
        return matchScore2;
    }

    public void setMatchScore2(double matchScore2) {
        this.matchScore2 = matchScore2;
    }

    public double getFirstHalfScore1() {
        return firstHalfScore1;
    }

    public void setFirstHalfScore1(double firstHalfScore1) {
        this.firstHalfScore1 = firstHalfScore1;
    }

    public double getFirstHalfScore0() {
        return firstHalfScore0;
    }

    public void setFirstHalfScore0(double firstHalfScore0) {
        this.firstHalfScore0 = firstHalfScore0;
    }

    public double getFirstHalfScore2() {
        return firstHalfScore2;
    }

    public void setFirstHalfScore2(double firstHalfScore2) {
        this.firstHalfScore2 = firstHalfScore2;
    }

    public String getHandicapedMatchScoreH() {
        return handicapedMatchScoreH;
    }

    public void setHandicapedMatchScoreH(String handicapedMatchScoreH) {
        this.handicapedMatchScoreH = handicapedMatchScoreH;
    }

    public double getHandicapedMatchScore1() {
        return handicapedMatchScore1;
    }

    public void setHandicapedMatchScore1(double handicapedMatchScore1) {
        this.handicapedMatchScore1 = handicapedMatchScore1;
    }

    public double getHandicapedMatchScore0() {
        return handicapedMatchScore0;
    }

    public void setHandicapedMatchScore0(double handicapedMatchScore0) {
        this.handicapedMatchScore0 = handicapedMatchScore0;
    }

    public double getHandicapedMatchScore2() {
        return handicapedMatchScore2;
    }

    public void setHandicapedMatchScore2(double handicapedMatchScore2) {
        this.handicapedMatchScore2 = handicapedMatchScore2;
    }

    public double getOppositeGoalsNo() {
        return oppositeGoalsNo;
    }

    public void setOppositeGoalsNo(double oppositeGoalsNo) {
        this.oppositeGoalsNo = oppositeGoalsNo;
    }

    public double getOppositeGoalsYes() {
        return oppositeGoalsYes;
    }

    public void setOppositeGoalsYes(double oppositeGoalsYes) {
        this.oppositeGoalsYes = oppositeGoalsYes;
    }

    public double getLowerUpper0_5Lower() {
        return lowerUpper0_5Lower;
    }

    public void setLowerUpper0_5Lower(double lowerUpper0_5Lower) {
        this.lowerUpper0_5Lower = lowerUpper0_5Lower;
    }

    public double getLowerUpper0_5Upper() {
        return lowerUpper0_5Upper;
    }

    public void setLowerUpper0_5Upper(double lowerUpper0_5Upper) {
        this.lowerUpper0_5Upper = lowerUpper0_5Upper;
    }

    public double getLowerUpper1_5Lower() {
        return lowerUpper1_5Lower;
    }

    public void setLowerUpper1_5Lower(double lowerUpper1_5Lower) {
        this.lowerUpper1_5Lower = lowerUpper1_5Lower;
    }

    public double getLowerUpper1_5Upper() {
        return lowerUpper1_5Upper;
    }

    public void setLowerUpper1_5Upper(double lowerUpper1_5Upper) {
        this.lowerUpper1_5Upper = lowerUpper1_5Upper;
    }

    public double getLowerUpper2_5Lower() {
        return lowerUpper2_5Lower;
    }

    public void setLowerUpper2_5Lower(double lowerUpper2_5Lower) {
        this.lowerUpper2_5Lower = lowerUpper2_5Lower;
    }

    public double getLowerUpper2_5Upper() {
        return lowerUpper2_5Upper;
    }

    public void setLowerUpper2_5Upper(double lowerUpper2_5Upper) {
        this.lowerUpper2_5Upper = lowerUpper2_5Upper;
    }

    public double getLowerUpper3_5Lower() {
        return lowerUpper3_5Lower;
    }

    public void setLowerUpper3_5Lower(double lowerUpper3_5Lower) {
        this.lowerUpper3_5Lower = lowerUpper3_5Lower;
    }

    public double getLowerUpper3_5Upper() {
        return lowerUpper3_5Upper;
    }

    public void setLowerUpper3_5Upper(double lowerUpper3_5Upper) {
        this.lowerUpper3_5Upper = lowerUpper3_5Upper;
    }

    public double getLowerUpper4_5Lower() {
        return lowerUpper4_5Lower;
    }

    public void setLowerUpper4_5Lower(double lowerUpper4_5Lower) {
        this.lowerUpper4_5Lower = lowerUpper4_5Lower;
    }

    public double getLowerUpper4_5Upper() {
        return lowerUpper4_5Upper;
    }

    public void setLowerUpper4_5Upper(double lowerUpper4_5Upper) {
        this.lowerUpper4_5Upper = lowerUpper4_5Upper;
    }

    public double getDoubleChange0_2() {
        return doubleChange0_2;
    }

    public void setDoubleChange0_2(double doubleChange0_2) {
        this.doubleChange0_2 = doubleChange0_2;
    }

    public double getDoubleChange1_0() {
        return doubleChange1_0;
    }

    public void setDoubleChange1_0(double doubleChange1_0) {
        this.doubleChange1_0 = doubleChange1_0;
    }

    public double getDoubleChange1_2() {
        return doubleChange1_2;
    }

    public void setDoubleChange1_2(double doubleChange1_2) {
        this.doubleChange1_2 = doubleChange1_2;
    }

    public double getFirstHalfDoubleChance1_0() {
        return firstHalfDoubleChance1_0;
    }

    public void setFirstHalfDoubleChance1_0(double firstHalfDoubleChance1_0) {
        this.firstHalfDoubleChance1_0 = firstHalfDoubleChance1_0;
    }

    public double getFirstHalfDoubleChance1_2() {
        return firstHalfDoubleChance1_2;
    }

    public void setFirstHalfDoubleChance1_2(double firstHalfDoubleChance1_2) {
        this.firstHalfDoubleChance1_2 = firstHalfDoubleChance1_2;
    }

    public double getFirstHalfDoubleChance0_2() {
        return firstHalfDoubleChance0_2;
    }

    public void setFirstHalfDoubleChance0_2(double firstHalfDoubleChance0_2) {
        this.firstHalfDoubleChance0_2 = firstHalfDoubleChance0_2;
    }

    public double getFirstHalfLowerUpper0_5Lower() {
        return firstHalfLowerUpper0_5Lower;
    }

    public void setFirstHalfLowerUpper0_5Lower(double firstHalfLowerUpper0_5Lower) {
        this.firstHalfLowerUpper0_5Lower = firstHalfLowerUpper0_5Lower;
    }

    public double getFirstHalfLowerUpper0_5Upper() {
        return firstHalfLowerUpper0_5Upper;
    }

    public void setFirstHalfLowerUpper0_5Upper(double firstHalfLowerUpper0_5Upper) {
        this.firstHalfLowerUpper0_5Upper = firstHalfLowerUpper0_5Upper;
    }

    public double getFirstHalfLowerUpper1_5Lower() {
        return firstHalfLowerUpper1_5Lower;
    }

    public void setFirstHalfLowerUpper1_5Lower(double firstHalfLowerUpper1_5Lower) {
        this.firstHalfLowerUpper1_5Lower = firstHalfLowerUpper1_5Lower;
    }

    public double getFirstHalfLowerUpper1_5Upper() {
        return firstHalfLowerUpper1_5Upper;
    }

    public void setFirstHalfLowerUpper1_5Upper(double firstHalfLowerUpper1_5Upper) {
        this.firstHalfLowerUpper1_5Upper = firstHalfLowerUpper1_5Upper;
    }

    public double getFirstHalfLowerUpper2_5Lower() {
        return firstHalfLowerUpper2_5Lower;
    }

    public void setFirstHalfLowerUpper2_5Lower(double firstHalfLowerUpper2_5Lower) {
        this.firstHalfLowerUpper2_5Lower = firstHalfLowerUpper2_5Lower;
    }

    public double getFirstHalfLowerUpper2_5Upper() {
        return firstHalfLowerUpper2_5Upper;
    }

    public void setFirstHalfLowerUpper2_5Upper(double firstHalfLowerUpper2_5Upper) {
        this.firstHalfLowerUpper2_5Upper = firstHalfLowerUpper2_5Upper;
    }

    public double getFirstHalfLowerUpper3_5Lower() {
        return firstHalfLowerUpper3_5Lower;
    }

    public void setFirstHalfLowerUpper3_5Lower(double firstHalfLowerUpper3_5Lower) {
        this.firstHalfLowerUpper3_5Lower = firstHalfLowerUpper3_5Lower;
    }

    public double getFirstHalfLowerUpper3_5Upper() {
        return firstHalfLowerUpper3_5Upper;
    }

    public void setFirstHalfLowerUpper3_5Upper(double firstHalfLowerUpper3_5Upper) {
        this.firstHalfLowerUpper3_5Upper = firstHalfLowerUpper3_5Upper;
    }

    public double getFirstHalfLowerUpper4_5Lower() {
        return firstHalfLowerUpper4_5Lower;
    }

    public void setFirstHalfLowerUpper4_5Lower(double firstHalfLowerUpper4_5Lower) {
        this.firstHalfLowerUpper4_5Lower = firstHalfLowerUpper4_5Lower;
    }

    public double getFirstHalfLowerUpper4_5Upper() {
        return firstHalfLowerUpper4_5Upper;
    }

    public void setFirstHalfLowerUpper4_5Upper(double firstHalfLowerUpper4_5Upper) {
        this.firstHalfLowerUpper4_5Upper = firstHalfLowerUpper4_5Upper;
    }

    public double getHomeLowerUpper0_5Lower() {
        return homeLowerUpper0_5Lower;
    }

    public void setHomeLowerUpper0_5Lower(double homeLowerUpper0_5Lower) {
        this.homeLowerUpper0_5Lower = homeLowerUpper0_5Lower;
    }

    public double getHomeLowerUpper0_5Upper() {
        return homeLowerUpper0_5Upper;
    }

    public void setHomeLowerUpper0_5Upper(double homeLowerUpper0_5Upper) {
        this.homeLowerUpper0_5Upper = homeLowerUpper0_5Upper;
    }

    public double getHomeLowerUpper1_5Lower() {
        return homeLowerUpper1_5Lower;
    }

    public void setHomeLowerUpper1_5Lower(double homeLowerUpper1_5Lower) {
        this.homeLowerUpper1_5Lower = homeLowerUpper1_5Lower;
    }

    public double getHomeLowerUpper1_5Upper() {
        return homeLowerUpper1_5Upper;
    }

    public void setHomeLowerUpper1_5Upper(double homeLowerUpper1_5Upper) {
        this.homeLowerUpper1_5Upper = homeLowerUpper1_5Upper;
    }

    public double getHomeLowerUpper2_5Lower() {
        return homeLowerUpper2_5Lower;
    }

    public void setHomeLowerUpper2_5Lower(double homeLowerUpper2_5Lower) {
        this.homeLowerUpper2_5Lower = homeLowerUpper2_5Lower;
    }

    public double getHomeLowerUpper2_5Upper() {
        return homeLowerUpper2_5Upper;
    }

    public void setHomeLowerUpper2_5Upper(double homeLowerUpper2_5Upper) {
        this.homeLowerUpper2_5Upper = homeLowerUpper2_5Upper;
    }

    public double getHomeLowerUpper3_5Lower() {
        return homeLowerUpper3_5Lower;
    }

    public void setHomeLowerUpper3_5Lower(double homeLowerUpper3_5Lower) {
        this.homeLowerUpper3_5Lower = homeLowerUpper3_5Lower;
    }

    public double getHomeLowerUpper3_5Upper() {
        return homeLowerUpper3_5Upper;
    }

    public void setHomeLowerUpper3_5Upper(double homeLowerUpper3_5Upper) {
        this.homeLowerUpper3_5Upper = homeLowerUpper3_5Upper;
    }

    public double getHomeLowerUpper4_5Lower() {
        return homeLowerUpper4_5Lower;
    }

    public void setHomeLowerUpper4_5Lower(double homeLowerUpper4_5Lower) {
        this.homeLowerUpper4_5Lower = homeLowerUpper4_5Lower;
    }

    public double getHomeLowerUpper4_5Upper() {
        return homeLowerUpper4_5Upper;
    }

    public void setHomeLowerUpper4_5Upper(double homeLowerUpper4_5Upper) {
        this.homeLowerUpper4_5Upper = homeLowerUpper4_5Upper;
    }
}
