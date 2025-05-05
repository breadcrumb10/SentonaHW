
//The "Workhorse" interface
//named to represent the Server & Client methods that do things.

public interface IClientServerable extends Runnable {
    
    final int port = 4999;
    boolean is_running = false;

    boolean IsRunning();
    void stop();

    void run();
    
}
