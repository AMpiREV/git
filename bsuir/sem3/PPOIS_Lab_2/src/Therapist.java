public class Therapist extends Doctor{
    private String recomendation;
    public Therapist(String age, String name, String prof, boolean isfree){
        super(age, name, prof, isfree);
    }
    public String write_letter(){
        letter = ("Справка о болезни, от " + getName() + " подпись " + getProfession());
        return letter;
    }
    public String writePreparats(){
        recomendation = "пить по три таблетки в день";
        return recomendation;
    }
}
