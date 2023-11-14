import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class UltimateQA {
    static String browser = "Chrome"; // Change this to "chrome" or "edge" as needed
    static WebDriver driver;
    static String baseUrl = "https://courses.ultimateqa.com/";

    public static void main(String[] args) {
        // 1. Setup Chrome browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name ");
        }


        // 2. Open URL.
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. Print the title of the page.
        System.out.println("Page Title: " + driver.getTitle());

        // 4. Print the current URL.
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // 5. Print the page source.
        System.out.println("Page Source: " + driver.getPageSource());

        // 6. Click on ‘Sign In’ link.
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        // 7. Print the current URL.
        System.out.println("Current URL after clicking on 'Sign In' link: " + driver.getCurrentUrl());

        // 8. Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("prime123@gmail.com");

        // 9. Enter the password to the password field.
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("Prime123");
        try {

            // 10. Click on Login Button.
            WebElement loginButton = driver.findElement(By.xpath("onSubmit"));
            loginButton.click();
        }catch (Exception e){
            System.out.println("capcha ");


            // 11. Navigate to baseUrl.
            driver.get(baseUrl);

            // 12. Navigate forward to Homepage.
            driver.navigate().forward();

            // 13. Navigate back to baseUrl.
            driver.navigate().back();

            // 14. Refresh the page.
            driver.navigate().refresh();

        } finally {
            // 15. Close the browser.
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
