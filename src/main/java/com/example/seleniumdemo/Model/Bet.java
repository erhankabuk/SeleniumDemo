package com.example.seleniumdemo.Model;


import javax.persistence.*;

@Entity
@Table(name="BetList")
public class Bet {

    //Eklenecek veri yoksa Constructor getter setter ları yap
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

    @Column(name = "Match_Score_1")
    private double matchScore1;

    @Column(name = "Match_Score_0")
    private double matchScore0;

    @Column(name = "Match_Score_2")
    private double matchScore2;

    @Column(name = "First_Half_1")
    private double firstHalfScore1;

    @Column(name = "First_Half_0")
    private double firstHalfScore0;

    @Column(name = "First_Half_2")
    private double firstHalfScore2;

    @Column(name = "Handicaped_Match_Score_H")
    private String handicapedMatchScoreH;

    @Column(name = "Handicaped_Match_Score_1")
    private double handicapedMatchScore1;

    @Column(name = "Handicaped_Match_Score_0")
    private double handicapedMatchScore0;

    @Column(name = "Handicaped_Match_Score_2")
    private double handicapedMatchScore2;

    @Column(name = "TwoAndHalf_Goal_Lower")
    private double twoAndHalfGoalLower;

    @Column(name = "TwoAndHalf_Goal_Upper")
    private double twoAndHalfGoalUpper;

    @Column(name = "Opposite_Goals_NO")
    private double oppositeGoalsNo;

    @Column(name = "Opposite_Goals_YES")
    private double oppositeGoalsYes;

    public Bet() {
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

    public double getTwoAndHalfGoalLower() {
        return twoAndHalfGoalLower;
    }

    public void setTwoAndHalfGoalLower(double twoAndHalfGoalLower) {
        this.twoAndHalfGoalLower = twoAndHalfGoalLower;
    }

    public double getTwoAndHalfGoalUpper() {
        return twoAndHalfGoalUpper;
    }

    public void setTwoAndHalfGoalUpper(double twoAndHalfGoalUpper) {
        this.twoAndHalfGoalUpper = twoAndHalfGoalUpper;
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
}
