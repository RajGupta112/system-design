package solidPrincipal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface DocumentElement{
    public  abstract String render();
}
class TextElement implements DocumentElement{
    private  String text;
    TextElement(String text){
        this.text=text;
    }

    @Override
    public String render() {
        return text;
    }
}
class ImageElement implements DocumentElement{
    private String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String render() {
        return "[Image:"+imagePath+"]";
    }
}

class NewLineElement implements DocumentElement{

    @Override
    public String render() {
        return "\n";
    }
}

class Document{
    private List<DocumentElement> documentElement= new ArrayList<>();
    public void addElements(DocumentElement element){
        documentElement.add(element);
    }

    public String render(){
        StringBuilder res= new StringBuilder();
        for(DocumentElement element:documentElement){
            res.append(element.render());
        }
        return res.toString();
    }
}
interface  Persistence1{
    void save(String data);
}
class FileStorage implements Persistence1{

    @Override
    public void save(String data) {
        try{
            FileWriter outFile= new FileWriter("document.txt");
            outFile .write(data);
            outFile.close();
            System.out.println("Document saved to Document.txt");

        }catch (IOException e){
            System.out.println("Error Unable to open file for writing");
        }
    }
}
class DBStorage implements Persistence1{

    @Override
    public void save(String data) {

    }
}
class DocumentEditor1{
    private  Document document;
    private Persistence1 storage;
    private String renderedDocument="";

    public DocumentEditor1(Document document, Persistence1 storage) {
        this.document = document;
        this.storage = storage;
    }
    public  void  addText(String text){
        document.addElements(new TextElement(text));
    }

    public void addNewLine() {
        document.addElements(new NewLineElement());
    }

    public String renderDocument(){
        if(renderedDocument.isEmpty()){
            renderedDocument=document.render();
        }
        return renderedDocument;
    }

    public  void saveDocument(){
        storage.save(renderDocument());
    }
}
public class DocumentEditorClient2 {
    public static void main(String[] args) {
        Document document = new Document();
        Persistence1 persistence = new FileStorage();

        DocumentEditor1 editor = new DocumentEditor1(document, persistence);

        // Simulate a client using the editor with common text formatting features.
        editor.addText("Hello, world!");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example.");
        editor.addNewLine();

        editor.addText("Indented text after a tab space.");
        editor.addNewLine();


        // Render and display the final document.
        System.out.println(editor.renderDocument());

        editor.saveDocument();
    }
}
