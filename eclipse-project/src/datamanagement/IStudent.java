package datamanagement;

/**
 * Interface for Student objects
 *
 */
public interface IStudent
{

    public Integer getId();

    public String getFirstName();
    public void setFirstName(String firstName);

    public String getLastName();
    public void setLastName(String lastName);

    public void addUnitRecord(IStudentUnitRecord record);

    public IStudentUnitRecord getUnitRecord(String unitCode);

    public StudentUnitRecordList getStudentUnitRecordList();

}
