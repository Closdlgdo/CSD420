import java.util.*;

// thread 1 generates random character (a-z)
class RandomCharacter extends Thread{
    public void run(){
        Random random = new Random();
        for(int i=0; i < 10000; i++){
            char randomizedCharacter = (char) (random.nextInt(26) + 'a');
        System.out.println(" 1st thread: Random Character: " + randomizedCharacter);
        }
    }
}

// thread 2 generates random character (0-9)
class RandomNumber extends Thread{
    public void run(){
        for(int i=0; i < 10000; i++){
            int randomizedNumber =  (int)(Math.random() * (9-0+1)+0);
        System.out.println(" 2nd thread,  Number: " + randomizedNumber);
        }
    }
}

// thread 3 generates random characters(All ASCII included)
class RandomASCII extends Thread{
    public void run(){
        for(int i=0; i < 10000; i++){
            Random random = new Random();
            System.out.println(" 3nd thread, ASCII: " + String.valueOf((char)(random.nextInt(95)+32)));
        }
    }
}

public class CarlosThreeThreads{

    public static void main(String[] args) {
        RandomCharacter t1 = new RandomCharacter();
        RandomNumber t2 = new RandomNumber();
        RandomASCII t3 = new RandomASCII();
        t1.start();
        t2.start();
        t3.start();
    }

}