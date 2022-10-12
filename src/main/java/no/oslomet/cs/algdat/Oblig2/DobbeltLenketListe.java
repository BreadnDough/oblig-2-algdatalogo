package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.*;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    // velger aa ha med hjelpemetoder fra kompendiet
    private Node<T> finnNode(int indeks)
    {
        Node<T> p;

        if (indeks < antall / 2)
        {
            p = hode;  // leter fra hode mot høyre
            for (int i = 0; i < indeks; i++)
            {
                p = p.neste;
            }
        }
        else
        {
            p = hale;  // leter fra hale mot venstre
            for (int i = antall - 1; i > indeks; i--)
            {
                p = p.forrige;
            }
        }
        return p;
    }

    //hjelpemetode
    private static void fratilKontroll(int antall, int fra, int til)
    {
        // fra er negativ
        // byttet ut arrayOutOfBoundsException med IndexOutOfBoundsException
        if (fra < 0)
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        // til er utenfor tabellen
        // byttet ut arrayOutOfBoundsException med IndexOutOfBoundsException
        if (til > antall)
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > antall(" + antall + ")");

        // fra er større enn til
        if (fra > til)
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    //hjelpemetode
    private T fjernNode(Node<T> p)  // private hjelpemetode
    {
        if (p == hode)
        {
            if (antall == 1) hode = hale = null;      // kun en verdi i listen
            else (hode = hode.neste).forrige = null;  // fjerner den første
        }
        else if (p == hale) (hale = hale.forrige).neste = null;  // fjerner den siste
        else (p.forrige.neste = p.neste).forrige = p.forrige;    // fjerner p

        antall--;     // en mindre i listen
        endringer++;  // en endring

        return p.verdi;
    }

    public DobbeltLenketListe() {
        throw new UnsupportedOperationException();
    }

    public DobbeltLenketListe(T[] a) {

        // tar i bruk en konstruktør for dette
        this();

        Objects.requireNonNull(a, "a er null!");

        //midlertidig node for naa.

        hode = hale = new Node<>(null);

        for (T verdi : a)
        {
            if (verdi != null)
            {
                hale = hale.neste = new Node<>(verdi, hale, null);  // ny node bakerst
                antall++;
            }
        }

        // dette vil da kunne faa fjernet den midlertidige noda som jeg tok i bruk.

        if (antall == 0) hode = hale = null;
        else (hode = hode.neste).forrige = null;
    }

    public Liste<T> subliste(int fra, int til) {

        // dette er sjekk for intervallet
        fratilKontroll(antall, fra, til);

        // lager en ny liste
        DobbeltLenketListe<T> liste = new DobbeltLenketListe<>();

        // fant fram til  noden med en indeks som er lik fra i dette tilfeldet
        Node<T> p = finnNode(fra);

        // velge å hente de verdiene for mitt halvåpnede intervall [fra:til>
        for (int i = fra; i < til; i++)
        {
            //kaller på metoden leggInn
            liste.leggInn(p.verdi);
            p = p.neste;
        }

        return liste;

    }

    @Override
    public int antall() {
        //returner antallet verdier i lista
        return antall;
    }

    @Override
    public boolean tom() {
        // returnerer true eller false basert på om lista er tom eller ikke.
        return antall == 0;
    }

    @Override
    public boolean leggInn(T verdi) {

        // er det null-verdier?
        Objects.requireNonNull(verdi, "Null-verdier er ikke tillatt!");

        Node<T> p = new Node<>(verdi, hale, null);
        // velger en så kalt ternary if
        hale = tom() ? (hode = p) : (hale.neste = p);

        // øker antall
        antall++;

        // øker endringer
        endringer++;

        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {

        //tekst for null-verdier
        Objects.requireNonNull(verdi, "Null-verdier er ikke tillatt!");

        //kaller for metoden.
        indeksKontroll(indeks, true);

        // naar det er for tom liste
        if (tom())
        {
            hode = hale = new Node<>(verdi, null, null);
        }
        /// naar ny verdi legges forrest
        else if (indeks == 0)
        {
            hode = hode.forrige = new Node<>(verdi, null, hode);
        }
        // naar ny verdi legges bakerst
        else if (indeks == antall)
        {
            hale = hale.neste = new Node<>(verdi, hale, null);
        }
        else
        // her skal ny verdi paa sin  indeks
        {
            // naa skal ny verdi legges til venstre for p noda
            Node<T> p = finnNode(indeks);
            p.forrige = p.forrige.neste = new Node<>(verdi, p.forrige, p);
        }

        // plusser paa en til antall
        antall++;
        // plusser paa en til endringer
        endringer++;
    }

    @Override
    public boolean inneholder(T verdi) {
        // returnerer med kall
        // , vil gi true hvis lista har verdi, ellers false.
        return indeksTil(verdi) != -1;
    }

    @Override
    public T hent(int indeks) {

        // sjekk fra Liste.java
        indeksKontroll(indeks, false);
        // returnerer med kall etter metode
        return finnNode(indeks).verdi;

    }

    @Override
    public int indeksTil(T verdi) {

        if (verdi == null)
            return -1;

        Node<T> p = hode;

        for (int indeks = 0; indeks < antall; indeks++, p = p.neste)
        {
            if (p.verdi.equals(verdi))
                return indeks;
        }

        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {

        Objects.requireNonNull(nyverdi, "Null-verdier er ikke tillat!");
        indeksKontroll(indeks, false);

        Node<T> p = finnNode(indeks);
        T gammelverdi = p.verdi;
        p.verdi = nyverdi;

        endringer++;

        return gammelverdi;
    }

    @Override
    public boolean fjern(T verdi) {
        // nullverdier skal ikke forekomme i lista
        if (verdi == null) {
            return false;
        }

        for (Node<T> p = hode; p != null; p = p.neste)
        {
            if (p.verdi.equals(verdi))
            {
                // velger aa kalle opp hjelpemetoden fjernNode
                fjernNode(p);
                return true;
            }
        }
        // i tilfellet verdien ikke ligger i lista vaar
        return false;
    }

    @Override
    public T fjern(int indeks) {

        // indekskontroll
        indeksKontroll(indeks, false);

        // returnerer med et kall paa to hjelpemetoder sammen.
        return fjernNode(finnNode(indeks));
    }


    // ===== Oppgave 7 =============================================

    // velger å endre null() til aa bli to kopier, den ene
    // som nullstill1(), og den andre nullstill2()
    // for tydeligheten sin skyld.

    // ===== nullstill() = nullstill1() ============================
    @Override
    public void nullstill() {

        Node<T> p = hode;


        // node «nulles»
        // nodeverdien og alle nodens pekere
        while (p != null)
        {
            Node<T> q = p.neste;
            p.verdi = null;
            p.forrige = null;
            p.neste = null;
            p = q;
        }

        // Til slutt settes både hode og hale til null
        hode = hale = null;

        // antall til 0
        // og endringer økes
        antall = 0;
        endringer++;
    }
    /*

    Dette er den andre måten å lage void nullstill() på. Jeg fikk red warnings
    med to ulike (jeg prøvd kopiere nullstill()-mal, og kallle en for nullstill1()
    og den andre nllstill(). Men fikk red warnings paa selves public class
    dobbeltLenketListe.java. Så da velger jeg å holde paa vanlig
    nullstill(). Den vanlige nullstill() er nullstill1(), altså første metode.


    Her under er den andre metoden nullstill2(), som jeg lagde. Den ser litt
    anderledes ut enn nullstill1() over.


    // ===== nullstill(2) ============================================

    @Override
    public void nullstill2() {

        while (antall > 0) fjern(0);

    }

    ============ Resultat av oppgave 7 ===============================

    Jeg kom fram til var at det var liten forskjell i effektivitet
    mellom nullstill1() (den heter nullstill() øverst) og
    nullstill2() (den nederste som er inne i samme tekst som det her).


     ===== Oppgave 7 slutt ===========================================
    */
    @Override
    public String toString() {
        // Den skal returnere en tegnstreng med listens
        // verdier.
        // StringJoiner er brukt
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (Node<T> p = hode; p != null; p = p.neste)
            sj.add(p.verdi.toString());
        return sj.toString();
    }

    public String omvendtString() {
        // Den skal returnere en tegnstreng i omvendt rekkefølge med listens
        // verdier.
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (Node<T> p = hale; p != null; p = p.forrige)
            sj.add(p.verdi.toString());
        return sj.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException("Det er ingen verdier!");

            if (endringer != iteratorendringer)
                throw new ConcurrentModificationException("Lista er endret!");

            T tempverdi = denne.verdi;
            denne = denne.neste;

            fjernOK = true;

            return tempverdi;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


