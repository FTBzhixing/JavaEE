package EnumExample.EnumMap;


import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

public class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}
    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString(){
        return name;
    }

    public static void main(String[] args) {
        EnumMap<LifeCycle, Set<Plant>> enumMap = new EnumMap<>(LifeCycle.class);
        for (LifeCycle value : LifeCycle.values()) {
            enumMap.put(value,new HashSet<>());
        }
    }
}
