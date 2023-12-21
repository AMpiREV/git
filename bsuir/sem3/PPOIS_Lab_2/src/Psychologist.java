public class Psychologist extends Doctor{
    private String[] pills = new String[2];
    public Psychologist(String age, String name, String prof, boolean isfree){
        super(age, name, prof, isfree);
    }

    /**
     * написание письма
     * @return справка с именем доктора и подписью
     */
    public String write_letter(){
        letter = ("Справка о болезни, от " + getName() + " подпись " + getProfession());
        return letter;
    }

    /**
     *
     * @return был проведён опрос с психологом
     */
    public String survey(){
        return "был проведён опрос психологом";
    }

    /**
     * заполнение массива pills
     * @return элементы массива
     */
    public String recipe(){
        pills[0] = "антидепресанты ";
        pills[1] = "таблетки для тревожности";
        return pills[0] + pills[1];
    }
}
