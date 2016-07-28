package datamanagement;

public class Student implements IStudent {
    
    private Integer               id_;
    private String                firstName_;
    private String                lastName_;
    private StudentUnitRecordList recordList_;

    public Student(Integer id, 
                   String firstName, String lastName,
                   StudentUnitRecordList recordList) {
        
        id_        = id;
        firstName_ = firstName;
        lastName_  = lastName;
        
        if (recordList == null) {
            recordList_ = new StudentUnitRecordList();
        }
        else {
            recordList_ = recordList;
        }
    }

    public Integer getID() {
        return this.id_;
    }

    public String getFirstName() {
        return firstName_;
    }

    public void setFirstName(String firstName) {
        this.firstName_ = firstName;
    }

    public String getLastName() {
        return lastName_;
    }

    public void setLastName(String lastName) {

        this.lastName_ = lastName;
    }

    public void addUnitRecord(IStudentUnitRecord record) {
        recordList_.add(record);
    }

    public IStudentUnitRecord getUnitRecord(String unitCode) {
        for (IStudentUnitRecord record : recordList_) {
            if (record.getUnitCode().equals(unitCode)) {
                return record;
            }
        }

        return null;
    }

    public StudentUnitRecordList getUnitRecords() {
        return recordList_;
    }
}
