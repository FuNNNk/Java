import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String name;
    private String path;
    private List<Document> documentList = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void add(Document document){
        documentList.add(document);
    }

    public Document findById(String id){
        for(Document doc: documentList){
            if(doc.getId().equals(id)){
                return doc;
            }
        }
        return null;
    }

    public String getPath() {
        return path;
    }
}
