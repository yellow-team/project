package datamanagement;

public class ListStudentsController {
    private StudentManager studentManager_;

    public ListStudentsController() {
        studentManager_ = StudentManager.getInstance();
    }

    public void listStudents(IStudentLister lister, String unitCode) {
        lister.clearStudents();
        StudentMap students = studentManager_.getStudentsByUnit(unitCode);
        for (Integer id : students.keySet()) {
            lister.addStudent(students.get(id));
        }
    }
}
