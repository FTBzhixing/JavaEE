package EnumExample.Operation;

public enum Operation1 {
    PLUS {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    public abstract double apply(double x,double y);

    public static void main(String[] args) {

        for (Operation1 value : Operation1.values()) {
            System.out.println(value.apply(1, 2));
        }

    }
}
