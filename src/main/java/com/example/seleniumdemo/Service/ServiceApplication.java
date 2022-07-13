package com.example.seleniumdemo.Service;

import com.example.seleniumdemo.Model.Bet;
import com.example.seleniumdemo.Repo.BetRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Thread.*;

@Service
public class ServiceApplication {
    @Autowired
    BetRepository repo;

    Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

    //Run this method
    public void getDataFromBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);

        var lastElement = checkDatabaseForUpdate();
        if (lastElement.getUpdateTime() == null || lastElement.getUpdateTime().isBefore(LocalDateTime.now())) {
            try {
                // Navigate to Url
                driver.get("https://www.iddaa.com/program/futbol?muk=1_1,2_88,2_100,2_101_2.5,2_89&m=false");
                sleep(5);

                // quantityOfMatche defines count of matches in main page
                //int quantityOfMatch =driver.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[51]")).size();
                int quantityOfMatch = 15;
                for (int i = 4; i < quantityOfMatch; i++) {
                    logger.info("i : " + i);
                    Bet matchData = new Bet();
                    String path = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[(%s)]/*", i);

                    //Get data on main page
                    List<WebElement> list = driver.findElements(By.xpath(path));
                    //while (list.isEmpty()) {
                    while (list.size()==0) {
                        sleep(100);
                        list = driver.findElements(By.xpath(path));
                    }

                    //Save data from main page
                    saveDataInMainPageToDatabase(list, matchData);

                    // Get data in clicked page
                    var currentMatchName = list.get(4).getText();
                    if (!currentMatchName.equalsIgnoreCase(lastElement.getMatchName())) {
                        var detailsCount = Integer.parseInt(list.get(19).getText());
                        String detailsPath = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[(%s)]/button[15]", i);
                        driver.findElement(By.xpath(detailsPath)).click();
                        // todo check page is loaded
                        // sleep(200);

                        if (i + 1 < quantityOfMatch && checkDataFromBrowserIsLoaded(driver, i, 0)) {
                            for (int j = 1; j <= detailsCount; j++) {
                                saveDataInClickedPage(matchData, driver, i, j);
                                logger.info("j : " + i);
                            }
                            repo.addMatchDataToDatabase(matchData);
                            //String closeClickedPage = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[%s]/div/div/a", i);
                            //driver.findElement(By.xpath(closeClickedPage)).click();
                        } else {
                            String closeClickedPage = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[%s]/div/div/a", i);
                            driver.findElement(By.xpath(closeClickedPage)).click();
                            sleep(100);
                        }
                    } else {
                        logger.trace("DataBase updated.");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    // Check Browser Loaded
    private boolean checkDataFromBrowserIsLoaded(WebDriver driver, int i, int limit) {
        try {
            String checkDataFromBrowserPath = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[%s]/div[2]/div/div/p", i + 1);
            var checkDataFromBrowser = driver.findElements(By.xpath(checkDataFromBrowserPath));
            //*[@id="__next"]/div[2]/div/div/div[2]/div[6]/div[2]/div/div/p
            //*[@id="__next"]/div[2]/div/div/div[2]/div[5]/div[2]/div/div[1]/div[2]
            // if (!Objects.equals(checkDataFromBrowser.get(0).getText(), "Oranlar güncellenmektedir")) {
            if (checkDataFromBrowser.size() < 1) {
                return true;
            } else if (limit < 6) {
                Thread.sleep(100);
                limit++;
                checkDataFromBrowserIsLoaded(driver, i, limit);
            }
            return false;
        } catch (InterruptedException e) {
            return false;
        }
    }

    //Check Update time for last element
    public Bet checkDatabaseForUpdate() {
        List<Bet> database = repo.getDataFromDatabase();
        if (database.size() < 1) return new Bet();
        return database.get(database.size() - 1);
    }

    //Get double value for each property at clicked page
    private double getDoubleDataFromClickedPage(WebDriver driver, int i, int j, int index) throws InterruptedException {
        String xpath = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[%s]/div[2]/div/div[%s]/div[2]/button[%s]/div[2]/div", i + 1, j, index);
        String val = driver.findElements(By.xpath(xpath)).get(0).getText();
        sleep(100);
        return val.equalsIgnoreCase("-") ? 0 : Double.parseDouble(val);
    }

    //Get All Data and save in database from main page
    private void saveDataInMainPageToDatabase(List<WebElement> list, Bet matchData) throws InterruptedException {

        matchData.setMatchNumber(list.get(1).getText());
        matchData.setMatchTime(list.get(2).getText());
        matchData.setLeagueName(list.get(3).getText());
        matchData.setMatchName(list.get(4).getText());

        matchData.setMatchScore1(list.get(5).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(5).getText()));
        matchData.setMatchScore0(list.get(6).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(6).getText()));
        matchData.setMatchScore2(list.get(7).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(7).getText()));

        matchData.setFirstHalfScore1(list.get(8).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(8).getText()));
        matchData.setFirstHalfScore0(list.get(9).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(9).getText()));
        matchData.setFirstHalfScore2(list.get(10).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(10).getText()));

        matchData.setHandicapedMatchScoreH(list.get(11).getText());
        matchData.setHandicapedMatchScore1(list.get(12).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(12).getText()));
        matchData.setHandicapedMatchScore0(list.get(13).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(13).getText()));
        matchData.setHandicapedMatchScore2(list.get(14).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(14).getText()));

        matchData.setLowerUpper2_5Lower(list.get(15).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(15).getText()));
        matchData.setLowerUpper2_5Upper(list.get(16).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(16).getText()));

        matchData.setOppositeGoalsYes(list.get(17).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(17).getText()));
        matchData.setOppositeGoalsNo(list.get(18).getText().equalsIgnoreCase("-") ? 0 : Double.valueOf(list.get(18).getText()));

        matchData.setUpdateTime(LocalDateTime.now());

    }

    //Get All Data and save in database from main page
    private void saveDataInClickedPage(Bet matchData, WebDriver driver, int i, int j) throws InterruptedException {

        String betNamePath = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[%s]/div[2]/div/div[%s]/div[1]/p", i + 1, j);
        List<WebElement> bet = driver.findElements(By.xpath(betNamePath));
        while (bet.isEmpty()) {
            sleep(1000);
            bet = driver.findElements(By.xpath(betNamePath));
        }
        var betName = bet.get(0).getText();

        if (betName.equalsIgnoreCase("Altı/Üstü 0,5")) {
            //Lower 0,5
            matchData.setLowerUpper0_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            //Upper 0,5
            matchData.setLowerUpper0_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            // sleep(1000);
        } else if (betName.equalsIgnoreCase("Altı/Üstü 1,5")) {
            //Lower 1,5
            matchData.setLowerUpper1_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            //Upper 1,5
            matchData.setLowerUpper1_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("Altı/Üstü 3,5")) {
            //Lower 3,5
            matchData.setLowerUpper3_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            //Upper 4,5
            matchData.setLowerUpper4_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("Altı/Üstü 4,5")) {
            //Lower 4,5
            matchData.setLowerUpper4_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            //Upper 4,5
            matchData.setLowerUpper4_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("İlk Yarı Altı/Üstü 0,5")) {
            // First Half Lower 0,5
            matchData.setFirstHalfLowerUpper0_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            // First Half Upper 0,5
            matchData.setFirstHalfLowerUpper0_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("İlk Yarı Altı/Üstü 1,5")) {
            // First Half Lower 1,5
            matchData.setFirstHalfLowerUpper1_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            // First Half Upper 1,5
            matchData.setFirstHalfLowerUpper1_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("İlk Yarı Altı/Üstü 2,5")) {
            // First Half Lower 2,5
            matchData.setFirstHalfLowerUpper2_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            // First Half Upper 2,5
            matchData.setFirstHalfLowerUpper2_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("İlk Yarı Altı/Üstü 3,5")) {
            // First Half Lower 3,5
            matchData.setFirstHalfLowerUpper3_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            // First Half Upper 3,5
            matchData.setFirstHalfLowerUpper3_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("İlk Yarı Altı/Üstü 4,5")) {
            // First Half Lower 4,5
            matchData.setFirstHalfLowerUpper4_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            // First Half Upper 4,5
            matchData.setFirstHalfLowerUpper4_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("Ev Sahibi Altı/Üstü 0,5")) {
            // Home Lower 0,5
            matchData.setHomeLowerUpper0_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            // Home Upper 0,5
            matchData.setHomeLowerUpper0_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("Ev Sahibi Altı/Üstü 1,5")) {
            // Home Lower 1,5
            matchData.setHomeLowerUpper1_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            // Home Upper 1,5
            matchData.setHomeLowerUpper1_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("Ev Sahibi Altı/Üstü 2,5")) {
            // Home Lower 2,5
            matchData.setHomeLowerUpper2_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            // Home Upper 2,5
            matchData.setHomeLowerUpper2_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("Ev Sahibi Altı/Üstü 3,5")) {
            // Home Lower 3,5
            matchData.setHomeLowerUpper3_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            // Home Upper 3,5
            matchData.setHomeLowerUpper3_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("Ev Sahibi Altı/Üstü 4,5")) {
            // Home Lower 4,5
            matchData.setHomeLowerUpper4_5Lower(getDoubleDataFromClickedPage(driver, i, j, 1));
            // Home Upper 4,5
            matchData.setHomeLowerUpper4_5Upper(getDoubleDataFromClickedPage(driver, i, j, 2));
            //sleep(1000);
        } else if (betName.equalsIgnoreCase("Çifte Şans")) {
            // Double Chance 1_0
            matchData.setDoubleChange1_0(getDoubleDataFromClickedPage(driver, i, j, 1));
            // Double Chance 1_2
            matchData.setDoubleChange1_2(getDoubleDataFromClickedPage(driver, i, j, 2));
            // Double Chance 0_2
            matchData.setDoubleChange0_2(getDoubleDataFromClickedPage(driver, i, j, 3));
            //sleep(2000);
        } else if (betName.equalsIgnoreCase("İlk Yarı Çifte Şans")) {
            // First Half Double Chance 1_0
            matchData.setFirstHalfDoubleChance1_0(getDoubleDataFromClickedPage(driver, i, j, 1));
            // First Half Double Chance 1_2
            matchData.setFirstHalfDoubleChance1_2(getDoubleDataFromClickedPage(driver, i, j, 2));
            // First Half Double Chance 0_2
            matchData.setFirstHalfDoubleChance0_2(getDoubleDataFromClickedPage(driver, i, j, 3));
            //sleep(2000);
        }

    }

}
