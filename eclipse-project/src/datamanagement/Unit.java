package datamanagement;

public class Unit implements IUnit {
    
    private String                unitCode_;
    private String                unitName_;
    private float                 psCutoff_;
    private float                 crCutoff_;
    private float                 dnCutoff_;
    private float                 hdCutoff_;
    private float                 aeCutoff_;
    private int                   asg1Weight_, asg2Weight_, examWeight_;
    private StudentUnitRecordList recordList_;

    
    public Unit(String unitCode, String unitName, 
                float psCutoff,  float crCutoff, 
                float dnCutoff,  float hdCutoff, 
                float aeCutoff,
                int asg1Weight,  int asg2Weight, int examWeight,
                StudentUnitRecordList recordList) {

        unitCode_ = unitCode;
        unitName_ = unitName;

        setCutoffs(psCutoff, crCutoff, dnCutoff, hdCutoff, aeCutoff);
        setAssessmentWeights(asg1Weight, asg2Weight, examWeight);

        if (recordList == null) {
            recordList_ = new StudentUnitRecordList();
        }
        else {
            recordList_ = recordList;
        }
    }

    
    public String getUnitCode() {
        return this.unitCode_;
    }

    
    public String getUnitName() {
        return this.unitName_;
    }

    
    public void setPsCutoff(float cutoff) {
        psCutoff_ = cutoff;
    }

    
    public float getPsCutoff() {
        return psCutoff_;
    }

    
    public void setCrCutoff(float cutoff) {
        crCutoff_ = cutoff;
    }

    
    public float getCrCutoff() {
        return crCutoff_;
    }

    
    public void setDiCutoff(float cutoff) {
        dnCutoff_ = cutoff;
    }

    
    public float getDiCuttoff() {
        return dnCutoff_;
    }

    
    public void setHdCutoff(float cutoff) {
        hdCutoff_ = cutoff;
    }

    
    public float getHdCutoff() {
        return hdCutoff_;
    }

    
    public void setAeCutoff(float cutoff) {
        aeCutoff_ = cutoff;
    }

    
    public float getAeCutoff() {
        return aeCutoff_;
    }

    
    public void addStudentRecord(IStudentUnitRecord record) {
        recordList_.add(record);
    }

    
    public IStudentUnitRecord getStudentRecord(int studentID) {
        for (IStudentUnitRecord r : recordList_) {
            if (r.getStudentID() == studentID) {
                return r;
            }
        }
        return null;
    }

    
    public StudentUnitRecordList getStudentUnitRecordList() {
        return recordList_;
    }

    
    @Override
    public int getAsg1Weight() {
        return asg1Weight_;
    }

    
    @Override
    public int getAsg2Weight() {
        return asg2Weight_;
    }

    
    @Override
    public int getExamWeight() {
        return examWeight_;
    }

    
    @Override
    public void setAssessmentWeights(int asg1Weight, 
                                     int asg2Weight,
                                     int examWeight) {
        if (   asg1Weight < 0 || asg1Weight > 100
            || asg2Weight < 0 || asg2Weight > 100
            || examWeight < 0 || examWeight > 100) {
            throw new RuntimeException("Assessment weights can't be less " +
                                       "than zero or greater than 100");
        }

        if (asg1Weight + asg2Weight + examWeight != 100) {
            throw new RuntimeException("Assessment weights must add to 100");
        }

        asg1Weight_ = asg1Weight;
        asg2Weight_ = asg2Weight;
        examWeight_ = examWeight;
    }

    
    private void setCutoffs(float psCutoff, float crCutoff, 
                            float diCutoff, float hdCutoff, 
                            float aeCutoff) {
    
        if (   psCutoff < 0 || psCutoff > 100
            || crCutoff < 0 || crCutoff > 100
            || diCutoff < 0 || diCutoff > 100
            || hdCutoff < 0 || hdCutoff > 100
            || aeCutoff < 0 || aeCutoff > 100) {
            throw new RuntimeException("Assessment cutoffs can't be less "+
                                       "than zero or greater than 100");
        }
        
        if (aeCutoff >= psCutoff) {
            throw new RuntimeException("AE cutoff must be less than PS cutoff");
        }
        if (psCutoff >= crCutoff) {
            throw new RuntimeException("PS cutoff must be less than CR cutoff");
        }
        if (crCutoff >= diCutoff) {
            throw new RuntimeException("CR cutoff must be less than DI cutoff");
        }
        if (diCutoff >= hdCutoff) {
            throw new RuntimeException("DI cutoff must be less than HD cutoff");
        }
        
        psCutoff_ = psCutoff;
        crCutoff_ = crCutoff;
        dnCutoff_ = diCutoff;
        hdCutoff_ = hdCutoff;
        aeCutoff_ = aeCutoff;
    }

    
    public String computeGrade(float asg1Mark, float asg2Mark, float examMark) {
        
        float totalMarks = asg1Mark + asg2Mark + examMark;
    
        if (   asg1Mark < 0 || asg1Mark > asg1Weight_ 
            || asg2Mark < 0 || asg2Mark > asg2Weight_
            || examMark < 0 || examMark > examWeight_) {
            throw new RuntimeException("Marks cannot be less than zero or " +
                                       "greater than assessment weights");
        }
    
        if (totalMarks < aeCutoff_) {
            return "FL";
        }
        else if (totalMarks < psCutoff_) {
            return "AE";
        }
        else if (totalMarks < crCutoff_) {
            return "PS";
        }
        else if (totalMarks < dnCutoff_) {
            return "CR";
        }
        else if (totalMarks < hdCutoff_) {
            return "DI";
        }
        else {
            return "HD";
        }
    }

}