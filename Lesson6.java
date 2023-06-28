import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Lesson6 {
    private static HashMap<Integer, Object> hashMap = new HashMap<>();
    private static final Object object = new Object();
    public static void main(String[] args) {
        Random generator = new Random();
        for (int i = 0; i < 15; i++) {
            addElementToHMap(generator.nextInt(100));
        }

        printToString();
        System.out.println();
        try {
            System.out.println(printOneEl(9));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addElementToHMap(Integer number){
        hashMap.put(number, object);   
    } 


    private static void printToString(){
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }


    private static int printOneEl(int index){
        return (Integer)hashMap.keySet().toArray()[index];
    }      
}