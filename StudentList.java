import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
    static String line;
    static String[] names;
    static String newStudentName;

    public static void readFile(){
        try{
            BufferedReader fileIn = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
            line = fileIn.readLine();
            names = line.split(", ");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeFile(){
        try{
            BufferedWriter fileOut = new BufferedWriter(new FileWriter("students.txt", false));
            fileOut.write(line+", "+newStudentName+'\n');

            Date date = new Date();
            String dateFormat = "dd/mm/yyyy-hh:mm:ss a";
            DateFormat dateFormatTemp = new SimpleDateFormat(dateFormat);
            String dateline= dateFormatTemp.format(date);

            fileOut.write("List last updated on "+dateline);
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
            System.out.println("Invalid Arguments!");
            return;
        }
        else{
            readFile();

            if(args[0].equals("a")) {
                System.out.println("Loading data ...");

                for(String name : names) { System.out.println(name); }

                System.out.println("Data Loaded.");
            }
            else if(args[0].equals("r"))
            {
                System.out.println("Loading data ...");

                Random random = new Random();
                int randomNum = random.nextInt(names.length);
                System.out.println(names[randomNum]);

                System.out.println("Data Loaded.");
            }
            else if(args[0].contains("+")){
                System.out.println("Loading data ...");

                newStudentName = args[0].substring(1);
                writeFile();

                System.out.println("Data Loaded.");
            }
            else if(args[0].contains("?"))
            {
                System.out.println("Loading data ...");

                String studentName = args[0].substring(1);
                for(String name: names){
                    if(name.equals(studentName)){
                        System.out.println("We found it!\n");
                        break;
                    }
                }

                System.out.println("Data Loaded.");
            }
            else if(args[0].contains("c"))
            {
                System.out.println("Loading data ...");

                System.out.println(names.length+" word(s) found\n");

                System.out.println("Data Loaded.");
            }
            else{
                System.out.println("Constant invalid!");
            }
        }
    }
}