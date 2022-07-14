package com.codegen.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "First_Name")
    private String fName;

    @Column(name = "Last_Name")
    private String lName;

    @Column(name = "Email")
    private String emailID;

    public Employee() {

    }

    public Employee( String fName, String lName, String emailID )
    {
        super();
        this.fName = fName;
        this.lName = lName;
        this.emailID = emailID;
    }

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public String getfName()
    {
        return fName;
    }

    public void setfName( String fName )
    {
        this.fName = fName;
    }

    public String getlName()
    {
        return lName;
    }

    public void setlName( String lName )
    {
        this.lName = lName;
    }

    public String getEmailID()
    {
        return emailID;
    }

    public void setEmailID( String emailID )
    {
        this.emailID = emailID;
    }
}
