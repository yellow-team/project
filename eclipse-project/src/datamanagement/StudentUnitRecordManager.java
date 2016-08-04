package datamanagement;

import java.util.List;
import org.jdom.*;

public class StudentUnitRecordManager 
{
	private static StudentUnitRecordManager self = null; //changed s->self
	private StudentUnitRecordMap studentUnitRecordMap; //changed rm->studentUnitRecordMap
    private java.util.HashMap<String,StudentUnitRecordList> mapByUnitCode; //changed ur->mapByUnitCode
    private java.util.HashMap<Integer,StudentUnitRecordList> mapByStudentId; //changed sr->mapByStudentId
    
    public static StudentUnitRecordManager instance() 
    {
        if (self == null ) 
        {
        	self = new StudentUnitRecordManager(); 
        }
        return self;
    }
    
    private StudentUnitRecordManager() 
    {
        studentUnitRecordMap = new StudentUnitRecordMap();
        mapByUnitCode = new java.util.HashMap<>();
        mapByStudentId = new java.util.HashMap<>();
    }
    
    public IStudentUnitRecord getStudentUnitRecord(Integer studentID, String unitCode) 
    {
    	IStudentUnitRecord iStudentUnitRecord = studentUnitRecordMap.get(studentID, unitCode);
    	return iStudentUnitRecord != null ? iStudentUnitRecord : createStudentUnitRecord(studentID, unitCode);
    }

    /**
	 * Goes through the XML file of records to find the data corresponding to the given unit code and student ID.
	 * It then creates and returns and object of type IStudentUnitRecord (this class simply associates the two)
	 * with these details. It also places the object in a map which has a key of student ID concatenated with unit code
	 * (of which there is only one, because StudentUnitRecordManager is a singleton class).
	 * 
	 * @param unitCode This is the unit code (unit being taken by student given by studentId) to find in the records
	 * @param studentId This is the student ID to find in the records (student taking unit given by unitCode)
	 * @return Object of type IStudentUnitRecord that associates the unit code and student ID if it exists in the XML record
	 * @exception RuntimException if no association between the given unit code and student ID exists.
	 */
    private IStudentUnitRecord createStudentUnitRecord(Integer unitCode, String studentId) 
    {
        IStudentUnitRecord iStudentUnitRecord;
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) 
        {
        	if (unitCode.toString().equals(el.getAttributeValue(Constants.STUDENT_ID)) && studentId.equals(el.getAttributeValue(Constants.UNIT_ID))) 
        	{
        		Integer sid_el = new Integer(el.getAttributeValue(Constants.STUDENT_ID));
        		String uid_el = el.getAttributeValue(Constants.UNIT_ID);
        		float asg1_el = new Float(el.getAttributeValue(Constants.ASG_1)).floatValue();
        		float asg2_el = new Float(el.getAttributeValue(Constants.ASG_2)).floatValue();
        		float exam_el = new Float(el.getAttributeValue(Constants.EXAM)).floatValue();
        		
        		iStudentUnitRecord = new StudentUnitRecord(sid_el, uid_el, asg1_el, asg2_el, exam_el);
        		studentUnitRecordMap.put(iStudentUnitRecord.getStudentID(), iStudentUnitRecord.getUnitCode(), iStudentUnitRecord);
        		return iStudentUnitRecord;
        	}
        }
        throw new RuntimeException("DBMD: createStudent : student unit record not in file");
    }
    
    /**
     * Looks in the map of student/unit association records that is organised with unit code as the key. If
     * it doesn't exit, it looks through the XML file to find them, and adds them to the map in case they
     * need to be looked up later, then it returns them.
     * 
     * @param unitCode Key to look up
     * @return StudentUnitRecordList of all associations between students and the given unit code.
     */
    public StudentUnitRecordList getRecordsByUnit(String unitCode) 
    {
    	StudentUnitRecordList recs = mapByUnitCode.get(unitCode);
    	if (recs != null) 
    	{
    		return recs; 
    	}
        recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) 
        {
        	if (unitCode.equals(el.getAttributeValue(Constants.UNIT_ID))) 
    		{
    			recs.add(new StudentUnitRecordProxy( new Integer(el.getAttributeValue(Constants.STUDENT_ID)), el.getAttributeValue(Constants.UNIT_ID)));
    		}
        }
        if (recs.size() > 0)
        {
        	mapByUnitCode.put(unitCode, recs); // be careful - this could be empty
        }
        return recs;
    }

    /**
     * Looks in the map of student/unit association records that is organised with student ID as the key. If
     * it doesn't exit, it looks through the XML file to find them, and adds them to the map in case they
     * need to be looked up later, then it returns them.
     * 
     * @param studentId Key to look up
     * @return StudentUnitRecordList of all associations between units and the student ID given.
     */
    public StudentUnitRecordList getRecordsByStudent(Integer studentID) 
    {
    	StudentUnitRecordList recs = mapByStudentId.get(studentID);
    	if (recs != null) 
    	{
    		return recs; 
    	}
    	recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) 
        {
        	if (studentID.toString().equals(el.getAttributeValue(Constants.STUDENT_ID))) 
            {
                recs.add(new StudentUnitRecordProxy(new Integer(el.getAttributeValue(Constants.STUDENT_ID)), el.getAttributeValue(Constants.UNIT_ID)));
            }
        }
        if (recs.size() > 0) 
        {
        	mapByStudentId.put(studentID, recs); // be careful - this could be empty
        }
        return recs;
    }

    /**
     * Updates exam and assignment results in the XML records file. The student and unit association
     * has to already exist.
     * 
     * @param irec An IStudentUnitRecord that associates a unit and student along with their exam/assignment results.
     * @exception RuntimeException if the student/unit association does not exist.
     */
    public void saveRecord(IStudentUnitRecord irec) 
    {
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) 
        {
            if (irec.getStudentID().toString().equals(el.getAttributeValue(Constants.STUDENT_ID)) && irec.getUnitCode().equals(el.getAttributeValue(Constants.UNIT_ID))) 
            {
                el.setAttribute(Constants.ASG_1, new Float(irec.getAsg1Score()).toString());
                el.setAttribute(Constants.ASG_2, new Float(irec.getAsg2Score()).toString());
                el.setAttribute(Constants.EXAM, new Float(irec.getExamScore()).toString());
                XMLManager.getXML().saveDocument(); //write out the XML file for continuous save
                return;
            }
        }
        
        throw new RuntimeException("DBMD: saveRecord : no such student record in data");
    }
}
