package datamanagement;

import java.util.List;
import org.jdom.*;

public class StudentUnitRecordManager
{
    private static StudentUnitRecordManager self = null;
    private StudentUnitRecordMap studentUnitRecordMap;
    private java.util.HashMap<String,StudentUnitRecordList> mapStudentUnitRecordListByUnitCode;
    private java.util.HashMap<Integer,StudentUnitRecordList> mapStudentUnitRecordListByStudentId;

    public static StudentUnitRecordManager getInstance()
    {
        if (self == null )
        {
            self = new StudentUnitRecordManager();
        }
        return self;
    }

    private StudentUnitRecordManager()
    {
        studentUnitRecordMap                = new StudentUnitRecordMap();
        mapStudentUnitRecordListByUnitCode  = new java.util.HashMap<>();
        mapStudentUnitRecordListByStudentId = new java.util.HashMap<>();
    }

    public IStudentUnitRecord getStudentUnitRecord(Integer unitCode,
                                                   String studentId)
    {
        IStudentUnitRecord iStudentUnitRecord = studentUnitRecordMap.get
                (unitCode, studentId);
        if(iStudentUnitRecord != null)
        {
            return iStudentUnitRecord;
        }
        return createStudentUnitRecord(unitCode, studentId);
    }

    /**
     * Goes through the XML file of records to find the data corresponding to
     * the given unit code and student ID. It then creates and returns an
     * object of type IStudentUnitRecord (this class simply associates the two)
     * with these details. It also places the object in a map which has a key of
     * student ID concatenated with unit code(of which there is only one,
     * because StudentUnitRecordManager is a singleton class).
     *
     * @param unitCode This is the unit code (unit being taken by student given
     * by studentId) to find in the records
     * @param studentId This is the student ID to find in the records (student
     * taking unit given by unitCode)
     * @return Object of type IStudentUnitRecord that associates the unit code
     * and student ID if it exists in the XML record
     * @exception RuntimException if no association between the given unit code
     * and student ID exists.
     */
    private IStudentUnitRecord createStudentUnitRecord(Integer studentId,
                                                        String unitCode)
    {
        IStudentUnitRecord iStudentUnitRecord;
        for (Element el : (List<Element>) XMLManager.getXML().getDocument()
                .getRootElement().getChild("studentUnitRecordTable")
                .getChildren("record"))
        {
            if (studentId.toString().equals
                    (el.getAttributeValue(Constants.STUDENT_ID)) &&
                    unitCode.equals(el.getAttributeValue(Constants.UNIT_ID)))
            {
                Integer tempStudentId = new Integer
                        (el.getAttributeValue(Constants.STUDENT_ID));
                String tempUnitId = el.getAttributeValue(Constants.UNIT_ID);
                float tempAsg1Mark = new Float(el.getAttributeValue
                        (Constants.ASG_1)).floatValue();
                float tempAsg2Mark = new Float(el.getAttributeValue
                        (Constants.ASG_2)).floatValue();
                float tempExamMark = new Float(el.getAttributeValue
                        (Constants.EXAM)).floatValue();

                iStudentUnitRecord = new StudentUnitRecord(tempStudentId,
                                                            tempUnitId,
                                                            tempAsg1Mark,
                                                            tempAsg2Mark,
                                                            tempExamMark);
                studentUnitRecordMap.put(iStudentUnitRecord.getStudentId(),
                        iStudentUnitRecord.getUnitCode(), iStudentUnitRecord);
                return iStudentUnitRecord;
            }
        }
        throw new RuntimeException
            ("DBMD: createStudent : student unit record not in file");
    }

    /**
     * Looks in the map of student/unit association records that is organised
     * with unit code as the key. If it doesn't exit, it looks through the XML
     * file to find them, and adds them to the map in case they
     * need to be looked up later, then it returns them.
     *
     * @param unitCode Key to look up
     * @return StudentUnitRecordList of all associations between students
     * and the given unit code.
     */
    public StudentUnitRecordList getStudentUnitRecordsByUnit(String unitCode)
    {
        StudentUnitRecordList studentUnitRecordList =
                mapStudentUnitRecordListByUnitCode.get(unitCode);
        if (studentUnitRecordList != null)
        {
            return studentUnitRecordList;
        }
        studentUnitRecordList = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument()
                .getRootElement().getChild("studentUnitRecordTable")
                .getChildren("record"))
        {
            if (unitCode.equals(el.getAttributeValue(Constants.UNIT_ID)))
            {
                studentUnitRecordList.add(new StudentUnitRecordProxy(new Integer
                        (el.getAttributeValue(Constants.STUDENT_ID)),
                        el.getAttributeValue(Constants.UNIT_ID)));
            }
        }
        if (studentUnitRecordList.size() > 0)
        {
            mapStudentUnitRecordListByUnitCode.put
                (unitCode, studentUnitRecordList);
        }
        return studentUnitRecordList;
    }

    /**
     * Looks in the map of student/unit association records that is organised
     * with student ID as the key. If it doesn't exit, it looks through the
     * XML file to find them, and adds them to the map in case they
     * need to be looked up later, then it returns them.
     *
     * @param studentId Key to look up
     * @return StudentUnitRecordList of all associations between units and the
     * student ID given.
     */
    public StudentUnitRecordList getRecordsByStudent(Integer studentId)
    {
        StudentUnitRecordList recs = mapStudentUnitRecordListByStudentId.get(studentId);
        if (recs != null)
        {
            return recs;
        }
        recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument()
                .getRootElement().getChild("studentUnitRecordTable")
                .getChildren("record"))
        {
            if (studentId.toString().equals
                    (el.getAttributeValue(Constants.STUDENT_ID)))
            {
                recs.add(new StudentUnitRecordProxy(new Integer
                        (el.getAttributeValue(Constants.STUDENT_ID)),
                        el.getAttributeValue(Constants.UNIT_ID)));
            }
        }
        if (recs.size() > 0)
        {
            mapStudentUnitRecordListByStudentId.put(studentId, recs);
        }
        return recs;
    }

    /**
     * Updates exam and assignment results in the XML records file. The
     * student and unit association has to already exist.
     *
     * @param irec An IStudentUnitRecord that associates a unit and student
     * along with their exam/assignment results.
     * @exception RuntimeException if the student/unit association does not
     * exist.
     */
    public void saveRecord(IStudentUnitRecord studentUnitRecord)
    {
        saveRecord(studentUnitRecord, studentUnitRecord.getAsg1Mark(),
        			studentUnitRecord.getAsg2Mark(),
        			studentUnitRecord.getExamMark());
    }
    public void saveRecord(IStudentUnitRecord studentUnitRecord, float asg1Mark,
            float asg2Mark, float examMark)
    {
        for (Element el : (List<Element>) XMLManager.getXML().getDocument()
                .getRootElement().getChild("studentUnitRecordTable")
                .getChildren("record"))
        {
            if (studentUnitRecord.getStudentId().toString().equals
                    (el.getAttributeValue(Constants.STUDENT_ID))
                    && studentUnitRecord.getUnitCode().equals
                    (el.getAttributeValue(Constants.UNIT_ID)))
            {
                el.setAttribute(Constants.ASG_1, new Float(asg1Mark)
                        .toString());
                el.setAttribute(Constants.ASG_2, new Float(asg2Mark)
                        .toString());
                el.setAttribute(Constants.EXAM, new Float(examMark)
                        .toString());
                XMLManager.getXML().saveDocument();
                return;
            }
        }

        throw new RuntimeException("DBMD: saveRecord : "
                + "no such student record in data");
    }
}
