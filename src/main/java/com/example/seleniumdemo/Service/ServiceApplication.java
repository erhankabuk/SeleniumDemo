package com.example.seleniumdemo.Service;

import com.example.seleniumdemo.Model.Bet;
import com.example.seleniumdemo.Repo.BetRepository;
import com.example.seleniumdemo.Utility.BusinessIntegrityException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;

@Service
public class ServiceApplication {
    @Autowired
    BetRepository repo;

    public void getDataFromBrowser() throws BusinessIntegrityException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(options);
        Bet matchData = new Bet();
        try {
            // Navigate to Url
            driver.get("https://www.iddaa.com/program/futbol?muk=1_1,2_88,2_100,2_101_2.5,2_89&m=false");
            //Get rid of the infobar "Chrome is being controlled by automated test software" through Selenium"

            //Find elements by xpath

            var matchNumber = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/span[2]")).getText();
            matchData.setMatchNumber(matchNumber);

            var matchTime = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/span[3]")).getText();
            matchData.setMatchTime(matchTime);

            var leagueName = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/span[4]")).getText();
            matchData.setLeagueName(leagueName);

            var matchName = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/a")).getText();
            matchData.setMatchName(matchName);

            double matchScore1 = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[1]")).getText());
            matchData.setMatchScore1(matchScore1);

            double matchScore0 = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[2]")).getText());
            matchData.setMatchScore0(matchScore0);

            double matchScore2 = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[3]")).getText());
            matchData.setMatchScore2(matchScore2);

            double firstHalfScore1 = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[4]")).getText());
            matchData.setFirstHalfScore1(firstHalfScore1);

            double firstHalfScore0 = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[5]")).getText());
            matchData.setFirstHalfScore0(firstHalfScore0);

            double firstHalfScore2 = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[6]")).getText());
            matchData.setFirstHalfScore2(firstHalfScore2);

            double handicapedMatchScoreH = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[7]")).getText());
            matchData.setHandicapedMatchScoreH(handicapedMatchScoreH);

            double handicapedMatchScore1 = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[8]")).getText());
            matchData.setHandicapedMatchScore1(handicapedMatchScore1);

            double handicapedMatchScore0 = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[9]")).getText());
            matchData.setHandicapedMatchScore0(handicapedMatchScore0);

            double handicapedMatchScore2 = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[10]")).getText());
            matchData.setHandicapedMatchScore2(handicapedMatchScore2);

            double twoAndHalfGoalLower = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[11]")).getText());
            matchData.setTwoAndHalfGoalLower(twoAndHalfGoalLower);

            double twoAndHalfGoalUpper = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[12]")).getText());
            matchData.setTwoAndHalfGoalUpper(twoAndHalfGoalUpper);

            double oppositeGoalsYes = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[13]")).getText());
            matchData.setOppositeGoalsYes(oppositeGoalsYes);

            double oppositeGoalsNo = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[4]/button[14]")).getText());
            matchData.setOppositeGoalsNo(oppositeGoalsNo);
//
//            var firstResult = driver.findElement(
//                    By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/button[1]")).getText();// =>1.18
//            var secondResult = driver.findElement(
//                    By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/button[1]")).getAccessibleName();// =>1.18
//            var thirdResult = driver.findElement(
//                    By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/button[1]")).getAriaRole();// =>button
//            var fourthResult = driver.findElement(
//                    By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/button[1]")).getTagName();// =>button
//            var fifthResult = driver.findElement(
//                    By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/button[1]")).getLocation();// =>(515, 331)
//
//            System.out.println("First : " + firstResult);
//            System.out.println("Second : " + secondResult);
//            System.out.println("Third : " + thirdResult);
//            System.out.println("Fourth : " + fourthResult);
//            System.out.println("Fifth : " + fifthResult);
            // Enter text "q" and perform keyboard action "Enter"
            //driver.findElement(By.name("q")).sendKeys("q" + Keys.ENTER);
        } finally {

            repo.addMatchDataToDatabase(matchData);
            driver.quit();

        }


    }
}
