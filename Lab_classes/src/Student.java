
/**
 * La classe Student repr�sente un �tudiant dans un syst�me administratif.
 * Elle contient des informations sur les �tudiants.
 * 
 * @author Michael Kolling et David Barnes
 * @version 2008.03.30
 */
public class Student
{
    // nom complet de l'�tudiant
    private String name;
    // num�ro d'identit� de l'�tudiant
    private String id;
    // nombre de cr�dits obtenus jusqu'� pr�sent
    private int credits;

    /**
     * Cr�e un nouvel �tudiant avec le nom et le num�ro d'identit� donn�s.
     */
    // CONSTRUCTEUR
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
        credits = 0;
    }

    /**
     * Renvoie le nom complet de l'�tudiant.
     */
    // GETTER
    public String getName()
    {
        return name;
    }

    /**
     * D�finit un nouveau nom pour cet �tudiant.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * Renvoie le num�ro d'identit� de cet �tudiant.
     */
    // GETTER
    public String getStudentID()
    {
        return id;
    }

    /**
     * Ajoute des cr�dits � ceux accumul�s par l'�tudiant.
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    /**
     * Renvoie le nombre de cr�dits accumul�s par cet �tudiant.
     */
    // GETTER
    public int getCredits()
    {
        return credits;
    }

    /**
     * Renvoie l'identifiant de cet �tudiant. Il s'agit d'une combinaison
     * des quatre premiers caract�res de son nom et des trois premiers
     * de son num�ro d'identit�.
     * Oscar: Modification pour controler que le nombre de caract�res est ok
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
     * Affiche le nom de l'�tudiant et son num�ro d'identit� sur le terminal.
     */
    public void print()
    {
        System.out.println(name + " (" + id + ")");
    }
}
