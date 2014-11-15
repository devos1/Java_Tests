import java.util.*;

/**
 * La classe LabClass repr�sente une liste d'inscriptions pour une s�ance de TP. Elle contient
 * l'heure, la salle et les participants, ainsi que le nom de l'enseignant.
 * 
 * @author Michael Kolling et David Barnes
 * @version 2008.03.30
 */
public class LabClass
{
    private String instructor;
    private String room;
    private String timeAndDay;
    private List<Student> students;
    private int capacity;
    
    /**
     * Cr�e un LabClass avec un nombre maximum d'inscriptions. Tous les autres d�tails
     * sont d�finis sur les valeurs par d�faut.
     */
    // CONSTRUCTEUR
    public LabClass(int maxNumberOfStudents)
    {
        instructor = "inconnu";
        room = "inconnu";
        timeAndDay = "inconnu";
        students = new ArrayList<Student>();
        capacity = maxNumberOfStudents;
    }

    /**
     * Ajoute un �tudiant � cette LabClass.
     */
    public void enrollStudent(Student newStudent)
    {
        if(students.size() == capacity) {
            System.out.println("La classe est pleine, vous ne pouvez plus vous inscrire.");
        }
        else {
            students.add(newStudent);
        }
    }
    
    /**
     * Renvoie le nombre d'�tudiants actuellement inscrits dans cette LabClass.
     */
    public int numberOfStudents()
    {
        return students.size();
    }
    
    /**
     * D�finit le num�ro de salle pour cette LabClass.
     */
    // SETTERS
    public void setRoom(String roomNumber)
    {
        room = roomNumber;
    }
    
    /**
     * D�finit l'heure de cette LabClass. Le param�tre doit d�finir le jour
     * et l'heure, comme "vendredi, 10h00".
     */
    public void setTime(String timeAndDayString)
    {
        timeAndDay = timeAndDayString;
    }
    
    /**
     * D�finit le nom de l'instructeur pour cette LabClass.
     */
    public void setInstructor(String instructorName)
    {
        instructor = instructorName;
    }
    
    /**
     * Affiche une liste de la classe avec d'autres infos sur LabClass sur le
     * terminal standard.
     */
    public void printList()
    {
        System.out.println("TP " + timeAndDay);
        System.out.println("Instructeur : " + instructor + "   salle : " + room);
        System.out.println("Liste de la classe :");
        for(Student student : students) {
            student.print();
        }
        System.out.println("Nombre d'�tudiants : " + numberOfStudents());
    }
}
