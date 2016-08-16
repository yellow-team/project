package datamanagement;

/**
 * Controller object that manages the state transitions of the UI,
 * e.g. enables/disables buttons and text fields.
 *
 */
public class ChangeGradeCTL
{
    ChangeGradeUI userInterface;
    String        selectedUnitCode     = null;
    Integer       selectedStudentID    = null;
    boolean       activeRecordSaveable = false;
    
    
    public void startUserInterface()
    {
        userInterface = new ChangeGradeUI(this);
        
        userInterface.setUnitComboBoxEnabled(false);
        userInterface.setStudentComboBoxEnabled(false);
        userInterface.setCheckGradeButtonEnabled(false);
        userInterface.setChangeMarksButtonEnabled(false);
        userInterface.setMarksTextFieldsEnabled(false);
        userInterface.setSaveChangesButtonEnabled(false);
        
        userInterface.refresh();
        
        ListUnitsCTL listUnitsController = new ListUnitsCTL();
        listUnitsController.listUnits(userInterface);
        userInterface.setVisible(true);
        userInterface.setUnitComboBoxEnabled(true);
    }
    
    
    
    public void selectUnit(String unitCode)
    {
        if (unitCode.equals(Constants.NONE_SELECTED))
        {
            userInterface.setStudentComboBoxEnabled(false);
        }
        else
        {
            ListStudentsCTL listStudentsController = new ListStudentsCTL();
            listStudentsController.listStudents(userInterface, unitCode);
            selectedUnitCode = unitCode;
            userInterface.setStudentComboBoxEnabled(true);
        }
        userInterface.setCheckGradeButtonEnabled(false);
    }
    
    
    
    public void selectStudent(Integer studentId)
    {
        selectedStudentID = studentId;
        if (selectedStudentID.intValue() == 0)
        {
            userInterface.refresh();
            userInterface.setCheckGradeButtonEnabled(false);
            userInterface.setChangeMarksButtonEnabled(false);
            userInterface.setMarksTextFieldsEnabled(false);
            userInterface.setSaveChangesButtonEnabled(false);
        }
        else
        {
            IStudent student = StudentManager.getInstance()
                    .getStudent(studentId);
            IStudentUnitRecord record = student.getUnitRecord(selectedUnitCode);
            
            userInterface.setRecord(record);
            userInterface.setCheckGradeButtonEnabled(true);
            userInterface.setChangeMarksButtonEnabled(true);
            userInterface.setMarksTextFieldsEnabled(false);
            userInterface.setSaveChangesButtonEnabled(false);
            activeRecordSaveable = false;
        }
    }
    
    
    /**
     * Computes the grade string from the given marks.
     * @param asg1Mark Mark for Assignment 1
     * @param asg2Mark Mark for Assignment 2
     * @param examMark Mark for the exam
     * @return A String of the grade achieved with these marks 
     * (FL, AE, PS, CR, DN, HD)
     */
    public String computeGradeString(float asg1Mark,
                                     float asg2Mark,
                                     float examMark)
    {
        IUnit unit = UnitManager.UM().getUnit(selectedUnitCode);
        String grade = unit.getGrade(asg1Mark, asg2Mark, examMark);
        userInterface.setChangeMarksButtonEnabled(true);
        userInterface.setMarksTextFieldsEnabled(false);
        if (activeRecordSaveable)
        {
            userInterface.setSaveChangesButtonEnabled(true);
        }
        return grade;
    }
    
    
    
    public void enableChangeMarks()
    {
        userInterface.setChangeMarksButtonEnabled(false);
        userInterface.setSaveChangesButtonEnabled(false);
        userInterface.setMarksTextFieldsEnabled(true);
        activeRecordSaveable = true;
    }

    
    /**
     * Finds the StudentUnitRecord with the currently selected Unit and Student,
     * updates it with the provided marks, and tells the StudentUnitRecord
     * manager singleton to save the record.
     * @param asg1Mark Mark for Assignment 1
     * @param asg2Mark Mark for Assignment 2
     * @param examMark Mark for the exam
     */
    public void saveGrade(float asg1Mark, float asg2Mark, float examMark)
    {
        IUnit unit = UnitManager.UM().getUnit(selectedUnitCode);
        IStudent student = StudentManager.getInstance()
                                            .getStudent(selectedStudentID);

        IStudentUnitRecord record = student.getUnitRecord(selectedUnitCode);
        
        record.setAsg1(asg1Mark);
        record.setAsg2(asg2Mark);
        record.setExam(examMark);
        
        StudentUnitRecordManager.instance().saveRecord(record);
        userInterface.setChangeMarksButtonEnabled(true);
        userInterface.setMarksTextFieldsEnabled(false);
        userInterface.setSaveChangesButtonEnabled(false);
    }
}
