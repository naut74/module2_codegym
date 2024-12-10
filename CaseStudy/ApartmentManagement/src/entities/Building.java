package entities;

import utility.Observer;
import utility.Subject;

import java.util.ArrayList;
import java.util.List;

public class Building implements Subject {
    private String buildingName;
    private String address;
    private List<Observer> observers;

    public Building(String buildingName, String address) {
        this.buildingName = buildingName;
        this.address = address;
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void reportMaintenanceIssue(String issue) {
        System.out.println("Reporting maintenance issue: " + issue);
        notifyObservers("Maintenance issue reported: " + issue);
    }
}
