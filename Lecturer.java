
/**
 * This is the lecturer class.
 * It is the child class of the teacher classes.
 * It has inherited the variables and methods in from teacher class and also has some of it's own.
 * Some methods and logic inside them like gradeAssigments() where created according to question requirements.
 * @author (Rishav Poudel)
 * @version (1.0.0)
 */
public class Lecturer extends Teacher 
{
    // Variable declarations
    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private char grade;
    private boolean hasGraded;

    // Constructor for Lecturer class, calling the superclass constructor using 'super'
    public Lecturer(int teacherId, String teacherName, String address, String workingType, String employmentStatus,
                    String department, int yearsOfExperience, int workingHours) 
    {
        super(teacherId, teacherName, address, workingType, employmentStatus);
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
        this.gradedScore = 0;
        this.grade = ' ';
        this.hasGraded = false;
        setWorkingHours(workingHours);
    }
    
    // Accessor methods for attributes in the Lecturer class
    public String getDepartment() 
    {
        return department;
    }

    public int getYearsOfExperience() 
    {
        return yearsOfExperience;
    }

    public int getGradedScore() 
    {
        return gradedScore;
    }

    public boolean hasGraded() 
    {
        return hasGraded;
    }
    
    public char getGrade()
    {
        return grade;
    }
    
    // Mutator method for gradedScore attribute
    public void setGradedScore(int gradedScore) 
    {
        this.gradedScore = gradedScore;
    }

    // Method to grade assignments
    public void gradeAssignment(int gradedScore, String department, int yearsOfExperience) 
    {
        //.equals() is a inbuilt method that compares the two strings and returns true or false accordingly.
        //.toLowerCase() is also a inbuilt method in java that converts the string to lowercase.
        
        /* Here if the condition is met then gradedscore is assigned then the score is checked and the grade is 
        stored in a variable called grade. Even though the grade varaible is not given in question it was required to create it due to
        the requirement to have grades according to the gradedScore.
        */
        if (!hasGraded && yearsOfExperience >= 5 && this.department.toLowerCase().equals(department.toLowerCase())) {
            this.gradedScore = gradedScore;
            if (gradedScore >= 70) {
                this.grade = 'A';
            } else if (gradedScore >= 60) {
                this.grade = 'B';
            } else if (gradedScore >= 50) {
                this.grade = 'C';
            } else if (gradedScore >= 40) {
                this.grade = 'D';
            } else {
                this.grade = 'E';
            }
            hasGraded = true;
        } else {
            System.out.println("Assignment not graded yet.");
        }
    }

    // Override display method to include additional details
    @Override
    public void display() 
    {
        super.display();
        System.out.println("Department: " + department);
        System.out.println("Years of Experience: " + yearsOfExperience);
        if (hasGraded) {
            System.out.println("Graded Score: " + gradedScore);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Assignment not graded yet.");
        }
    }
}
