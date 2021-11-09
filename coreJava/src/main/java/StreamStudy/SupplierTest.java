package StreamStudy;

import SupplierStudy.Student;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello world";
        System.out.println(supplier.get());

        Supplier<Student> student = () -> new Student();
        Supplier<Student> student2 = Student::new;
        System.out.println(student.get().equals(student2.get()));
        System.out.println(student.get().getName());
//        Function
    }
}
