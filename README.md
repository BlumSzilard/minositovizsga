# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

**Új repository-ba dolgozz! Hozz létre egy új privát repository-t a `Strukturavaltas3-Alap-Java` organization-ön belül, 
a következő névvel: `sv3-2022-jvjbf-kepesitovizsga-SAJÁTNÉV`, és oda töltsd fel a vizsgafeladatok megoldását!**
Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, tesztek). Projekt, könyvtár 
neve legyen: `sv3-2022-jvjbf-kepesitovizsga`. GroupId: `training360`, artifactId: `sv3-2022-jvjbf-kepesitovizsga`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: "init".

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes
feladathoz tartoznak előre elkészített tesztosztályok. Ezekkel a megoldásod helyességét ellenőrizheted.
Ezeket a teszteket ne írd át! Ez alól egyetlen esetben tehetsz kivételt: az Adatbáziskezelés feladatnál 
átírhatod az adatbázis elérési paramétereit a saját számítógépeden használtakra.

A feladatra 3 órád van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk
ellenőrizni a megoldásod. Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod!

Csak olyan kódot commitolj, ami le is fordul! Ha nem fordul, arra a részfeladatra nem jár pont.

## Jelszavak (Algoritmusos feladat, 20 pont)

Manapság nagy hangsúlyt fektetünk arra, hogy egy jelszó biztonságos legyen. Ennek megfelelően ebben a feladatban egy
jelszóról kell eldönteni, hogy mennyire biztonságos.

Készíts egy `PasswordOperations` nevű osztályt, és benne egy `PasswordStrength checkPasswordStrength(String password)` nevű
metódust!
Egy jelszó erőssége három szintű lehet: `WEEK`, `MEDIUM`, `STRONG`. Egy jelszót gyengének tekintünk, ha csak számokból
vagy csak betűkből áll (mindegy, hogy kis- vagy nagybetűkből). Egy jelszót közepesnek tekintünk, ha számokat és
kisbetűket is tartalmaz, és egy jelszót erősnek tekintünk ha számokat és betűket is tartalmaz és tartalmaz legalább egy
nagybetűt. (Különleges karakterekkel most nem foglalkozunk!)
A metódus visszatérési értékét a leírt szabályok szerint valósítsd meg!

## Kvízkérdések (OOP, 20 pont)

A feladatban egy kvízjátékot fogunk modellezni.

Készítsd el a `Level` felsorolásos típust, a következő értékekkel: `EASY`, `MEDIUM`, `HIGH`! Legyen neki egy `point`
attribútuma, melyet getterrel lehet elérni és az értéke rendre `1`, `2`, `3`!

Készítsd el a `Question` interface-t, melynek három absztrakt metódusa a `String getQuestion()`, `Level getLevel()`
és `int calculatePoints(String... answer)`!

Készítsd el a `MultipleChoiceQuestion` osztályt! Ennek adattagjai legyenek: `String question`, `Level level`,
`List<String> options` és `List<String> correctAnswers`! Ezeket mindegyiket konstruktorban állítsd be a megfelelő
ellenőrzés után! A lehetséges válaszoknak (`options`) legalább 2 hosszúnak kell lennie és a helyes válaszok
mindegyikének (`correctAnswers`) benne kell lennie a lehetséges válaszok listájában. Ha utóbbi nem teljesül, dobj
saját `CorrectAnswersMismatchException` kivételt!
Az osztály implementálja a `Question` interface-t! A `getQuestion()` és `getLevel()` metódust értelemszerűen definiáld
felül!

A `calculatePoints(String... answer)` metódusban összegezni kell a helyes válaszokhoz tartozó kérdések szintjeit, és azt
visszaadni a pontszámként! Ha a válasz helytelen, az nulla pontot ér. A megadott válaszok sorrendje tetszőleges. Ha
olyan választ adott meg ami nincs a válasz opciók között, dobj `IllegalArgumentException` kivételt!

Készítsd el a `OneWordQuestion` osztályt! Ennek három adattagja a kérdés, a szint és a helyes válasz és ez az osztály is
implementálja a `Question` interface-t! A pontok kalkulálásánál figyelj arra, hogy csak egy választ lehessen megadni!
Ha a válasz jó, akkor a szintnek megfelelő pont jár, ha nem jó akkor 0.

## Kvízjáték (Kollekciók, 20 pont)

Készítsd el a `Quiz` nevű osztályt, legyen benne egy lista, amiben kérdések vannak, és legyen egy metódus, amivel
kérdést lehet a listához hozzáadni! Tételezzük fel, hogy ez a kvíz csak olyan kérdéseket kap, amiben egy helyes válasz
van!

Legyen benne egy metódus, ami paraméterül vár válaszokat és visszaadja, hogy hány pontot ért el az illető a
kvízen (`int calculateSumPoints(List<String> answers)`)! A válaszok a kérdések sorrendjében szerepelnek.

Készíts egy `Map<Level,Integer> groupByLevel()` metódust ami egy `Map` adatszerkezetbe összegyűjti, hogy szintenként
hány kérdés van!

## Repülőutak (Filekezelés feladat, 20 pont)

Adott a `data.csv` fájl, amiben egy sor szerkezete a következőképpen néz
ki: `{légitársaság};{honnan}-{hova};{hány ember}`, ahogy ez a fejlécben is látható.

Egy példa fájl:

```
Airline;Departure-Arrival;Number of Passengers
Air France;London-Paris;113
KLM;Amsterdam-San Francisco;340
KLM;Amsterdam-Budapest;165
British Airways;London-Budapest;210
Air France;Paris-Rome;212
Lufthansa;Frankfurt-Vienna;154
KLM;Budapest-Rome;154
```

Hozd létre a `Flight` nevű osztályt, amelyben egy sor adatai legyenek az adattagok! Hozd létre a `FlightService` nevű
osztályt, melyben repülőutak listájába olvasod be a file adatait! A beolvasás már a `FlightService` példányosításakor
történjen meg!

Készíts egy metódust, ami paraméterül vár egy légitársaságot, és visszaadja, hogy összesen hány utast szállított az
adott légitársaság!

## Hitelek (Adatbáziskezelés, 20 pont)

Hozz létre egy `Loan` nevű osztályt! Minden hitelnek van egy egyedi azonosítója, egy neve, akihez a hitel tartozik, egy
érték, hogy mennyivel tartozik még az illető és egy kamat (`double` típusú).

Ezeknek az adatoknak megfelelően néz ki a `loans` tábla, melynek létrehozását a migrációs sql file-ban találod.

Készítsd el a `LoanRepository` osztályt, mely az adatbázissal való kommunikációért felelős, ennek megfelelően
egy `DataSource` objektumot kap konstruktorban!

Legyen benne egy `long insertLoan(String name, int debt, double interest)` metódus, ami beszúrja az adatokat a táblába
és visszatér az adatbázis által generált kulccsal!

Legyen benne egy `Loan findLoanById(long id)` metódus, ami id alapján visszaad egy hitel objektumot!

Legyen benne két update metódus! Az egyik a kamatozásért felel, `void updateDebtWithInterest()`, ekkor a tartozás a
kamatnak megfelelő százalékkal nő minden hitelnél. A másik egy törlesztés
metódus, `void updateDebtWithPayment(long id, int amount)`, ami a paraméterül kapott értékkel csökkenti az id-nak
megfelelő tartozást.

Készíts egy `LoanService` osztályt, aminek adattagja egy `LoanRepository`, melyet konstruktorban kap meg! Legyen benne
egy metódus: `int payForLoan(long id, int amount)`!
Ha nagyobb a befizetni kívánt összeg, mint a tartozás, akkor a metódus az egyenleget 0-ra rendezi és visszatér annyival,
amennyivel többet akarunk fizetni. Ha nem nagyobb, akkor befizeti a tartozást és visszatér 0-val. 
