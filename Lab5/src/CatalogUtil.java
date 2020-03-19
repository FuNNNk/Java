import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CatalogUtil {
    public static void save(Catalog catalog){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))){
                oos.writeObject(catalog);
                }
        catch (IOException ex){
            System.out.println("Save: IO Exception");
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException{
        Path file = Paths.get(path);
        try(ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file.toString()))){
            return (Catalog)oos.readObject();
        }catch (FileNotFoundException fnf) {
            System.out.println("Load: File not found exception");
        }catch (IOException IOe){
            System.out.println("Load: IO Exception");
        }catch (ClassNotFoundException cnf){
            System.out.println("Load: Class not found exception");
        }
        return null;
    }

    public static void view(Document document) throws IOException{
        Desktop desktop = Desktop.getDesktop();
        File file = new File(document.getLocation());
        desktop.open(file);
    }
}
