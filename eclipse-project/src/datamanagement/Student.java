package datamanagement;

/**
 * Representation of a Student
 * Contains the student's ID number, First and Last name,
 * and a list of records (marks for assessments in Units)
 *
 */
public class Student implements IStudent
{

    private Integer               id_;
    private String                firstName;
    private String                lastName;
    private StudentUnitRecordList recordList;

    public Student(Integer id, String firstName, String lastName,
            StudentUnitRecordList recordList)
    {

        this.id_       = id;
        this.firstName = firstName;
        this.lastName  = lastName;

        if (recordList == null)
        {
            this.recordList = new StudentUnitRecordList();
        }
        else
        {
            this.recordList = recordList;
        }
    }

    public Integer getID()
    {
        return this.id_;
    }

    
    
    public String getFirstName()
    {
        return firstName;
    }

    
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    
    
    public String getLastName()
    {
        return lastName;
    }

    
    
    public void setLastName(String lastName)
    {

        this.lastName = lastName;
    }

    
    
    public void addUnitRecord(IStudentUnitRecord record)
    {
        recordList.add(record);
    }

    
    
    public IStudentUnitRecord getUnitRecord(String unitCode)
    {
        for (IStudentUnitRecord record : recordList)
        {
            if (record.getUnitCode().equals(unitCode))
            {
                return record;
            }
        }

        return null;
    }

    
    
    public StudentUnitRecordList getRecordList()
    {
        return recordList;
    }
}
