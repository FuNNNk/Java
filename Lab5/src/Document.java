import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private String name;
    private String location;
    private Map<String,Object> tags = new HashMap<>();

    public Document(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void addTag(String name, Object obj){
        tags.put(name,obj);
    }
}
