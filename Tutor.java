
/**
 * This is the tutor class
 * It is the child class of the teacher classes.
 * It has inherited the variables and methods in from teacher class and also has some of it's own.
 * methods like setSalary has a bit of complex logic and was made according to the question requirements.
 * @author (Rishav Poudel)
 * @version (1.0.0)
 */
public class Tutor extends Teacher 
{
    // Variable declarations
    private double salary;
    private String specialization;
    private String academicQualifications;
    private int performanceIndex;
    private boolean isCertified;

    // Constructor for Tutor class, calling the superclass constructor using 'super'
    public Tutor(int teacherId, String teacherName, String address, String workingType, String employmentStatus,
                 int workingHours, double salary, String specialization, String academicQualifications, int performanceIndex) {
        super(teacherId, teacherName, address, workingType, employmentStatus);
        this.salary = salary;
        this.specialization = specialization;
        this.academicQualifications = academicQualifications;
        this.performanceIndex = performanceIndex;
        this.isCertified = false;
        setWorkingHours(workingHours); // Set working hours using the setter method
    }
    
    // Accessor methods for attributes in the Tutor class
    public double getSalary() 
    {
        return salary;
    }

    public String getSpecialization() 
    {
        return specialization;
    }

    public String getAcademicQualifications() 
    {
        return academicQualifications;
    }

    public int getPerformanceIndex() 
    {
        return performanceIndex;
    }

    public boolean isCertified() 
    {
        return isCertified;
    }

    // Method to set salary and certify the tutor
    public void setSalary(double newSalary, int newPerformanceIndex) 
    {
        if (newPerformanceIndex > 5 && getWorkingHours() > 20) {
            double appraisal = 0;
            if (newPerformanceIndex >= 5 && newPerformanceIndex <= 7) {
                appraisal = 0.05;
            } else if (newPerformanceIndex >= 8 && newPerformanceIndex <= 9) {
                appraisal = 0.10;
            } else if (newPerformanceIndex == 10) {
                appraisal = 0.20;
            }
            this.salary = newSalary + appraisal * newSalary;
            this.performanceIndex = newPerformanceIndex;
            isCertified = true;
        } else {
            System.out.println("Salary cannot be approved. Tutor not certified yet.");
        }
    }

    // Method to remove the tutor if not certified
    public void removeTutor() 
    {
        if (!isCertified) {
            this.salary = 0;
            this.specialization = "";
            this.academicQualifications = "";
            this.performanceIndex = 0;
            isCertified = false;
        }
    }

    // Override display method to include additional details
    @Override
    public void display() 
    {
        if (!isCertified) {
            super.display();
        } else {
            super.display();
            System.out.println("Salary: " + salary);
            System.out.println("Specialization: " + specialization);
            System.out.println("Academic Qualifications: " + academicQualifications);
            System.out.println("Performance Index: " + performanceIndex);
        }
    }
}
