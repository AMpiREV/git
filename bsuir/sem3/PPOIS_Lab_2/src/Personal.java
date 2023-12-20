public class Personal extends Human{
    private String job;
    String work = "выполняет работу";
    String endwork = "закончил работу";
    public Personal(String age, String name,String job){
        super(age,name);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public String EndWork(){
        return super.getAge()+super.getName() + endwork;
    }
    public String contWork(){
        return super.getAge()+super.getName() + work;
    }
}
