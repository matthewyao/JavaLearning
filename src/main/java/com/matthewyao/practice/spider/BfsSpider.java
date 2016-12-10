package com.matthewyao.practice.spider;

/**
 * Created by matthewyao on 2016/1/22.
 */
import java.util.Set;

public class BfsSpider {
    /**
     * ???????????URL????
     */
    private void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++)
            SpiderQueue.addUnvisitedUrl(seeds[i]);
    }
    // ???????????????? http://www.xxxx.com?????????
    public void crawling(String[] seeds) {
        LinkFilter filter = new LinkFilter() {
            public boolean accept(String url) {
                return true;
//                if (url.startsWith("http://www.baidu.com"))
//                    return true;
//                else
//                    return false;
            }
        };
        // ????? URL ????
        initCrawlerWithSeeds(seeds);
        // ????????????????????????????????????? 1000
        while (!SpiderQueue.unVisitedUrlsEmpty()
                && SpiderQueue.getVisitedUrlNum() <= 1000) {
            // ??? URL ??????
            String visitUrl = (String) SpiderQueue.unVisitedUrlDeQueue();
            if (visitUrl == null)
                continue;
            DownTool downLoader = new DownTool();
            // ???????
            downLoader.downloadFile(visitUrl);
            // ?? URL ?????????? URL ??
            SpiderQueue.addVisitedUrl(visitUrl);
            // ??????????????? URL
            Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter);
            // ????????? URL ???
            for (String link : links) {
                SpiderQueue.addUnvisitedUrl(link);
            }
        }
    }
    // main ???????
    public static void main(String[] args) {
        BfsSpider crawler = new BfsSpider();
        crawler.crawling(new String[] { "http://www.ola.com.cn" });
        System.out.println("Finish!");
    }
}
