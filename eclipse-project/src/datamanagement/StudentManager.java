package datamanagement;

import org.jdom.*;

import java.util.HashMap;
import java.util.List;

public class StudentManager
{
    private final static StudentManager self = new StudentManager();

    private StudentMap                  studentMap;
    private HashMap<String, StudentMap> unitToStudentMapMap;

    public static StudentManager getInstance()
    {
        return self;
    }

    private StudentManager()
    {
        studentMap          = new StudentMap();
        unitToStudentMapMap = new HashMap<String, StudentMap>();
    }

    public IStudent getStudent(Integer id)
    {
        IStudent student = studentMap.get(id);

        if (student == null)
        {
            return createStudent(id);
        }
        else
        {
            return student;
        }
    }

    private Element getStudentElement(Integer id)
    {
        for (Element el : (List<Element>) XMLManager.getInstance().getDocument()
                .getRootElement().getChild("studentTable")
                .getChildren("student"))
        {

            if (id.toString().equals(el.getAttributeValue("sid")))
            {
                return el;
            }
        }
        return null;
    }

    private IStudent createStudent(Integer id)
    {
        IStudent student;
        Element el = getStudentElement(id);

        if (el != null)
        {
            StudentUnitRecordList recordList = StudentUnitRecordManager
                    .instance().getRecordsByStudent(id);
            student = new Student(new Integer(el.getAttributeValue("sid")),
                    el.getAttributeValue("fname"),
                    el.getAttributeValue("lname"), recordList);

            studentMap.put(student.getID(), student);
            return student;
        }

        throw new RuntimeException("DBMD: createStudent : student not in file");
    }

    private IStudent createStudentProxy(Integer id)
    {
        Element el = getStudentElement(id);

        if (el != null)
            return new StudentProxy(id, el.getAttributeValue("fname"),
                    el.getAttributeValue("lname"));
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }

    public StudentMap getStudentsByUnit(String unitCode)
    {
        StudentMap studentMap = unitToStudentMapMap.get(unitCode);

        if (studentMap != null)
        {
            return studentMap;
        }

        studentMap = new StudentMap();
        IStudent student;
        StudentUnitRecordList recordList = StudentUnitRecordManager.instance()
                .getRecordsByUnit(unitCode);

        for (IStudentUnitRecord record : recordList)
        {
            student = createStudentProxy(new Integer(record.getStudentID()));
            studentMap.put(student.getID(), student);
        }

        unitToStudentMapMap.put(unitCode, studentMap);
        return studentMap;
    }
}
