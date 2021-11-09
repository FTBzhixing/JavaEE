package FavorExample;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {
    private final Map<Class<?>,Object> favorites = new HashMap<>();
    public <T> void putFavorite(Class<T> type,T instance){
        favorites.put(Objects.requireNonNull(type),instance);
    }
    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }

    static Annotation getAnnotation(AnnotatedElement element,String annotationTypeName){
        Class<?> annotationType = null;
        try {
            annotationType=Class.forName(annotationTypeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class,"java");
        f.putFavorite(String.class,"color");
        String favorite = f.getFavorite(String.class);
        System.out.println(favorite);

    }
}
