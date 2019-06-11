import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class dataMethods {

    public static void getSlidePics() throws IOException {

        Document doc = Jsoup.connect("http://www.pacadengg.org/index.html").get();
        // Best code for this case
        Elements ec = doc.select("ul.bjqs li"); /* This line stores all elements in ul.bjqs into ec
            Need to add li at the end so that it is point to li child. */


        for (Element e : ec) { // This line traverses the each element e in collection ec
            System.out.println(e.select("img").attr("abs:src"));/*This filter the img tag in each li tag.
             It then further get the src attribute from each img and converts it into absolute path */

        }
    }

public static void getAnnouncementNews() throws IOException {
    Document doc = Jsoup.connect("http://www.pacadengg.org/index.html").get();
    System.out.println("Announcement and news"); // Added to provide a combined heading as i cant at the moment separate
    Elements ec = doc.select("div.col-2 p");
    for(Element e : ec) {

        String oneannounnews = e.select("p").text();// Stores each news piece and date piece

        System.out.println(oneannounnews);




    }


}

}