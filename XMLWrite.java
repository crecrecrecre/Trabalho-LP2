import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWrite {

    public static void main(String[] args) {

        try {

            // Cria uma instância de DocumentBuilderFactory

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Cria um DocumentBuilder

            DocumentBuilder builder = factory.newDocumentBuilder();

            // Cria um novo documento XML
            Document document = builder.newDocument();

            // Cria o elemento raiz
            Element rootElement = document.createElement("pessoa");
            document.appendChild(rootElement);

            // Cria e adiciona elementos filho
            Element nome = document.createElement("nome");
            nome.appendChild(document.createTextNode("Isabela"));
            rootElement.appendChild(nome);

            Element sobrenome = document.createElement("sobrenome");
            sobrenome.appendChild(document.createTextNode("Crestane"));
            rootElement.appendChild(sobrenome);

            Element idade = document.createElement("idade");
            idade.appendChild(document.createTextNode("17"));
            rootElement.appendChild(idade);

            Element endereco = document.createElement("endereco");
            endereco.appendChild(document.createTextNode("Av Direitos Humanos 1201"));
            rootElement.appendChild(endereco);

            Element cpf = document.createElement("cpf");
            cpf.appendChild(document.createTextNode("123.456.789-00"));
            rootElement.appendChild(cpf);

            // Cria um Transformer para converter o documento para XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult("pessoa.xml");

            // Escreve o documento XML para o arquivo

            transformer.transform(source, result);

            System.out.println("Arquivo XML criado com sucesso!");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}