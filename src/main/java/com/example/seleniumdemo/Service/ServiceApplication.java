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
                Bet matchData = new Bet();

                String path = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[(%s)]/*", i);
                List<WebElement> list = driver.findElements(By.xpath(path));

                var detailsCount = Integer.parseInt(list.get(19).getText());
                String detailsPath = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[(%s)]/button[15]", i);
                driver.findElement(By.xpath(detailsPath)).click();
                for (int j = 1; j < detailsCount; j++) {
                    String betNamePath = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/div[2]/div/div[%s]/div[1]/p", j);
                    var betName = driver.findElements(By.xpath(betNamePath)).get(0).getText();
                    if (betName.equalsIgnoreCase("Altı/Üstü 0,5")) {

                        /*
                        var lower = getDoubleDataFromClickedPage(driver, j, 1);
                        matchData.setLowerUpper0_5Lower(lower);

                        var upper = getDoubleDataFromClickedPage(driver, j, 2);
                        matchData.setLowerUpper0_5Upper(upper);
                        String lowerValue = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/div[2]/div/div[%s]/div[2]/button[1]/div[2]/div", j);
                        var lower = driver.findElements(By.xpath(lowerValue)).get(0).getText();
                        matchData.setLowerUpper0_5Lower(lower.equalsIgnoreCase("-") ? 0 : Double.valueOf(lower));
                        String upperValue = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/div[2]/div/div[%s]/div[2]/button[2]/div[2]/div", j);
                        var upper = driver.findElements(By.xpath(upperValue)).get(0).getText();
                        matchData.setLowerUpper0_5Upper(upper.equalsIgnoreCase("-") ? 0 : Double.valueOf(upper));
*/
                        //Lower 0,5
                        matchData.setLowerUpper0_5Lower(getDoubleDataFromClickedPage(driver, j, 1));
                        //Upper 0,5
                        matchData.setLowerUpper0_5Upper(getDoubleDataFromClickedPage(driver, j, 2));

                    } else if (betName.equalsIgnoreCase("Altı/Üstü 1,5")) {

                        //Lower 1,5
                        matchData.setLowerUpper1_5Lower(getDoubleDataFromClickedPage(driver, j, 1));
                        //Upper 1,5
                        matchData.setLowerUpper1_5Upper(getDoubleDataFromClickedPage(driver, j, 2));
                    } else if (betName.equalsIgnoreCase("Altı/Üstü 3,5")) {
                        //Lower 3,5
                        matchData.setLowerUpper3_5Lower(getDoubleDataFromClickedPage(driver, j, 1));
                        //Upper 4,5
                        matchData.setLowerUpper4_5Upper(getDoubleDataFromClickedPage(driver, j, 2));
                    } else if (betName.equalsIgnoreCase("Altı/Üstü 4,5")) {
                        //Lower 4,5
                        matchData.setLowerUpper4_5Lower(getDoubleDataFromClickedPage(driver, j, 1));
                        //Upper 4,5
                        matchData.setLowerUpper4_5Upper(getDoubleDataFromClickedPage(driver, j, 2));
                    } else if (betName.equalsIgnoreCase("İlk Yarı Altı/Üstü 0,5")) {
                        //todo sorguları ikili üçlü olarak doldur doğru kaydediyor mu kontrol et SaveData metodunu düzenle
                    } else if (betName.equalsIgnoreCase("İlk Yarı Altı/Üstü 1,5")) {

                    } else if (betName.equalsIgnoreCase("İlk Yarı Altı/Üstü 2,5")) {

                    } else if (betName.equalsIgnoreCase("İlk Yarı Altı/Üstü 3,5")) {

                    } else if (betName.equalsIgnoreCase("İlk Yarı Altı/Üstü 4,5")) {

                    } else if (betName.equalsIgnoreCase("Ev Sahibi Altı/Üstü 0,5")) {

                    } else if (betName.equalsIgnoreCase("Ev Sahibi Altı/Üstü 1,5")) {

                    } else if (betName.equalsIgnoreCase("Ev Sahibi Altı/Üstü 2,5")) {

                    } else if (betName.equalsIgnoreCase("Ev Sahibi Altı/Üstü 3,5")) {

                    } else if (betName.equalsIgnoreCase("Ev Sahibi Altı/Üstü 4,5")) {

                    } else if (betName.equalsIgnoreCase("Çifte Şans")) {

                    } else if (betName.equalsIgnoreCase("İlk Yarı Çifte Şans")) {

                    } else {
                        System.out.println("Veri yok");
                    }


                }
                //Döngüde her satırın ismine bak
                //Eğer satır ismi propertylerin birine eşitse o propertyi bu satırın değerine set et
                //else de tüm set değerlerini 0 yap


                // button 1 2 alt üst değerini veriyor
                // driver.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/div[2]/div/div[1]/div[2]/button[2]/div[2]/div")).get(0).getText()
                //driver.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/div[2]/div/div[burası sağ tarafın sırası 1den başlıyor]/div[2]/button[1]/div[2]/div")).get(0).getText()

                //Burası da sol taraftaki ismi veriyor
                //driver.findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/div[2]/div/div[burası da birinci kısımdaki isimleri veriyot]/div[1]/p")).get(0).getText()


                repo.addMatchDataToDatabase(saveDataToDatabase(list, matchData));
                /*
                for (int j = 0; j < list.size(); j++) {
                    System.out.println("*");
                    System.out.print(list.get(j).getText());
                }
                */
            }

        }
        /*
        catch (Exception e) {
            throw new BusinessIntegrityException(e.getMessage());
        } */ finally {

            driver.quit();

        }


    }

    //Get double value for each property at clicked page
    private double getDoubleDataFromClickedPage(WebDriver driver, int j, int index) {
        String xpath = String.format("//*[@id=\"__next\"]/div[2]/div/div/div[2]/div[5]/div[2]/div/div[%s]/div[2]/button[%s]/div[2]/div", j, index);
        String val = driver.findElements(By.xpath(xpath)).get(0).getText();
        return val.equalsIgnoreCase("-") ? 0 : Double.valueOf(val);

    }

    private Bet saveDataToDatabase(List<WebElement> list, Bet matchData) {
        //  Bet matchData = new Bet();

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


        return matchData;
    }

    private void getDetailData(WebElement webElement) {
        //Tıklayınca açılan sayfaya bak
        // herbir divdeki isimleri kontrol et
        //İsimlerin eşleştiği verileri doldur yoksa 0 yaz


    }
}
