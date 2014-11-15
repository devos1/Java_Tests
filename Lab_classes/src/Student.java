
/**
 * La classe Student représente un étudiant dans un systéme administratif.
 * Elle contient des informations sur les étudiants.
 * 
 * @author Michael Kolling et David Barnes
 * @version 2008.03.30
 */
public class Student
{
    // nom complet de l'étudiant
    private String name;
    // numéro d'identité de l'étudiant
    private String id;
    // nombre de crédits obtenus jusqu'à présent
    private int credits;

    /**
     * Crée un nouvel étudiant avec le nom et le numéro d'identité donnés.
     */
    // CONSTRUCTEUR
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
        credits = 0;
    }

    /**
     * Renvoie le nom complet de l'étudiant.
     */
    // GETTER
    public String getName()
    {
        return name;
    }

    /**
     * Définit un nouveau nom pour cet étudiant.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * Renvoie le numéro d'identité de cet étudiant.
     */
    // GETTER
    public String getStudentID()
    {
        return id;
    }

    /**
     * Ajoute des crédits é ceux accumulés par l'étudiant.
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    /**
     * Renvoie le nombre de crédits accumulés par cet étudiant.
     */
    // GETTER
    public int getCredits()
    {
        return credits;
    }

    /**
     * Renvoie l'identifiant de cet étudiant. Il s'agit d'une combinaison
     * des quatre premiers caractéres de son nom et des trois premiers
     * de son numéro d'identité.
     * Oscar: Modification pour controler que le nombre de caractères est ok
     */
    public String getLoginName()
    {
        
       int lenName = name.length();
       int lenId = id.length();
       
       if (lenName > 4){
           lenName = 4;
        }
        
        if (lenId > 3){
            lenId = 3;
        }
             
       return name.substring(0, lenName) + id.substring(0, lenId); 
}
    
    /**
     * Affiche le nom de l'étudiant et son numéro d'identité sur le terminal.
     */
    public void print()
    {
        System.out.println(name + " (" + id + ")");
    }
}
