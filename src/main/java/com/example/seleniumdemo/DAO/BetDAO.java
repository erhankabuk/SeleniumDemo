package com.example.seleniumdemo.DAO;

import com.example.seleniumdemo.Model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BetDAO extends JpaRepository<Bet, Long> {
    Bet findByMatchNameAndMatchTime(String matchName, String matchTime);
}
