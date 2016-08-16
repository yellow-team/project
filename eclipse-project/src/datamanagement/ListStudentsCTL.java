package datamanagement;

/**
 * Controller class that sources (proxy) Student objects for the UI.
 *
 */
public class ListStudentsCTL
{
    private StudentManager studentManager;

    public ListStudentsCTL()
    {
        studentManager = StudentManager.getInstance();
    }

    
    
    /**
     * Retrieves a map of proxied Students from the StudentManager singleton
     * and provides them to the UI through the IStudentLister interface.
     * @param unitLister
     */
    public void listStudents(IStudentLister studentLister, String unitCode)
    {
        studentLister.clearStudents();
        StudentMap students = studentManager.getStudentsByUnit(unitCode);
        
        for (Integer id : students.keySet())
        {
            studentLister.addStudent(students.get(id));
        }
    }
}
