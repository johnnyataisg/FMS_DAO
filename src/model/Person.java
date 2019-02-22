package model;

public class Person
{
    private String personID;
    private String descendant;
    private String firstname;
    private String lastname;
    private String gender;
    private String father;
    private String mother;
    private String spouse;

    public Person(String perID, String desc, String fName, String lName, String gen, String dad, String mom, String spo)
    {
        this.personID = perID;
        this.descendant = desc;
        this.firstname = fName;
        this.lastname = lName;
        this.gender = gen;
        this.father = dad;
        this.mother = mom;
        this.spouse = spo;
    }

    public String getPersonID()
    {
        return this.personID;
    }

    public void setPersonID(String perID)
    {
        this.personID = perID;
    }

    public String getDescendant()
    {
        return this.descendant;
    }

    public void setDescendant(String desc)
    {
        this.descendant = desc;
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

    public String getFather()
    {
        return this.father;
    }

    public void setFather(String dad)
    {
        this.father = dad;
    }

    public String getMother()
    {
        return this.mother;
    }

    public void setMother(String mom)
    {
        this.mother = mom;
    }

    public String getSpouse()
    {
        return this.spouse;
    }

    public void setSpouse(String spo)
    {
        this.spouse = spo;
    }
}
