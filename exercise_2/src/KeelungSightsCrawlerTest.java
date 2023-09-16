import java.util.ArrayList;

public class KeelungSightsCrawlerTest {
    public static void main(String[] args) {

        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        ArrayList<Sight> sights = crawler.getItems("中正區");

        for (Sight sight : sights) {
            System.out.println(sight);
        }
    }
}
