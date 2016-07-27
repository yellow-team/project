package datamanagement;
public class StudentUnitRecordProxy implements IStudentUnitRecord 
{
	private Integer studentID;
	private String unitCode;
	private StudentUnitRecordManager studentUnitRecordManger;
	
	public StudentUnitRecordProxy(Integer studentId, String unitCode) 
	{
		this.studentID = studentId;
		this.unitCode = unitCode;
		this.studentUnitRecordManger = StudentUnitRecordManager.instance();
	}
	public Integer getStudentID() 
	{ 
		return studentID;
	}
	public String getUnitCode() 
	{ 
		return unitCode; 
	}
	public void setAsg1Score(float asg1Score) 
	{
		studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).setAsg1Score(asg1Score);
	}
	public float getAsg1Score() 
	{
		return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).getAsg1Score();
	}
	public void setAsg2Score(float asg2Score) 
	{ 
		studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).setAsg2Score(asg2Score);
	}
	public float getAsg2Score() 
	{
		return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).getAsg2Score();
	}
	public void setExamScore(float examScore) 
	{
		studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).setExamScore(examScore);
	}
	public float getExamScore() 
	{
		return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).getExamScore();
	}
	public float getTotal() 
	{
		return studentUnitRecordManger.getStudentUnitRecord(studentID, unitCode).getTotal();
	}
}
