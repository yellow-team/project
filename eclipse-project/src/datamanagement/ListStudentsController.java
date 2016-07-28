package datamanagement;

public class ListStudentsController
{
    private StudentManager studentManager;

    public ListStudentsController()
    {
        studentManager = StudentManager.getInstance();
    }

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
