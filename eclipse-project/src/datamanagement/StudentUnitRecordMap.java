package datamanagement;

public class StudentUnitRecordMap
extends java.util.HashMap<String, IStudentUnitRecord>
{
    private static final long serialVersionUID = 3272800013952389204L;

    /**
     * Avoids programmer needing to know 'magic formula' for the key. Has
     * same name as Map's method to increase familiarity and make it easy to
     * stumble across this one instead of Map's.
     */
    public IStudentUnitRecord get(Integer studentId, String unitCode)
    {
        return super.get(studentId.toString() + unitCode);
    }

    /**
     * Avoids programmer needing to know 'magic formula' for the key. Has
     * same name as Map's method to increase familiarity and make it easy to
     * stumble across this one instead of Map's.
     */
    public void put(Integer studentId, String unitCode,
    		IStudentUnitRecord iStudentUnitRecord)
    {
        super.put(studentId.toString() + unitCode, iStudentUnitRecord);
    }
    //TODO: find out how to disable super's methods from being
    //accessed to force use of these.
}
