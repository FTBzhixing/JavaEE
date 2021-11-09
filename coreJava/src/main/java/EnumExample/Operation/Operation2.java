package EnumExample.Operation;

public enum Operation2 {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    Operation2(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    //若枚举Operation1不对外开放，那可以写一个静态方法
    public static Operation1 inverse(Operation1 op) {
        switch (op) {
            case PLUS:
                return Operation1.PLUS;
            case MINUS:
                return Operation1.MINUS;
            case TIMES:
                return Operation1.TIMES;
            case DIVIDE:
                return Operation1.DIVIDE;
        }
        throw new AssertionError("Unknown op " + op);
    }

    public abstract double apply(double x, double y);

    public static void main(String[] args) {

        for (Operation2 value : Operation2.values()) {
            System.out.println(value.apply(1, 2));
        }
    }
}
