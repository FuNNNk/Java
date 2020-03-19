import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.testCreateSave();
        main.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources", "D:/java/catalog.ser");
        Document document = new Document("java1", "Java Course 1");
        document.addTag("type","Slides");
        catalog.add(document);

        CatalogUtil.save(catalog);
    }

    private void testLoadView(){
        try{
            Catalog catalog = CatalogUtil.load("D:/java/catalog.ser");
            Document document = catalog.findById("java1");
            CatalogUtil.view(document);
        }catch (InvalidCatalogException ice){
            System.out.println("Main: Invalid catalog exception");
        }catch(NullPointerException npe){
            System.out.println("Main: Null pointer exception");
        }catch (IOException ioe){
            System.out.println("Main: IO Exception");
        }
    }
}
