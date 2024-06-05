/**
 * This is the TeacherGUI class
 * It creates and serves as the GUI for other 3 classes preset in the project
 * Like helping create object of them using GUI and storing them in a aaraylist
 * Helping call methods present in their individual classes using the GUI
 * @author (Rishav Poudel)
 * @version (1.0.0)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeacherGUI {

    // Array list of Teacher type
    private ArrayList<Teacher> teachersList;

    // MainFrame
    private JFrame frame;

    // Panels
    private JPanel mainPanel, titlePanel, navPanel, homePanel, lecturerPanel, tutorPanel, salaryPanel,
            gradePanel, removeTutorPanel, displayPanel;

    // Labels
    private JLabel teacherIdLabel, teacherNameLabel, addressLabel, workingTypeLabel, employmentStatusLabel,
            workingHoursLabel, departmentLabel, yearsOfExperienceLabel, gradedScoreLabel, salaryLabel;

    // Labels0
    private JLabel teacherIdLabel0, teacherNameLabel0, addressLabel0, workingTypeLabel0, employmentStatusLabel0,
            workingHoursLabel0, salaryLabel0, specializationLabel, academicQualificationsLabel, performanceIndexLabel,
            yearsOfExperienceLabel0, departmentLabel0, performanceIndexLabel0;

    // TextFields
    private JTextField teacherIdField, teacherNameField, addressField, workingTypeField, employmentStatusField,
            workingHoursField, departmentField, yearsOfExperienceField, gradedScoreField, salaryField;

    // TextFields 0,1,2,3
    private JTextField teacherIdField0, teacherNameField0, addressField0, workingTypeField0, employmentStatusField0,
            workingHoursField0, specializationField, academicQualificationsField, performanceIndexField, salaryField0,
            teacherIDField1, teacherIDField2, teacherIDField3, yearsOfExperienceField0, departmentField0,
            performanceIndexField0;

    // main Buttons
    private JButton addLecturer, addTutor, gradeAssignment, setSalary, removeTutor, clearButton,
            navDisplayButton;

    // more labels
    private JLabel titleLabel, homeTitleLabel, homeSubTitleLabel;

    // extra butttons
    private JButton homeButton, navSalaryButton, navGradeButton, navRemoveButton, homeLecturerButton, homeTutorButton,
            clearButton0, clearButton1, clearButton2, clearButton3;

    public TeacherGUI() {
        // Initialize ArrayList to hold Teacher objects
        teachersList = new ArrayList<>();

        // Create JFrame
        frame = new JFrame("Teacher GUI");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // *********************************************** [ Header ]
        // *********************************************************************/

        // adding main header to the frame
        titleLabel = new JLabel("Teacher Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(18, 118, 176));
        // Add padding
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        // adding title panel to center the title
        titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setBackground(new Color(60, 78, 102));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        titlePanel.add(titleLabel, gbc);
        // Add the title panel to the frame's content pane at the top
        frame.getContentPane().add(titlePanel, BorderLayout.NORTH);

        // ****************************************** [ NavigationPanel ]
        // ****************************************************************/

        // creating a panel for navigation
        navPanel = new JPanel();
        // Box layout on yAxis meaning every new component is added vertically
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        navPanel.setBackground(new Color(60, 78, 102));

        // Set the combined border to the navigation panel
        navPanel.setBorder(
                BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0, 162, 232)),
                        BorderFactory.createEmptyBorder(50, 10, 0, 10)));

        // creating buttons for navigation
        homeButton = new JButton("Home");
        homeButton.setBackground(new Color(0, 162, 232));
        homeButton.setForeground(Color.WHITE);
        homeButton.setFocusPainted(false);

        navGradeButton = new JButton("Grade Assignments");
        navGradeButton.setBackground(new Color(0, 162, 232));
        navGradeButton.setForeground(Color.WHITE);
        navGradeButton.setFocusPainted(false);

        navSalaryButton = new JButton("Set Salary");
        navSalaryButton.setBackground(new Color(0, 162, 232));
        navSalaryButton.setForeground(Color.WHITE);
        navSalaryButton.setFocusPainted(false);

        navRemoveButton = new JButton("Remove");
        navRemoveButton.setBackground(new Color(0, 162, 232));
        navRemoveButton.setForeground(Color.WHITE);
        navRemoveButton.setFocusPainted(false);

        navDisplayButton = new JButton("Display");
        navDisplayButton.setBackground(new Color(0, 162, 232));
        navDisplayButton.setForeground(Color.WHITE);
        navDisplayButton.setFocusPainted(false);

        // Set maximum size for the buttons
        Dimension buttonSize = new Dimension(150, 30);
        homeButton.setMaximumSize(buttonSize);
        navSalaryButton.setMaximumSize(buttonSize);
        navGradeButton.setMaximumSize(buttonSize);
        navRemoveButton.setMaximumSize(buttonSize);
        navDisplayButton.setMaximumSize(buttonSize);

        // Add buttons to the navigation panel
        // add vertical space between buttons
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(homeButton);
        // add vertical space between buttons
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(navGradeButton);
        // add vertical space between buttons
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(navSalaryButton);
        // add vertical space between buttons
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(navRemoveButton);
        // add vertical space between buttons
        navPanel.add(Box.createVerticalStrut(10));
        navPanel.add(navDisplayButton);

        // Add the navigation panel to the frame's content pane at the west
        frame.getContentPane().add(navPanel, BorderLayout.WEST);

        // *********************************************[ MainPanel
        // ]*****************************************************

        // Main Panel is the panel that holds all over panels
        // It uses card layout i.e stacks everything on top and shows the one that is
        // instructed to show using .show()

        CardLayout cards = new CardLayout();
        mainPanel = new JPanel();
        mainPanel.setLayout(cards);
        mainPanel.setBackground(Color.GRAY);

        // ******************************************* [ Home Panel ]
        // ******************************************************
        createHomePanel();
        // ******************************************* [ Lecturer Panel ]
        // ******************************************************
        createLecturerPanel();
        // ******************************************** [ Tutor Panel ]
        // ********************************************************
        createTutorPanel();
        // ******************************************** [ Salary Panel ]
        // *******************************************************
        createSalaryPanel();
        // ******************************************** [ Grade Panel ]
        // ********************************************************
        createGradePanel();
        // ****************************************** [ Remove Tutor Panel
        // ]****************************************************
        createRemoveTutorPanel();
        // ****************************************** [ Remove Tutor Panel
        // ]****************************************************
        

        // ***************************************[ Buttons Logic To Navigate
        // ]**************************************************

        // *********** [ Action listner to show homePanel ] ***********
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(mainPanel, "homePanel");
                clearFields();
            }
        });

        // *********** [ ActionListnerToShowlecturerPanel ] ***********
        homeLecturerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(mainPanel, "lecturerPanel");
                clearFields();

            }
        });

        // *********** [ Action listner to show tutorPanel ] ***********
        homeTutorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(mainPanel, "tutorPanel");
                clearFields();
            }
        });

        // *********** [ Action listner to show salaryPanel ] ***********
        navSalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(mainPanel, "salaryPanel");
                clearFields();
            }
        });

        // *********** [ Action listner to show grade Panel ] ***********
        navGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(mainPanel, "gradePanel");
                clearFields();
            }
        });

        // *********** [ Action listner to show remove tutor Panel ] ***********
        navRemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(mainPanel, "removeTutorPanel");
                clearFields();
            }
        });

        // *********** [ Action listner to show Display panel ] ***********
        navDisplayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createDisplayPanel();
                cards.show(mainPanel, "displayPanel");
                clearFields();
            }
        });

        // *********** [ Logic for clear buttons ] ***********
        JButton[] clearButtons = { clearButton, clearButton0, clearButton1, clearButton2, clearButton3 };

        for (JButton clearButton : clearButtons) {
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clearFieldsButtons();
                }
            });
        }

        // ************************************** [ Main Buttons Logic ]
        // ***********************************************************/

        mainButtonsLogic();

        // ************************************** [ Frame Settings ]
        // ***********************************************************/

        cards.show(mainPanel, "homePanel");
        frame.add(mainPanel, BorderLayout.CENTER);
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        // frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createHomePanel() {
        // Home panel
        homePanel = new JPanel(new GridBagLayout());
        GridBagConstraints homeGbc = new GridBagConstraints();

        homeTitleLabel = new JLabel("Add Employee Data");
        homeTitleLabel.setFont(new Font("Calibri", Font.BOLD, 48)); // Set font type and size
        homeGbc.insets = new Insets(0, 0, 0, 60);
        homeGbc.gridx = 0;
        homeGbc.gridy = 0;
        homePanel.add(homeTitleLabel, homeGbc);

        homeSubTitleLabel = new JLabel("Select the type of employee to add:");
        homeSubTitleLabel.setFont(new Font("Calibri", Font.ITALIC, 18)); // Set font type and size
        homeGbc.insets = new Insets(0, 0, 20, 60);
        homeGbc.gridy++;
        homePanel.add(homeSubTitleLabel, homeGbc);

        homeLecturerButton = new JButton("Lecturer");
        homeLecturerButton.setFocusPainted(false);
        homeLecturerButton.setPreferredSize(new Dimension(100, 40));
        homeGbc.gridy++;
        homeGbc.insets = new Insets(0, 0, 100, 180);
        homePanel.add(homeLecturerButton, homeGbc);

        homeTutorButton = new JButton("Tutor");
        homeTutorButton.setFocusPainted(false);
        homeTutorButton.setPreferredSize(new Dimension(100, 40));
        homeGbc.insets = new Insets(0, 100, 100, 60);
        homePanel.add(homeTutorButton, homeGbc);

        mainPanel.add(homePanel, "homePanel");
    }

    private void createLecturerPanel() {
        lecturerPanel = new JPanel(new GridLayout(6, 4, 5, 10));
        lecturerPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 170, 10));

        // creating components
        JLabel addALecturer = new JLabel("Add a Lecturer");
        addALecturer.setFont((new Font("Calibri", Font.BOLD, 22)));

        teacherIdLabel = new JLabel("Teacher ID: ");
        teacherIdField = new JTextField(20);

        teacherNameLabel = new JLabel("Name: ");
        teacherNameField = new JTextField(20);

        addressLabel = new JLabel("Address: ");
        addressField = new JTextField(20);

        workingTypeLabel = new JLabel("Working Type: ");
        workingTypeField = new JTextField(20);

        employmentStatusLabel = new JLabel("Employment Status: ");
        employmentStatusField = new JTextField(20);

        workingHoursLabel = new JLabel("Working Hours: ");
        workingHoursField = new JTextField(20);

        yearsOfExperienceLabel = new JLabel("Years of Experience: ");
        yearsOfExperienceField = new JTextField(20);

        departmentLabel = new JLabel("Department: ");
        departmentField = new JTextField(20);

        // new Jlabel() basically fills the other columns so that we can add the other
        // components into desired columns
        lecturerPanel.add(addALecturer);

        lecturerPanel.add(new JLabel());
        lecturerPanel.add(new JLabel());
        lecturerPanel.add(new JLabel());

        lecturerPanel.add(teacherIdLabel);
        lecturerPanel.add(teacherIdField);

        lecturerPanel.add(teacherNameLabel);
        lecturerPanel.add(teacherNameField);

        lecturerPanel.add(addressLabel);
        lecturerPanel.add(addressField);

        lecturerPanel.add(workingTypeLabel);
        lecturerPanel.add(workingTypeField);

        lecturerPanel.add(employmentStatusLabel);
        lecturerPanel.add(employmentStatusField);

        lecturerPanel.add(workingHoursLabel);
        lecturerPanel.add(workingHoursField);

        lecturerPanel.add(yearsOfExperienceLabel);
        lecturerPanel.add(yearsOfExperienceField);

        lecturerPanel.add(departmentLabel);
        lecturerPanel.add(departmentField);

        clearButton = new JButton("Clear");
        clearButton.setFocusPainted(false);
        addLecturer = new JButton("Add");
        addLecturer.setFocusPainted(false);

        lecturerPanel.add(new JLabel());
        lecturerPanel.add(new JLabel());

        lecturerPanel.add(clearButton);
        lecturerPanel.add(addLecturer);

        mainPanel.add(lecturerPanel, "lecturerPanel");
    }

    private void createTutorPanel() {
        tutorPanel = new JPanel(new GridLayout(7, 4, 5, 10));
        tutorPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 130, 10));

        JLabel addATutor = new JLabel("Add a Tutor");
        addATutor.setFont((new Font("Calibri", Font.BOLD, 22)));
        tutorPanel.add(addATutor);
        tutorPanel.add(new JLabel());
        tutorPanel.add(new JLabel());
        tutorPanel.add(new JLabel());

        // creating components for tutor panel
        teacherIdLabel0 = new JLabel("Teacher ID: ");
        teacherIdField0 = new JTextField(20);
        teacherIdLabel0.setPreferredSize(new Dimension(Integer.MAX_VALUE, 50));
        teacherIdField0.setPreferredSize(new Dimension(Integer.MAX_VALUE, 50));

        teacherNameLabel0 = new JLabel("Name: ");
        teacherNameField0 = new JTextField(20);

        addressLabel0 = new JLabel("Address: ");
        addressField0 = new JTextField(20);

        workingTypeLabel0 = new JLabel("Working Type: ");
        workingTypeField0 = new JTextField(20);

        employmentStatusLabel0 = new JLabel("Employment Status: ");
        employmentStatusField0 = new JTextField(20);

        workingHoursLabel0 = new JLabel("Working Hours: ");
        workingHoursField0 = new JTextField(20);

        salaryLabel = new JLabel("Salary: ");
        salaryField = new JTextField(20);

        specializationLabel = new JLabel("Specialization: ");
        specializationField = new JTextField(20);
        academicQualificationsLabel = new JLabel("Academic Qualifications: ");
        academicQualificationsField = new JTextField(20);

        performanceIndexLabel = new JLabel("Performance Index: ");
        performanceIndexField = new JTextField(20);

        // adding components for tutor Panel
        tutorPanel.add(teacherIdLabel0);
        tutorPanel.add(teacherIdField0);

        tutorPanel.add(teacherNameLabel0);
        tutorPanel.add(teacherNameField0);

        tutorPanel.add(addressLabel0);
        tutorPanel.add(addressField0);

        tutorPanel.add(workingTypeLabel0);
        tutorPanel.add(workingTypeField0);

        tutorPanel.add(employmentStatusLabel0);
        tutorPanel.add(employmentStatusField0);

        tutorPanel.add(workingHoursLabel0);
        tutorPanel.add(workingHoursField0);

        tutorPanel.add(salaryLabel);
        tutorPanel.add(salaryField);

        tutorPanel.add(specializationLabel);
        tutorPanel.add(specializationField);

        tutorPanel.add(academicQualificationsLabel);
        tutorPanel.add(academicQualificationsField);

        tutorPanel.add(performanceIndexLabel);
        tutorPanel.add(performanceIndexField);

        clearButton0 = new JButton("Clear");
        clearButton0.setFocusPainted(false);
        addTutor = new JButton("Add");
        addTutor.setFocusPainted(false);

        tutorPanel.add(new JLabel());
        tutorPanel.add(new JLabel());

        tutorPanel.add(clearButton0);
        tutorPanel.add(addTutor);

        mainPanel.add(tutorPanel, "tutorPanel");
    }

    private void createGradePanel() {
        gradePanel = new JPanel(new GridLayout(6, 2, 5, 10));
        gradePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 130, 10));
        gradePanel.setSize(frame.getWidth(), 200);

        // creating and adding component grading panel
        JLabel gradeTheAssigment = new JLabel("Grade Assignment");
        gradeTheAssigment.setFont((new Font("Calibri", Font.BOLD, 22)));
        gradePanel.add(gradeTheAssigment);
        gradePanel.add(new JLabel());

        gradePanel.add(new JLabel("Teacher ID: "));
        teacherIDField2 = new JTextField(20);
        gradePanel.add(teacherIDField2);

        gradedScoreLabel = new JLabel("Graded Score: ");
        gradedScoreField = new JTextField(20);

        gradePanel.add(gradedScoreLabel);
        gradePanel.add(gradedScoreField);

        departmentLabel0 = new JLabel("Department: ");
        departmentField0 = new JTextField(20);
        gradePanel.add(departmentLabel0);
        gradePanel.add(departmentField0);

        yearsOfExperienceLabel0 = new JLabel("Years of experience: ");
        yearsOfExperienceField0 = new JTextField(20);
        gradePanel.add(yearsOfExperienceLabel0);
        gradePanel.add(yearsOfExperienceField0);

        clearButton2 = new JButton("Clear");
        clearButton2.setFocusPainted(false);

        gradeAssignment = new JButton("Grade");
        setSalary.setFocusPainted(false);

        gradePanel.add(clearButton2);
        gradePanel.add(gradeAssignment);

        mainPanel.add(gradePanel, "gradePanel");
    }

    private void createSalaryPanel() {
        salaryPanel = new JPanel(new GridLayout(6, 2, 5, 10));
        salaryPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 130, 10));
        salaryPanel.setSize(frame.getWidth(), 200);

        // creating and adding components for Salary panel
        JLabel setTheSalary = new JLabel("Set new Salary");
        setTheSalary.setFont((new Font("Calibri", Font.BOLD, 22)));
        salaryPanel.add(setTheSalary);
        salaryPanel.add(new JLabel());

        salaryPanel.add(new JLabel("Teacher ID: "));

        teacherIDField1 = new JTextField(20);
        salaryPanel.add(teacherIDField1);

        salaryLabel0 = new JLabel("New Salary: ");
        salaryField0 = new JTextField(20);

        performanceIndexLabel0 = new JLabel("Performance index");
        performanceIndexField0 = new JTextField(20);

        salaryPanel.add(salaryLabel0);
        salaryPanel.add(salaryField0);

        salaryPanel.add(performanceIndexLabel0);
        salaryPanel.add(performanceIndexField0);

        clearButton1 = new JButton("Clear");
        clearButton1.setFocusPainted(false);

        setSalary = new JButton("Set Salary");
        setSalary.setFocusPainted(false);

        salaryPanel.add(clearButton1);
        salaryPanel.add(setSalary);

        mainPanel.add(salaryPanel, "salaryPanel");
    }

    private void createRemoveTutorPanel() {
        removeTutorPanel = new JPanel(new GridLayout(5, 2, 5, 10));
        removeTutorPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 130, 10));
        removeTutorPanel.setSize(frame.getWidth(), 200);

        // creating and adding component for remove tutor panel
        JLabel removeTheTutor = new JLabel("Remove Tutor");
        removeTheTutor.setFont((new Font("Calibri", Font.BOLD, 22)));
        removeTutorPanel.add(removeTheTutor);
        removeTutorPanel.add(new JLabel());

        removeTutorPanel.add(new JLabel("Teacher ID: "));
        teacherIDField3 = new JTextField(20);
        removeTutorPanel.add(teacherIDField3);

        clearButton3 = new JButton("Clear");
        clearButton3.setFocusPainted(false);

        removeTutor = new JButton("Remove");
        setSalary.setFocusPainted(false);

        removeTutorPanel.add(clearButton3);
        removeTutorPanel.add(removeTutor);

        mainPanel.add(removeTutorPanel, "removeTutorPanel");
    }

    private void createDisplayPanel() {
        displayPanel = new JPanel(new GridLayout(10,10));

        // adding the title for display panel
        JLabel displayTheTutor = new JLabel("Click on teacher ID to display their info");
        displayTheTutor.setFont((new Font("Calibri", Font.BOLD, 22)));
        displayPanel.add(displayTheTutor);

        int length = teachersList.size();
        JButton[] buttons = new JButton[length];

        for (Teacher teacher : teachersList) {
            int i = 0;
            int teacherId = teacher.getTeacherId();
            buttons[i] = new JButton(String.valueOf(teacherId));

            buttons[i].setBackground(new Color(26, 214, 173));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFocusPainted(false);

            displayPanel.add(buttons[i]);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Creating a new panel where all info of indivisuals teachers is shown
                    JPanel teacherInfoPanel = new JPanel(new GridLayout(5, 4));
                    teacherInfoPanel.setPreferredSize(new Dimension(700, 200));

                    // initializing variables with values stored
                    String name = teacher.getTeacherName();
                    String address = teacher.getAddress();
                    String employmentStatus = teacher.getEmploymentStatus();
                    int workingHours = teacher.getWorkingHours();
                    String workingType = teacher.getWorkingType();

                    teacherInfoPanel.add(new JLabel("name: "));
                    teacherInfoPanel.add(new JLabel(name));

                    teacherInfoPanel.add(new JLabel("Address: "));
                    teacherInfoPanel.add(new JLabel(address));

                    teacherInfoPanel.add(new JLabel("Employment Status: "));
                    teacherInfoPanel.add(new JLabel(employmentStatus));

                    teacherInfoPanel.add(new JLabel("Working Hours: "));
                    teacherInfoPanel.add(new JLabel(String.valueOf(workingHours)));

                    teacherInfoPanel.add(new JLabel("Working Type: "));
                    teacherInfoPanel.add(new JLabel(workingType));

                    if (teacher instanceof Lecturer) {
                        // If it is lecturer then we display lecturer details too
                        Lecturer lecturer = (Lecturer) teacher;
                        String department = lecturer.getDepartment();
                        char grade = lecturer.getGrade();
                        int gradedScore = lecturer.getGradedScore();
                        int yearsOfExperience = lecturer.getYearsOfExperience();
                        boolean hasGraded = lecturer.hasGraded();

                        teacherInfoPanel.add(new JLabel("Department: "));
                        teacherInfoPanel.add(new JLabel(department));
                        

                        teacherInfoPanel.add(new JLabel("Grade: "));
                        teacherInfoPanel.add(new JLabel(String.valueOf(grade)));

                        teacherInfoPanel.add(new JLabel("Graded Score: "));
                        teacherInfoPanel.add(new JLabel(String.valueOf(gradedScore)));

                        teacherInfoPanel.add(new JLabel("Years of Experience: "));
                        teacherInfoPanel.add(new JLabel(String.valueOf(yearsOfExperience)));

                        teacherInfoPanel.add(new JLabel("Has Graded: "));
                        teacherInfoPanel.add(new JLabel(String.valueOf(hasGraded)));

                    } else if (teacher instanceof Tutor) {
                        Tutor tutor = (Tutor) teacher;
                        
                        teacherInfoPanel.add(new JLabel("Academic Qualifications: "));
                        teacherInfoPanel.add(new JLabel(tutor.getAcademicQualifications()));

                        teacherInfoPanel.add(new JLabel("Performance Index: "));
                        teacherInfoPanel.add(new JLabel(String.valueOf(tutor.getPerformanceIndex())));

                        teacherInfoPanel.add(new JLabel("Salary: "));
                        teacherInfoPanel.add(new JLabel(String.valueOf(tutor.getSalary())));
                        
                        teacherInfoPanel.add(new JLabel("Sepecialization: "));
                        teacherInfoPanel.add(new JLabel(String.valueOf(tutor.getSpecialization())));

                        teacherInfoPanel.add(new JLabel("Is Certifed: "));
                        teacherInfoPanel.add(new JLabel(String.valueOf(tutor.isCertified())));
                        
                    }

                    JOptionPane.showConfirmDialog(frame, teacherInfoPanel, "Teacher Information", JOptionPane.OK_OPTION);
                }
            });
        }
        mainPanel.add(displayPanel, "displayPanel");
    }

    private void clearFieldsButtons() {
        JTextField[] textfields = { teacherIdField0, teacherNameField0, addressField0, workingTypeField0,
                employmentStatusField0, workingHoursField0, specializationField, academicQualificationsField,
                performanceIndexField, salaryField0, teacherIDField1, teacherIDField2, teacherIDField3,
                yearsOfExperienceField0, departmentField0, teacherIdField, teacherNameField, addressField,
                workingTypeField, employmentStatusField, workingHoursField, departmentField, yearsOfExperienceField,
                gradedScoreField, salaryField, performanceIndexField0 };

        int option = JOptionPane.showConfirmDialog(frame, "Clear all fields?", "Please Confirm",
                JOptionPane.OK_CANCEL_OPTION);
        // Process the input based on user's choice
        if (option == JOptionPane.OK_OPTION) {
            for (JTextField textfield : textfields) {
                textfield.setText("");
            }
        }
    }

    private void clearFields() {
        JTextField[] textfields = { teacherIdField0, teacherNameField0, addressField0, workingTypeField0,
                employmentStatusField0, workingHoursField0, specializationField, academicQualificationsField,
                performanceIndexField, salaryField0, teacherIDField1, teacherIDField2, teacherIDField3,
                yearsOfExperienceField0, departmentField0, teacherIdField, teacherNameField, addressField,
                workingTypeField, employmentStatusField, workingHoursField, departmentField, yearsOfExperienceField,
                gradedScoreField, salaryField, performanceIndexField0 };

        for (JTextField textfield : textfields) {
            textfield.setText("");
        }
    }

    private void mainButtonsLogic() {
        addLecturerLogic();
        addTutorLogic();
        gradeAssignmentLogic();
        setSalaryLogic();
        removeTutorLogic();
    }

    private void addLecturerLogic() {
        // *************** Logic to add a lecturer****************/
        addLecturer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teacherName, address, workingType, employmentStatus, department;
                int teacherID, workingHours, yearsOfExperience;
                int count = 0;
                try {
                    teacherName = teacherNameField.getText().strip();
                    address = addressField.getText().strip();
                    workingType = workingTypeField.getText().strip();
                    employmentStatus = employmentStatusField.getText().strip();
                    department = departmentField.getText().strip();

                    if (teacherName.equals("") ||
                            address.equals("") ||
                            workingType.equals("") ||
                            employmentStatus.equals("") ||
                            department.equals("")) {

                        JOptionPane.showMessageDialog(frame, "Please Look for empty fields", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    } else {
                        teacherID = Integer.parseInt(teacherIdField.getText().strip());
                        workingHours = Integer.parseInt(workingHoursField.getText().strip());
                        yearsOfExperience = Integer.parseInt(yearsOfExperienceField.getText().strip());
                        
                        for (Teacher teacher : teachersList) {
                            if(teacher.getTeacherId() == teacherID){
                                count++;
                            } 
                        }
                        if(count == 0){
                            Lecturer lecturer = new Lecturer(teacherID, teacherName, address, workingType, employmentStatus,
                                    department, yearsOfExperience, workingHours);
                            teachersList.add(lecturer);
                            JOptionPane.showMessageDialog(frame, "The lecturer has been added",
                                    "Lecturer added Sucessfully", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(frame, "Teacher ID already exists",
                                    "Error", JOptionPane.INFORMATION_MESSAGE);
                        }

                        
                    }
                    clearFields();

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, "Please enter appropriate values.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void addTutorLogic() {
        // *************** Logic to add a Tutor*************************/
        addTutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teacherName, address, workingType, employmentStatus, specialization, academicQualifications;
                int teacherID, workingHours, salary, performanceIndex;
                int count = 0;
                try {

                    teacherName = teacherNameField0.getText().strip();
                    address = addressField0.getText().strip();
                    workingType = workingTypeField0.getText().strip();
                    employmentStatus = employmentStatusField0.getText().strip();

                    specialization = specializationField.getText().strip();
                    academicQualifications = academicQualificationsField.getText().strip();

                    if (teacherName.equals("") ||
                            address.equals("") ||
                            workingType.equals("") ||
                            employmentStatus.equals("") ||
                            specialization.equals("") ||
                            academicQualifications.equals("")) {
                        JOptionPane.showMessageDialog(frame, "Please Look for empty fields", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    } else {
                        teacherID = Integer.parseInt(teacherIdField0.getText().strip());
                        workingHours = Integer.parseInt(workingHoursField0.getText().strip());
                        salary = Integer.parseInt(salaryField.getText().strip());
                        performanceIndex = Integer.parseInt(performanceIndexField.getText().strip());
                        for (Teacher teacher : teachersList) {
                            if(teacher.getTeacherId() == teacherID){
                                count++;
                            } 
                        }
                        if(count == 0){
                            Tutor tutor = new Tutor(teacherID, teacherName, address, workingType, employmentStatus,
                                workingHours, salary, specialization, academicQualifications, performanceIndex);
                        teachersList.add(tutor);
                        JOptionPane.showMessageDialog(frame, "The Tutor has been added",
                                "Lecturer added Sucessfully", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(frame, "Teacher ID already exists",
                                    "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        
                    }
                    clearFields();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, "Please enter appropriate values.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void gradeAssignmentLogic() {
        // *************** Logic to Grade Assignments**************/

        gradeAssignment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String department;
                int teacherID, gradedScore, yearsOfExperience;
                try {
                    department = departmentField0.getText().strip();
                    if (department.equals("")) {
                        JOptionPane.showMessageDialog(frame, "Please Look for empty fields", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        teacherID = Integer.parseInt(teacherIDField2.getText().strip());
                        gradedScore = Integer.parseInt(gradedScoreField.getText().strip());
                        yearsOfExperience = Integer.parseInt(yearsOfExperienceField0.getText().strip());

                        JPanel confirmPanel = new JPanel(new GridLayout(4, 2, 5, 5));
                        JLabel idLabel, scoreLabel, departmentLabel, experienceLabel;
                        JTextField idField, scoreField, departmentField, experienceField;

                        idLabel = new JLabel("Teacher ID:");
                        scoreLabel = new JLabel("Graded Score:");
                        departmentLabel = new JLabel("Department:");
                        experienceLabel = new JLabel("Years of experience:");

                        idField = new JTextField(20);
                        scoreField = new JTextField(20);
                        departmentField = new JTextField(20);
                        experienceField = new JTextField(20);

                        idField.setEditable(false);
                        scoreField.setEditable(false);
                        departmentField.setEditable(false);
                        experienceField.setEditable(false);

                        idField.setText(String.valueOf(teacherID));
                        scoreField.setText(String.valueOf(gradedScore));
                        departmentField.setText(department);
                        experienceField.setText(String.valueOf(yearsOfExperience));

                        confirmPanel.add(idLabel);
                        confirmPanel.add(idField);

                        confirmPanel.add(scoreLabel);
                        confirmPanel.add(scoreField);

                        confirmPanel.add(departmentLabel);
                        confirmPanel.add(departmentField);

                        confirmPanel.add(experienceLabel);
                        confirmPanel.add(experienceField);

                        int option = JOptionPane.showConfirmDialog(frame, confirmPanel, "Please Confirm",
                                JOptionPane.OK_CANCEL_OPTION);
                        // Process the input based on user's choice
                        if (option == JOptionPane.OK_OPTION) {
                            int counter = 0;
                            for (Teacher teacher : teachersList) {
                                if (teacher instanceof Lecturer) {
                                    Lecturer lecturer = (Lecturer) teacher;
                                    if (lecturer.getTeacherId() == teacherID) {
                                        counter++;
                                        lecturer.gradeAssignment(gradedScore, department, yearsOfExperience);
                                    }
                                }
                            }
                            if (counter == 0) {
                                JOptionPane.showMessageDialog(frame, "Lecturer ID did not match", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(frame, "Assignment Graded", "Successfull",
                                        JOptionPane.INFORMATION_MESSAGE);
                                clearFields();
                            }
                        }
                    }

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, "Please enter appropriate values.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void setSalaryLogic() {
        // *****************************************LogictoSetSalary*************************************************
        setSalary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id, performanceIndex;
                Double salary;
                try {
                    id = Integer.parseInt(teacherIDField1.getText().strip());
                    salary = Double.parseDouble(salaryField0.getText().strip());
                    performanceIndex = Integer.parseInt(performanceIndexField0.getText().strip());

                    JPanel confirmPanel = new JPanel(new GridLayout(3, 2, 5, 5));
                    JTextField idField, salaryField, performanceIndexField;

                    idField = new JTextField(20);
                    idField.setEditable(false);
                    idField.setText(String.valueOf(id));

                    salaryField = new JTextField(20);
                    salaryField.setEditable(false);
                    salaryField.setText(String.valueOf(salary));

                    performanceIndexField = new JTextField(20);
                    performanceIndexField.setEditable(false);
                    performanceIndexField.setText(String.valueOf(performanceIndex));

                    confirmPanel.add(new JLabel("Teacher id: "));
                    confirmPanel.add(idField);
                    confirmPanel.add(new JLabel("New Salary: "));
                    confirmPanel.add(salaryField);
                    confirmPanel.add(new JLabel("New Performance Index: "));
                    confirmPanel.add(performanceIndexField);

                    int option = JOptionPane.showConfirmDialog(frame, confirmPanel, "Please Confirm",
                            JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        int counter = 0;
                        for (Teacher teacher : teachersList) {
                            if (teacher instanceof Tutor) {
                                Tutor tutor = (Tutor) teacher;
                                if (tutor.getTeacherId() == id) {
                                    counter++;
                                    tutor.setSalary(salary, performanceIndex);
                                }
                            }
                        }
                        if (counter == 0) {
                            JOptionPane.showMessageDialog(frame, "Tutor ID did not match", "Error",
                                    JOptionPane.ERROR_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(frame, "New Salary set", "Successfull",
                                    JOptionPane.INFORMATION_MESSAGE);
                            clearFields();
                        }
                    }

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, "Please enter appropriate values.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void removeTutorLogic() {
        // *****************************************LogictoremoveTutor*************************************************
        // **/
        removeTutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(teacherIDField3.getText().strip());
                    JPanel confirmPanel = new JPanel(new GridLayout(2, 2, 5, 5));
                    JTextField idField;

                    idField = new JTextField(20);
                    idField.setEditable(false);
                    idField.setText(String.valueOf(id));

                    confirmPanel.add(new JLabel("Teacher id: "));
                    confirmPanel.add(idField);

                    int option = JOptionPane.showConfirmDialog(frame, confirmPanel, "Please Confirm",
                            JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        int counter = 0;
                        for (Teacher teacher : teachersList) {
                            if (teacher instanceof Tutor) {
                                Tutor tutor = (Tutor) teacher;
                                if (tutor.getTeacherId() == id) {
                                    counter++;
                                    tutor.removeTutor();
                                    teachersList.remove(teacher);
                                    break;
                                }
                            }
                        }
                        if (counter == 0) {
                            JOptionPane.showMessageDialog(frame, "Tutor ID did not match", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Tutor removed", "Successfull",
                                    JOptionPane.INFORMATION_MESSAGE);
                            clearFields();
                        }
                    }

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, "Please enter appropriate values.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Create and show GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TeacherGUI();
            }
        });
    }
}