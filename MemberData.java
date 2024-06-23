package membership.sourcecode;

public class MemberData {
private String name;
    private String email;
    private String age;
    private String gender;
    private String type;
    private String dob;


    public MemberData(String name, String email, String age, String gender,String type) {
        this.name = name;
        this.email = email;
        this.age =age;
        this.gender = gender;
        this.type=type;
        this.dob=dob;
    }

    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type=type;
    }
    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public void setAge(String age)
    {
        this.age=age;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }

    public void setGender(String gender)
    {
        this.gender=gender;
    }
    public void setDob(String dob)
    {
        this.dob=dob;
    }

    @Override
    public String toString() {
        return name + ',' +
                 email + ',' +
               age + ',' +
                gender + ',' +
               type ;
    }

    public String getDob(){return dob;}

}
