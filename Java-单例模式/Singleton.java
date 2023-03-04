public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {

    }

    public Singleton getUniqueInstance() {
        // 先判断对象是否已经被实例化，没有的话才进入加锁实例化
        if(uniqueInstance == null) {
            // 加类锁
            synchronized(Singleton.class) {
                // 双重检验
                if(uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}