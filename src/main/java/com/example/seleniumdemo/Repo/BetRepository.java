package com.example.seleniumdemo.Repo;

import com.example.seleniumdemo.DAO.BetDAO;
import com.example.seleniumdemo.Model.Bet;
import com.example.seleniumdemo.Utility.BusinessIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BetRepository {
    @Autowired
    BetDAO betDAO;

    public void addMatchDataToDatabase(Bet matchData) throws BusinessIntegrityException {
        Bet newMatch = new Bet();
        newMatch.setMatchNumber(matchData.getMatchNumber());
        newMatch.setMatchTime(matchData.getMatchTime());
        newMatch.setLeagueName(matchData.getLeagueName());
        newMatch.setMatchName(matchData.getMatchName());
        //Match Score
        newMatch.setMatchScore1(matchData.getMatchScore1());
        newMatch.setMatchScore0(matchData.getMatchScore0());
        newMatch.setMatchScore2(matchData.getMatchScore2());
        //First Half Score
        newMatch.setFirstHalfScore1(matchData.getFirstHalfScore1());
        newMatch.setFirstHalfScore0(matchData.getFirstHalfScore0());
        newMatch.setFirstHalfScore2(matchData.getFirstHalfScore2());
        //Handicaped Matches
        newMatch.setHandicapedMatchScoreH(matchData.getHandicapedMatchScoreH());
        newMatch.setHandicapedMatchScore1(matchData.getHandicapedMatchScore1());
        newMatch.setHandicapedMatchScore0(matchData.getHandicapedMatchScore0());
        newMatch.setHandicapedMatchScore2(matchData.getHandicapedMatchScore2());
        //Opposite Goals
        newMatch.setOppositeGoalsYes(matchData.getOppositeGoalsYes());
        newMatch.setOppositeGoalsNo(matchData.getOppositeGoalsNo());
        //Lower/Upper
        newMatch.setLowerUpper0_5Lower(newMatch.getLowerUpper0_5Lower());
        newMatch.setLowerUpper0_5Upper(newMatch.getLowerUpper0_5Upper());
        newMatch.setLowerUpper1_5Lower(newMatch.getLowerUpper1_5Lower());
        newMatch.setLowerUpper1_5Upper(newMatch.getLowerUpper1_5Upper());
        newMatch.setLowerUpper2_5Lower(newMatch.getLowerUpper2_5Lower());
        newMatch.setLowerUpper2_5Upper(newMatch.getLowerUpper2_5Upper());
        newMatch.setLowerUpper3_5Lower(newMatch.getLowerUpper3_5Lower());
        newMatch.setLowerUpper3_5Upper(newMatch.getLowerUpper3_5Upper());
        newMatch.setLowerUpper4_5Lower(newMatch.getLowerUpper4_5Lower());
        newMatch.setLowerUpper4_5Upper(newMatch.getLowerUpper4_5Upper());
        //Double Chance
        newMatch.setDoubleChange0_2(matchData.getDoubleChange0_2());
        newMatch.setDoubleChange1_0(matchData.getDoubleChange1_0());
        newMatch.setDoubleChange1_2(matchData.getDoubleChange1_2());
        //First Half Double Chance
        newMatch.setFirstHalfDoubleChance0_2(newMatch.getFirstHalfDoubleChance0_2());
        newMatch.setFirstHalfDoubleChance1_0(newMatch.getFirstHalfDoubleChance1_0());
        newMatch.setFirstHalfDoubleChance1_2(newMatch.getFirstHalfDoubleChance1_2());
        //First Half Lower/Upper
        newMatch.setFirstHalfLowerUpper0_5Lower(newMatch.getFirstHalfLowerUpper0_5Lower());
        newMatch.setFirstHalfLowerUpper0_5Upper(newMatch.getFirstHalfLowerUpper0_5Upper());
        newMatch.setFirstHalfLowerUpper1_5Lower(newMatch.getFirstHalfLowerUpper1_5Lower());
        newMatch.setFirstHalfLowerUpper1_5Upper(newMatch.getFirstHalfLowerUpper1_5Upper());
        newMatch.setFirstHalfLowerUpper2_5Lower(newMatch.getFirstHalfLowerUpper2_5Lower());
        newMatch.setFirstHalfLowerUpper2_5Upper(newMatch.getFirstHalfLowerUpper2_5Upper());
        newMatch.setFirstHalfLowerUpper3_5Lower(newMatch.getFirstHalfLowerUpper3_5Lower());
        newMatch.setFirstHalfLowerUpper3_5Upper(newMatch.getFirstHalfLowerUpper3_5Upper());
        newMatch.setFirstHalfLowerUpper4_5Lower(newMatch.getFirstHalfLowerUpper4_5Lower());
        newMatch.setFirstHalfLowerUpper4_5Upper(newMatch.getFirstHalfLowerUpper4_5Upper());
        //Home Lower/Upper
        newMatch.setHomeLowerUpper0_5Lower(newMatch.getHomeLowerUpper0_5Lower());
        newMatch.setHomeLowerUpper0_5Upper(newMatch.getHomeLowerUpper0_5Upper());
        newMatch.setHomeLowerUpper1_5Lower(newMatch.getHomeLowerUpper1_5Lower());
        newMatch.setHomeLowerUpper1_5Upper(newMatch.getHomeLowerUpper1_5Upper());
        newMatch.setHomeLowerUpper2_5Lower(newMatch.getHomeLowerUpper2_5Lower());
        newMatch.setHomeLowerUpper2_5Upper(newMatch.getHomeLowerUpper2_5Upper());
        newMatch.setHomeLowerUpper3_5Lower(newMatch.getHomeLowerUpper3_5Lower());
        newMatch.setHomeLowerUpper3_5Upper(newMatch.getHomeLowerUpper3_5Upper());
        newMatch.setHomeLowerUpper4_5Lower(newMatch.getHomeLowerUpper4_5Lower());
        newMatch.setHomeLowerUpper4_5Upper(newMatch.getHomeLowerUpper4_5Upper());

        betDAO.save(newMatch);

    }
    public List<Bet> getDataFromDatabase(){

      return betDAO.findAll();

    }


}
