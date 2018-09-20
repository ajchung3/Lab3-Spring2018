import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class WebScraper {
    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        String[] wordCount;
        int princeCount = 0;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        wordCount = contents.split(" ");
        for (int i = 0; i < wordCount.length; i++) {
            if (wordCount[i].toLowerCase().contains("prince")) {
                princeCount++;
            }
        }
        urlScanner.close();
        return contents + "Word Count: " + wordCount.length + "     Prince Count: " + princeCount;
    }
}
