package datamanagement;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * User interface for the application.
 * Most of this file is generated automatically from the visual window-builder
 * used in the Eclipse Java IDE.
 *
 */
public class ChangeGradeUI extends JFrame implements IUnitLister, IStudentLister
{
    private ChangeGradeCTL        controller;
    private DefaultComboBoxModel  unitComboBoxModel;
    private DefaultComboBoxModel  studentComboBoxModel;
    float                         asg1Mark;
    float                         asg2Mark;
    float                         examMark;
    Integer                       studentId;

    public ChangeGradeUI(ChangeGradeCTL controller)
    {
        this.controller           = controller;
        this.unitComboBoxModel    = new DefaultComboBoxModel(new String[0]);
        this.studentComboBoxModel = new DefaultComboBoxModel(new String[0]);

        initComponents();
        unitComboBox.setModel(unitComboBoxModel);
        studentComboBox.setModel(studentComboBoxModel);
        errorMessageLabel.setText("");
    }

    /** This method is called from within the constructor to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor. */
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleLabel            = new JLabel();
        unitSelectionPanel    = new JPanel();
        unitComboBox          = new JComboBox();
        studentSelectionPanel = new JPanel();
        studentComboBox       = new JComboBox();
        MarksPanel            = new JPanel();
        asg1Label             = new JLabel();
        asg2Label             = new JLabel();
        examLabel             = new JLabel();
        asg1MarkTextField     = new JTextField();
        asg2MarkTextField     = new JTextField();
        examMarkTextField     = new JTextField();
        changeMarksButton     = new JButton();
        gradeDisplayPanel     = new JPanel();
        gradeLabel            = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        titleLabel.setText("Check Grade UI");

        unitSelectionPanel.setBorder(BorderFactory.createTitledBorder("Unit"));

        unitComboBox.setModel(unitComboBoxModel);
        unitComboBox.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                unitComboBoxItemStateChanged(evt);
            }
        });

        GroupLayout gl_unitSelectionPanel = new GroupLayout(unitSelectionPanel);
        unitSelectionPanel.setLayout(gl_unitSelectionPanel);
        gl_unitSelectionPanel.setHorizontalGroup(gl_unitSelectionPanel
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_unitSelectionPanel.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(unitComboBox, GroupLayout.PREFERRED_SIZE,
                                185, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));
        gl_unitSelectionPanel.setVerticalGroup(gl_unitSelectionPanel
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_unitSelectionPanel.createSequentialGroup()
                        .addComponent(unitComboBox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));

        studentSelectionPanel
                .setBorder(BorderFactory.createTitledBorder("Student"));

        studentComboBox.setModel(studentComboBoxModel);
        studentComboBox.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                studentComboBoxItemStateChanged(evt);
            }
        });

        GroupLayout gl_studentSelectionPanel = new GroupLayout(
                studentSelectionPanel);
        studentSelectionPanel.setLayout(gl_studentSelectionPanel);
        gl_studentSelectionPanel.setHorizontalGroup(gl_studentSelectionPanel
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_studentSelectionPanel.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(studentComboBox,
                                GroupLayout.PREFERRED_SIZE, 185,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));
        gl_studentSelectionPanel.setVerticalGroup(gl_studentSelectionPanel
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_studentSelectionPanel.createSequentialGroup()
                        .addComponent(studentComboBox,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));

        MarksPanel.setBorder(BorderFactory.createTitledBorder("Marks"));

        asg1Label.setText("Asg1:");
        asg2Label.setText("Asg2:");
        examLabel.setText("Exam:");

        asg1MarkTextField.setEditable(false);
        asg1MarkTextField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jTextFieldKeyTyped(evt);
            }
        });

        asg2MarkTextField.setEditable(false);
        asg2MarkTextField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jTextFieldKeyTyped(evt);
            }
        });

        examMarkTextField.setEditable(false);
        examMarkTextField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jTextFieldKeyTyped(evt);
            }
        });

        changeMarksButton.setText("Change");
        changeMarksButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                changeMarksButtonActionPerformed(evt);
            }
        });
        checkGradeButton = new JButton();

        checkGradeButton.setText("Check Grade");
        checkGradeButton.setActionCommand("checkGrade");
        checkGradeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkGradeButtonActionPerformed(evt);
            }
        });

        GroupLayout gl_MarksPanel = new GroupLayout(MarksPanel);
        gl_MarksPanel.setHorizontalGroup(gl_MarksPanel
                .createParallelGroup(Alignment.LEADING)
                .addGroup(gl_MarksPanel.createSequentialGroup()
                        .addContainerGap().addComponent(asg1Label)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_MarksPanel
                                .createParallelGroup(Alignment.TRAILING)
                                .addGroup(gl_MarksPanel.createSequentialGroup()
                                        .addComponent(asg1MarkTextField,
                                                GroupLayout.PREFERRED_SIZE, 59,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(18).addComponent(asg2Label)
                                        .addGap(18))
                                .addGroup(Alignment.LEADING, gl_MarksPanel
                                        .createSequentialGroup().addGap(12)
                                        .addComponent(changeMarksButton,
                                                GroupLayout.PREFERRED_SIZE, 94,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(28)))
                        .addGroup(gl_MarksPanel
                                .createParallelGroup(Alignment.TRAILING)
                                .addGroup(gl_MarksPanel.createSequentialGroup()
                                        .addComponent(asg2MarkTextField,
                                                GroupLayout.PREFERRED_SIZE, 59,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(18).addComponent(examLabel))
                                .addComponent(checkGradeButton))
                        .addGap(18)
                        .addComponent(examMarkTextField,
                                GroupLayout.PREFERRED_SIZE, 59,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(15)));
        gl_MarksPanel
                .setVerticalGroup(
                        gl_MarksPanel.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_MarksPanel.createSequentialGroup()
                                        .addGroup(gl_MarksPanel
                                                .createParallelGroup(
                                                        Alignment.BASELINE)
                                                .addComponent(asg1Label)
                                                .addComponent(asg1MarkTextField,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.DEFAULT_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                                .addComponent(asg2Label)
                                .addComponent(asg2MarkTextField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(examLabel)
                                .addComponent(examMarkTextField,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(gl_MarksPanel
                                .createParallelGroup(Alignment.BASELINE)
                                .addComponent(changeMarksButton)
                                .addComponent(checkGradeButton))
                        .addContainerGap()));
        MarksPanel.setLayout(gl_MarksPanel);

        gradeDisplayPanel.setBorder(BorderFactory.createTitledBorder("Grade"));

        gradeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gradeLabel.setForeground(new java.awt.Color(255, 0, 0));
        gradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gradeLabel.setText("grade");

        GroupLayout gl_gradeDisplayPanel = new GroupLayout(gradeDisplayPanel);
        gradeDisplayPanel.setLayout(gl_gradeDisplayPanel);
        gl_gradeDisplayPanel.setHorizontalGroup(gl_gradeDisplayPanel
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(gradeLabel, GroupLayout.Alignment.TRAILING,
                        GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE));
        gl_gradeDisplayPanel.setVerticalGroup(gl_gradeDisplayPanel
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_gradeDisplayPanel.createSequentialGroup()
                        .addGap(34, 34, 34).addComponent(gradeLabel)
                        .addContainerGap(43, Short.MAX_VALUE)));

        errorMessageLabel = new JLabel();
        errorMessageLabel.setText("Error message");
        errorMessageLabel.setForeground(Color.RED);
        errorMessageLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        saveChangesButton = new JButton();

        saveChangesButton.setText("Save");
        saveChangesButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkMarksButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(errorMessageLabel,
                                                GroupLayout.DEFAULT_SIZE, 400,
                                                Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout
                                        .createParallelGroup(Alignment.LEADING,
                                                false)
                                        .addComponent(MarksPanel,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                .createParallelGroup(
                                                        Alignment.LEADING)
                                                .addComponent(
                                                    unitSelectionPanel,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.DEFAULT_SIZE,
                                                    GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                    studentSelectionPanel,
                                                    GroupLayout.PREFERRED_SIZE,
                                                    GroupLayout.DEFAULT_SIZE,
                                                    GroupLayout.PREFERRED_SIZE))
                                                .addGap(18)
                                                .addComponent(gradeDisplayPanel,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup().addGap(157)
                                .addComponent(titleLabel))
                        .addGroup(layout.createSequentialGroup().addGap(165)
                                .addComponent(saveChangesButton,
                                        GroupLayout.PREFERRED_SIZE, 86,
                                        GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(titleLabel).addGap(13)
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(unitSelectionPanel,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                                ComponentPlacement.RELATED)
                                        .addComponent(studentSelectionPanel,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addComponent(gradeDisplayPanel,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MarksPanel, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(saveChangesButton).addGap(11)
                        .addComponent(errorMessageLabel,
                                GroupLayout.PREFERRED_SIZE, 30,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unitComboBoxItemStateChanged(java.awt.event.ItemEvent evt)
    {// GEN-FIRST:event_jComboBox1ItemStateChanged
        String unit = (String) unitComboBox.getSelectedItem();
        refresh();
        clearStudents();
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
            if (unit.equals((String) unitComboBox.getItemAt(0)))
            {
                unit = "NONE";
            }
            controller.selectUnit(unit);
        }
    }// GEN-LAST:event_jComboBox1ItemStateChanged

    private void studentComboBoxItemStateChanged(java.awt.event.ItemEvent evt)
    {// GEN-FIRST:event_jComboBox2ItemStateChanged
        refresh();
        String student = (String) studentComboBox.getSelectedItem();
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
            if (student.equals((String) studentComboBox.getItemAt(0)))
            {
                studentId = new Integer(0);
                controller.selectStudent(studentId);
            }
            else
            {
                studentId = new Integer(student.split("\\s")[0]);
            }
            controller.selectStudent(studentId);
        }
    }// GEN-LAST:event_jComboBox2ItemStateChanged
    
    
    private boolean computeInputValidity()
    {
        try
        {
            Float.parseFloat(asg1MarkTextField.getText());
        }
        catch (NumberFormatException e)
        {
            errorMessageLabel.setText("Invalid input for assignment 1 mark.");
            return false;
        }
        
        
        try
        {
            Float.parseFloat(asg2MarkTextField.getText());
        }
        catch (NumberFormatException e)
        {
            errorMessageLabel.setText("Invalid input for assignment 2 mark.");
            return false;
        }
        
        
        try
        {
            Float.parseFloat(examMarkTextField.getText());
        }
        catch (NumberFormatException e)
        {
            errorMessageLabel.setText("Invalid input for exam mark.");
            return false;
        }
        
        return true;
    }
    
    
    
    private void checkGradeButtonActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_jButton3ActionPerformed
        boolean inputValid = computeInputValidity();
        
        if (inputValid)
        {
            asg1Mark = new Float(asg1MarkTextField.getText()).floatValue();
            asg2Mark = new Float(asg2MarkTextField.getText()).floatValue();
            examMark = new Float(examMarkTextField.getText()).floatValue();
            // lblErrMsg.setText("");
            try
            {
                String s = controller.checkGrade(asg1Mark, 
                                                         asg2Mark,
                                                         examMark);
                gradeLabel.setText(s);
            }
            catch (RuntimeException re)
            {
                errorMessageLabel.setText(re.getMessage());
            }
        }
    }// GEN-LAST:event_jButton3ActionPerformed

    private void changeMarksButtonActionPerformed(
            java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_jButton1ActionPerformed
        controller.enableChangeMarks();
        gradeLabel.setText("");
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldKeyTyped(java.awt.event.KeyEvent evt)
    {// GEN-FIRST:event_jTextField1KeyTyped
        gradeLabel.setText("");
        errorMessageLabel.setText("");
    }// GEN-LAST:event_jTextField1KeyTyped

    private void checkMarksButtonActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_jButton2ActionPerformed
        boolean inputValid = computeInputValidity();
        
        if (inputValid)
        {
            float changedAsg1Mark = new Float(asg1MarkTextField.getText())
                    .floatValue();
            float changedAsg2Mark = new Float(asg2MarkTextField.getText())
                    .floatValue();
            float changedExamMark = new Float(examMarkTextField.getText())
                    .floatValue();
            errorMessageLabel.setText("");
            
            try
            {
                controller.saveGrade(changedAsg1Mark, 
                                     changedAsg2Mark, 
                                     changedExamMark);
            }
            catch (RuntimeException re)
            {
                errorMessageLabel.setText(re.getMessage());
            }
        }
    }// GEN-LAST:event_jButton2ActionPerformed

    public void clearUnits()
    {
        unitComboBoxModel.removeAllElements();
        unitComboBoxModel.addElement("<none selected>");
        clearStudents();
    }

    
    public void addUnit(IUnit unit)
    {
        unitComboBoxModel.addElement(unit.getUnitCode());
    }

    
    public void setUnitComboBoxEnabled(boolean b)
    {
        unitComboBox.setEnabled(b);
        errorMessageLabel.setText("");
    }

    
    public void clearStudents()
    {
        studentComboBoxModel.removeAllElements();
        studentComboBoxModel.addElement("<none selected>");
    }

    
    public void addStudent(IStudent student)
    {
        studentComboBoxModel.addElement(student.getID().toString() + " : "
                + student.getFirstName() + " " + student.getLastName());
    }

    public void setStudentComboBoxEnabled(boolean b)
    {
        studentComboBox.setEnabled(b);
        errorMessageLabel.setText("");
    }

    public void setRecord(IStudentUnitRecord record)
    {
        asg1MarkTextField.setText(new Float(record.getAsg1()).toString());
        asg2MarkTextField.setText(new Float(record.getAsg2()).toString());
        examMarkTextField.setText(new Float(record.getExam()).toString());
        gradeLabel.setText("");
    }

    public void refresh()
    {
        asg1MarkTextField.setText("");
        asg2MarkTextField.setText("");
        examMarkTextField.setText("");
        gradeLabel.setText("");
        errorMessageLabel.setText("");
        asg1MarkTextField.setEditable(false);
        asg2MarkTextField.setEditable(false);
        examMarkTextField.setEditable(false);
    }

    public void setCheckGradeButtonEnabled(boolean b)
    {
        checkGradeButton.setEnabled(b);
    }

    public void setChangeMarksButtonEnabled(boolean b)
    {
        changeMarksButton.setEnabled(b);
    }

    public void setMarksTextFieldsEnabled(boolean b)
    {
        asg1MarkTextField.setEditable(b);
        asg2MarkTextField.setEditable(b);
        examMarkTextField.setEditable(b);
    }

    public void setSaveChangesButtonEnabled(boolean b)
    {
        saveChangesButton.setEnabled(b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton    changeMarksButton;
    private JButton    checkGradeButton;
    private JButton    saveChangesButton;
    private JComboBox  unitComboBox;
    private JComboBox  studentComboBox;
    private JLabel     titleLabel;
    private JLabel     asg1Label;
    private JLabel     asg2Label;
    private JLabel     examLabel;
    private JLabel     gradeLabel;
    private JLabel     errorMessageLabel;
    private JPanel     unitSelectionPanel;
    private JPanel     studentSelectionPanel;
    private JPanel     MarksPanel;
    private JPanel     gradeDisplayPanel;
    private JTextField asg1MarkTextField;
    private JTextField asg2MarkTextField;
    private JTextField examMarkTextField;
}
