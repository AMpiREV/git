public class Surgeon extends Doctor{
    private boolean agreement;
    private String recomendation;
    public Surgeon(String age, String name, String prof, boolean isfree, boolean agreement){
        super(age, name, prof, isfree);
        this.agreement = agreement;
    }
    public String rec(){
        recomendation = "надо наложить гипс";
        return recomendation;
    }
    public boolean giveaccess(){
        agreement = true;
        return agreement;
    }

}
