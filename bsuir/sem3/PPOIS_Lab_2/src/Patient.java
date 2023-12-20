public class Patient extends Human{
    private String problem1;
    private String problem2;
    private String problem3;
    private String health;
    boolean passport;
    boolean[] state_of_health = new boolean[3];
    public Patient(String age, String name, String problem1, String problem2, String problem3){
        super(age,name);
        this.problem1 = problem1;
        this.problem2 = problem2;
        this.problem3 = problem3;
    }
    public String state(boolean[] status){
        if(status[1] && status[2] && status[0]) {health = "здоров!";}
            else health = "не здоров!";
        return health;
    }
    public boolean treatment(int problem){
        System.out.println(problem+" проблема решена");
        state_of_health[problem] = true;
        return state_of_health[problem];
    }
    public String showinfo(){

        return "возраст " + super.getAge() + " имя " + super.getName() + " проблемы "
                + problem1 + " " + problem2 + " " + problem3;
    }
    public boolean showpassport(){
        passport = true;
        return passport;
    }
}
