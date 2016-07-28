package datamanagement;

public class ChangeGradeController {

    ChangeGradeUI ui_;
    String        currentUnitCode_  = null;
    Integer       currentStudentID_ = null;
    boolean       changed_          = false;

    public ChangeGradeController() {
    }

    public void execute() {
        ui_ = new ChangeGradeUI(this);
        
        ui_.setUnitComboBoxEnabled(false);
        ui_.setStudentComboBoxEnabled(false);
        ui_.setCheckGradeButtonEnabled(false);
        ui_.setChangeMarksButtonEnabled(false);
        ui_.setMarksTextFieldsEnabled(false);
        ui_.setSaveChangesButtonEnabled(false);
        
        ui_.refresh();

        ListUnitsController listUnitsController = new ListUnitsController();
        listUnitsController.listUnits(ui_);
        ui_.setVisible(true);
        ui_.setUnitComboBoxEnabled(true);
    }

    public void unitSelected(String unitCode) {

        if (unitCode.equals("NONE")) {
            ui_.setStudentComboBoxEnabled(false);
        }
        else {
            ListStudentsController listStudentsController = new ListStudentsController();
            listStudentsController.listStudents(ui_, unitCode);
            currentUnitCode_ = unitCode;
            ui_.setStudentComboBoxEnabled(true);
        }
        ui_.setCheckGradeButtonEnabled(false);
    }

    public void studentSelected(Integer studentId) {
        currentStudentID_ = studentId;
        if (currentStudentID_.intValue() == 0) {
            ui_.refresh();
            ui_.setCheckGradeButtonEnabled(false);
            ui_.setChangeMarksButtonEnabled(false);
            ui_.setMarksTextFieldsEnabled(false);
            ui_.setSaveChangesButtonEnabled(false);
        }

        else {
            IStudent student = StudentManager.get().getStudent(studentId);
            IStudentUnitRecord record = student.getUnitRecord(currentUnitCode_);

            ui_.setRecord(record);
            ui_.setCheckGradeButtonEnabled(true);
            ui_.setChangeMarksButtonEnabled(true);
            ui_.setMarksTextFieldsEnabled(false);
            ui_.setSaveChangesButtonEnabled(false);
            changed_ = false;
        }
    }

    public String checkGrade(float asg1Mark, float asg2Mark, float examMark) {
        IUnit unit = UnitManager.getInstance().getUnit(currentUnitCode_);
        String student = unit.computeGrade(asg1Mark, asg2Mark, examMark);
        ui_.setChangeMarksButtonEnabled(true);
        ui_.setMarksTextFieldsEnabled(false);
        if (changed_) {
            ui_.setSaveChangesButtonEnabled(true);
        }
        return student;
    }

    public void enableChangeMarks() {
        ui_.setChangeMarksButtonEnabled(false);
        ui_.setSaveChangesButtonEnabled(false);
        ui_.setMarksTextFieldsEnabled(true);
        changed_ = true;
    }

    public void saveGrade(float asg1Mark, float asg2Mark, float examMark) {

        IUnit u = UnitManager.getInstance().getUnit(currentUnitCode_);
        IStudent s = StudentManager.get().getStudent(currentStudentID_);

        IStudentUnitRecord record = s.getUnitRecord(currentUnitCode_);
        record.setAsg1(asg1Mark);
        record.setAsg2(asg2Mark);
        record.setExam(examMark);
        StudentUnitRecordManager.instance().saveRecord(record);
        ui_.setChangeMarksButtonEnabled(true);
        ui_.setMarksTextFieldsEnabled(false);
        ui_.setSaveChangesButtonEnabled(false);
    }
}
