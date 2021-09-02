package common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput extends Competitor {
    Scanner scan = new Scanner(System.in);
    Scanner intScan = new Scanner(System.in);

    int result2;
    String result;
    String result3;

    public String verifyStringInput(String verifyString) {

        result = "";
        if (verifyString.equals("")) {
            result = "invalid";
        } else {
            result = "valid";
        }
        return result;
    }

    public String verifyGender(String verifyGender) {
        result3 = "";
        if (verifyGender.equals("F") || verifyGender.equals("M") || verifyGender.equals("FEMALE") || verifyGender.equals("MALE") || verifyGender.equals("E") || verifyGender.equals("EXIT")) {
            result3 = "valid";
        } else {
            result3 = "invalid";
        }
        return result3;
    }

    public int verifyIntInput(int verifyInt) {
        int count = 0;
        while (verifyInt > 0) {
            verifyInt = verifyInt / 10;
            count++;
        }
        if (count == 6) {
            result2 = 200;
        } else {
            result2 = 404;
        }
        return result2;
    }

    public int genderScanner() {
        String gender;
        int sheetNum = 0;
        boolean go = false;
        while (!go) {
            System.out.println("Sweden have, as of now, 2 legal genders. Even if you identify yourself as something else we have to ask because of gender statistics");

            System.out.print("Type your gender (F)emale or (M)ale or (E)xit: ");
            gender = scan.nextLine().toUpperCase();
            verifyGender(gender);

            if (result3.equals("valid")) {
                System.out.println("valid");
                if (gender.charAt(0) == 'F') {
                    gender = "Female";
                    sheetNum = 1;
                } else if (gender.charAt(0) == 'M') {
                    gender = "Male";
                    sheetNum = 0;
                } else if (gender.charAt(0) == 'E') {
                    gender = "Exit";
                    System.out.println("Exiting");
                    sheetNum = 2;
                    go = true;
                }
                if (gender.equals("Male") || gender.equals("Female")) {
                    int rowNum = getRowNum(sheetNum);
                    if (rowNum < 20) {
                        getUserGender(gender, sheetNum);
                        go = true;
                    } else if (rowNum >= 20) {
                        System.out.println("Maximum contestants added");
                        go = false;
                    }
                }
            } else {
                System.err.println("Incorrect");
                System.out.println("Try again");
                go = false;

            }
        }
        return sheetNum;
    }

    public int firstNameScanner(int sheetNum) {
        String firstName;
        boolean go = false;
        while (!go) {

            System.out.print("Type your first name: ");
            firstName = scan.nextLine();
            verifyStringInput(firstName);
            if (result.equals("valid")) {
                System.out.println("correct");
                getUserFirstName(firstName, sheetNum);
                go = true;
            } else {
                System.err.println("Incorrect");
                System.out.println("Try again");
                go = false;

            }
        }
        return sheetNum;
    }

    public void lastNameScanner(int sheetNum) {
        String lastName;
        boolean go = false;
        while (!go) {

            System.out.print("Type your last name: ");
            lastName = scan.nextLine();
            verifyStringInput(lastName);
            if (result.equals("valid")) {
                System.out.println("Valid");
                getUserLastName(lastName, sheetNum);
                go = true;
            } else {
                System.err.println("Incorrect");
                System.out.println("Try again");
                go = false;

            }
        }
    }

    public void ssnScanner(int sheetNum) {
        String ssn = "";
        int Ssn = 0;
        boolean go = false;
        while (!go) {
            try {
                System.out.print("Type your ssn(personnummer): ");
                System.out.print("Year-Month-Day ");
                ssn = scan.nextLine();
                int ssnInt = Integer.parseInt(ssn);
                verifyIntInput(ssnInt);
                if (result2 == 200) {
                    System.out.println("Valid");
                    getUserSsn(ssnInt, sheetNum);
                    go = true;
                } else if (result2 == 404) {
                    System.err.println("Incorrect");
                    System.out.println("Try again");
                    go = false;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Type numbers");

            }
        }

    }


}
