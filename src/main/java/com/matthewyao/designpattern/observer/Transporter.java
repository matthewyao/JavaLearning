package com.matthewyao.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaokuan on 2018/6/9.
 */
public class Transporter implements Watched {

    private List<Watcher> watchers = new ArrayList<Watcher>();

    @Override
    public void addWatcher(Watcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        watchers.remove(watcher);
    }

    @Override
    public void notifyWatchers() {
        System.out.println("运输车开动...");
        for (Watcher watcher : watchers) {
            watcher.update();
        }
    }
}
