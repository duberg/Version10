package common;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        disableAccessWarning();
        File tempFile = new File("Competition.xlsx");
        boolean exists = tempFile.exists();
        Workbook myWorkbook = new Workbook();
        XSSFWorkbook workbook = new XSSFWorkbook();
        Competitor comp = new Competitor();
        Scanner scan = new Scanner(System.in);
        String firstName, lastName, ssn, gender;
        UserInput user = new UserInput();


        if (exists) {
            System.out.println("Den finns");
            myWorkbook.readExcelMen();
            myWorkbook.readExcelWomen();

            int sheetNum = user.genderScanner();
            if (sheetNum == 0 || sheetNum == 1) {
                int rowNum = comp.getRowNum(sheetNum);
                if (sheetNum == 0 && rowNum < 20) {
                    user.firstNameScanner(0);
                    user.lastNameScanner(0);
                    user.ssnScanner(0);
                } else if (sheetNum == 1 && rowNum < 20) {
                    user.firstNameScanner(1);
                    user.lastNameScanner(1);
                    user.ssnScanner(1);
                } else {
                    System.out.println("bye");
                }
            }


        } else if (!exists) {
            myWorkbook.createWorkbook();

        }
    }


    @SuppressWarnings("unchecked")
    private static void disableAccessWarning() {

        try {
            Class unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object unsafe = field.get(null);

            Method putObjectVolatile = unsafeClass.getDeclaredMethod("putObjectVolatile", Object.class, long.class, Object.class);
            Method staticFieldOffset = unsafeClass.getDeclaredMethod("staticFieldOffset", Field.class);

            Class loggerClass = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field loggerField = loggerClass.getDeclaredField("logger");
            Long offset = (Long) staticFieldOffset.invoke(unsafe, loggerField);
            putObjectVolatile.invoke(unsafe, loggerClass, offset, null);
        } catch (Exception ignored) {
        }
       
    }
}


