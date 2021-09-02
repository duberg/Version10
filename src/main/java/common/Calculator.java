package common;

public class Calculator {
    private double currentTime;
    private double currentLength;
    private int currentMinutes;
    private int currentSeconds;
    private double a = 0;
    private double b = 0;
    private double c = 0;

    public void setTrackSeconds(double time) {
        currentTime = time;
    }

    public void setCurrentLength(double length) {
        currentLength = length;
    }

    public void setMinutes(int minutes) {
        currentMinutes = minutes;
    }

    public void setSeconds(int seconds) {
        currentSeconds = seconds;
    }

    public void whichBranchMen(String menBranch) {
        int choice = 0;
        switch (menBranch) {
            case "100m":
                choice = 1;
                break;
            case "400m":
                choice = 5;
                break;
            case "110mH":
                choice = 6;
                break;
            case "1500m":
                choice = 10;
                break;
            case "Long jump":
                choice = 2;
                break;
            case "Shot put":
                choice = 3;
                break;
            case "High jump":
                choice = 4;
                break;
            case "Discus throw":
                choice = 7;
                break;
            case "Pole vault":
                choice = 8;
                break;
            case "Javelin throw":
                choice = 9;
                break;

        }


        switch (choice) {
            case 1:
                a = 25.4347;
                b = 18;
                c = 1.81;
                getTrackResults();
                break;
            case 5:
                a = 1.53775;
                b = 82;
                c = 1.81;
                getTrackResults();
                break;
            case 6:
                a = 5.74352;
                b = 28.5;
                c = 1.92;
                getTrackResults();
                break;
            case 10:
                a = 0.03768;
                b = 480;
                c = 1.85;
                minutesToSeconds();
                getTrackResults();
                break;
            case 2:
                a = 0.14354;
                b = 220;
                c = 1.4;
                getLengthResults();
                break;
            case 3:
                a = 51.39;
                b = 1.5;
                c = 1.05;
                getLengthResults();
                break;
            case 4:
                a = 0.8465;
                b = 75;
                c = 1.42;
                getLengthResults();
                break;
            case 7:
                a = 12.91;
                b = 4;
                c = 1.1;
                getLengthResults();
                break;
            case 8:
                a = 0.2797;
                b = 100;
                c = 1.35;
                getLengthResults();
                break;
            case 9:
                a = 10.14;
                b = 7;
                c = 1.08;
                getLengthResults();
                break;
            default:
                System.out.println("Sorry not correct");
        }

    }

    public void whichBranchWomen(String womenBranch) {
        int choice = 0;
        switch (womenBranch) {
            case "100mH":
                choice = 1;
                break;
            case "800m":
                choice = 7;
                break;
            case "Long jump":
                choice = 5;
                break;
            case "Shot put":
                choice = 3;
                break;
            case "High jump":
                choice = 2;
                break;
            case "Javelin throw":
                choice = 6;
                break;
            case "200m":
                choice = 4;
                break;
        }
        switch (choice) {
            case 1:
                a = 9.23076;
                b = 26.7;
                c = 1.835;
                getTrackResults();
                break;
            case 2:
                a = 1.84523;
                b = 75;
                c = 1.348;
                getLengthResults();
                break;
            case 3:
                a = 56.0211;
                b = 1.5;
                c = 1.05;
                getLengthResults();
                break;
            case 4:
                a = 4.99087;
                b = 42.5;
                c = 1.81;
                getTrackResults();
                break;
            case 5:
                a = 0.188807;
                b = 210;
                c = 1.41;
                getLengthResults();
                break;
            case 6:
                a = 15.9803;
                b = 3.8;
                c = 1.04;
                getLengthResults();
                break;
            case 7:
                a = 0.11193;
                b = 254;
                c = 1.88;
                minutesToSeconds();
                getTrackResults();
                break;
        }
    }

    public void minutesToSeconds() {
        currentTime = currentMinutes * 60 + currentSeconds;
    }

    public int getTrackResults() {
        int result = (int) (a * Math.pow((b - currentTime), c));
        return result;
    }

    public int getLengthResults() {
        int result1 = (int) (a * Math.pow((currentLength - b), c));

        return result1;
    }


}
