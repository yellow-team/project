package datamanagement;

/**
 * Interface for Student objects
 *
 */
public interface IStudent
{
    public Integer getStudentId();

    public String getFirstName();
    public void setFirstName(String firstName);

    public String getLastName();
    public void setLastName(String lastName);

    public void addUnitRecord(IStudentUnitRecord studentUnitRecord);

    public IStudentUnitRecord getUnitRecord(String unitCode);

    public StudentUnitRecordList getStudentUnitRecordList();
}
