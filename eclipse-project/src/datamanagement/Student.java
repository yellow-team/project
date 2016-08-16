package datamanagement;

/**
 * Representation of a Student
 * Contains the student's ID number, First and Last name,
 * and a list of records (marks for assessments in Units)
 *
 */
public class Student implements IStudent
{

    private Integer               id;
    private String                firstName;
    private String                lastName;
    private StudentUnitRecordList recordList;
    
    /**
     * Creates a new Student object
     * @param id The ID number of the student, used as a key elsewhere.
     * @param firstName Student's first name.
     * @param lastName Student's last name.
     * @param recordList A StudentUnitRecordList of the subjects the student
     * has marks for. If null is passed in place of a StudentUnitRecordList,
     * an empty StudentUnitRecordList will be created.
     */
    public Student(Integer id, String firstName, String lastName,
            StudentUnitRecordList recordList)
    {
        this.id        = id;
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
        return this.id;
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
    
    /**
     * Looks up an IStudentUnitRecord given the unitCode
     * @param unitCode the code of the Unit to look up
     * @return The first matching IStudentUnitRecord, or null if no match.
     */
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
