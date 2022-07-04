package com.example.seleniumdemo.Service;

import com.example.seleniumdemo.Model.Bet;
import com.example.seleniumdemo.Repo.BetRepository;
import com.example.seleniumdemo.Utility.BusinessIntegrityException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        driver.manage().deleteAllCookies();
        try {
            // Navigate to Url
            driver.get("https://www.iddaa.com/program/futbol?muk=1_1,2_88,2_100,2_101_2.5,2_89&m=false");
            //todo use 44
            //for (int i = 4; i < 44; i++) {
                for (int i = 4; i < 5; i++) {

                String path= String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[(%s)]/*", i);
                List<WebElement> list = driver.findElements(By.xpath(path));
//todo continue with click
                repo.addMatchDataToDatabase(saveDataToDatabase(list));
/*
                for (int j = 0; j < list.size(); j++) {
                    System.out.println("*");
                    System.out.print(list.get(j).getText());
                }
  */
            }

        } finally {

            driver.quit();

        }


    }

    private Bet saveDataToDatabase(List<WebElement> list) {
        Bet matchData = new Bet();

        matchData.setMatchNumber(list.get(1).getText());
        matchData.setMatchTime(list.get(2).getText());
        matchData.setLeagueName(list.get(3).getText());
        matchData.setMatchName(list.get(4).getText());

        matchData.setMatchScore1(list.get(5).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(5).getText()));
        matchData.setMatchScore0(list.get(6).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(6).getText()));
        matchData.setMatchScore2(list.get(7).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(7).getText()));

        matchData.setFirstHalfScore1(list.get(8).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(8).getText()));
        matchData.setFirstHalfScore0(list.get(9).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(9).getText()));
        matchData.setFirstHalfScore2(list.get(10).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(10).getText()));
        matchData.setHandicapedMatchScoreH(list.get(11).getText());
        matchData.setHandicapedMatchScore1(list.get(12).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(12).getText()));
        matchData.setHandicapedMatchScore0(list.get(13).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(13).getText()));
        matchData.setHandicapedMatchScore2(list.get(14).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(14).getText()));
        matchData.setLowerUpper2_5Lower((list.get(15).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(15).getText()));
        matchData.setLowerUpper2_5Upper(list.get(16).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(16).getText()));
        matchData.setOppositeGoalsYes(list.get(17).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(17).getText()));
        matchData.setOppositeGoalsNo(list.get(18).getText().equalsIgnoreCase("-")?0: Double.valueOf(list.get(18).getText()));

        getDetailData(list.get(19));

        return matchData;
    }

    private void getDetailData(WebElement webElement) {
        //
    }
}
