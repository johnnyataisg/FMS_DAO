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
        database.clearTables();
        try
        {
            PersonDAO pDAO = new PersonDAO(database.openConnection());
            pDAO.insert(person);
            comparePerson = pDAO.find("10101");
            database.closeConnection(true);
        }
        catch (DataAccessException e)
        {
            database.closeConnection(false);
        }
        assertNotNull(comparePerson);
        assertEquals(person, comparePerson);
    }

    @Test
    public void insertFail() throws Exception
    {
        boolean didItWork = true;
        try
        {
            PersonDAO pDAO = new PersonDAO(database.openConnection());
            pDAO.insert(person);
            Person newPerson = new Person("10101",
                    "hello world",
                    "Drex",
                    "Effect",
                    "f",
                    "Adam",
                    "Eve",
                    "");
            pDAO.insert(newPerson);
            database.closeConnection(didItWork);
        }
        catch (DataAccessException e)
        {
            database.closeConnection(false);
            didItWork = false;
        }
        assertFalse(didItWork);
        Person comparePerson = person;
        try
        {
            PersonDAO pDAO = new PersonDAO(database.openConnection());
            comparePerson = pDAO.find(person.getPersonID());
            database.closeConnection(true);
        }
        catch (DataAccessException e)
        {
            database.closeConnection(false);
        }
        assertNull(comparePerson);
    }

    @Test
    public void findPass() throws Exception
    {
        Person findResult = null;
        database.clearTables();
        try
        {
            PersonDAO pDAO = new PersonDAO(database.openConnection());
            pDAO.insert(person);
            findResult = pDAO.find("10101");
            database.closeConnection(true);
        }
        catch (DataAccessException e)
        {
            database.closeConnection(false);
        }
        assertNotNull(findResult);
        assertEquals(person, findResult);
    }

    @Test
    public void findFail() throws Exception
    {
        Person findResult = null;
        database.clearTables();
        try
        {
            PersonDAO pDAO = new PersonDAO(database.openConnection());
            findResult = pDAO.find("10101");
            database.closeConnection(true);
        }
        catch (DataAccessException e)
        {
            database.closeConnection(false);
        }
        assertNull(findResult);
    }

    @Test
    public void clearPass() throws Exception
    {
        database.clearTables();
        int size_after_insert = 0;
        int size_after_clear = 0;
        try
        {
            PersonDAO pDAO = new PersonDAO(database.openConnection());
            pDAO.insert(person);
            size_after_insert = pDAO.size();

            pDAO.clearPersons();
            size_after_clear = pDAO.size();

            database.closeConnection(true);
        }
        catch (DataAccessException e)
        {
            database.closeConnection(false);
        }
        assertTrue(size_after_insert > 0 && size_after_clear == 0);
    }

    @Test
    public void clearFail() throws Exception
    {
        database.clearTables();
        int size_after_clear = 0;
        int size_after_second_clear = 0;
        try
        {
            PersonDAO pDAO = new PersonDAO(database.openConnection());
            pDAO.insert(person);

            pDAO.clearPersons();
            size_after_clear = pDAO.size();

            pDAO.clearPersons();
            size_after_second_clear = pDAO.size();

            database.closeConnection(true);
        }
        catch (DataAccessException e)
        {
            database.closeConnection(false);
        }
        assertTrue(size_after_clear == 0 && size_after_second_clear == 0);
    }
}