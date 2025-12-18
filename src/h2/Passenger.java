package h2;

public class Passenger {
    public String name;
    public int planned;
    public int visited;
    public boolean ticket;

    // Konstruktor setzt Attribute; visited wird auf 0 gesetzt.
    // Annahme: jeder Passagier will mindestens eine Station fahren.
    public Passenger(String name, int planned, boolean ticket) {
        this.name = name;
        this.planned = planned;
        this.ticket = ticket;
        this.visited = 0;
    }
}
