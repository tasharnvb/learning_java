package session;

import entity.Film;
import entity.Genre;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collection;
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * set <property name="hbm2ddl.auto">update</property> in persistence.xml
 */
//@Ignore
public class JpaFilmDAOIT {

    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    // arrange

    private FilmDAO dao = new JpaFilmDAO();

    // runs once before any of the test methods
    @BeforeClass
    public static void setup() {
        String url = "jdbc:mysql://localhost:3306/filmstore";
        try (Connection connection = DriverManager.getConnection(url, "root", "password")) {
            try (Statement statement = connection.createStatement()) {
                for (String command : commands) {
                    statement.addBatch(command);
                }
                int[] updates = statement.executeBatch();
                int count = updates.length;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Add META-INF/persistence.xml to src/main/resources folder
     * and add hibernate-entitymanager dependency to build.gradle
     */
//    @Test
//    public void entityManagerFactoryCanBeObtained() {
//        EntityManager em = EntityManagerUtil.getEntityManager();
//        em.close();
//    }

    //@Ignore
    @Test
    public void selectByIdShouldReturnCorrectFilmFromStore() {
        logger.info("");
        // act
        Film film = dao.selectById(4L);
        // assert
        assertEquals("Pulp Fiction", film.getTitle());
    }

    //@Ignore
    @Test
    public void selectAllShouldReturn250Films() {
        // act
        int count = dao.selectAll().size();
        // assert
        assertEquals("film table has 250 rows", 250, count);
    }

    //@Ignore
    @Test
    public void selectByTitleShouldGetMatchingFilms() {
        // act
        Collection<Film> films = dao.selectByTitle("Alien");
        // assert
        assertEquals(2, films.size());
    }

    //@Ignore
    @Test
    public void insertShouldAddFilmToStore() {
        // arrange
        Film film = new Film("The Pink Panther", 5, LocalDate.of(1964, 1, 20), Genre.COMEDY);
        // act
        long generatedId = dao.insert(film);
        // assert
        assertEquals(251, dao.selectAll().size());
    }

    //@Ignore
    @Test
    public void updateShouldModifyFilmInStore() {
        // arrange
        Film film = dao.selectById(8L);
        film.setStock(9);
        // act
        boolean updated = dao.update(film);
        // assert
        assertTrue(updated);
        assertEquals(9, dao.selectById(8L).getStock());
    }

    //@Ignore
    @Test
    public void deleteShouldRemoveFilmFromStore() {
        // arrange
        int initialSize = dao.selectAll().size();
        // act
        boolean deleted = dao.delete(5L);
        // assert
        assertTrue(deleted);
        assertEquals(initialSize - 1, dao.selectAll().size());
    }

    //@Ignore
    @Test
    public void deleteShouldReturnFalseIfFilmDoesNotExist() {
        // act
        boolean deleted = dao.delete(500L);
        // assert
        assertFalse(deleted);
    }

    private static String[] commands = {
            "set foreign_key_checks = 0;",
            "create table if not exists Film (id bigint not null auto_increment, genre varchar(255), released date, stock integer not null, title varchar(255), version integer not null, primary key (id));",
            "truncate table film;", //removes all data from table
            //"delete from film where id > 250;",
            "insert into Film (title, released, stock, genre, version) values ('The Shawshank Redemption','1994-01-01',8,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Godfather','1972-01-01',7,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Godfather: Part II','1974-01-01',8,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Pulp Fiction','1994-01-01',9,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Good, the Bad and the Ugly','1966-01-01',0,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('12 Angry Men','1957-01-01',9,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Schindler''s List','1993-01-01',6,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Dark Knight','2008-01-01',4,'FANTASY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Lord of the Rings: The Return of the King','2003-01-01',5,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('One Flew Over the Cuckoo''s Nest','1975-01-01',0,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('Star Wars: Episode V - The Empire Strikes Back','1980-01-01',4,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Fight Club','1999-01-01',8,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Seven Samurai','1954-01-01',6,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Inception','2010-01-01',2,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Lord of the Rings: The Fellowship of the Ring','2001-01-01',9,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Goodfellas','1990-01-01',2,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Star Wars: Episode IV - A New Hope','1977-01-01',9,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('City of God','2002-01-01',8,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Casablanca','1942-01-01',5,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Matrix','1999-01-01',4,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Once Upon a Time in the West','1968-01-01',7,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Rear Window','1954-01-01',1,'FANTASY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Silence of the Lambs','1991-01-01',7,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Raiders of the Lost Ark','1981-01-01',4,'FANTASY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Lord of the Rings: The Two Towers','2002-01-01',5,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Usual Suspects','1995-01-01',9,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Forrest Gump','1994-01-01',0,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Se7en','1995-01-01',3,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('Psycho','1960-01-01',9,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('It''s a Wonderful Life','1946-01-01',7,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Leon','1994-01-01',8,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Sunset Boulevard','1950-01-01',3,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Memento','2000-01-01',7,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb','1964-01-01',1,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Apocalypse Now','1979-01-01',8,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('American History X','1998-01-01',7,'FANTASY',0);",
            "insert into Film (title, released, stock, genre, version) values ('North by Northwest','1959-01-01',7,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Terminator 2: Judgment Day','1991-01-01',7,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('Avengers Assemble','2012-01-01',9,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Citizen Kane','1941-01-01',3,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('Saving Private Ryan','1998-01-01',0,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Alien','1979-01-01',9,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('City Lights','1931-01-01',8,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Spirited Away','2001-01-01',7,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('American Beauty','1999-01-01',1,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Toy Story 3','2010-01-01',9,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Taxi Driver','1976-01-01',9,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('M','1931-01-01',9,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Shining','1980-01-01',3,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Vertigo','1958-01-01',8,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Paths of Glory','1957-01-01',4,'FANTASY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Pianist','2002-01-01',2,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Modern Times','1936-01-01',6,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Departed','2006-01-01',8,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Amelie','2001-01-01',4,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Double Indemnity','1944-01-01',8,'FANTASY',0);",
            "insert into Film (title, released, stock, genre, version) values ('WALL·E','2008-01-01',3,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Lives of Others','2006-01-01',2,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Aliens','1986-01-01',4,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('A Clockwork Orange','1971-01-01',3,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Life Is Beautiful','1997-01-01',2,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Back to the Future','1985-01-01',9,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('To Kill a Mockingbird','1962-01-01',6,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Lawrence of Arabia','1962-01-01',8,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Das Boot','1981-01-01',2,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Requiem for a Dream','2000-01-01',4,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Reservoir Dogs','1992-01-01',4,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Third Man','1949-01-01',5,'FANTASY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Eternal Sunshine of the Spotless Mind','2004-01-01',8,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Prestige','2006-01-01',8,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('A Separation','2011-01-01',8,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Green Mile','1999-01-01',2,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Cinema Paradiso','1988-01-01',2,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Great Dictator','1940-01-01',5,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Chinatown','1974-01-01',9,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Gladiator','2000-01-01',8,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Treasure of the Sierra Madre','1948-01-01',5,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('L.A. Confidential','1997-01-01',3,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Once Upon a Time in America','1984-01-01',4,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Rashomon','1950-01-01',3,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Monty Python and the Holy Grail','1975-01-01',2,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Intouchables','2011-01-01',5,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Full Metal Jacket','1987-01-01',2,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Singin'' in the Rain','1952-01-01',2,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Bicycle Thieves','1948-01-01',1,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Some Like It Hot','1959-01-01',8,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Amadeus','1984-01-01',9,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('All About Eve','1950-01-01',1,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Metropolis','1927-01-01',1,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Raging Bull','1980-01-01',4,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Braveheart','1995-01-01',2,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Oldboy','2003-01-01',5,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('2001: A Space Odyssey','1968-01-01',5,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Star Wars: Episode VI - Return of the Jedi','1983-01-01',3,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Bridge on the River Kwai','1957-01-01',2,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Apartment','1960-01-01',3,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Unforgiven','1992-01-01',7,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Pan''s Labyrinth','2006-01-01',5,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Princess Mononoke','1997-01-01',4,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Sting','1973-01-01',3,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Lion King','1994-01-01',0,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Downfall','2004-01-01',0,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Indiana Jones and the Last Crusade','1989-01-01',4,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Mr. Smith Goes to Washington','1939-01-01',5,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Inglourious Basterds','2009-01-01',6,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Grave of the Fireflies','1988-01-01',8,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Die Hard','1988-01-01',0,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Seventh Seal','1957-01-01',4,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Up','2009-01-01',7,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('On the Waterfront','1954-01-01',5,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Elephant Man','1980-01-01',4,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Yojimbo','1961-01-01',4,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Great Escape','1963-01-01',0,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Maltese Falcon','1941-01-01',5,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Batman Begins','2005-01-01',9,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Gran Torino','2008-01-01',8,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Rebecca','1940-01-01',0,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Witness for the Prosecution','1957-01-01',2,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Snatch.','2000-01-01',4,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('For a Few Dollars More','1965-01-01',5,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('The General','1926-01-01',3,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Heat','1995-01-01',0,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Blade Runner','1982-01-01',6,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('Fargo','1996-01-01',2,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Wild Strawberries','1957-01-01',5,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Ran','1985-01-01',8,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Toy Story','1995-01-01',6,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Sin City','2005-01-01',9,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Touch of Evil','1958-01-01',4,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Big Lebowski','1998-01-01',4,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Ikiru','1952-01-01',9,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Deer Hunter','1978-01-01',0,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Jaws','1975-01-01',2,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('No Country for Old Men','2007-01-01',9,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Hotel Rwanda','2004-01-01',7,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Cool Hand Luke','1967-01-01',2,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Scarface','1983-01-01',9,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('It Happened One Night','1934-01-01',9,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Wizard of Oz','1939-01-01',5,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Sixth Sense','1999-01-01',0,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Wages of Fear','1953-01-01',2,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Strangers on a Train','1951-01-01',4,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Kid','1921-01-01',7,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The King''s Speech','2010-01-01',3,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Kill Bill: Vol. 1','2003-01-01',1,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Black Swan','2010-01-01',9,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Annie Hall','1977-01-01',5,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Artist','2011-01-01',9,'FANTASY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Gold Rush','1925-01-01',2,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('High Noon','1952-01-01',9,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Platoon','1986-01-01',3,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Warrior','2011-01-01',0,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Trainspotting','1996-01-01',6,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Lock, Stock and Two Smoking Barrels','1998-01-01',9,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Butch Cassidy and the Sundance Kid','1969-01-01',0,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Grapes of Wrath','1940-01-01',0,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Into the Wild','2007-01-01',4,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('Sunrise','1927-01-01',7,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Secret in Their Eyes','2009-01-01',1,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Thing','1982-01-01',3,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Donnie Darko','2001-01-01',5,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Notorious','1946-01-01',8,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Gone with the Wind','1939-01-01',0,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Casino','1995-01-01',2,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('Million Dollar Baby','2004-01-01',5,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Les Diaboliques','1955-01-01',8,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('There Will Be Blood','2007-01-01',2,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Life of Brian','1979-01-01',3,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('My Neighbour Totoro','1988-01-01',7,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Finding Nemo','2003-01-01',5,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Ben-Hur','1959-01-01',0,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('How to Train Your Dragon','2010-01-01',9,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('Amores Perros','2000-01-01',7,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Terminator','1984-01-01',6,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('V for Vendetta','2005-01-01',8,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Big Sleep','1946-01-01',6,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Groundhog Day','1993-01-01',6,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Good Will Hunting','1997-01-01',2,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Slumdog Millionaire','2008-01-01',4,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Best Years of Our Lives','1946-01-01',4,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Stand by Me','1986-01-01',7,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Dog Day Afternoon','1975-01-01',5,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Judgement at Nuremberg','1961-01-01',9,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Twelve Monkeys','1995-01-01',9,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Graduate','1967-01-01',4,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('Harakiri','1962-01-01',4,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Network','1976-01-01',3,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Bourne Ultimatum','2007-01-01',2,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Night of the Hunter','1955-01-01',9,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Manchurian Candidate','1962-01-01',3,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The 400 Blows','1959-01-01',5,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Mary and Max','2009-01-01',5,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Gandhi','1982-01-01',4,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Dial M for Murder','1954-01-01',8,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Persona','1966-01-01',9,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Battle of Algiers','1966-01-01',5,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('District 9','2009-01-01',4,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Princess Bride','1987-01-01',9,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Killing','1956-01-01',6,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('8½','1963-01-01',3,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('Who''s Afraid of Virginia Woolf?','1966-01-01',7,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('La Strada','1954-01-01',3,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Howl''s Moving Castle','2004-01-01',3,'CRIME',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Passion of Joan of Arc','1928-01-01',9,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Hustler','1961-01-01',4,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Sherlock Jr.','1924-01-01',5,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Ratatouille','2007-01-01',6,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Fanny and Alexander','1982-01-01',8,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Exorcist','1973-01-01',0,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Wrestler','2008-01-01',4,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Wild Bunch','1969-01-01',6,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Kind Hearts and Coronets','1949-01-01',2,'ACTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Rocky','1976-01-01',3,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Stalag 17','1953-01-01',7,'FANTASY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Barry Lyndon','1975-01-01',5,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Diving Bell and the Butterfly','2007-01-01',7,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Harry Potter and the Deathly Hallows: Part 2','2011-01-01',2,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Nights of Cabiria','1957-01-01',5,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('A Streetcar Named Desire','1951-01-01',1,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Star Trek','2009-01-01',4,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('A Beautiful Mind','2001-01-01',5,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('All Quiet on the Western Front','1930-01-01',0,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Tokyo Story','1953-01-01',3,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Truman Show','1998-01-01',1,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Ip Man','2008-01-01',2,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('High and Low','1963-01-01',4,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Rope','1948-01-01',5,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Infernal Affairs','2002-01-01',5,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('The Man Who Shot Liberty Valance','1962-01-01',1,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Roman Holiday','1953-01-01',6,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Come and See','1985-01-01',6,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Stalker','1979-01-01',5,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Rosemary''s Baby','1968-01-01',1,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Pirates of the Caribbean: The Curse of the Black Pearl','2003-01-01',6,'FANTASY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Mystic River','2003-01-01',5,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Let the Right One In','2008-01-01',0,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Nausicaä of the Valley of the Wind','1984-01-01',3,'ADVENTURE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Festen','1998-01-01',8,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Anatomy of a Murder','1959-01-01',4,'ANIMATED',0);",
            "insert into Film (title, released, stock, genre, version) values ('Monsters, Inc.','2001-01-01',2,'SUSPENSE',0);",
            "insert into Film (title, released, stock, genre, version) values ('Nosferatu','1922-01-01',4,'FANTASY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Beauty and the Beast','1991-01-01',9,'SCIENCE_FICTION',0);",
            "insert into Film (title, released, stock, genre, version) values ('Throne of Blood','1957-01-01',3,'FAMILY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Manhattan','1979-01-01',3,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('La Grande Illusion','1937-01-01',5,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Le Samouraï','1967-01-01',9,'HORROR',0);",
            "insert into Film (title, released, stock, genre, version) values ('3 Idiots','2009-01-01',8,'COMEDY',0);",
            "insert into Film (title, released, stock, genre, version) values ('Magnolia','1999-01-01',4,'MUSICAL',0);",
            "insert into Film (title, released, stock, genre, version) values ('Shutter Island','2010-01-01',1,'DRAMA',0);",
            "insert into Film (title, released, stock, genre, version) values ('Memories of Murder','2003-01-01',9,'COMEDY',0);" };
}
// delete from filmstore.ORDERTABLE_FILM;
// delete from filmstore.film;
// delete from filmstore.ORDERTABLE ;
// "SET FOREIGN_KEY_CHECKS=0;",
// "delete from Film;",

// @Test
// public void order() {
// FilmDAO dao = new JpaFilmDAO();
// Film film1 = dao.selectById(1);
// Film film2 = dao.selectById(2);
//
// OrderDAO order = new JpaOrderDAO();
// order.addToOrder(film1);
// order.addToOrder(film2);
// int size = order.getFilmsInOrder().size();
// assertTrue(size == 2);
// assertTrue(order.persistOrder());
//
// }