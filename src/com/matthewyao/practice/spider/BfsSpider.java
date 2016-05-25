package com.matthewyao.practice.spider;

/**
 * Created by matthewyao on 2016/1/22.
 */
import java.util.Set;

public class BfsSpider {
    /**
     * ʹ�����ӳ�ʼ��URL����
     */
    private void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++)
            SpiderQueue.addUnvisitedUrl(seeds[i]);
    }
    // �������������ȡ�� http://www.xxxx.com��ͷ������
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
        // ��ʼ�� URL ����
        initCrawlerWithSeeds(seeds);
        // ѭ����������ץȡ�����Ӳ�����ץȡ����ҳ������ 1000
        while (!SpiderQueue.unVisitedUrlsEmpty()
                && SpiderQueue.getVisitedUrlNum() <= 1000) {
            // ��ͷ URL ������
            String visitUrl = (String) SpiderQueue.unVisitedUrlDeQueue();
            if (visitUrl == null)
                continue;
            DownTool downLoader = new DownTool();
            // ������ҳ
            downLoader.downloadFile(visitUrl);
            // �� URL �����ѷ��ʵ� URL ��
            SpiderQueue.addVisitedUrl(visitUrl);
            // ��ȡ��������ҳ�е� URL
            Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter);
            // �µ�δ���ʵ� URL ���
            for (String link : links) {
                SpiderQueue.addUnvisitedUrl(link);
            }
        }
    }
    // main �������
    public static void main(String[] args) {
        BfsSpider crawler = new BfsSpider();
        crawler.crawling(new String[] { "http://www.ola.com.cn" });
        System.out.println("Finish!");
    }
}
