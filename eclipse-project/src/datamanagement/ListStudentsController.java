package datamanagement;

/**
 * Controller class that sources (proxy) Student objects for the UI.
 *
 */
public class ListStudentsController
{
    private StudentManager studentManager;

    public ListStudentsController()
    {
        studentManager = StudentManager.getInstance();
    }

    
    
    /**
     * Retrieves a map of proxied Students from the StudentManager singleton
     * and provides them to the UI through the IStudentLister interface.
     * @param unitLister
     */
    public void listStudents(IStudentLister lister, String unitCode)
    {
        lister.clearStudents();
        StudentMap students = studentManager.getStudentsByUnit(unitCode);
        
        for (Integer id : students.keySet())
        {
            lister.addStudent(students.get(id));
        }
    }
}
