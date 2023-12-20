public class Cleaner extends Personal{
    public Cleaner(String age, String name,String job) {
        super(age, name, job);
    }
    public String contWork(){
        return super.getAge()+super.getName()+ getJob() + work;
    }
    public String EndWork(){
        return super.getAge()+super.getName()+getJob()+ " уже " + endwork;
    }
}
