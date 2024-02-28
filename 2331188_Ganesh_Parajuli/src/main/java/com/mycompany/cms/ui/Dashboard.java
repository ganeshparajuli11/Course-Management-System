
package com.mycompany.cms.ui;


import com.mycompany.cms.dao.CoursesDao;
import com.mycompany.cms.dao.ModuleDao;
import com.mycompany.cms.dao.PersonDao;
import com.mycompany.cms.dao.StudentDao;
import com.mycompany.cms.dao.TeacherDao;
import com.mycompany.cms.dao.imp.CoursesDaoImp;
import com.mycompany.cms.dao.imp.ModuleDaoImp;
import com.mycompany.cms.dao.imp.PersonDaoImp;
import com.mycompany.cms.dao.imp.StudentDaoImp;
import com.mycompany.cms.dao.imp.TeacherDaoImp;
import com.mycompany.cms.person.Courses;
import com.mycompany.cms.person.Modules;
import com.mycompany.cms.person.Person;
import com.mycompany.cms.person.Student;
import com.mycompany.cms.person.Teacher;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class Dashboard extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private final PersonDao personDao = new PersonDaoImp();
    private final CoursesDao courseDao = new CoursesDaoImp();
    private final ModuleDao moduleDao = new ModuleDaoImp();
    private final TeacherDao teacherDao = new TeacherDaoImp();
    private final StudentDao studentDao = new StudentDaoImp();
               

    private final String[] columns = new String[]{"Id", "Name", "Email"};
    private final String[] columnsCourse = new String[]{"Id", "Course Name"};
    private final String[] modulesModule = new String[]{"Id", "Module Name", "Module level"};
    private final String[] gradeColumns = new String[]{"Id", "Grade", "Module"};
    private final String[] gradeModule = new String[]{"Id","Name","Grade"};

    private final DefaultTableModel model = new DefaultTableModel();
    private final DefaultTableModel model1 = new DefaultTableModel();
    private final DefaultTableModel model2 = new DefaultTableModel();
    private final DefaultTableModel model3 = new DefaultTableModel();
    private final DefaultTableModel model4 = new DefaultTableModel();
    private final DefaultTableModel model5 = new DefaultTableModel();

     private final Person user;

    public Dashboard(Person person) throws SQLException, ClassNotFoundException {
        this.user = person;
        initComponents();
        setUpTableModel();
        findAllStudent();
        findAllTeacher();
        findAllCourses();
        findAllModules();
            
         if(!person.getUsertype().equals("admin")){
             resultPanel.setVisible(false);
             jPanel3.setVisible(false);
             jPanel2.setVisible(false);
             adminAccessStudent1.setVisible(false);
             adminAccessStudent.setVisible(false);
         }
         if(!person.getUsertype().equals("teacher")){
             gradePanel.setVisible(false);
         }
        showFeatures.removeAll();
        showFeatures.add(homePanel);
        showFeatures.repaint();
        showFeatures.revalidate();
        viewTotal();
        if(this.user.getUsertype().equals("teacher")){
            gradeButton.setVisible(true);
            resultButton.setVisible(false);
           enrollModulePanel.setVisible(false);
            currentUsername.setText(person.getfName()+ " " +person.getlName());
            currentUserLevel.setVisible(false);
            jLabel32.setVisible(false);
       }else{
            gradeButton.setVisible(false);
        }
        
         if(this.user.getUsertype().equals("admin")){
            gradeButton.setVisible(false);
            enrollModulePanel.setVisible(false);
            currentUsername.setText(person.getfName()+ " " +person.getlName());
            currentUserLevel.setVisible(false);
            jLabel32.setVisible(false);
       }

         if(this.user.getUsertype().equals("student")){
             Student student = new Student();
            gradeButton.setVisible(false);
            resultPanel.setVisible(false);
            resultSlip.setVisible(true);
            resultButton.setVisible(true);
//          enrollModulePanel.setVisible(true);
            jScrollPane4.setVisible(true);

            currentUsername.setText(person.getfName()+ " " +person.getlName());
            currentUserLevel.setText(student.getGrade());
       }

    }

    private Dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setUpTableModel() {
        studentTable.setModel(model);
        teacherTable.setModel(model1);
        studentTable2.setModel(model2);
        studentTable3.setModel(model3);
        gradeTable.setModel(model4);
        jTable1.setModel(model5);

        model.setColumnIdentifiers(columns);
        model1.setColumnIdentifiers(columns);
        model2.setColumnIdentifiers(columnsCourse);
        model3.setColumnIdentifiers(modulesModule);
        model4.setColumnIdentifiers(gradeColumns);
        model5.setColumnIdentifiers(gradeModule);

                

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        homebutton = new javax.swing.JButton();
        studentbutton = new javax.swing.JButton();
        teacherbutton = new javax.swing.JButton();
        resultButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        coursebutton = new javax.swing.JButton();
        moduleButton = new javax.swing.JButton();
        gradeButton = new javax.swing.JButton();
        showFeatures = new javax.swing.JPanel();
        resultSlip = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        gradePanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        gardeName = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        editGrade = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        moduleForGrade = new javax.swing.JLabel();
        resultPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        gradeTable = new javax.swing.JTable();
        searchGradeButton = new javax.swing.JButton();
        remarks = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        modulePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        userfName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        moduleLevel = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        courseId = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        editButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        level5RadioButton = new javax.swing.JRadioButton();
        level6RadioButton = new javax.swing.JRadioButton();
        level4RadioButton = new javax.swing.JRadioButton();
        level7RadioButton = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        optionalCourseComboBox1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        searchStudentTextField2 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        studentTable3 = new javax.swing.JTable();
        enrollModulePanel = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        coursePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        courseNameTxtField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        addCourse = new javax.swing.JButton();
        editCourse = new javax.swing.JButton();
        deleteCourse = new javax.swing.JButton();
        CourseScrollPane = new javax.swing.JScrollPane();
        studentTable2 = new javax.swing.JTable();
        teacherPanel = new javax.swing.JPanel();
        adminAccessStudent1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        userfNameTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        emailTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        passwordPasswordField1 = new javax.swing.JPasswordField();
        addTeacher = new javax.swing.JButton();
        editTeacher = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lastNameTextField1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        module = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        searchStudentTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        teacherTable = new javax.swing.JTable();
        studentPanel = new javax.swing.JPanel();
        adminAccessStudent = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userfNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passwordPasswordField = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        studentGrade = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        searchStudentTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        homePanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        totalStudents = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        totalTeacher = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        totalCourses = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        totalModules = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        currentUsername = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        currentUserLevel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        homebutton.setBackground(new java.awt.Color(0, 0, 153));
        homebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        homebutton.setForeground(new java.awt.Color(255, 255, 255));
        homebutton.setText("Home");
        homebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebuttonActionPerformed(evt);
            }
        });

        studentbutton.setBackground(new java.awt.Color(0, 0, 153));
        studentbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentbutton.setForeground(new java.awt.Color(255, 255, 255));
        studentbutton.setText("Student");
        studentbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentbuttonActionPerformed(evt);
            }
        });

        teacherbutton.setBackground(new java.awt.Color(0, 0, 153));
        teacherbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        teacherbutton.setForeground(new java.awt.Color(255, 255, 255));
        teacherbutton.setText("Teacher");
        teacherbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherbuttonActionPerformed(evt);
            }
        });

        resultButton.setBackground(new java.awt.Color(0, 0, 153));
        resultButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        resultButton.setForeground(new java.awt.Color(255, 255, 255));
        resultButton.setText("Result");
        resultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(0, 0, 153));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Log out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        coursebutton.setBackground(new java.awt.Color(0, 0, 153));
        coursebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        coursebutton.setForeground(new java.awt.Color(255, 255, 255));
        coursebutton.setText("Course");
        coursebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursebuttonActionPerformed(evt);
            }
        });

        moduleButton.setBackground(new java.awt.Color(0, 0, 153));
        moduleButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        moduleButton.setForeground(new java.awt.Color(255, 255, 255));
        moduleButton.setText("Module");
        moduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moduleButtonActionPerformed(evt);
            }
        });

        gradeButton.setBackground(new java.awt.Color(0, 0, 153));
        gradeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gradeButton.setForeground(new java.awt.Color(255, 255, 255));
        gradeButton.setText("Grade");
        gradeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gradeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coursebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(homebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(teacherbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(coursebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(moduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gradeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        showFeatures.setLayout(new java.awt.CardLayout());

        resultSlip.setBackground(new java.awt.Color(58, 72, 146));

        jPanel9.setBackground(new java.awt.Color(0, 0, 153));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Name: ");

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Ganesh Parajuli");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Level :");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("5");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Course:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Bachelor in Computer Science");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Remarks:");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Pass");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                            .addComponent(jLabel41))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout resultSlipLayout = new javax.swing.GroupLayout(resultSlip);
        resultSlip.setLayout(resultSlipLayout);
        resultSlipLayout.setHorizontalGroup(
            resultSlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultSlipLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1816, Short.MAX_VALUE))
        );
        resultSlipLayout.setVerticalGroup(
            resultSlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultSlipLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        showFeatures.add(resultSlip, "card9");

        gradePanel.setBackground(new java.awt.Color(58, 72, 146));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable1);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Search by id:");

        jButton9.setBackground(new java.awt.Color(0, 0, 153));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Search");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Name:");

        gardeName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gardeName.setForeground(new java.awt.Color(255, 255, 255));
        gardeName.setText("Mandip Raut");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Grade:");

        jTextField5.setText("55.00");

        editGrade.setBackground(new java.awt.Color(0, 0, 153));
        editGrade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editGrade.setForeground(new java.awt.Color(255, 255, 255));
        editGrade.setText("Edit");
        editGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editGradeActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Module:");

        moduleForGrade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        moduleForGrade.setForeground(new java.awt.Color(255, 255, 255));
        moduleForGrade.setText("OOP");

        javax.swing.GroupLayout gradePanelLayout = new javax.swing.GroupLayout(gradePanel);
        gradePanel.setLayout(gradePanelLayout);
        gradePanelLayout.setHorizontalGroup(
            gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradePanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gradePanelLayout.createSequentialGroup()
                        .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gardeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(moduleForGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(335, 335, 335)
                .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(gradePanelLayout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1235, Short.MAX_VALUE))
        );
        gradePanelLayout.setVerticalGroup(
            gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradePanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradePanelLayout.createSequentialGroup()
                        .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradePanelLayout.createSequentialGroup()
                        .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(gardeName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(moduleForGrade))
                        .addGap(17, 17, 17)
                        .addGroup(gradePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(editGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        showFeatures.add(gradePanel, "card8");

        resultPanel.setBackground(new java.awt.Color(58, 72, 146));

        jPanel4.setBackground(new java.awt.Color(58, 72, 146));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Search by id:");

        gradeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(gradeTable);

        searchGradeButton.setBackground(new java.awt.Color(0, 0, 153));
        searchGradeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchGradeButton.setForeground(new java.awt.Color(255, 255, 255));
        searchGradeButton.setText("Search");
        searchGradeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchGradeButtonActionPerformed(evt);
            }
        });

        remarks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        remarks.setForeground(new java.awt.Color(255, 255, 255));
        remarks.setText("Pass");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Name:");

        name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Mandip Raut");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Remarks : ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchGradeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remarks)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchGradeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remarks)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(125, 125, 125))
        );

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1617, Short.MAX_VALUE))
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        showFeatures.add(resultPanel, "card7");

        modulePanel.setBackground(new java.awt.Color(58, 72, 146));

        jPanel3.setBackground(new java.awt.Color(58, 72, 146));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Module Name:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Module level:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Course id:");

        courseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseIdActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 0, 153));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Add");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        editButton3.setBackground(new java.awt.Color(0, 0, 153));
        editButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editButton3.setForeground(new java.awt.Color(255, 255, 255));
        editButton3.setText("Edit");
        editButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton3ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 0, 153));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Level");

        level5RadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        level5RadioButton.setForeground(new java.awt.Color(51, 51, 51));
        level5RadioButton.setText("5");

        level6RadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        level6RadioButton.setForeground(new java.awt.Color(51, 51, 51));
        level6RadioButton.setText("6");

        level4RadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        level4RadioButton.setForeground(new java.awt.Color(51, 51, 51));
        level4RadioButton.setText("4");
        level4RadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level4RadioButtonActionPerformed(evt);
            }
        });

        level7RadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        level7RadioButton.setForeground(new java.awt.Color(51, 51, 51));
        level7RadioButton.setText("7");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Optional ");

        optionalCourseComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        optionalCourseComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "yes", "no" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(moduleLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(userfName, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(courseId, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(level4RadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(level5RadioButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(level6RadioButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(level7RadioButton)))
                    .addComponent(optionalCourseComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userfName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moduleLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(level5RadioButton)
                    .addComponent(level4RadioButton)
                    .addComponent(level6RadioButton)
                    .addComponent(level7RadioButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionalCourseComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Search:");

        searchStudentTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchStudentTextField2KeyReleased(evt);
            }
        });

        studentTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(studentTable3);

        enrollModulePanel.setBackground(new java.awt.Color(58, 72, 146));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Select Optional Module");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OOP", "NMC", "AI", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 0, 153));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Enroll");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 0, 153));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Remove");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Module Enroll or Remove");

        javax.swing.GroupLayout enrollModulePanelLayout = new javax.swing.GroupLayout(enrollModulePanel);
        enrollModulePanel.setLayout(enrollModulePanelLayout);
        enrollModulePanelLayout.setHorizontalGroup(
            enrollModulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enrollModulePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(enrollModulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(enrollModulePanelLayout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12))
                    .addComponent(jLabel34))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        enrollModulePanelLayout.setVerticalGroup(
            enrollModulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enrollModulePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(enrollModulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout modulePanelLayout = new javax.swing.GroupLayout(modulePanel);
        modulePanel.setLayout(modulePanelLayout);
        modulePanelLayout.setHorizontalGroup(
            modulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modulePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modulePanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(searchStudentTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(enrollModulePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1171, 1171, 1171))
        );
        modulePanelLayout.setVerticalGroup(
            modulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modulePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(modulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enrollModulePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(modulePanelLayout.createSequentialGroup()
                        .addGroup(modulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(searchStudentTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        showFeatures.add(modulePanel, "card6");

        coursePanel.setBackground(new java.awt.Color(58, 72, 146));

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Course Name:");

        addCourse.setBackground(new java.awt.Color(0, 0, 153));
        addCourse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addCourse.setForeground(new java.awt.Color(255, 255, 255));
        addCourse.setText("Add");
        addCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseActionPerformed(evt);
            }
        });

        editCourse.setBackground(new java.awt.Color(0, 0, 153));
        editCourse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editCourse.setForeground(new java.awt.Color(255, 255, 255));
        editCourse.setText("Edit");
        editCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCourseActionPerformed(evt);
            }
        });

        deleteCourse.setBackground(new java.awt.Color(0, 0, 153));
        deleteCourse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteCourse.setForeground(new java.awt.Color(255, 255, 255));
        deleteCourse.setText("Delete");
        deleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(courseNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        studentTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        CourseScrollPane.setViewportView(studentTable2);

        javax.swing.GroupLayout coursePanelLayout = new javax.swing.GroupLayout(coursePanel);
        coursePanel.setLayout(coursePanelLayout);
        coursePanelLayout.setHorizontalGroup(
            coursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursePanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(CourseScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1315, Short.MAX_VALUE))
        );
        coursePanelLayout.setVerticalGroup(
            coursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursePanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(coursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CourseScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(211, Short.MAX_VALUE))
        );

        showFeatures.add(coursePanel, "card5");

        teacherPanel.setBackground(new java.awt.Color(58, 72, 146));

        adminAccessStudent1.setBackground(new java.awt.Color(58, 72, 146));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("First Name");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email");

        emailTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextField1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password");

        addTeacher.setBackground(new java.awt.Color(0, 0, 153));
        addTeacher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addTeacher.setForeground(new java.awt.Color(255, 255, 255));
        addTeacher.setText("Add");
        addTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeacherActionPerformed(evt);
            }
        });

        editTeacher.setBackground(new java.awt.Color(0, 0, 153));
        editTeacher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editTeacher.setForeground(new java.awt.Color(255, 255, 255));
        editTeacher.setText("Edit");
        editTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTeacherActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 153));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Last Name");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Module Id:");

        javax.swing.GroupLayout adminAccessStudent1Layout = new javax.swing.GroupLayout(adminAccessStudent1);
        adminAccessStudent1.setLayout(adminAccessStudent1Layout);
        adminAccessStudent1Layout.setHorizontalGroup(
            adminAccessStudent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAccessStudent1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(adminAccessStudent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminAccessStudent1Layout.createSequentialGroup()
                        .addGroup(adminAccessStudent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userfNameTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel24)
                            .addComponent(emailTextField1)
                            .addComponent(lastNameTextField1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(adminAccessStudent1Layout.createSequentialGroup()
                        .addGroup(adminAccessStudent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(module)
                            .addGroup(adminAccessStudent1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 304, Short.MAX_VALUE))
                            .addComponent(passwordPasswordField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adminAccessStudent1Layout.createSequentialGroup()
                        .addComponent(addTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        adminAccessStudent1Layout.setVerticalGroup(
            adminAccessStudent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAccessStudent1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userfNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGroup(adminAccessStudent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminAccessStudent1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel9)
                        .addGap(0, 179, Short.MAX_VALUE))
                    .addGroup(adminAccessStudent1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(module, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(adminAccessStudent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Search:");

        searchStudentTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchStudentTextField1KeyReleased(evt);
            }
        });

        teacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(teacherTable);

        javax.swing.GroupLayout teacherPanelLayout = new javax.swing.GroupLayout(teacherPanel);
        teacherPanel.setLayout(teacherPanelLayout);
        teacherPanelLayout.setHorizontalGroup(
            teacherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teacherPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(adminAccessStudent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(teacherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(teacherPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchStudentTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 1419, Short.MAX_VALUE))
        );
        teacherPanelLayout.setVerticalGroup(
            teacherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teacherPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(teacherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(teacherPanelLayout.createSequentialGroup()
                        .addComponent(adminAccessStudent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(teacherPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(teacherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchStudentTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        showFeatures.add(teacherPanel, "card4");

        studentPanel.setBackground(new java.awt.Color(58, 72, 146));

        adminAccessStudent.setBackground(new java.awt.Color(58, 72, 146));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name");

        userfNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email");

        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");

        passwordPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(0, 0, 153));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Last Name");

        lastNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Select Level");

        studentGrade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        studentGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "5", "6", "7" }));

        javax.swing.GroupLayout adminAccessStudentLayout = new javax.swing.GroupLayout(adminAccessStudent);
        adminAccessStudent.setLayout(adminAccessStudentLayout);
        adminAccessStudentLayout.setHorizontalGroup(
            adminAccessStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAccessStudentLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(adminAccessStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminAccessStudentLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adminAccessStudentLayout.createSequentialGroup()
                        .addGroup(adminAccessStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(adminAccessStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(adminAccessStudentLayout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastNameTextField)
                                .addComponent(emailTextField)
                                .addComponent(passwordPasswordField)
                                .addComponent(userfNameTextField)
                                .addComponent(jLabel7))
                            .addComponent(jLabel36))
                        .addGap(0, 54, Short.MAX_VALUE))))
        );
        adminAccessStudentLayout.setVerticalGroup(
            adminAccessStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminAccessStudentLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userfNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(adminAccessStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, adminAccessStudentLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(adminAccessStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search:");

        searchStudentTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchStudentTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchStudentTextFieldKeyReleased(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        studentTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(studentTable);

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminAccessStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(searchStudentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1403, Short.MAX_VALUE))
        );
        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminAccessStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(studentPanelLayout.createSequentialGroup()
                        .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchStudentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 167, Short.MAX_VALUE)))
                .addContainerGap())
        );

        showFeatures.add(studentPanel, "card3");

        homePanel.setBackground(new java.awt.Color(58, 72, 146));

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Total Students");

        totalStudents.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalStudents.setForeground(new java.awt.Color(255, 255, 255));
        totalStudents.setText("2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel20))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(totalStudents)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(totalStudents)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 153));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Total Teachers");

        totalTeacher.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalTeacher.setForeground(new java.awt.Color(255, 255, 255));
        totalTeacher.setText("3");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel21))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(totalTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(totalTeacher)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 0, 153));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Total Courses");

        totalCourses.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalCourses.setForeground(new java.awt.Color(255, 255, 255));
        totalCourses.setText("3");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(totalCourses)
                        .addGap(95, 95, 95))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(totalCourses)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 0, 153));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Total Module");

        totalModules.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalModules.setForeground(new java.awt.Color(255, 255, 255));
        totalModules.setText("6");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(totalModules)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(43, 43, 43))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalModules)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Current User :");

        currentUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        currentUsername.setForeground(new java.awt.Color(255, 255, 255));
        currentUsername.setText("Mandip Raut");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Level             :");

        currentUserLevel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        currentUserLevel.setForeground(new java.awt.Color(255, 255, 255));
        currentUserLevel.setText("5");

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(currentUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addComponent(currentUserLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(65, 65, 65))))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 1408, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(currentUsername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentUserLevel)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(235, 235, 235))
        );

        showFeatures.add(homePanel, "card2");

        getContentPane().add(showFeatures, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebuttonActionPerformed
        
        showFeatures.removeAll();
        showFeatures.add(homePanel);
        showFeatures.repaint();
        showFeatures.revalidate();
        try {
            viewTotal();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_homebuttonActionPerformed

    private void viewTotal() throws SQLException, ClassNotFoundException{
        List<Student> students = studentDao.findAll();
        List<Teacher> teacher = teacherDao.findAll();
        List<Modules> module1 = moduleDao.findAll();
        List<Courses> course = courseDao.findAll();
        totalStudents.setText(String.valueOf(students.size()));
        totalTeacher.setText(String.valueOf(teacher.size()));
        totalModules.setText(String.valueOf(module1.size()));
        totalCourses.setText(String.valueOf(course.size()));
    }
    private void findAllStudent() throws SQLException, ClassNotFoundException {
        model.setRowCount(0);
        List<Person> persons = personDao.findAllStudent();
        for (Person person : persons) {
            Object[] row = {person.getId(), person.getfName()+ " "+person.getlName(), person.getEmail()};
            
            model.addRow(row);
            
        }
    }
    
    private void findAllCourses() throws SQLException, ClassNotFoundException {
        model2.setRowCount(0);
        List<Courses> courses = courseDao.findAll();
        for (Courses course : courses) {
            Object[] row = {course.getCourse_id(), course.getCourse_name()};
            
            model2.addRow(row);
           
        }
    }
    
    private void findAllModules() throws SQLException, ClassNotFoundException {
        model3.setRowCount(0);
        List<Modules> modules = moduleDao.findAll();
        for (Modules module1 : modules) {
            Object[] row = {module1.getModule_id(), module1.getModule_name(), module1.getLevel()};
            
            model3.addRow(row);
           
        }
    }
    
    private void findAllTeacher() throws SQLException, ClassNotFoundException {
        model1.setRowCount(0);
        List<Person> persons = personDao.findAllTeacher();
        if(persons != null){
        for (Person person : persons) {
            Object[] row = {person.getId(), person.getfName() +" "+person.getlName(), person.getEmail()};
            
            model1.addRow(row);
        }
        }
    }
    
    private void findAllGrade() throws SQLException, ClassNotFoundException {
        model4.setRowCount(0);
        int id = Integer.parseInt(jTextField3.getText());
        Student checkStu = studentDao.findOne(id);
//         moduleForGrade.setText();
        if(checkStu!=null){
            Person nam = personDao.findOne(id);
            name.setText(nam.getfName()+" "+nam.getlName());
//            Modules module = moduleDao.findOne(student1.getModule_id());
//           
            List<Student> students = studentDao.findAll(id);
            int pass = 0;
            int total = 0;
            for (Student student : students) {
                Person person = personDao.findOne(id);
                if(person!=null){
                    Modules module = moduleDao.findOne(student.getModule_id());
                    if(module!=null){
                        total++;
                        Object[] row = {student.getId(), student.getMarks(), module.getModule_name()};
                         if(student.getMarks()>40){
                             pass++;
                         }
                        model4.addRow(row);
                    }
                }
            }
            if(pass>=total/2){
                remarks.setText("PASS");
            }else{
                remarks.setText("FAIL");
            }
         }else{
            
             JOptionPane.showMessageDialog(null, "User not found", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void findAllGradeForResult() throws SQLException, ClassNotFoundException {
        model5.setRowCount(0);
        int id = Integer.parseInt(jTextField4.getText());
        int teacherid = this.user.getId();
        int moduleId = teacherDao.findOne(teacherid).getModule_id();
        List<Student> checkStu = studentDao.findAll(id, moduleId);
        if(checkStu!=null){
            for (Student student : checkStu) {
                Object[] row = {student.getId(),personDao.findOne(student.getId()).getfName()+" "+personDao.findOne(student.getId()).getlName(), student.getMarks()};
                model5.addRow(row);
            }   
            
            
        }else{
            //message
        }
    }
    
    
    private void removeStudent() {
        int selectedRow = studentTable.getSelectedRow();
        int id = (int) studentTable.getValueAt(selectedRow, 0);
        try {
            Person person = personDao.findOne(id);
            if (person != null) {
                int rowCount = personDao.remove(id);
                if (rowCount >= 1) {
                    
                    findAllStudent();
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
    }
    
     private void removeTeacher() {
        int selectedRow = teacherTable.getSelectedRow();
        int id = (int) teacherTable.getValueAt(selectedRow, 0);
        try {
            Person person = personDao.findOne(id);
            if (person != null) {
                int rowCount = personDao.remove(id);
                if (rowCount >= 1) {
                    
                    findAllTeacher();
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
    }
     
     private void removeCourse() {
        int selectedRow = studentTable2.getSelectedRow();
        int id = (int) studentTable2.getValueAt(selectedRow, 0);
        try {
            Courses course = courseDao.findOne(id);
            if (course != null) {
                int rowCount = courseDao.remove(id);
                if (rowCount >= 1) {
                    
                    findAllCourses();
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
    }
     
      
     private void removeModule() {
        int selectedRow = studentTable3.getSelectedRow();
        int id = (int) studentTable3.getValueAt(selectedRow, 0);
        try {
            Modules module = moduleDao.findOne(id);
            if (module != null) {
                int rowCount = moduleDao.remove(id);
                if (rowCount >= 1) {
                    
                    findAllModules();
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
    }
     private void saveStudent() throws NumberFormatException, HeadlessException {
        try {
            Person person = getValueFromTextFieldForStudent();
            int rowCount = personDao.save(person);
            if (rowCount >= 1) {
               
                resetForm();
                findAllStudent();
            } else {
                
            }
        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            
        }
    }
     
     private void saveGrade() {
         
         try {
             
             Person person = getValueFromTextFieldForStudent();
              int rowCount = personDao.saveGrade(person);
             if (rowCount >= 1) {             
                resetForm();
                findAllStudent();
            } else {
                 System.out.println("Error");
            }
         }catch (ClassNotFoundException | NumberFormatException | SQLException e){
             
             System.out.println("Error occured");
         }
     }
     
     
     private void saveTeacher() throws NumberFormatException, HeadlessException {
        try {
            Person person = getValueFromTextFieldForTeacher();
            int moduleId = Integer.parseInt(module.getText());
            if(moduleDao.findOne(moduleId)!=null){
                int rowCount = personDao.save(person);
                Teacher teacher = new Teacher(person.getId(),moduleId);
                if (rowCount >= 1) {
                    int save = teacherDao.save(teacher);
                    resetTeacherForm();
                    findAllTeacher();
                } else {
                    
                    System.out.println("Teacher data saving..");
                }
            }else{
                //message- enter valid module id
                 JOptionPane.showMessageDialog(null, "Enter valid module id", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            
        }
    }
     
     private void saveCourse() throws NumberFormatException, HeadlessException {
        try {
            Courses course = getValueFromTextFieldForCourse();
            int rowCount = courseDao.save(course);
            if (rowCount >= 1) {
               
                resetTeacherForm();
                findAllCourses();
            } else {
                
            }
        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            
        }
    }
     
     private void saveModule() throws NumberFormatException, HeadlessException {
        try {
            Modules module = getValueFromTextFieldForModule();
            int rowCount = moduleDao.save(module);
            if (rowCount >= 1) {
               
                resetModuleForm();
                findAllModules();
            } else {
                
            }
        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            
        }
    }
     
     
      private void resetForm() {
        userfNameTextField.setText("");
        lastNameTextField.setText("");
        emailTextField.setText("");
        
        passwordPasswordField.setText("");
    }
      private void resetTeacherForm() {
        userfNameTextField1.setText("");
        lastNameTextField1.setText("");
        emailTextField1.setText("");
        passwordPasswordField1.setText("");
        module.setText("");
    }
      
       private void resetModuleForm() {
        userfName.setText("");
        moduleLevel.setText("");
        courseId.setText("");
        
    }
      
     private Person getValueFromTextFieldForStudent() throws NumberFormatException {
        String fname = userfNameTextField.getText();
        String lname = lastNameTextField.getText();
        String email = emailTextField.getText();
        
        @SuppressWarnings("deprecation")
        String password = passwordPasswordField.getText();
        String grade = (String) studentGrade.getSelectedItem();
        
        
        
        Person person = new Person(fname, lname, email, password,"student",grade);
        return person;
    }
     
      private Person getValueFromTextFieldForTeacher() throws NumberFormatException {
        String fname = userfNameTextField1.getText();
        String lname = lastNameTextField1.getText();
        String email = emailTextField1.getText();
        
        String password = passwordPasswordField1.getText();
        
        
        
        Person person = new Person(fname, lname, email, password, "teacher");
        return person;
    }
      
       private Modules getValueFromTextFieldForModule() throws NumberFormatException, SQLException, ClassNotFoundException {
        String module_name = userfName.getText();
        int level = Integer.parseInt(moduleLevel.getText());
        int course_id = Integer.parseInt(courseId.getText());
        
        Courses course = courseDao.findOne(course_id);
        if(course!=null){
            Modules module = new Modules(module_name, level, 0 , 0, course_id);
            return module;
        }else{
            System.out.println("course id  not valid");
            return null;
        }
        
           
    }
      
       private Courses getValueFromTextFieldForCourse() throws NumberFormatException {
        String course_name = courseNameTxtField.getText();
        
        
        
        Courses course = new Courses(course_name);
        return course;
    }
      
     private void searchStudent() throws SQLException, ClassNotFoundException {
        String query = searchStudentTextField.getText();
        if (query.length() == 0) {
            findAllStudent();
        } else {
            model.setRowCount(0);
            try {
                List<Person> persons = personDao.search(searchStudentTextField.getText());
                for (Person person : persons) {
                    Object[] row = {person.getId(), person.getfName(), person.getEmail()};
                    model.addRow(row);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                
            }
        }
    }
     
     private void searchModule() throws SQLException, ClassNotFoundException {
        String query = searchStudentTextField2.getText();
        if (query.length() == 0) {
            findAllModules();
        } else {
            model3.setRowCount(0);
            try {
                List<Modules> modules = moduleDao.search(searchStudentTextField2.getText());
                for (Modules module : modules) {
                    Object[] row = {module.getModule_id(), module.getModule_name(), module.getLevel()};
                    model3.addRow(row);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                
            }
        }
    }
     
     private void searchTeacher() throws SQLException, ClassNotFoundException {
        String query = searchStudentTextField1.getText();
        if (query.length() == 0) {
            findAllTeacher();
        } else {
            model.setRowCount(0);
            try {
                List<Person> persons = personDao.search(searchStudentTextField.getText());
                for (Person person : persons) {
                    Object[] row = {person.getId(), person.getfName(), person.getEmail()};
                    model.addRow(row);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                
            }
        }
    }
     
     private void updateStudent() throws NumberFormatException {
        try {
            String selectedGrade = null;
            int selectedRow = studentTable.getSelectedRow();
            int id = (int) studentTable.getValueAt(selectedRow, 0);
            Person person = personDao.findOne(id);
            if (editButton.getText().equals("Edit")) {
                editButton.setText("Update");
                
                userfNameTextField.setText(person.getfName());
                lastNameTextField.setText(person.getlName());
                emailTextField.setText(person.getEmail());
//                String garde2 = (String) studentGrade.getSelectedItem();
                selectedGrade = (String) studentGrade.getSelectedItem();
                
                
                passwordPasswordField.setText(person.getPassword());
        
                
            } else if (editButton.getText().equals("Update")) {
                
                person.setfName(userfNameTextField.getText());
                person.setfName(lastNameTextField.getText());
                person.setEmail(emailTextField.getText());
                person.setPassword(passwordPasswordField.getText());
                person.setGrade(selectedGrade);
                
                
                int rowCount = personDao.updateStudent(person, id);

                if (rowCount >= 1) {
                    
                    resetForm();
                    findAllStudent();
                    editButton.setText("Edit");
                } else {
                    
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
    }
     
    @SuppressWarnings("deprecation")
     private void updateTeacher() throws NumberFormatException {
        try {
            
            int selectedRow = teacherTable.getSelectedRow();
            if(selectedRow != -1){
                
            int id = (int) teacherTable.getValueAt(selectedRow, 0);
            Person person = personDao.findOne(id);
            if(person != null){
                
            
            if (editTeacher.getText().equals("Edit")) {
                editTeacher.setText("Update");
                
                userfNameTextField1.setText(person.getfName());
                lastNameTextField1.setText(person.getlName());
                emailTextField1.setText(person.getEmail());
                
                passwordPasswordField1.setText(person.getPassword());
        
                
            } else if (editTeacher.getText().equals("Update")) {
                
                person.setfName(userfNameTextField1.getText());
                person.setfName(lastNameTextField1.getText());
                person.setEmail(emailTextField1.getText());
                person.setPassword(passwordPasswordField1.getText());
                
                
                int rowCount = personDao.updateTeacher(person, id);

                if (rowCount >= 1) {
                    
                    resetTeacherForm();
                    findAllTeacher();
                    editTeacher.setText("Edit");
                } else {
                    
                }
            }
            }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
    }
     
     private void updateCourse() throws NumberFormatException {
        try {
            int selectedRow = studentTable2.getSelectedRow();
            int id = (int) studentTable2.getValueAt(selectedRow, 0);
            Courses course = courseDao.findOne(id);
            if (editCourse.getText().equals("Edit")) {
                editCourse.setText("Update");
                
                courseNameTxtField.setText(course.getCourse_name());
                
                
                
        
                
            } else if (editCourse.getText().equals("Update")) {
                
                course.setCourse_name(courseNameTxtField.getText());
                
                
                int rowCount = courseDao.update(course, id);

                if (rowCount >= 1) {
                    
                    courseNameTxtField.setText("");
                    findAllCourses();
                    editCourse.setText("Edit");
                } else {
                    
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
    }
    
      private void updateModule() throws NumberFormatException {
        try {
            int selectedRow = studentTable3.getSelectedRow();
            int id = (int) studentTable3.getValueAt(selectedRow, 0);
            Modules module = moduleDao.findOne(id);
            if (editButton3.getText().equals("Edit")) {
                editButton3.setText("Update");
                
                userfName.setText(module.getModule_name());
                moduleLevel.setText(String.valueOf(module.getLevel()));
             courseId.setVisible(false);
             jLabel16.setVisible(false);
                
                
                
        
                
            } else if (editButton3.getText().equals("Update")) {
                
                module.setModule_name(userfName.getText());
                module.setLevel(Integer.parseInt(moduleLevel.getText()));
                
                
                int rowCount = moduleDao.update(module, id);

                if (rowCount >= 1) {
                    
                    userfName.setText("");
                    courseId.setVisible(true);
                    moduleLevel.setText("");
             jLabel16.setVisible(true);
                    findAllModules();
                    editButton3.setText("Edit");
                } else {
                    
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
    }

       private void updateGrade() throws NumberFormatException {
        try {
            int selectedRow = jTable1.getSelectedRow();
            int id = (int) jTable1.getValueAt(selectedRow, 0);
            Student student = studentDao.findOne(id);
            if (editGrade.getText().equals("Edit")) {
                editGrade.setText("Update");
                gardeName.setText(personDao.findOne(id).getfName()+" "+personDao.findOne(id).getlName());
                moduleForGrade.setText(moduleDao.findOne(id).getModule_name());
                
                jTextField5.setText(String.valueOf(student.getMarks()));
         
                
            } else if (editGrade.getText().equals("Update")) {
                student.setMarks(Integer.parseInt(jTextField5.getText()));
                
                
                
                int rowCount = studentDao.updateMarks(student, id,teacherDao.findOne(this.user.getId()).getModule_id());

                if (rowCount >= 1) {
                    
                    jTextField5.setText("");
                    gardeName.setText("");
             
                    findAllGradeForResult();
                    editGrade.setText("Edit");
                } else {
                    
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
    }
    private void studentbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentbuttonActionPerformed
        // TODO add your handling code here:
        showFeatures.removeAll();
        showFeatures.add(studentPanel);
        showFeatures.repaint();
        showFeatures.revalidate();
        try {
            findAllStudent();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_studentbuttonActionPerformed

    private void teacherbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherbuttonActionPerformed
        // TODO add your handling code here:
        showFeatures.removeAll();
        showFeatures.add(teacherPanel);
        showFeatures.repaint();
        showFeatures.revalidate();
    }//GEN-LAST:event_teacherbuttonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        updateStudent();
    }//GEN-LAST:event_editButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        removeStudent();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void resultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultButtonActionPerformed
        // TODO add your handling code here:
         showFeatures.removeAll();
        showFeatures.add(resultPanel);
        showFeatures.repaint();
        showFeatures.revalidate();
        if(!this.user.getUsertype().equals("admin")){
            resultPanel.setVisible(false);
       }
        
        if(this.user.getUsertype().equals("student")){
            resultPanel.setVisible(false);
            resultSlip.setVisible(true);
            
       }
    }//GEN-LAST:event_resultButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        LoginPage login = new LoginPage();
        login.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        saveStudent();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchStudentTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchStudentTextFieldKeyReleased
        try {
            // TODO add your handling code here:
            searchStudent();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchStudentTextFieldKeyReleased

    private void addTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeacherActionPerformed
        
        saveTeacher();
        resetTeacherForm();
    }//GEN-LAST:event_addTeacherActionPerformed

    private void editTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTeacherActionPerformed
       
        updateTeacher();
//        resetTeacherForm();
    }//GEN-LAST:event_editTeacherActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        removeTeacher();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void searchStudentTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchStudentTextField1KeyReleased
        try {
            // TODO add your handling code here:
            searchTeacher();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchStudentTextField1KeyReleased

    private void coursebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursebuttonActionPerformed
        // TODO add your handling code here:
        showFeatures.removeAll();
        showFeatures.add(coursePanel);
        showFeatures.repaint();
        showFeatures.revalidate();
    }//GEN-LAST:event_coursebuttonActionPerformed

    private void addCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseActionPerformed
        // TODO add your handling code here:
        saveCourse();
    }//GEN-LAST:event_addCourseActionPerformed

    private void editCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourseActionPerformed
        // TODO add your handling code here:
        updateCourse();
    }//GEN-LAST:event_editCourseActionPerformed

    private void deleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourseActionPerformed
        // TODO add your handling code here:
        removeCourse();
    }//GEN-LAST:event_deleteCourseActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        saveModule();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void editButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton3ActionPerformed
        // TODO add your handling code here:
        updateModule();
    }//GEN-LAST:event_editButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        removeModule();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void searchStudentTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchStudentTextField2KeyReleased
        try {
            // TODO add your handling code here:
            searchModule();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchStudentTextField2KeyReleased

    private void moduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moduleButtonActionPerformed
        // TODO add your handling code here:
        showFeatures.removeAll();
        showFeatures.add(modulePanel);
        showFeatures.repaint();
        showFeatures.revalidate();
    }//GEN-LAST:event_moduleButtonActionPerformed

    private void searchGradeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchGradeButtonActionPerformed
        try {
            // TODO add your handling code here:
            findAllGrade();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchGradeButtonActionPerformed

    private void gradeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeButtonActionPerformed
            showFeatures.removeAll();
            showFeatures.add(gradePanel);
            showFeatures.repaint();
            showFeatures.revalidate();
        
       
    }//GEN-LAST:event_gradeButtonActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            if(this.user.getUsertype().equals("teacher")){
                findAllGradeForResult();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void editGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editGradeActionPerformed
        // TODO add your handling code here:
        updateGrade();
    }//GEN-LAST:event_editGradeActionPerformed

    private void courseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseIdActionPerformed

    private void emailTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextField1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void level4RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level4RadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_level4RadioButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CourseScrollPane;
    private javax.swing.JButton addCourse;
    private javax.swing.JButton addTeacher;
    private javax.swing.JPanel adminAccessStudent;
    private javax.swing.JPanel adminAccessStudent1;
    private javax.swing.JTextField courseId;
    private javax.swing.JTextField courseNameTxtField;
    private javax.swing.JPanel coursePanel;
    private javax.swing.JButton coursebutton;
    private javax.swing.JLabel currentUserLevel;
    private javax.swing.JLabel currentUsername;
    private javax.swing.JButton deleteCourse;
    private javax.swing.JButton editButton;
    private javax.swing.JButton editButton3;
    private javax.swing.JButton editCourse;
    private javax.swing.JButton editGrade;
    private javax.swing.JButton editTeacher;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField emailTextField1;
    private javax.swing.JPanel enrollModulePanel;
    private javax.swing.JLabel gardeName;
    private javax.swing.JButton gradeButton;
    private javax.swing.JPanel gradePanel;
    private javax.swing.JTable gradeTable;
    private javax.swing.JPanel homePanel;
    private javax.swing.JButton homebutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField lastNameTextField1;
    private javax.swing.JRadioButton level4RadioButton;
    private javax.swing.JRadioButton level5RadioButton;
    private javax.swing.JRadioButton level6RadioButton;
    private javax.swing.JRadioButton level7RadioButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField module;
    private javax.swing.JButton moduleButton;
    private javax.swing.JLabel moduleForGrade;
    private javax.swing.JTextField moduleLevel;
    private javax.swing.JPanel modulePanel;
    private javax.swing.JLabel name;
    private javax.swing.JComboBox<String> optionalCourseComboBox1;
    private javax.swing.JPasswordField passwordPasswordField;
    private javax.swing.JPasswordField passwordPasswordField1;
    private javax.swing.JLabel remarks;
    private javax.swing.JButton resultButton;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JPanel resultSlip;
    private javax.swing.JButton searchGradeButton;
    private javax.swing.JTextField searchStudentTextField;
    private javax.swing.JTextField searchStudentTextField1;
    private javax.swing.JTextField searchStudentTextField2;
    private javax.swing.JPanel showFeatures;
    private javax.swing.JComboBox<String> studentGrade;
    private javax.swing.JPanel studentPanel;
    private javax.swing.JTable studentTable;
    private javax.swing.JTable studentTable2;
    private javax.swing.JTable studentTable3;
    private javax.swing.JButton studentbutton;
    private javax.swing.JPanel teacherPanel;
    private javax.swing.JTable teacherTable;
    private javax.swing.JButton teacherbutton;
    private javax.swing.JLabel totalCourses;
    private javax.swing.JLabel totalModules;
    private javax.swing.JLabel totalStudents;
    private javax.swing.JLabel totalTeacher;
    private javax.swing.JTextField userfName;
    private javax.swing.JTextField userfNameTextField;
    private javax.swing.JTextField userfNameTextField1;
    // End of variables declaration//GEN-END:variables
}
