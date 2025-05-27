package solidPrincipal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class  DocumentEditor{
   private List<String> documentElements;
    private String renderedDocument;
    public  DocumentEditor(){
        documentElements= new ArrayList<>();
        renderedDocument="";
    }

    public void addText(String text){
        documentElements.add(text);
    }

    public  void addImage(String path){
        documentElements.add(path);
    }

    public  String renderDocument(){
        if(renderedDocument.isEmpty()){
            StringBuilder res= new StringBuilder();
            for(String element:documentElements){
                if(element.length()>4 && (element.endsWith(".jpg")|| element.endsWith(".png"))){
                    res.append("[Image:").append(element).append("]\n");
                }else {
                    res.append(element).append("\n");
                }
            }
            renderedDocument=res.toString();
        }
        return renderedDocument;
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(renderDocument());
            writer.close();
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }

}

public class DocumentEditorClient {
    public static void main(String[] args){
        DocumentEditor user=  new DocumentEditor();
        user.addImage("hello");
        user.addImage("picture.jpg");
        user.addText("this is a document editor");

        System.out.println(user.renderDocument());
        user.saveToFile();
    }
}
