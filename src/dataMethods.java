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
protected static String newsParagraph = "";
    public static void getAnnouncementNews() throws IOException {
        Document doc = Jsoup.connect("http://www.pacadengg.org/index.html").get();
        System.out.println("Announcement and news"); // Added to provide a combined heading as i cant at the moment separate
        Elements ec = doc.select("div.col-2 p");
        for (Element e : ec) {

            String oneannounnews = e.select("p").text();// Stores each news piece and date piece

            //System.out.println(oneannounnews);
            newsParagraph = newsParagraph + oneannounnews + "\n";


        }


    }


    public static void contactUS() throws IOException {
        Document doc = Jsoup.connect("http://www.pacadengg.org/contactus.html").get();
        Elements ec = doc.select("div.col-2.myfonts p"); // . added to make up for spaces
Element e2 = doc.select("img").get(1); /* important. I only needed one element so used Element not s.
      I selected the element with img tag. But there are muliple ElementS. So to keep it singular element(no s)
      I used the get(1) meaning get second img tag. This way I only get one element(no s) and which is the second one.
        I then used the abs url thing to convert to a proper link*/
        System.out.println(e2.absUrl("src"));
        for (Element e : ec) {
            System.out.println(e.select("p").text()); // does not get cv links


        }

    }

    protected static String fellowParagraph  = "";

    public static void getFellows() throws IOException {


        Document doc = Jsoup.connect("http://www.pacadengg.org/founder_fellows.html").get();
        Elements ec = doc.select("table.tablecss tr p");
        for (Element e : ec) {

             fellowParagraph = fellowParagraph + e.select("p").text() +"\n";// Stores each news piece and date piece




        }
    }

protected static String symposiumsParagraph = "";
public static void getSymposiums() throws IOException {

    Document doc = Jsoup.connect("http://www.pacadengg.org/events.html").get();
    Elements ec = doc.select("div.wrap tr p");

    for (Element e : ec) {
         symposiumsParagraph= symposiumsParagraph + e.select("p").text()+"\n"+"\n";
    }



}



}