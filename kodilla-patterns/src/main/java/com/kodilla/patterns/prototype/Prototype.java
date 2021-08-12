package com.kodilla.patterns.prototype;

import java.lang.ref.Cleaner;

public class Prototype<T> implements Cloneable {
    @Override
    public T clone() throws CloneNotSupportedException {
       return (T)super.clone();
    }
}
