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
    public void setasg1Mark(float asg1Mark)
    {
        studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).setasg1Mark(asg1Mark);
    }
    public float getasg1Mark()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).getasg1Mark();
    }
    public void setasg2Mark(float asg2Mark)
    {
        studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).setasg2Mark(asg2Mark);
    }
    public float getasg2Mark()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).getasg2Mark();
    }
    public void setexamMark(float examMark)
    {
        studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).setexamMark(examMark);
    }
    public float getexamMark()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).getexamMark();
    }
    public float getTotal()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).getTotal();
    }
}
