package datamanagement;
//key is studentID + unit code (as string). Not very good. I will fix this.
public class StudentUnitRecordMap extends java.util.HashMap<String, IStudentUnitRecord>
{
	private static final long serialVersionUID = 3272800013952389204L;
	
	public IStudentUnitRecord get(Integer studentID, String unitCode)
	{
		return super.get(studentID.toString()+unitCode);
	}
	public void put(Integer studentID, String unitCode, IStudentUnitRecord iStudentUnitRecord)
	{
		super.put(studentID.toString()+unitCode, iStudentUnitRecord);
	}	
}
