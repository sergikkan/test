import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestProject {

    @Test
    public void openSite(){
        open("https://google.com");
    }
}
