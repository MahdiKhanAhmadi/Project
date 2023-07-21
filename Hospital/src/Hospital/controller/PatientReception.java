package Hospital.controller;

import Hospital.model.service.PatientService;
import Hospital.model.entity.Patient;

import java.util.List;
//import java.util.Random;
import java.util.Random;
import java.util.Scanner;

public class PatientReception {
    public static void main(String[] args) throws Exception {

        System.out.println("1.patient reception    2.patient discharge");
        Scanner scan = new Scanner(System.in);
        String userinput = scan.nextLine();
        if (userinput.equals("1")){
            main1();
        } else if (userinput.equals("2")) {
            main2();
        }


    }

    static void main1() throws Exception {
        Scanner scan = new Scanner(System.in);
        Random generate = new Random();
        int patientid = generate.nextInt(10000);
        System.out.println("enter the patients name:");
        String userinput = scan.nextLine();
        System.out.println("enter the patients family: ");
        String userinput1 = scan.nextLine();
        System.out.println("enter the patients issue:");
        String userinput2 = scan.nextLine();
        System.out.println("enter the patients reception date:");
        String userinput3 = scan.nextLine();
        System.out.println("choose your doctor: (Ahmadi), (Moradi), (rezaie) , (sharifi)");
        String userinput4 = scan.nextLine();
        PatientService.getInstance()
                .save(new Patient()
                        .setId(patientid)
                        .setName(userinput)
                        .setFamily(userinput1)
                        .settypeOfIllness(userinput2)
                        .setreceptionDate(userinput3)
                        .setDoctor(userinput4));


        List<Patient> patientList = PatientService.getInstance().findAll();
        for (Patient patient : patientList){
            System.out.println("the patients id:" + patient.getId());
            System.out.println("patients name: " + patient.getName());
            System.out.println("patients family: " + patient.getFamily());
            System.out.println("type of illness: " + patient.gettypeOfIllness());
            System.out.println("reception date:" + patient.getreceptionDate());
            System.out.println("doctor: " + patient.getDoctor());
        }
    }
    static void main2() throws Exception {
        System.out.println("enter the patients family:");
        Scanner scan = new Scanner(System.in);
        String userinput = scan.nextLine();
        Patient patient = PatientService.getInstance().findOneByFamily(userinput);
        System.out.println("the patients id:" + patient.getId());
        System.out.println("patients name: " + patient.getName());
        System.out.println("patients family: " + patient.getFamily());
        System.out.println("type of illness: " + patient.gettypeOfIllness());
        System.out.println("reception date:" + patient.getreceptionDate());
        System.out.println("doctor: " + patient.getDoctor());
        String name = patient.getDoctor();
        if (name.equals("Ahmadi")){
            System.out.println("your payment : 1 million per day");
        } else if (name.equals("Moradi")) {
            System.out.println("your payment : 1.5 million per day");
        } else if (name.equals("rezaie")) {
            System.out.println("your payment : 1 million per day");
        } else if (name.equals("sharifi")){
            System.out.println("your payment : 2 million per day");
        }
//        switch (patient.getDoctor()){
//            case "Ahmadi":
//                System.out.println("your payment : 1 million per day");
//            case "Moradi":
//                System.out.println("your payment : 1.5 million per day");
//            case "rezaie" :
//                System.out.println("your payment : 1 million per day");
//            case "sharifi":
//                System.out.println("your payment : 2 million per day");
//        }
        System.out.println("enter the patients family to remove:");
        String userinput1 = scan.nextLine();
        PatientService.getInstance().remove(userinput1);
        System.out.println( patient.getFamily()+ " removed successfully ");
    }
}
