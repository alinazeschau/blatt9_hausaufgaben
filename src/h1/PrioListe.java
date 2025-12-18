package h1;

import java.util.ArrayList;

public class PrioListe {

    // ArrayList-Attribut myList, initial als leere ArrayList für Patient-Objekte
    public ArrayList<Patient> myList;

    public PrioListe() {
        myList = new ArrayList<>();
    }

    // Fügt p abhängig von prio ein: je kleiner prio, desto weiter vorne.
    // myList ist beim Einfügen bereits sortiert; Prioritäten sind paarweise verschieden.
    public void addPatient(Patient p) {
        if (myList.isEmpty()) {
            myList.add(p);
            return;
        }

        int i = 0;
        while (i < myList.size() && myList.get(i).prio < p.prio) {
            i++;
        }
        myList.add(i, p);
    }

    // Gibt das vorderste Patient-Objekt zurück und löscht es aus myList. 
    public Patient getNextPatient() {
        Patient first = myList.get(0);
        myList.remove(0);
        return first;
    }

    // Gibt den Zellenindex des übergebenen Objekts in myList zurück, sonst -1.  
    public int getPosition(Patient p) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) == p) { // „übergebenes Objekt“ → Identität
                return i;
            }
        }
        return -1;
    }
}

