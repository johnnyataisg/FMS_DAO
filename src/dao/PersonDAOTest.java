package dao;

import model.Person;

import java.sql.Connection;

import org.junit.*;
import static org.junit.Assert.*;

public class PersonDAOTest {
    Database database;
    Person person;

    @Before
    public void setUp() throws Exception
    {
        database = new Database();

        person = new Person("10101",
                "Adam",
                "Johnny",
                "Pao",
                "m",
                "Arthur",
                "Terry",
                "Jina");

        database.createTables();
    }

    @After
    public void tearDown() throws Exception {
        database.clearTables();
    }

    @Test
    public void insertPass() throws Exception
    {
        Person comparePerson = null;
        //Let's clear the database as well so any lingering data doesn't affect our tests
        database.clearTables();
        try
        {
            //Let's get our connection and make a new DAO
            PersonDAO pDAO = new PersonDAO(database.openConnection());
            //While insert returns a bool we can't use that to verify that our function actually worked
            //only that it ran without causing an error
            pDAO.insert(person);
            //So lets use a find function to get the event that we just put in back out
            comparePerson = pDAO.find(person.getPersonID());
            database.closeConnection(true);
        }
        catch (DataAccessException e)
        {
            database.closeConnection(false);
        }
        //First lets see if our find found anything at all. If it did then we know that if nothing
        //else something was put into our database, since we cleared it in the beginning
        assertNotNull(comparePerson);
        //Now lets make sure that what we put in is exactly the same as what we got out. If this
        //passes then we know that our insert did put something in, and that it didn't change the
        //data in any way
        assertEquals(person, comparePerson);

    }

    @Test
    public void insertFail() throws Exception {
        //lets do this test again but this time lets try to make it fail
        boolean didItWork = true;
        try {
            Connection conn = db.openConnection();
            EventDAO eDao = new EventDAO(conn);
            //if we call the function the first time it will insert it successfully
            eDao.insert(bestEvent);
            //but our sql table is set up so that "eventID" must be unique. So trying to insert it
            //again will cause the function to throw an exception
            eDao.insert(bestEvent);
            db.closeConnection(didItWork);
        } catch (DataAccessException e) {
            //If we catch an exception we will end up in here, where we can change our boolean to
            //false to show that our function failed to perform correctly
            db.closeConnection(false);
            didItWork = false;
        }
        //Check to make sure that we did in fact enter our catch statement
        assertFalse(didItWork);
        //Since we know our database encountered an error, both instances of insert should have been
        //rolled back. So for added security lets make one more quick check using our find function
        //to make sure that our event is not in the database
        //Set our compareTest to an actual event
        Event compareTest = bestEvent;
        try {
            Connection conn = db.openConnection();
            EventDAO eDao = new EventDAO(conn);
            //and then get something back from our find. If the event is not in the database we
            //should have just changed our compareTest to a null object
            compareTest = eDao.find(bestEvent.getEventID());
            db.closeConnection(true);
        } catch (DataAccessException e) {
            db.closeConnection(false);
        }
        //Now make sure that compareTest is indeed null
        assertNull(compareTest);

    }

}