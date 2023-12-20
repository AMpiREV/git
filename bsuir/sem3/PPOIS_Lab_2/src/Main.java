

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Doctor surgeon = new Surgeon("11", "вася", "хирург", true, false);
        Patient patient = new Patient("20", "саша", "простуда", "сломанная кость", "псих");
        Registry registry = new Registry("70 ", "бабушка ", "регистратура ");
        Personal registry1 = new Registry("70 ", "бабушка ", "регистратура ");
        Security security = new Security("30", "леша","охрана");
        Cleaner cleaner = new Cleaner("70 ", "дама ", "уборщица ");
        Surgeon surgeon1 = new Surgeon("11", "вася", "хирург", true, false);
        Doctor therapist = new Therapist("31", "ольга", "терапевт", true);
        Therapist therapist1 = new Therapist("31", "ольга", "терапевт", true);
        Doctor psychologist = new Psychologist("27", "бузова", "психолог", true);
        Psychologist psychologist1 = new Psychologist("27", "бузова", "психолог", true);

        boolean statuspr[] = new boolean[3];
        statuspr[0] = false;
        statuspr[1] = false;
        statuspr[2] = false;

        boolean passport = patient.showpassport();
        System.out.println(security.patient_pass(passport));
        System.out.println(patient.showinfo());
        String patient_card = registry.card("20 ", "sasha");
        System.out.println(registry.card("20 ", "sasha"));
        System.out.println(registry.giveAccess(patient_card));
        System.out.println(registry.EndWork());
        System.out.println(cleaner.contWork());

        while(true) {
            System.out.println("1) Проверить свободен ли хирург");
            System.out.println("2) Проверить свободен ли терапевт");
            System.out.println("3) Проверить свободен ли психиатр");
            System.out.println("4) Здоров пациент?");
            int k=scan.nextInt();
            switch (k) {
                case 1: {
                    System.out.println(surgeon.Isfree());
                    System.out.println(surgeon1.fu());
                    System.out.println(surgeon1.rec());
                    System.out.println("1) класть гипс");
                    System.out.println("2) не класть гипс");
                    int a = scan.nextInt();
                    if (a == 1) {
                        boolean agreement = surgeon1.giveaccess();
                        if (agreement) {patient.treatment(1);}
                        statuspr[1] = true;
                        break;
                    } else if (a == 2) break; else return;
                }
                case 2: {
                    System.out.println(therapist.Isfree());
                    System.out.println(therapist.fu());
                    System.out.println(therapist1.write_letter());
                    System.out.println(therapist1.writePreparats());
                    patient.treatment(0);
                    statuspr[0] = true;
                    break;
                }
                case 3:{
                    System.out.println(psychologist.Isfree());
                    System.out.println(psychologist.fu());
                    System.out.println(psychologist1.survey());
                    System.out.println(psychologist1.recipe());
                    System.out.println(psychologist1.write_letter());
                    patient.treatment(2);
                    statuspr[2] = true;
                    break;
                }
                case 4:{
                    System.out.println(patient.state(statuspr));
                    System.out.println(cleaner.EndWork());
                    return;
                }
                default: {return;}
            }
        }
    }
}