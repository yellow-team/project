package datamanagement;

public interface IStudentUnitRecord
{
    public Integer getStudentId();
    public String getUnitCode();

    public void setAsg1Mark(float asg1Mark);
    public float getAsg1Mark();

    public void setAsg2Mark(float asg2Mark);
    public float getAsg2Mark();

    public void setExamMark(float examMark);
    public float getExamMark();

    public float calculateSumOfMarks();
}
