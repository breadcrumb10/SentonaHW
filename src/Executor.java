import javax.tools.*;
import java.io.*;
import java.util.Scanner;

class executor {

public static void main(String[] args) {
    //Variables for prompt loop
    boolean prompt = true;
    Scanner Scantastic = new Scanner(System.in);

    StringServer wtf = new StringServer("*bang*",4999);
    PrinterClient ftw = new PrinterClient("localhost", 4999);

    Thread exec_thread = null;

    int choice1 = Scantastic.nextInt();
    switch (choice1){
        case 1:
            exec_thread = new Thread(wtf);
            break;
        case 2:
            exec_thread = new Thread(ftw);
            break;
        default:
            break;
    }

    exec_thread.start();


    while (wtf.IsRunning()) {
        prompt = true;
        while (prompt == true) {
            System.out.println("\t\t-What would you like to do?-");
            System.out.println();
            System.out.println("\t{1: Close the Server\t2: Continue running Server}");

            int choice2 = Scantastic.nextInt();
            switch (choice2) {

                //Close the server
                case 1:
                    wtf.stop();
                    exec_thread.interrupt();
                    prompt = false;
                    Scantastic.close();
                    break;

                //Continue running current server
                case 2:
                    prompt = false;
                    break;

                //Default - Run the Prompt again
                default:
                    break;
            }
        }
    }

    while (ftw.IsRunning()) {

        System.out.println("\t\t-What would you like to do?-");
        System.out.println();
        System.out.println("\t{1: Close the Client\t\t\t\t2: Keep Client Running}");

        int choice = Scantastic.nextInt();
        switch (choice) {

            //Close the client
            case 1:
                Scantastic.close();
                ftw.stop();
                exec_thread.interrupt();
                break;

            //Keep Client Running
            case 2:
                break;

            //repeat
            default:
                break;
        }
    }

    try {
        exec_thread.join();
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }



}
}