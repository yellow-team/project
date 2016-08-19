package datamanagement;

public class StudentUnitRecordProxy implements IStudentUnitRecord
{
    private Integer studentId;
    private String unitCode;
    private StudentUnitRecordManager studentUnitRecordManger;

    public StudentUnitRecordProxy(Integer studentId, String unitCode)
    {
        this.studentId = studentId;
        this.unitCode = unitCode;
        this.studentUnitRecordManger = StudentUnitRecordManager.getInstance();
    }

    public Integer getStudentId()
    {
        return studentId;
    }

    public String getUnitCode()
    {
        return unitCode;
    }

    public void setAsg1Mark(float asg1Mark)
    {
        studentUnitRecordManger.getStudentUnitRecord(studentId, unitCode)
            .setAsg1Mark(asg1Mark);
    }

    public float getAsg1Mark()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentId, unitCode)
                .getAsg1Mark();
    }

    public void setAsg2Mark(float asg2Mark)
    {
        studentUnitRecordManger.getStudentUnitRecord(studentId, unitCode)
            .setAsg2Mark(asg2Mark);
    }

    public float getAsg2Mark()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentId, unitCode)
                .getAsg2Mark();
    }

    public void setExamMark(float examMark)
    {
        studentUnitRecordManger.getStudentUnitRecord(studentId, unitCode)
            .setExamMark(examMark);
    }

    public float getExamMark()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentId, unitCode)
                .getExamMark();
    }

    public float calculateSumOfMarks()
    {
        return studentUnitRecordManger.getStudentUnitRecord(studentId, unitCode)
                .calculateSumOfMarks();
    }
}
