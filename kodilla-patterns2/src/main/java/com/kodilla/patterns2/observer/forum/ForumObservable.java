package com.kodilla.patterns2.observer.forum;

public interface ForumObservable {
    void registryObserver(ForumObserver forumObserver);
    void notifyObservers();
    void removeObserver(ForumObserver forumObserver);
}
