package add.details;

public class EmployeeDetails {
    private String name,age,gender,job,nid,phone,email;
    private double salary;
    public void setEmployeeData(String name,String age,String gender,String job,String nid,double salary,String phone,String email) {
        this.name = name;
        this.age=age;
        this.gender=gender;
        this.job=job;
        this.nid=nid;
        this.salary=salary;
        this.phone=phone;
        this.email=email;
    }
    //adding getter methods for private attributes
    public String getName(){return this.name;}
    public String getAge(){return this.age;}
    public String getGender(){return this.gender;}
    public String getJob(){return this.job;}
    public String getNid(){return this.nid;}
    public double getSalary(){return this.salary;}
    public String getPhone(){return this.phone;}
    public String getEmail(){return this.email;}

    public static void main(String[] args) {
        new EmployeeDetails();
    }
}
