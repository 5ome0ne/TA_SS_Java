package automobile.model;

public interface Alarm {
    default void turnAlarmOn(){
        System.out.println("Alarm Turn On!");
    }
    default void turnAlarmOff(){
        System.out.println("Alarm Turn Off!");
    }
}
