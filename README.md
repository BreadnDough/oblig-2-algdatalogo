# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Gruppe 90 Oblig 2:
* Frederik Alexander Biltvedt, s362044, s362044@oslomet.no


# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Jeg har selv prøvd meg på alle samtlige oppgavene.

# Oppgavebeskrivelse

I oppgave 1 så gikk vi frem ved å lage metodene int antall() og boolean tom(). Den første skal returnere antallet verdier i 
listen og den andre skal returnere true/false avhengig av om listen er tom eller ikke.  
Laget konstruktøren DobbeltLenketListe(T[] a), og det er en dobbeltlenket 
liste som har med de samme verdiene man tar fra tabellen a. Jeg har tatt med NullPointerException (med teksten "Tabellen a er null!)for tilfeldene 
null!" med import av object klassen med metoden reuiredNonNull.  Hvis tabellen a har kun en verdi som ikke er null (listen får da én 
node), så vil hode og hale peke til samme node. Men om a er tom (altså lengden er 0), 
vil det ikke bli noen noder, og dermed vil node og hale forbli null (dvs dette er en tom liste.). La til konstruktør DobbeltLenketListe().

I oppgave 2a så brukte vi metoden String toString() til å returnere en tegnstreng med listens 
verdier. Altså om listainneholder tallene 1, 2 og 3, skal metoden returnere strengen 
"[1, 2, 3]" og det kommer fram "[]" hvis listen er tom. 
Jeg brukte StringJoiner til å bygge opp tegnstrengen og verdiene i lista ved å traversere fra hodet til halen 
med bruk av neste-pekere. I oppgv 2a brukte vi metoden String omvendtString() til å returnere en 
tegnstreng, men verdiene skal komme fram i omvendt rekkefølge.
Jeg fant til verdiene i omvendt rekkefølge ved å traversere fra hale til hode 
ved å ta i bruk forrige-pekere. Hensikten med omvendtString() er å kunne sjekke at forrige-pekerne fungrerer.
I oppgave 2b så brukte vi metoden boolean leggInn(T verdi) til å sjekke for null/ikke verdier som ikke skal
tas med med to ulike tilfelder.

I oppgave 3a så brukte vi en hjelpemetoden Node<T> finnNode(int indeks) (fra kompendiumet) 
til å returnere noden med den gitte indeks/posisjon. Den gjør en letingen etter noden starter fra hode og gå mot høyre 
ved hjelp av neste-pekere. Hvis ikke, skal letingen starte fra halen og gå mot venstre ved hjelp av forrige-pekere. I oppgave 3a så brukte
vi metoden public T hent(int indeks) som kaller på hjelpemetoden Node<T> finnNode(int indeks) og tok i bruk et kall på indeksKontroll som er arvet fra liste.java. I oppgave 3a så brukte vi en metoden T oppdater(int indeks, T nyverdi) til erstatte 
verdien på plass indeks med nyverdi og returnere det som lå der fra før sammmen med både en sjekk fra indeksKontroll og med melding via reuireNonNull fra objects klassen. I oppgave 3b så brukte vi metoden Liste<T> subliste(int fra, int til) til å returnere en liste (en 
instans av klassen DobbeltLenketListe) som inneholder verdiene innenfor det halvåpende intervallet [fra:til> i 
lista. Det ble brukt sjekk for indeksene til fra og til med kall til fratilkontroll (hjelpemetode fra kompendium). 
Metoden som ble kalt inne i metoden Liste<T> subliste(int fra, int til) er her private, og jeg endret
ArrayIndexOutOfBoundsException med IndexOutOfBoundsException siden vi ikke holder på med en 
tabell eller array, samtidig endret tablengde med ordet antall for å passe med koden.  Jeg tok i bruk metoden leggInn()
inne i Liste<T> subliste.


I oppgave 4 så brukte metoden indeksTil til å returnere indeksen/posisjonen til verdi hvis 
den finnes i listen og hvis den ikke finens skal det returnes med  -1. Metoden skal isteden returnere -1, uten unntakskontroll
fordi null vil ikke være med i lista. Hvis verdi er forekommer flere ganger, så vil indeksen til den første av dem (sett fra venstre) 
returneres. I oppgave 4 har jeg også brukt metoden inneholder til å returnere true hvis 
lista inneholder verdien og den vil returnere false ellers. Også tok jeg i brukt kall inne i metoden inneholder 
metoden indeksTil som en del av koden

I oppgave 5 så brukte vi metoden void leggInn(int indeks, T verdi) til å legge verdi inn i listen slik at 
den får indeks/posisjon indeks. Negative indekser og indekser større enn antall er 
ulovlige ( altså er indekser fra og med 0 til og med antall er lovlige). I oppgave 5 har vi gjort opp
hvert av tilfellene 1) listen er tom, 2) verdien skal legges først, 3) verdien skal legges bakerst og 4) 
verdien skal legges mellom to andre verdier. Jeg har sørget for at neste- og forrige-pekere skal få korrekte 
verdier for alle noder. Også vil forrige-peker i den første noden være null og neste-peker i 
den siste noden være null.


I oppgave 6 så brukte vi metoden T fjern(int indeks) til fjerne (og returnere) verdien på posisjon indeks (som først må sjekkes). 
I oppgave 6 brukte vi også metoden boolean fjern(T verdi) til å fjerne verdi fra listen og så returnere true. 
Hvis det finnes flere forekomster av verdier det den så vil det være at den første av dem (fra venstre) som skal fjernes. 
Hvis verdien ikke ligger i lista så skal metoden kun returnere false. Det er ikke brukt unntakskontroll for null-verdier, og kun  returnere false siden det ikke er noen mulige null i lista. Jeg har valgt å bruke en hjelpemetode fra kompendiumet som heter T fjernNode(Node<T> p),
dette ble brukt i den andre metoden boolean fjern(T verdi) og første metoden T fjern(int indeks). I den hjelpemetoden
ble tilfellene( 1) den første fjernes, 2) den siste fjernes og 3) 
en verdi mellom to andre fjernes.) tatt hensyn til. Altså alle neste- og forrige-pekere er forsåvidt jeg vet  korrekt etter 
bruk av fjerning. Variabelen antall blir redusert og endringer økes, helt etter oppgaveteksten ønsker.

I oppgave 7 så brukte vi metoden void nullstill() til å «tømme» listen og nulle alt slik at 
«søppeltømmeren» kan hente alt som ikke lenger brukes. Jeg kodet ferdig hver av de to metodene
med tidsmaaling, og fant at det var liten forskjell i effektivitet naar det kom til 
de metodene. Første metode gjaldt å starte i hode og gå mot hale ved hjelpe pekeren neste. 
For hver node «nulles» nodeverdien og alle nodens pekere. Til slutt settes både hode og hale til null, antall til 0 
og endringer økes. Andre mtode er en løkke som inneholder metodekallet fjern(0) (den første noden fjernes) og 
som går inntil listen er tom

I oppgave 8a så brukte vi metoden T next() til først å sjekke om iteratorendringer er lik endringer. 
Hvis den ikke er lik det, så skal det kastes en ConcurrentModificationException. Det er lagt til en NoSuchElementException 
hvis det ikke er flere igjen i listen (dvs. hvis hasNext() er ikke sann/true). Forså at det skal 
settes fjernOK til sann/true, verdien til denne returneres og denne flyttes til den neste node. I oppgave 8b så brukte vi
metoden Iterator<T> iterator() til å returnere en instans av iteratorklassen. I oppgave 8c så brukte vi  
konstruktøren private DobbeltLenketListeIterator(int indeks) til  å sette pekeren denne til den noden som hører til den 
oppgitte indeksen.  I oppgave 8d så brukte vi metoden Iterator<T> iterator(int indeks) til først å sjekke at 
indeksen er lovlig. Inne i den metoden ble det brukt et kall etter metoden indeksKontroll() . Deretter skal den ved hjelp av 
konstruktøren i punkt 8c kunne returnere en instans av iteratorklassen.

I oppgave 9 så brukte vi metoden void remove() i iteratorklassen. Den kaster en IllegalStateException hvis det ikke er tillatt 
å kalle på metoden. Det kastes Concurrrent-ModificiationException, hvis det viser seg at endringer og iteratorendringene er
ulike. Hvis man klarer å passere disse to testene skal fjernOK settes til usann/false, og noden rett til venstre for p
fjernes. Hvis den som skal fjernes er eneste verdi (antall == 1), så nulles hode og hale. Hvis den siste skal 
fjernes (denne == null), så må hale oppdateres. Hvis den første skal fjernes (denne.forrige == hode), så må hode oppdateres.
4) Hvis en node inne i listen skal fjernes (noden denne.forrige), så må pekerne i nodene på hver side oppdateres.
iteratorendringer plusses med 1 for hver gang dette gaar gjennom fullstendig.


I oppgave 10 så brukte vi en metoden sorter(Liste<T> liste, Comperator<? super T > c) er ment for å sortere en liste med
bruk av comperator. Oppgaven skal løses uten hjelpestruktur og den er såkalt "på plass".
Målet er å få metoden til å virke (at den sorterer korrekt). Også er det ment å lete etter hvilken
orden sorteringen ender med. Foreløbig har jeg kun fått til pseudoesque kode for nå.
