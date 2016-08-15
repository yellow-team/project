package datamanagement;

/**
 * Interface that allows Student-like objects to be added to lists in the UI.
 * @author jtulip
 *
 */

public interface IStudentLister
{
    public void clearStudents();

    public void addStudent(IStudent student);
}
