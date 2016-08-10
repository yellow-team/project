package datamanagement;

/**
 * Proxy class for Student objects managed by StudentManager singleton.
 * Each StudentProxy has a reference to the StudentManager singleton,
 * rather than a StudentUnitRecordList.
 *
 */
public class StudentProxy implements IStudent
{
    private Integer        studentId;
    private String         firstName;
    private String         lastName;
    private StudentManager studentManager;

    public StudentProxy(Integer id, String firstName, String lastName)
    {
        this.studentId = id;
        this.firstName = firstName;
        this.lastName  = lastName;
        studentManager = StudentManager.getInstance();
    }

    public Integer getID()
    {
        return studentId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setFirstName(String firstName)
    {
        studentManager.getStudent(studentId).setFirstName(firstName);
    }

    public void setLastName(String lastName)
    {
        studentManager.getStudent(studentId).setLastName(lastName);
    }

    public void addUnitRecord(IStudentUnitRecord record)
    {
        studentManager.getStudent(studentId).addUnitRecord(record);
    }

    public IStudentUnitRecord getUnitRecord(String unitCode)
    {
        return studentManager.getStudent(studentId).getUnitRecord(unitCode);
    }

    public StudentUnitRecordList getRecordList()
    {
        return studentManager.getStudent(studentId).getRecordList();
    }
}
