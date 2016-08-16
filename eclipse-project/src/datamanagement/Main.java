package datamanagement;

/**
 * A utility with a GUI that allows the storage, retrieval, modification
 * and validation of student grades (FL, AE, PS, CR, DN, HD) 
 * based on three assessments (Assignment 1, Assignment 2, Exam).
 *
 */
public class Main
{
    public static void main(String[] p)
    {
        new ChangeGradeCTL().startUserInterface();
    }
}
