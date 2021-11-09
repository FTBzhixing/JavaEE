package StaticFactory.Bulider2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import static StaticFactory.Bulider2.Pizza.Topping.HAM;

public abstract class Pizza {

    public enum Topping{HAM , MUSHROOM, ONION, PEPPER, SAUSAGE}
    Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        //EnumSet.noneOf功能是创建一个指定类型的EnumSet空集合
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        abstract Pizza build();
        protected abstract T self();
    }
    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }

    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(HAM).build();
        Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();
    }
}
