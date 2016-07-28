package datamanagement;

public class ChangeGradeController
{
    ChangeGradeUI ui;
    String        currentUnitCode  = null;
    Integer       currentStudentID = null;
    boolean       changed          = false;

    public ChangeGradeController()
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

        ListUnitsController listUnitsController = new ListUnitsController();
        listUnitsController.listUnits(ui);
        ui.setVisible(true);
        ui.setUnitComboBoxEnabled(true);
    }

    
    public void unitSelected(String unitCode)
    {

        if (unitCode.equals("NONE"))
        {
            ui.setStudentComboBoxEnabled(false);
        }
        else
        {
            ListStudentsController listStudentsController = new ListStudentsController();
            listStudentsController.listStudents(ui, unitCode);
            currentUnitCode = unitCode;
            ui.setStudentComboBoxEnabled(true);
        }
        ui.setCheckGradeButtonEnabled(false);
    }

    
    public void studentSelected(Integer studentId)
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

    
    public String checkGrade(float asg1Mark, float asg2Mark, float examMark)
    {
        IUnit unit = UnitManager.getInstance().getUnit(currentUnitCode);
        String student = unit.computeGrade(asg1Mark, asg2Mark, examMark);
        ui.setChangeMarksButtonEnabled(true);
        ui.setMarksTextFieldsEnabled(false);
        if (changed)
        {
            ui.setSaveChangesButtonEnabled(true);
        }
        return student;
    }

    
    public void enableChangeMarks()
    {
        ui.setChangeMarksButtonEnabled(false);
        ui.setSaveChangesButtonEnabled(false);
        ui.setMarksTextFieldsEnabled(true);
        changed = true;
    }

    
    public void saveGrade(float asg1Mark, float asg2Mark, float examMark)
    {

        IUnit u = UnitManager.getInstance().getUnit(currentUnitCode);
        IStudent s = StudentManager.getInstance().getStudent(currentStudentID);

        IStudentUnitRecord record = s.getUnitRecord(currentUnitCode);
        record.setAsg1(asg1Mark);
        record.setAsg2(asg2Mark);
        record.setExam(examMark);
        StudentUnitRecordManager.instance().saveRecord(record);
        ui.setChangeMarksButtonEnabled(true);
        ui.setMarksTextFieldsEnabled(false);
        ui.setSaveChangesButtonEnabled(false);
    }
}
