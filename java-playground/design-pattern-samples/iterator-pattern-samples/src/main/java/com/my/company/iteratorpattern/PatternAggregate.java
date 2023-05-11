package com.my.company.iteratorpattern;

public interface PatternAggregate {
    void addPattern(DesignPattern designPattern);

    void removePattern(DesignPattern designPattern);

    PatternIterator getPatternIterator();
}
