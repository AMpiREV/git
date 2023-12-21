public class Therapist extends Doctor{
    private String recomendation;
    public Therapist(String age, String name, String prof, boolean isfree){
        super(age, name, prof, isfree);
    }

    /**
     * написание справки с именем доктора и его подписью
     * @return справка
     */
    public String write_letter(){
        letter = ("Справка о болезни, от " + getName() + " подпись " + getProfession());
        return letter;
    }

    /**
     *
     * @return смс об "пить по три таблетки в день"
     */
    public String writePreparats(){
        recomendation = "пить по три таблетки в день";
        return recomendation;
    }
}
