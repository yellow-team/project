package datamanagement;
//also need to commit:
//- gUI.java
public interface IStudentUnitRecord 
{
    public Integer getStudentID();
    public String getUnitCode();

    public void setAsg1Score(float asg1Score);
    public float getAsg1Score();

    public void setAsg2Score(float asg2Score);
    public float getAsg2Score();

    public void setExamScore(float examScore);
    public float getExamScore();

    public float getTotal();
}
