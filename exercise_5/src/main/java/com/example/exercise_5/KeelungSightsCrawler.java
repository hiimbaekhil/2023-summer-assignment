package com.example.exercise_5;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;

import static java.lang.Math.min;
import static java.lang.Math.pow;

public class KeelungSightsCrawler {

    private final ArrayList<Sight> sights = new ArrayList<>();

    public KeelungSightsCrawler() {

        Document doc1 = parseDocument("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/");

        for (Element zone : doc1.select(".box_ss > a")) {

            Elements links = doc1.select("h4:contains(" + zone.text() + ") + ul a");

            for (Element link : links) {

                Document doc2 = parseDocument(link.attr("abs:href"));

                sights.add(new Sight(
                        link.attr("title"),
                        zone.text(),
                        doc2.select("[property='rdfs:label'] strong").text(),
                        doc2.select("[itemprop='image']").attr("content"),
                        doc2.select("[itemprop='description']").attr("content"),
                        doc2.select("[itemprop='address']").attr("content")
                ));
            }
        }
    }

    public ArrayList<Sight> getSights() {
        return sights;
    }

    private Document parseDocument(String url) {

        SecureRandom randomNumbers = new SecureRandom();

        // if an error occurs, wait and retry up to maximum number of retries (exponential backoff)
        for (int n = 0; n < 9; ++n) {
            try {
                return Jsoup.connect(url).get();

            } catch (IOException e) {

                System.err.printf("Exception: %s%n", e);
                System.out.println("An error occurs while fetching the URL. Retry again later.");

                try {
                    Thread.sleep((long) min(pow(2, n) * 1000 + randomNumbers.nextInt(1000), 64000));

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    Thread.currentThread().interrupt(); // re-interrupt the thread
                }
            }
        }

        System.out.println("Failed to return parsed Document.");
        System.exit(1);

        return null;
    }
}
