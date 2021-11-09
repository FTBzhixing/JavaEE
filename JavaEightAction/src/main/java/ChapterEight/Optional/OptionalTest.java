package ChapterEight.Optional;

import java.util.Optional;

/**
 *  get()是这些方法中最简单但又最不安全的方法。如果变量存在，它直接返回封装的变量 值，否则就抛出一个NoSuchElementException异常。
 * 所以，除非你非常确定Optional 变量一定包含值，否则使用这个方法是个相当糟糕的主意。此外，这种方式即便相对于 嵌套式的null检查，也并未体现出多大的改进。
 *  orElse(T other)是我们在代码清单10-5中使用的方法，正如之前提到的，它允许你在 Optional对象不包含值时提供一个默认值。
 *  orElseGet(Supplier<? extends T> other)是orElse方法的延迟调用版，Supplier 方法只有在Optional对象不含值时才执行调用。如果创建默认值是件耗时费力的工作，
 * 你应该考虑采用这种方式（借此提升程序的性能），或者你需要非常确定某个方法仅在 Optional为空时才进行调用，也可以考虑该方式（这种情况有严格的限制条件）。
 *  orElseThrow(Supplier<? extends X> exceptionSupplier)和get方法非常类似， 它们遭遇Optional对象为空时都会抛出一个异常，但是使用orElseThrow你可以定制希 望抛出的异常类型。
 *  ifPresent(Consumer<? super T>)让你能在变量值存在时执行一个作为参数传入的 方法，否则就不进行任何操作
 */
public class OptionalTest {
    public static void main(String[] args) {
        Car nullCar = null;

        //声明一个空的Optional
        Optional<Car> empty = Optional.empty();
        //依据一个非空值创建Optional
        Car car = new Car();
        Optional<Car> optionalCar = Optional.of(car);
        //可接受null的Optional
        Optional<Car> optionalCar1 = Optional.ofNullable(nullCar);
        System.out.println(optionalCar1);

        //使用 map 从 Optional 对象中提取和转换值
        Optional<Car> optCar = Optional.ofNullable(car);
        Optional<String> name = optCar.map(Car::getName);
        System.out.println(name);

        //使用 flatMap链式调用Optional对象,注意使用flatmap要将成员变量设置为Optional<T>类型
        Person person = new Person();
        Optional<Person> optPerson = Optional.of(person);
        String pName = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");

        //两种写法，第二种更好
//        if(optPerson.isPresent()&&optCar.isPresent()){
//            return Optional.of(findCheapestInsurance(person.get(), car.get()))
//        }
//        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));

        //关于filter的重构
        Insurance insurance = new Insurance();
        if (insurance != null && "CambridgeInsurance".equals(insurance.getName())) {
            System.out.println("ok");
        }
        Optional<Insurance> optInsurance = Optional.of(insurance);
        optInsurance.filter(i->"CambridgeInsurance".equals(i.getName())).ifPresent(x-> System.out.println("OK"));

        //在try-catch中使用Optional
//        try {
//            return Optional.of(Integer.parseInt(s));
//        } catch (NumberFormatException e) {
//            return Optional.empty();
//        }

    }
}
