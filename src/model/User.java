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

    public boolean equals(Object obj_2)
    {
        if (obj_2.getClass() != this.getClass())
        {
            return false;
        }
        else
        {
            User user_2 = (User)obj_2;

            if (!this.username.equals(user_2.getUsername()))
            {
                return false;
            }
            if (!this.password.equals(user_2.getPassword()))
            {
                return false;
            }
            if (!this.email.equals(user_2.getEmail()))
            {
                return false;
            }
            if (!this.firstname.equals(user_2.getFirstname()))
            {
                return false;
            }
            if (!this.lastname.equals(user_2.getLastname()))
            {
                return false;
            }
            if (!this.gender.equals(user_2.getGender()))
            {
                return false;
            }
            if (!this.personID.equals(user_2.getPersonID()))
            {
                return false;
            }
            return true;
        }
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
