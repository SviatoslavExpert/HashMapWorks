package com.granovskiy;

import java.util.List;

public class InnerEntryList {
    private Entry<Car, Driver> entry;
    private int innerEntryListSize;
    private List<Entry> entryContainer;

    public InnerEntryList(int innerEntryListSize) {
        this.innerEntryListSize = innerEntryListSize;
    }

    public Entry<Car, Driver> getEntry() {
        return entry;
    }

    public void setEntry(Entry<Car, Driver> entry) {
        this.entry = entry;
    }

    public int getInnerEntryListSize() {
        return innerEntryListSize;
    }

    public void setInnerEntryListSize(int innerEntryListSize) {
        this.innerEntryListSize = innerEntryListSize;
    }

    public List<Entry> getEntryContainer() {
        return entryContainer;
    }

    public void setEntryContainer(List<Entry> entryContainer) {
        this.entryContainer = entryContainer;
    }

    @Override
    public String toString() {
        return "InnerEntryList{" +
                "entryContainer=" + entryContainer +
                '}';
    }
}
