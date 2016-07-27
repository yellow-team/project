package datamanagement;


//This class links a student with a unit along with the results for that unit.
public class StudentUnitRecord implements IStudentUnitRecord
{
	private Integer studentId; //changed sid->studentId
	private String unitCode; //changed uc->unitCode
	private float asg1Score, asg2Score, examScore; //changed a1->asg1Score, a2->asg2Score, exam->examScore

	public StudentUnitRecord(Integer studentId, String unitCode, float asg1Score, float asg2Score, float examScore) 
	{
		this.studentId = studentId;
		this.unitCode = unitCode;
		this.setAsg1Score(asg1Score);
		this.setAsg2Score(asg2Score);
		this.setExamScore(examScore);
	}

	public Integer getStudentID() 
	{
		return studentId;
	}

	public String getUnitCode() 
	{
		return unitCode;
	}

	public void setAsg1Score(float asg1Score) 
	{
		if (asg1Score < 0 || asg1Score > UnitManager.instance().getUnit(unitCode).getAsg1Weight()) 
		{
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.asg1Score = asg1Score;
	}

	public float getAsg1Score() 
	{
		return asg1Score;
	}

	public void setAsg2Score(float asg2Score) 
	{
		if (asg2Score < 0 || asg2Score > UnitManager.instance().getUnit(unitCode).getAsg2Weight()) 
		{
			throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.asg2Score = asg2Score;

	}

	public float getAsg2Score() 
	{
		return asg2Score;
	}

	public void setExamScore(float examScore) 
	{
		if (examScore < 0 || examScore > UnitManager.instance().getUnit(unitCode).getExamWeight()) 
		{
				throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
		}
		this.examScore = examScore;
	}

	public float getExamScore() 
	{
		return examScore;
	}

	public float getTotal() 
	{
		return asg1Score + asg2Score + examScore;
	}
}
