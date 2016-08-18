package datamanagement;
public class UnitProxy implements IUnit
{
    private String unitCode;
    private String unitName;
    UnitManager unitManager;

    public UnitProxy(String unitCode, String unitName)
    {
        this.unitCode = unitCode;
        this.unitName = unitName;
        unitManager = UnitManager.getInstance();
    }

    public String getUnitCode()
    {
        return this.unitCode;
    }

    public String getUnitName()
    {
        return this.unitName;
    }

    public void setPsCutoff(float cutoff)
    {
        unitManager.getUnit(unitCode).setPsCutoff(cutoff);
    }

    public float getPsCutoff()
    {
        return unitManager.getUnit(unitCode).getPsCutoff();
    }

    public void setCrCutoff(float cutoff)
    {
        unitManager.getUnit(unitCode).setCrCutoff(cutoff);
    }

    public float getCrCutoff()
    {
        return unitManager.getUnit(unitCode).getCrCutoff();
    }

    public void setDiCutoff(float cutoff)
    {
        unitManager.getUnit(unitCode).setDiCutoff(cutoff);
    }

    public float getDiCutoff()
    {
        return unitManager.getUnit(unitCode).getDiCutoff();
    }

    public void setHdCutoff(float cutoff)
    {
        unitManager.getUnit(unitCode).setHdCutoff(cutoff);
    }

    public float getHdCutoff()
    {
        return unitManager.getUnit(unitCode).getHdCutoff();
    }

    public void setAeCutoff(float cutoff)
    {
        unitManager.getUnit(unitCode).setAeCutoff(cutoff);
    }

    public float getAeCutoff()
    {
        return unitManager.getUnit(unitCode).getAeCutoff();
    }

    public String calculateGradeString(float f1, float f2, float f3)
    {
        return unitManager.getUnit(unitCode).calculateGradeString(f1, f2, f3);
    }

    public void addStudentUnitRecord(IStudentUnitRecord studentUnitRecord)
    {
        unitManager.getUnit(unitCode).addStudentUnitRecord(studentUnitRecord);
    }

    public IStudentUnitRecord getStudentUnitRecord(int s)
    {
        return unitManager.getUnit(unitCode).getStudentUnitRecord(s);
    }

    public StudentUnitRecordList getStudentUnitRecordList()
    {
        return unitManager.getUnit(unitCode).getStudentUnitRecordList();
    }

    public int getAsg1Weight()
    {
        return unitManager.getUnit(unitCode).getAsg1Weight();
    }

    public int getAsg2Weight()
    {
        return unitManager.getUnit(unitCode).getAsg2Weight();
    }

    public int getExamWeight()
    {
        return unitManager.getUnit(unitCode).getExamWeight();
    }

    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt)
    {
        unitManager.getUnit(unitCode).setAssessmentWeights(asg1Wgt, asg2Wgt,
        		examWgt);
    }
}
