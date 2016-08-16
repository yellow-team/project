package datamanagement;

import org.jdom.*;

import java.util.HashMap;
import java.util.List;

/**
 * Singleton class that manages Student objects and their proxies.
 * Reads from Student data stored as XML.
 * Provides StudentMaps of proxied Student objects for Units.
 *
 */
public class StudentManager
{
    private static StudentManager self = null;

    private StudentMap                  studentMap;
    private HashMap<String, StudentMap> unitToStudentMapMap;

    
    public static StudentManager getInstance()
    {
        if (self == null)
        {
            self = new StudentManager();
        }
        
        return self;
    }
    
    
    private StudentManager()
    {
        this.studentMap          = new StudentMap();
        this.unitToStudentMapMap = new HashMap<String, StudentMap>();
    }
    
    /**
     * Gets an IStudent for the given student ID
     * @param studentId The ID of the IStudent to get
     * @return A Student object for the given ID
     */
    public IStudent getStudent(Integer studentId)
    {
        IStudent student = studentMap.get(studentId);

        if (student == null)
        {
            return createStudent(studentId);
        }
        
        return student;
    }
    
    
    private Element getStudentElement(Integer studentId)
    {
        for (Element el : (List<Element>) XMLManager.getInstance().getDocument()
                .getRootElement().getChild("studentTable")
                .getChildren("student"))
        {

            if (studentId.toString().equals(el.getAttributeValue("sid")))
            {
                return el;
            }
        }
        return null;
    }
    
    
    private IStudent createStudent(Integer studentId)
    {
        IStudent student;
        Element el = getStudentElement(studentId);

        if (el != null)
        {
            StudentUnitRecordList studentUnitRecordList = 
                                            StudentUnitRecordManager.instance()
                                            .getRecordsByStudent(studentId);
            student = new Student(new Integer(el.getAttributeValue("sid")),
                    el.getAttributeValue("fname"),
                    el.getAttributeValue("lname"), studentUnitRecordList);

            studentMap.put(student.getStudentId(), student);
            return student;
        }

        throw new RuntimeException("DBMD: createStudent : student not in file");
    }
    
    
    private IStudent createStudentProxy(Integer studentId)
    {
        Element el = getStudentElement(studentId);

        if (el != null) {
            return new StudentProxy(studentId,
                                    el.getAttributeValue("fname"),
                                    el.getAttributeValue("lname"));
        }
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }
    
    /**
     * Given a unit code, retrieves the associated StudentMap.
     * If the map does not exist, a StudentMap of proxied Student objects
     * is generated
     * @param unitCode The code of the Unit to get students for.
     * @return A StudentMap of proxied Student objects for the given unit code.
     */
    public StudentMap getStudentsByUnit(String unitCode)
    {
        StudentMap studentProxyMap = unitToStudentMapMap.get(unitCode);

        if (studentProxyMap != null)
        {
            return studentProxyMap;
        }

        studentProxyMap = new StudentMap();
        IStudent student;
        StudentUnitRecordList recordList = StudentUnitRecordManager.instance()
                .getRecordsByUnit(unitCode);

        for (IStudentUnitRecord record : recordList)
        {
            student = createStudentProxy(new Integer(record.getStudentID()));
            studentProxyMap.put(student.getStudentId(), student);
        }

        unitToStudentMapMap.put(unitCode, studentProxyMap);
        return studentProxyMap;
    }
}
