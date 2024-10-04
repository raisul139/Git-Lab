import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
    static String line;
    static String[] names;
    static String newStudentName;

    public static void readFile(){
        try{
            BufferedReader fileIn = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.fileName)));
            line = fileIn.readLine();
            names = line.split(", ");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeFile(){
        try{
            BufferedWriter fileOut = new BufferedWriter(new FileWriter(Constants.fileName, false));
            fileOut.write(line+", "+newStudentName+'\n');

            Date date = new Date();
            String dateFormat = Constants.dateFormat;
            DateFormat dateFormatTemp = new SimpleDateFormat(dateFormat);
            String dateline= dateFormatTemp.format(date);

            fileOut.write(Constants.outputMassegeOne+" "+dateline);
            fileOut.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//		Check arguments
        if(args.length!=1){
            //terminate
            System.out.println(Constants.invalidOutputMassege);
            return;
        }
        else{
            readFile();

            if(args[0].equals("a")) {
                System.out.println(Constants.getOutputMassegeTwo);

                for(String name : names) { System.out.println(name); }

                System.out.println(Constants.outputMassegeThree);
            }
            else if(args[0].equals("r"))
            {
                System.out.println(Constants.getOutputMassegeTwo);

                Random random = new Random();
                int randomNum = random.nextInt(names.length);
                System.out.println(names[randomNum]);

                System.out.println(Constants.outputMassegeThree);
            }
            else if(args[0].contains("+")){
                System.out.println(Constants.getOutputMassegeTwo);

                newStudentName = args[0].substring(1);
                writeFile();

                System.out.println(Constants.outputMassegeThree);
            }
            else if(args[0].contains("?"))
            {
                System.out.println(Constants.getOutputMassegeTwo);

                String studentName = args[0].substring(1);
                for(String name: names){
                    if(name.equals(studentName)){
                        System.out.println("We found it!");
                        break;
                    }
                }

                System.out.println(Constants.outputMassegeThree);
            }
            else if(args[0].contains("c"))
            {
                System.out.println(Constants.getOutputMassegeTwo);

                System.out.println(names.length+" word(s) found");

                System.out.println(Constants.outputMassegeThree);
            }
            else{
                System.out.println("Constant invalid!");
            }
        }
    }
}