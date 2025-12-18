package h2;

import java.util.ArrayList;
import java.util.HashSet;

public class Bus {

    // Passenger-ArrayList passengers; enthält die Passagiere, die sich gerade im Bus befinden.  
    public ArrayList<Passenger> passengers;

    // öffentlicher Konstruktor ohne Parameter: initialisiert passengers als leere ArrayList  
    public Bus() {
        passengers = new ArrayList<>();
    }

    // Fügt p ans Ende von passengers hinzu. 
    public void enterBus(Passenger p) {
        passengers.add(p);
    }

    // Prüft für alle Passagiere, ob planned == visited; dann aus passengers löschen. 
    private void exitBus() {
        for (int i = passengers.size() - 1; i >= 0; i--) {
            Passenger p = passengers.get(i);
            if (p.planned == p.visited) {
                passengers.remove(i);
            }
        }
    }

    // Simuliert nächste Haltestelle:
    // visited anpassen; dann exitBus(); dann boarding in Reihenfolge ans Ende.
    public void nextStop(Passenger[] boarding) {
        for (Passenger p : passengers) {
            p.visited++;
        }

        exitBus();

        for (int i = 0; i < boarding.length; i++) {
            passengers.add(boarding[i]);
        }
    }

    // Überladung: keine neuen Passagiere; ansonsten analog.  
    public void nextStop() {
        nextStop(new Passenger[0]);
    }

    // Entfernt alle Passagiere ohne Ticket und gibt sie als ArrayList in Originalreihenfolge zurück.  
    public ArrayList<Passenger> findPassengersWithoutTickets() {
        ArrayList<Passenger> removed = new ArrayList<>();

        for (int i = 0; i < passengers.size(); ) {
            Passenger p = passengers.get(i);
            if (!p.ticket) {
                removed.add(p);
                passengers.remove(i);
            } else {
                i++;
            }
        }

        return removed;
    }

    // Entfernt Passagiere, deren Namen in passengerNames enthalten sind, und fügt sie in otherBus ein
    // in der Reihenfolge, in der sie im ersten Bus standen. Kein Name kommt doppelt vor.  
    public void transferPassengers(Bus otherBus, String[] passengerNames) {
        HashSet<String> wanted = new HashSet<>();
        for (int i = 0; i < passengerNames.length; i++) {
            wanted.add(passengerNames[i]);
        }

        ArrayList<Passenger> moved = new ArrayList<>();

        for (int i = 0; i < passengers.size(); ) {
            Passenger p = passengers.get(i);
            if (wanted.contains(p.name)) {
                moved.add(p);
                passengers.remove(i);
            } else {
                i++;
            }
        }

        for (int i = 0; i < moved.size(); i++) {
            otherBus.enterBus(moved.get(i));
        }
    }
}
