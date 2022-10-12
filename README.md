# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
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
vil det ikke bli noen noder, og dermed vil node og hale forbli null (dvs dette er en tom liste.)



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

I oppgave 3 så brukte vi en ... til å ...

I oppgave 4 så brukte vi en ... til å ...

I oppgave 5 så brukte vi en ... til å ...

I oppgave 6 så brukte vi en ... til å ...

I oppgave 7 så brukte vi en ... til å ...

I oppgave 8 så brukte vi en ... til å ...

I oppgave 9 så brukte vi en ... til å ...

I oppgave 10 så brukte vi en ... til å ...
