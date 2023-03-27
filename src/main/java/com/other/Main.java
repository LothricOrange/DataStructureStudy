package com.other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception{
        Document doc = Jsoup.connect("https://ext.se.360.cn/webstore/category").get();
        Elements apps = doc.select(".appwrap");
        apps.forEach((app) -> {
            String img = app.selectFirst("img").attr("src");
            String name = app.selectFirst("h3").text();
            String intro = app.selectFirst(".intro").text();
            System.out.println(name + "_" + intro + "_" + img);

            try {
                HttpURLConnection conn = (HttpURLConnection)new URL(img).openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                try (
                    InputStream is = conn.getInputStream();
                    FileOutputStream fos = new FileOutputStream("O:\\Downloads\\Order\\img\\" + name + ".jpg")) {
                    byte[] bytes = new byte[8192];
                    int len;
                    while ((len = is.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}
