package datamanagement;

public interface IStudentUnitRecord 
{
    public Integer getStudentID();
    public String getUnitCode();

    public void setasg1Mark(float asg1Mark);
    public float getasg1Mark();

    public void setasg2Mark(float asg2Mark);
    public float getasg2Mark();

    public void setexamMark(float examMark);
    public float getexamMark();

    public float getTotal();
}
