package com.my.company.utility;

// Source - https://stackoverflow.com/a
// Posted by krishnakumarp
// Retrieved 2025-11-10, License - CC BY-SA 3.0

import java.net.URL;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Urlscrap {

    public static void main(String[] args) throws Exception
    {

        //WebClient webClient = new WebClient(Opera);
        WebClient webClient = new WebClient();
        HtmlPage currentPage = (HtmlPage) webClient.getPage(new URL("http://www.google.com"));
        //get list of all divs
        final List<?> images = currentPage.getByXPath("//img");
        for (Object imageObject : images) {
            HtmlImage image = (HtmlImage) imageObject;
            System.out.println(image.getSrcAttribute());
        }
        //webClient.closeAllWindows();
    }
}
