import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main
{
    public static void main(String[] args)
    {
        String link;
        String urlSite = "https://lenta.ru";
        try {
            Document doc = Jsoup.connect(urlSite).get();
            Elements pngs = doc.select("img[src$=.png]");
            Elements jpgs = doc.select("img[src$=.jpg]");
            Elements gifs = doc.select("img[src$=.gif]");


            for(int i = 0; i < pngs.size(); i++){
                link = pngs.get(i).attr("abs:src");
                ImageIO.write(ImageIO.read(new URL(link)), "png", new File("pages/png/" + i + ".png"));
            }

            for(int i = 0; i < jpgs.size(); i++){
                link = jpgs.get(i).attr("abs:src");
                ImageIO.write(ImageIO.read(new URL(link)), "jpg", new File("pages/jpg/" + i + ".jpg"));

            }
            for(int i = 0; i < gifs.size(); i++){
                link = gifs.get(i).attr("abs:src");
                ImageIO.write(ImageIO.read(new URL(link)), "gif", new File("pages/gif/" + i + ".gif"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Процесс завершен");
    }
}
