package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String passwd;
    private int defaultPasswdLength;
    private String department;

    public String getAltMail() {
        return altMail;
    }

    private  String email;
    private int mailBoxCap = 500;
    private String altMail;
    private String companySuffix ="company.com";

    // Create Name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.defaultPasswdLength = 8;

        // Call method to set department
        this.department = setDepartment();
        // Password Set
        this.passwd = genRandomPas(this.defaultPasswdLength);
        // Generate Email
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department.toLowerCase()+"."+companySuffix;


    }
    public void setMailBoxCap(int mailBoxCap) {
        this.mailBoxCap = mailBoxCap;
    }
    public void setAltMail(String altMail) {
        this.altMail = altMail;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    private String setDepartment(){
        System.out.println("Enter the Department\n---------------------\n1.Sales\n2.Accounts\n3.Development");
        System.out.print("Enter Code:");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        return (x == 1 ? "Sales" : (x == 2 ? "Accounts" : "Development")).toLowerCase();
    }
    // Generate the Random Password
    private String genRandomPas(int len){
        String pswd = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!<;{:=}|)>(&<@#$%^/+*-";
        char[] paswd = new char[len];
        for (int i = 0; i < len; i++) {
            int rand = (int) (Math.random() * pswd.length());
            String st ="[";
            st+= pswd.charAt(rand);
            st+="]";
            pswd = pswd.replaceAll( st, "");
            paswd[i] = pswd.charAt(rand);
        }
        return new String(paswd);
    }
    public void showInfo(){
        System.out.println("*************************************************");
        System.out.println("* Employee: "+firstName.toLowerCase()+" "+lastName.toLowerCase());
        System.out.println("* Department: "+department);
        System.out.println("* Email: "+email);
        System.out.println("* Password Auto-genrated: "+ passwd);
        System.out.println("* Mail Capacity: "+mailBoxCap);
        System.out.println("*************************************************");
    }

}
