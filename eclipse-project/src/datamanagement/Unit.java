package datamanagement;

public class Unit implements IUnit
{
    private String unitCode;
    private String unitName;
    private float psCutoff;
    private float crCutoff;
    private float diCutoff;
    private float hdCutoff;
    private float aeCutoff;
    private int asg1Weight, asg2Weight, examWeight;

    private StudentUnitRecordList studentUnitRecordList;

    public Unit(String unitCode, String unitName, float psCutoff,
    		float crCutoff, float diCutoff, float hdCutoff, float aeCutoff,
    		int asg1Weight, int asg2Weight, int examWeight,
    		StudentUnitRecordList studentUnitRecordList)
    {
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.psCutoff = psCutoff;
        this.crCutoff = crCutoff;
        this.diCutoff = diCutoff;
        this.hdCutoff = hdCutoff;
        this.aeCutoff = aeCutoff;
        setAssessmentWeights(asg1Weight, asg2Weight, examWeight);
        this.studentUnitRecordList = studentUnitRecordList == null ?
        		new StudentUnitRecordList() : studentUnitRecordList;
    }

    public String getUnitCode()
    {
        return unitCode;
    }

    public String getUnitName()
    {
        return unitName;
    }

    public void setPsCutoff(float psCutoff)
    {
        this.psCutoff = psCutoff;
    }

    public float getPsCutoff()
    {
        return psCutoff;
    }

    public void setCrCutoff(float crCutoff)
    {
        this.crCutoff = crCutoff;
    }

    public float getCrCutoff()
    {
        return crCutoff;
    }

    public void setDiCutoff(float diCutoff)
    {
        this.diCutoff = diCutoff;
    }

    public float getDiCutoff()
    {
        return diCutoff;
    }

    public void setHdCutoff(float hdCutoff)
    {
        this.hdCutoff = hdCutoff;
    }

    public float getHdCutoff()
    {
        return hdCutoff;
    }

    public void setAeCutoff(float aeCutoff)
    {
        this.aeCutoff = aeCutoff;
    }

    public float getAeCutoff()
    {
        return aeCutoff;
    }

    public void addStudentRecord(IStudentUnitRecord record)
    {
        studentUnitRecordList.add(record);
    }

    public IStudentUnitRecord getStudentRecord(int studentID)
    {
        for (IStudentUnitRecord r : studentUnitRecordList)
        {
            if (r.getStudentID() == studentID)
            {
                return r;
            }
        }
        return null;
    }

    public StudentUnitRecordList getStudentRecordList()
    {
        return studentUnitRecordList;
    }

    @Override
    public int getAsg1Weight()
    {
        return asg1Weight;
    }

    @Override
    public int getAsg2Weight()
    {
        return asg2Weight;
    }

    @Override
    public int getExamWeight()
    {
        return examWeight;
    }

    @Override
    public void setAssessmentWeights(int asg1Weight, int asg2Weight,
    		int examWeight)
    {
        if (asg1Weight < 0 || asg1Weight > 100 ||
            asg2Weight < 0 || asg2Weight > 100 ||
            examWeight < 0 || examWeight > 100 )
        {
            throw new RuntimeException
            ("Assessment weights cant be less than zero or greater than 100");
        }
        if (asg1Weight + asg2Weight + examWeight != 100)
        {
            throw new RuntimeException("Assessment weights must add to 100");
        }
        this.asg1Weight = asg1Weight;
        this.asg2Weight = asg2Weight;
        this.examWeight = examWeight;
    }

    private void setCutoffs(float aeCutoff, float psCutoff, float crCutoff,
    		float diCutoff, float hdCutoff)
    {
        if (psCutoff < 0 || psCutoff > 100 ||
            crCutoff < 0 || crCutoff > 100 ||
            diCutoff < 0 || diCutoff > 100 ||
            hdCutoff < 0 || hdCutoff > 100 ||
            aeCutoff < 0 || aeCutoff > 100 )
        {
            throw new RuntimeException
            ("Assessment cutoffs cant be less than zero or greater than 100");
        }
        if (aeCutoff >= psCutoff)
        {
            throw new RuntimeException(Constants.AE
            		+ " cutoff must be less than "
            		+ Constants.PASS + " cutoff");
        }
        if (psCutoff >= crCutoff)
        {
            throw new RuntimeException(Constants.PASS
            		+ " cutoff must be less than "
            		+ Constants.CREDIT +" cutoff");
        }
        if (crCutoff >= diCutoff)
        {
            throw new RuntimeException(Constants.CREDIT
            		+ " cutoff must be less than " + Constants.DISTINCTION
            		+ " cutoff");
        }
        if (diCutoff >= hdCutoff)
        {
            throw new RuntimeException(Constants.DISTINCTION
            		+ " cutoff must be less than "
            		+ Constants.HIGH_DISTINCTION + " cutoff");
        }
    }

    public String getGrade(float asg1Mark, float asg2Mark, float examMark)
    {
        float total = asg1Mark + asg2Mark + examMark;

        if (asg1Mark < 0 || asg1Mark > asg1Weight ||
                asg2Mark < 0 || asg2Mark > asg2Weight ||
                examMark < 0 || examMark > examWeight )
        {
            throw new RuntimeException("marks cannot be less than zero "
            		+ "or greater than assessment weights");
        }

        if (total < aeCutoff)
        {
            return "FL";
        }
        else if (total < psCutoff)
            return "AE";
        else if (total < crCutoff)
            return "PS";
        else if (total < diCutoff)
            return "CR";
        else if (total < hdCutoff)
            return "DI";
        else
            return "HD";
    }
}
