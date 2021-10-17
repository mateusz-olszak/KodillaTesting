package com.kodilla.patterns2.observer.homework;

public interface HomeworkObservable {
    void register(HomeworkObserver homeworkObserver);
    void notifyObservers();
    void unregister(HomeworkObserver homeworkObserver);
}
