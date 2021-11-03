package emailapp;

public class Email {
    public Scanner sc = new Scanner(System.in);

    //Setting variables
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alterEmail;

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee: "+ this.firstName + this.lastName);

        //calling methods
        this.department = this.setDept();
        this.password = this.generatePassword(8);
        this.email = this.generateEmail();

    }

    public String generateEmail(){
        return this.firstName.toLowerCase()+ "." + this.lastName.toLowerCase()+ "@" + this.department.toLowerCase()+ ".company.com";
    }
    //Asking for department
    private String setDept() {
        System.out.println("Department codes \n1 for Sales \n2 for Development \3 for Accounting \n0 for none");
        boolean flag = false;

        do {
            System.out.println("Please enter department code:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice. Please choose it again");
            }
        } while (!flag);

        return null;
    }
    //Generate Random password
    public String generatePassword(int length){
        Random ran = new Random();
        String Capital_chars = "ABCDEFGEIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_chars + Small_chars + numbers + symbols;
        String password = "";

        for(int i = 0; i<length; i++){
            password = password + values.charAt(ran.nextInt(values.length()));
        }
        return password;
    }

    //Change password
    public void setPassword(){
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password? (Y/N)");
            char choice = sc.next().charAt(0);

            if(choice == "Y" || choice =="y"){
                flag = true;
                System.out.println("Enter current password");
                String temp = sc.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter new password:");
                    this.password = sc.next();
                    System.out.println("Password changed successfully");
                }else System.out.println("Incorrect password");
            }else if(choice =="N" || choice =="n"){
                flag = true;
                System.out.println("Password changed option cancelled!");
            }
            else{
                System.out.println("Enter valid choice");
            }

        }while (!flag);
    }
    //Set mailbox capacity
    public void setMailCapacity(){
        System.out.println("Current capacity= " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity:");
        this.mailCapacity = sc.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }
    //Set alternate mail
    public void setAlterEmail(){
        System.out.println("Enter new alternate email: ");
        this.alterEmail = sc.next();
        System.out.println("Alternate email is set");
    }

    //Set user information
    public void getInfo(){
        System.out.println("New: " + this.firstName+ " "+ this.lastName);
        System.out.println("Department: " + this.department);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox capacity " + this.mailCapacity + "mb");
        System.out.println("Alternate email: " + this.alterEmail);
    }

}
