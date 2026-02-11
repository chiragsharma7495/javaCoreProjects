package ExtraCurricularSmallProjects;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeastRecentlyUsedCache<K , V> extends LinkedHashMap<K , V>  {

    private int capacity;

    public LeastRecentlyUsedCache(int capacity){
        super(capacity , 0.75f , true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size() > capacity;
    }
    public static void main(String[] args) {
        LeastRecentlyUsedCache<String , Integer> student = new LeastRecentlyUsedCache<>(3);
        student.put("chirag" , 90);
        student.put("archita" , 98);
        student.put("arshiya" , 89);
        student.put("divam" , 90);

        System.out.println(student);
    }
}
