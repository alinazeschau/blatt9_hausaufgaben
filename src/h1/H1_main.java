package h1;

public class H1_main {

    private static void printList(PrioListe pl) {
        for (int i = 0; i < pl.myList.size(); i++) {
            Patient p = pl.myList.get(i);
            System.out.print("[" + i + "] " + p.name + "(prio=" + p.prio + ")  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrioListe pl = new PrioListe();

        // Beispiel aus der Aufgabenbeschreibung (A:1, B:10, C:5, D:7) 
        Patient A = new Patient("A", 1);
        Patient B = new Patient("B", 10);
        Patient C = new Patient("C", 5);
        Patient D = new Patient("D", 7);

        pl.addPatient(A);
        pl.addPatient(B);
        pl.addPatient(C);
        pl.addPatient(D);

        System.out.println("PrioListe nach Einfügen:");
        printList(pl);

        System.out.println("Position von D: " + pl.getPosition(D));

        Patient next = pl.getNextPatient();
        System.out.println("getNextPatient(): " + next.name);

        System.out.println("PrioListe danach:");
        printList(pl);
    }
}
