package model;

public class User
{
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String gender;
    private String personID;

    public User(String uName, String pWord, String e, String fName, String lName, String gen, String perID)
    {
        this.username = uName;
        this.password = pWord;
        this.email = e;
        this.firstname = fName;
        this.lastname = lName;
        this.gender = gen;
        this.personID = perID;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String uName)
    {
        this.username = uName;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String pWord)
    {
        this.password = pWord;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String e)
    {
        this.email = e;
    }

    public String getFirstname()
    {
        return this.firstname;
    }

    public void setFirstname(String fName)
    {
        this.firstname = fName;
    }

    public String getLastname()
    {
        return this.lastname;
    }

    public void setLastname(String lName)
    {
        this.lastname = lName;
    }

    public String getGender()
    {
        return this.gender;
    }

    public void setGender(String gen)
    {
        this.gender = gen;
    }

    public String getPersonID()
    {
        return this.personID;
    }

    public void setPersonID(String perID)
    {
        this.personID = perID;
    }
}
