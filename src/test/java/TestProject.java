import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriverException;

import static com.codeborne.selenide.Selenide.open;

public class TestProject {

    private final static int MAX_RETRY_COUNT = 5;


    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled =true;
      //  Configuration.browserSize = "1920*1080";
        Configuration.headless = false;
    }

    @Before
    public void init(){
        setUp();
    }

    @Test
    public void openSite(){


        int retryCount = 0;
        while(true)
        {
            try
            {
                open("https://google.com");
                break;
            }
            catch(WebDriverException e)
            {
                if( retryCount > MAX_RETRY_COUNT )
                {
                    throw new RuntimeException("Too many retries...", e);
                }


                retryCount++;
                try
                {
                    Thread.sleep(2_000);
                }
                catch (InterruptedException interruptedException)
                {
                    interruptedException.printStackTrace();
                }
                continue;
            }
        }

    }
}
