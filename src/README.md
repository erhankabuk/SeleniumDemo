### Codes
* Refresh the current page
```
driver.navigate().refresh();
```
* xPath
* Interactions
* 
```

public class HelloSelenium {
public static void main(String[] args) {
WebDriver driver = new FirefoxDriver();
try {
// Navigate to Url
driver.get("https://google.com");

      // Enter text "q" and perform keyboard action "Enter"
      driver.findElement(By.name("q")).sendKeys("q" + Keys.ENTER);
    } finally {
      driver.quit();
    }
}
}
  ```

*