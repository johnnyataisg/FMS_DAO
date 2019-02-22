import dao.*;
import model.Person;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main
{
    public static void main(String[] args)
    {
        /*Result result = JUnitCore.runClasses(PersonDAOTest.class);

        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());*/

        org.junit.runner.JUnitCore.runClasses(PersonDAOTest.class, UserDAOTest.class);

        org.junit.runner.JUnitCore.main("dao.PersonDAOTest", "dao.UserDAOTest");
    }
        /*Database db = new Database();
        Person person = new Person("10101",
                "Adam",
                "Johnny",
                "Pao",
                "m",
                "Arthur",
                "Terry",
                "Jina");
        try
        {
            PersonDAO pdao = new PersonDAO(db.openConnection());
            pdao.insert(person);
            Person test = pdao.find(person.getPersonID());
            System.out.println(person.equals(test));
        }
        catch (DataAccessException e)
        {
            System.out.println("Error occurred");
        }*/
}