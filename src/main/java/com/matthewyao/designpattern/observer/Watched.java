package com.matthewyao.designpattern.observer;

/**
 * Created by yaokuan on 2018/6/9.
 */
public interface Watched {
    void addWatcher(Watcher watcher);

    void removeWatcher(Watcher watcher);

    void notifyWatchers();
}
