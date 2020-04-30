package util;

public class PersistenceUtil {
    private static PersistenceUtil ourInstance = new PersistenceUtil();

    public static PersistenceUtil getInstance() {
        return ourInstance;
    }

    private PersistenceUtil() {
    }
}
