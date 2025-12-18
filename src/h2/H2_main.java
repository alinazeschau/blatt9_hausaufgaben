package h2;

import java.util.ArrayList;

public class H2_main {

    private static void printBus(String label, Bus b) {
        System.out.println(label + " (n=" + b.passengers.size() + "):");
        for (int i = 0; i < b.passengers.size(); i++) {
            Passenger p = b.passengers.get(i);
            System.out.println("  [" + i + "] " + p.name
                    + " planned=" + p.planned
                    + " visited=" + p.visited
                    + " ticket=" + p.ticket);
        }
    }

    public static void main(String[] args) {
        Bus A = new Bus();
        Bus B = new Bus();

        // Beispielzustand (analog zum in der Aufgabe skizzierten Transfer-Beispiel)
        A.enterBus(new Passenger("Anna", 2, true));
        A.enterBus(new Passenger("Ben",  2, true));
        A.enterBus(new Passenger("Clara",2, true));

        printBus("Start Bus A", A);
        printBus("Start Bus B", B);

        // Transfer: Anna und Clara von A nach B 
        A.transferPassengers(B, new String[] {"Anna", "Clara"});

        printBus("Nach transferPassengers -> Bus A", A);
        printBus("Nach transferPassengers -> Bus B", B);

        // Nächste Haltestelle ohne Zustieg  
        B.nextStop();
        printBus("Bus B nach nextStop()", B);

        // Ticketkontrolle-Demo: eine Person ohne Ticket steigt ein, wird dann gefunden/entfernt  
        Passenger[] boarding = new Passenger[] {
                new Passenger("Dora", 1, false),
                new Passenger("Erik", 1, true)
        };
        B.nextStop(boarding);
        printBus("Bus B nach nextStop(boarding)", B);

        ArrayList<Passenger> removed = B.findPassengersWithoutTickets();
        System.out.println("Entfernt (ohne Ticket): " + removed.size());
        printBus("Bus B nach findPassengersWithoutTickets()", B);
    }
}

