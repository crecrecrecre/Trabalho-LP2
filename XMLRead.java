import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLRead {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("pessoa.xml");
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            System.out.println("Elemento raiz: " + root.getNodeName());
           
            NodeList nomeList = document.getElementsByTagName("nome");
            System.out.println("Nome:: " + nomeList.item(0).getTextContent());
            NodeList sobrenomeList = document.getElementsByTagName("sobrenome");
            System.out.println("Sobrenome: " + sobrenomeList.item(0).getTextContent());
            NodeList idadeList = document.getElementsByTagName("idade");
            System.out.println("Idade: " + idadeList.item(0).getTextContent());
            NodeList enderecoList = document.getElementsByTagName("endereco");
            System.out.println("Endereço: " + enderecoList.item(0).getTextContent());
            NodeList cpfList = document.getElementsByTagName("cpf");
            System.out.println("CPF: " + cpfList.item(0).getTextContent());            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}