package datamanagement;



public class StudentUnitRecord implements IStudentUnitRecord
{
    private Integer studentId;
    private String unitCode;
    private float asg1Mark, asg2Mark, examMark;

    public StudentUnitRecord(Integer studentId, String unitCode, float asg1Mark, float asg2Mark, float examMark)
    {
        this.studentId = studentId;
        this.unitCode = unitCode;
        this.setasg1Mark(asg1Mark);
        this.setasg2Mark(asg2Mark);
        this.setexamMark(examMark);
    }

    public Integer getStudentID()
    {
        return studentId;
    }

    public String getUnitCode()
    {
        return unitCode;
    }

    public void setasg1Mark(float asg1Mark)
    {
        if (asg1Mark < 0 || asg1Mark > UnitManager.getInstance().getUnit(unitCode).getAsg1Weight())
        {
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
        }
        this.asg1Mark = asg1Mark;
    }

    public float getasg1Mark()
    {
        return asg1Mark;
    }

    public void setasg2Mark(float asg2Mark)
    {
        if (asg2Mark < 0 || asg2Mark > UnitManager.getInstance().getUnit(unitCode).getAsg2Weight())
        {
            throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
        }
        this.asg2Mark = asg2Mark;

    }

    public float getasg2Mark()
    {
        return asg2Mark;
    }

    public void setexamMark(float examMark)
    {
        if (examMark < 0 || examMark > UnitManager.getInstance().getUnit(unitCode).getExamWeight())
        {
                throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
        }
        this.examMark = examMark;
    }

    public float getexamMark()
    {
        return examMark;
    }

    public float getTotal()
    {
        return asg1Mark + asg2Mark + examMark;
    }
}
