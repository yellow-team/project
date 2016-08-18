package datamanagement;

public interface IUnit
{
    public String getUnitCode();
    public String getUnitName();

    public float getPsCutoff();
    public void  setPsCutoff(float cutoff);

    public float getCrCutoff();
    public void  setCrCutoff(float cutoff);

    public float getDiCutoff();
    public void  setDiCutoff(float cutoff);

    public float getHdCutoff();
    public void  setHdCutoff(float cutoff);

    public float getAeCutoff();
    public void  setAeCutoff(float cutoff);

    public int getAsg1Weight();
    public int getAsg2Weight();
    public int getExamWeight();
    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt);

    public String calculateGradeString(float asg1Mark, float asg2Mark, float examMark);

    public void addStudentRecord(IStudentUnitRecord studentUnitRecord);
    public IStudentUnitRecord getStudentRecord(int studentId);

    public StudentUnitRecordList getStudentRecordList();
}
