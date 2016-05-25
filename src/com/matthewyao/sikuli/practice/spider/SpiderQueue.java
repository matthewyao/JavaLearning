package com.matthewyao.sikuli.practice.spider;

/**
 * Created by matthewyao on 2016/1/22.
 */
import java.util.HashSet;
import java.util.Set;
/**
 * �Զ����� ����Visited���unVisited��
 */
public class SpiderQueue {
    /**
     * �ѷ��ʵ�url���ϣ���Visited��
     */
    private static Set<Object> visitedUrl = new HashSet<Object>();
    /**
     * ��ӵ����ʹ��� URL ������
     */
    public static void addVisitedUrl(String url) {
        visitedUrl.add(url);
    }
    /**
     * �Ƴ����ʹ��� URL
     */
    public static void removeVisitedUrl(String url) {
        visitedUrl.remove(url);
    }
    /**
     * ����Ѿ����ʵ� URL ��Ŀ
     */
    public static int getVisitedUrlNum() {
        return visitedUrl.size();
    }
    /**
     * �����ʵ�url���ϣ���unVisited��
     */
    private static Queue unVisitedUrl = new Queue();
    /**
     * ���UnVisited����
     */
    public static Queue getUnVisitedUrl() {
        return unVisitedUrl;
    }
    /**
     * δ���ʵ�unVisitedUrl������
     */
    public static Object unVisitedUrlDeQueue() {
        return unVisitedUrl.deQueue();
    }
    /**
     * ��֤���url��unVisitedUrl��ʱ��ÿ�� URLֻ������һ��
     */
    public static void addUnvisitedUrl(String url) {
        if (url != null && !url.trim().equals("") && !visitedUrl.contains(url)
                && !unVisitedUrl.contians(url))
            unVisitedUrl.enQueue(url);
    }
    /**
     * �ж�δ���ʵ� URL�������Ƿ�Ϊ��
     */
    public static boolean unVisitedUrlsEmpty() {
        return unVisitedUrl.empty();
    }
}
