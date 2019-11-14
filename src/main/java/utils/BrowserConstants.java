package utils;

public class BrowserConstants {
    protected static final int FIREFOX = 1;
    protected static final int CHROME = 2;
    protected static final int HTMLUNIT = 3;
    protected static final int HEADLESSCHROME = 4;
    protected static int convert(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            return FIREFOX;
        }
        if (browser.equalsIgnoreCase("chrome")) {
            return CHROME;
        }
        if (browser.equalsIgnoreCase("htmlunit")) {
            return HTMLUNIT;
        }
        if (browser.equalsIgnoreCase("headlessChrome")) {
            return HEADLESSCHROME;
        }
        return CHROME;
    }
}
