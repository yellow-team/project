package datamanagement;
public class StudentUnitRecordProxy implements IStudentUnitRecord
{
    private Integer studentID;
    private String unitCode;
    private StudentUnitRecordManager studentUnitRecordManger;

    public StudentUnitRecordProxy(Integer studentId, String unitCode)
    {
        this.studentID = studentId;
        this.unitCode = unitCode;
        this.studentUnitRecordManger = StudentUnitRecordManager.getInstance();
    }
    public Integer getStudentID()
    {
        return studentID;
    }
    public String getUnitCode()
    {
        return unitCode;
    }
    public void setAsg1Mark(float asg1Mark)
    {
        studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode)
        .setAsg1Mark(asg1Mark);
    }
    public float getAsg1Mark()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode)
        		.getAsg1Mark();
    }
    public void setAsg2Mark(float asg2Mark)
    {
        studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode)
        .setAsg2Mark(asg2Mark);
    }
    public float getAsg2Mark()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode)
        		.getAsg2Mark();
    }
    public void setExamMark(float examMark)
    {
        studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode)
        .setExamMark(examMark);
    }
    public float getExamMark()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode)
        		.getExamMark();
    }
    public float getTotal()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode)
        		.getTotal();
    }
}
