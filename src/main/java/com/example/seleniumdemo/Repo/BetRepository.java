package com.example.seleniumdemo.Repo;

import com.example.seleniumdemo.DAO.BetDAO;
import com.example.seleniumdemo.Model.Bet;
import com.example.seleniumdemo.Utility.BusinessIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        newMatch.setMatchScore1(matchData.getMatchScore1());
        newMatch.setMatchScore0(matchData.getMatchScore0());
        newMatch.setMatchScore2(matchData.getMatchScore2());
        newMatch.setFirstHalfScore1(matchData.getFirstHalfScore1());
        newMatch.setFirstHalfScore0(matchData.getFirstHalfScore0());
        newMatch.setFirstHalfScore2(matchData.getFirstHalfScore2());
        newMatch.setHandicapedMatchScoreH(matchData.getHandicapedMatchScoreH());
        newMatch.setHandicapedMatchScore1(matchData.getHandicapedMatchScore1());
        newMatch.setHandicapedMatchScore0(matchData.getHandicapedMatchScore0());
        newMatch.setHandicapedMatchScore2(matchData.getHandicapedMatchScore2());
        newMatch.setTwoAndHalfGoalLower(matchData.getTwoAndHalfGoalLower());
        newMatch.setTwoAndHalfGoalUpper(matchData.getTwoAndHalfGoalUpper());
        newMatch.setOppositeGoalsYes(matchData.getOppositeGoalsYes());
        newMatch.setOppositeGoalsNo(matchData.getOppositeGoalsNo());
        betDAO.save(newMatch);


    }


}
