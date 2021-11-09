package SingletonExample;

//这种方法在功能上与公有域方法相似，但更加简洁，无偿地提供了序列化机制，绝对
//防止多次实例化，即使是在面对复杂的序列化或者反射攻击的时候 虽然这种方法还没有广
//泛采用，但是单元枚举类型经常成为实现 Singleton 最佳方法
public enum Singleton1 {
    INSTANCE;

    public static void main(String[] args) {
        Singleton1 instance = INSTANCE;
    }
}
