package datamanagement;

/**
 * Controller object that manages the state transitions of the UI,
 * e.g. enables/disables buttons, 
 *
 */
public class ChangeGradeCTL
{
    ChangeGradeUI ui;
    String        currentUnitCode  = null;
    Integer       currentStudentID = null;
    boolean       changed          = false;

    public ChangeGradeCTL()
    {
    }

    
    
    public void execute()
    {
        ui = new ChangeGradeUI(this);

        ui.setUnitComboBoxEnabled(false);
        ui.setStudentComboBoxEnabled(false);
        ui.setCheckGradeButtonEnabled(false);
        ui.setChangeMarksButtonEnabled(false);
        ui.setMarksTextFieldsEnabled(false);
        ui.setSaveChangesButtonEnabled(false);

        ui.refresh();

        ListUnitsCTL listUnitsController = new ListUnitsCTL();
        listUnitsController.listUnits(ui);
        ui.setVisible(true);
        ui.setUnitComboBoxEnabled(true);
    }

    
    
    public void selectUnit(String unitCode)
    {

        if (unitCode.equals("NONE"))
        {
            ui.setStudentComboBoxEnabled(false);
        }
        else
        {
            ListStudentsCTL listStudentsController = new ListStudentsCTL();
            listStudentsController.listStudents(ui, unitCode);
            currentUnitCode = unitCode;
            ui.setStudentComboBoxEnabled(true);
        }
        ui.setCheckGradeButtonEnabled(false);
    }

    
    
    public void selectStudent(Integer studentId)
    {
        currentStudentID = studentId;
        if (currentStudentID.intValue() == 0)
        {
            ui.refresh();
            ui.setCheckGradeButtonEnabled(false);
            ui.setChangeMarksButtonEnabled(false);
            ui.setMarksTextFieldsEnabled(false);
            ui.setSaveChangesButtonEnabled(false);
        }

        else
        {
            IStudent student = StudentManager.getInstance()
                    .getStudent(studentId);
            IStudentUnitRecord record = student.getUnitRecord(currentUnitCode);

            ui.setRecord(record);
            ui.setCheckGradeButtonEnabled(true);
            ui.setChangeMarksButtonEnabled(true);
            ui.setMarksTextFieldsEnabled(false);
            ui.setSaveChangesButtonEnabled(false);
            changed = false;
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
    public String checkGrade(float asg1Mark, float asg2Mark, float examMark)
    {
        IUnit unit = UnitManager.getInstance().getUnit(currentUnitCode);
        String grade = unit.computeGrade(asg1Mark, asg2Mark, examMark);
        ui.setChangeMarksButtonEnabled(true);
        ui.setMarksTextFieldsEnabled(false);
        if (changed)
        {
            ui.setSaveChangesButtonEnabled(true);
        }
        return grade;
    }

    
    
    public void enableChangeMarks()
    {
        ui.setChangeMarksButtonEnabled(false);
        ui.setSaveChangesButtonEnabled(false);
        ui.setMarksTextFieldsEnabled(true);
        changed = true;
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
        IUnit unit = UnitManager.getInstance().getUnit(currentUnitCode);
        IStudent student = StudentManager.getInstance()
                                            .getStudent(currentStudentID);

        IStudentUnitRecord record = student.getUnitRecord(currentUnitCode);
        
        record.setAsg1(asg1Mark);
        record.setAsg2(asg2Mark);
        record.setExam(examMark);
        
        StudentUnitRecordManager.instance().saveRecord(record);
        ui.setChangeMarksButtonEnabled(true);
        ui.setMarksTextFieldsEnabled(false);
        ui.setSaveChangesButtonEnabled(false);
    }
}
