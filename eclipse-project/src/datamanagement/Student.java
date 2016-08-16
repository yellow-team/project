package datamanagement;

/**
 * Representation of a Student
 * Contains the student's ID number, First and Last name,
 * and a list of records (marks for assessments in Units).
 *
 */
public class Student implements IStudent
{
    private Integer               id;
    private String                firstName;
    private String                lastName;
    private StudentUnitRecordList studentUnitRecordList;
    
    /**
     * Creates a new Student object
     * @param id The ID number of the student, used as a key elsewhere.
     * @param firstName Student's first name.
     * @param lastName Student's last name.
     * @param studentUnitRecordList A StudentUnitRecordList of the 
     * subjects the student has marks for. If null is passed in place
     * of a StudentUnitRecordList, an empty StudentUnitRecordList
     * will be created.
     */
    public Student(Integer id, String firstName, String lastName,
            StudentUnitRecordList studentUnitRecordList)
    {
        this.id        = id;
        this.firstName = firstName;
        this.lastName  = lastName;

        if (studentUnitRecordList == null)
        {
            this.studentUnitRecordList = new StudentUnitRecordList();
        }
        else
        {
            this.studentUnitRecordList = studentUnitRecordList;
        }
    }
    
    
    public Integer getStudentId()
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
    
    
    public void addUnitRecord(IStudentUnitRecord studentUnitRecord)
    {
        studentUnitRecordList.add(studentUnitRecord);
    }
    
    /**
     * Looks up an IStudentUnitRecord given the unitCode
     * @param unitCode the code of the Unit to look up
     * @return The first matching IStudentUnitRecord, or null if no match.
     */
    public IStudentUnitRecord getUnitRecord(String unitCode)
    {
        for (IStudentUnitRecord record : studentUnitRecordList)
        {
            if (record.getUnitCode().equals(unitCode))
            {
                return record;
            }
        }
        return null;
    }
    
    
    public StudentUnitRecordList getStudentUnitRecordList()
    {
        return studentUnitRecordList;
    }
}
