
/**
 * This is the teacher class.
 * It holds various private instance variables and public methods that are passed down to its children classes that are lecturer and tutor.
 * @author (Rishav Poudel)
 * @version (1.0.0)
 */
public class Teacher
{
    // Variable declarations
    private int teacherId;
    private String teacherName;
    private String address;
    private String workingType;
    private String employmentStatus;
    private int workingHours;

    // Constructor for Teacher class
    public Teacher(int teacherId, String teacherName, String address, String workingType, String employmentStatus) 
    {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.address = address;
        this.workingType = workingType;
        this.employmentStatus = employmentStatus;
        this.workingHours = -1; // default value when not assigned
    }

    // Setter method for workingHours
    public void setWorkingHours(int newHours) 
    {
        this.workingHours = newHours;
    }
    
    // Accessor methods for attributes in the Teacher class
    public int getTeacherId() 
    {
        return teacherId;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }

    public String getAddress() 
    {
        return address;
    }

    public String getWorkingType() 
    {
        return workingType;
    }

    public String getEmploymentStatus() 
    {
        return employmentStatus;
    }

    public int getWorkingHours() 
    {
        return workingHours;
    }

    // Display method to print details of the Teacher
    public void display() 
    {
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Address: " + address);
        System.out.println("Working Type: " + workingType);
        System.out.println("Employment Status: " + employmentStatus);
        //Checking if the working hour has been assigned or not
        if (workingHours != -1) {
            System.out.println("Working Hours: " + workingHours);
        } else {
            System.out.println("Working Hours not assigned.");
        }
    }
}
