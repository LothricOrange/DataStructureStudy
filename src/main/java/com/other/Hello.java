package com.other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Hello {
    public static void main(String[] args) throws IOException {
        String url;
        for (int i = 0; i < 251; i += 25) {
            url = "https://movie.douban.com/top250?start=" + i;
            Document doc = Jsoup.connect(url).get();
            Elements movies = doc.select(".item");
            movies.forEach((movie) -> {
                String name = movie.selectFirst(".hd").selectFirst(".title").text();
                String rank = movie.selectFirst(".pic").selectFirst("em").text();
                String quote = "";
                Element info = movie.selectFirst(".info");
                Element quoteElement = info.selectFirst(".quote");
                if (quoteElement != null) {
                    quote = quoteElement.selectFirst("span").text();
                }
                String type = info.selectFirst(".bd").selectFirst("p").text();
                System.out.println(rank + "_" + name + "_" + quote + "_" + type);
            });
        }


    }
}
