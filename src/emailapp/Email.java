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

}
