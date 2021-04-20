
# Rapport

**Skriv din rapport här!**

Uppgiften gick ut på att skapa en app som lagrar en tabell med flera rader i en SQLite fil.

Generellt är det inget konstigt med layouten på appen. Flera vyer användes för att kunna åstadkomma resultatet. Det som skall skrivas ut lagras i en TextView. Det fanns redan färdiga klasser att använda för att skapa tabeller och databasen. 

```Java
public class DatabaseHelper extends SQLiteOpenHelper {
class DatabaseTables {
```
Här finns statiska konstanter för att lägga till och anropa korrekt data och för att inte det ska skickas in fel värden vid anrop eller inserts. Dessa modifierades endast för att lägga till annat än berg. I detta fallet fiskar.

```Java
    static class Fish {

        static final String TABLE_NAME = "fish";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_WIDTH = "width";
        static final String COLUMN_NAME_LOCATION = "location";
    }

    static final String SQL_CREATE_TABLE_FISH =
            // "CREATE TABLE mountain (id INTEGER PRIMARY KEY, name TEXT, height INT)"
            "CREATE TABLE " + Fish.TABLE_NAME + " (" +
                    Fish.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    Fish.COLUMN_NAME_NAME + " TEXT," +
                    Fish.COLUMN_NAME_WIDTH + " INT," +
                    Fish.COLUMN_NAME_LOCATION + " TEXT)";

    static final String SQL_DELETE_TABLE_FISH =
            // "DROP TABLE IF EXISTS mountain"
            "DROP TABLE IF EXISTS " + Fish.TABLE_NAME;
```
Här är en tabell för fiskar i klassen DatabasHelper. Fish är en statisk innerklass.

```Java
    private static final int DATABASE_VERSION = 1; // If this is incremented onUpgrade() will be executed
    private static final String DATABASE_NAME = "Fishes.db"; // The file name of our database

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // This method is executed only if there is not already a database in the file `Mountain.db`
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_TABLE_FISH);
    }

    // This method is executed only if the database version has changed, e.g. from 1 to 2
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DatabaseTables.SQL_DELETE_TABLE_FISH);
        onCreate(sqLi
```

Funktionerna är självbeskrivande. Enda ändringen är att det skapas en databas som heter Fishes istället för Mountain.

I klassen Fish så läggs relevant data till för fiskar som användaren får fylla i och som kommer lagras i databasen och matchas med tabellen i databasen så samma data lagras i både ett fisk objekt och en tabell. Så när man hämtar data från filen

## Följande grundsyn gäller dugga-svar:

- Ett kortfattat svar är att föredra. Svar som är längre än en sida text (skärmdumpar och programkod exkluderat) är onödigt långt.
- Svaret skall ha minst en snutt programkod.
- Svaret skall inkludera en kort övergripande förklarande text som redogör för vad respektive snutt programkod gör eller som svarar på annan teorifråga.
- Svaret skall ha minst en skärmdump. Skärmdumpar skall illustrera exekvering av relevant programkod. Eventuell text i skärmdumpar måste vara läsbar.
- I de fall detta efterfrågas, dela upp delar av ditt svar i för- och nackdelar. Dina för- respektive nackdelar skall vara i form av punktlistor med kortare stycken (3-4 meningar).

Programkod ska se ut som exemplet nedan. Koden måste vara korrekt indenterad då den blir lättare att läsa vilket gör det lättare att hitta syntaktiska fel.

```
function errorCallback(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            // Geolocation API stöds inte, gör något
            break;
        case error.POSITION_UNAVAILABLE:
            // Misslyckat positionsanrop, gör något
            break;
        case error.UNKNOWN_ERROR:
            // Okänt fel, gör något
            break;
    }
}
```

Bilder läggs i samma mapp som markdown-filen.

![](android.png)

Läs gärna:

- Boulos, M.N.K., Warren, J., Gong, J. & Yue, P. (2010) Web GIS in practice VIII: HTML5 and the canvas element for interactive online mapping. International journal of health geographics 9, 14. Shin, Y. &
- Wunsche, B.C. (2013) A smartphone-based golf simulation exercise game for supporting arthritis patients. 2013 28th International Conference of Image and Vision Computing New Zealand (IVCNZ), IEEE, pp. 459–464.
- Wohlin, C., Runeson, P., Höst, M., Ohlsson, M.C., Regnell, B., Wesslén, A. (2012) Experimentation in Software Engineering, Berlin, Heidelberg: Springer Berlin Heidelberg.
