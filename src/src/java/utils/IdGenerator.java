package utils;

public class IdGenerator {
    public static long generateId(){
        return (long) (Math.random() * 1000000);
    }
}
