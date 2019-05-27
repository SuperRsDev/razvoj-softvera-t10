package ba.unsa.rs.tutorial10;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tutorijal {

    public static void main(String[] args) {
        ucitajGradove();
        ArrayList<Drzava> drzave = ucitajXml();
        zapisiXml(drzave);
    }

    public static ArrayList<Grad> ucitajGradove() {
        ArrayList<Grad> gradovi = new ArrayList<>();
        Scanner ulaz;
        try {
            ulaz = new Scanner(new FileReader("src/resources/mjerenja.txt")).useDelimiter("\\r\\n");
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka mjerenja.txt ne postoji ili se ne može otvoriti");
            return null;
        }

        while (ulaz.hasNext()) {
            String red = ulaz.nextLine();
            String[] elementiReda  = red.split(",");
            String naziv = elementiReda[0];

            double[] temperature = Arrays.stream(Arrays.copyOfRange(elementiReda, 1, elementiReda.length))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            Grad grad = new Grad(naziv, 0, temperature);
            gradovi.add(grad);
        }
        return gradovi;
    }

    public static ArrayList<Drzava> ucitajXml() {
        ArrayList<Drzava> drzave = new ArrayList<>();
        Document xmldoc = null;
        try {
            DocumentBuilder docReader
                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("src/resources/drzave.xml"));
        } catch (Exception e) {
            System.out.println("proba.xml nije validan XML dokument");
        }

        NodeList djeca = xmldoc.getElementsByTagName("drzava");
        for(int i = 0; i < djeca.getLength(); i++) {
            Node dijete = djeca.item(i);
            if (dijete instanceof Element) {
                Element e = (Element) dijete;
                NodeList children = e.getChildNodes();
                Grad grad = getGrad(e);
                Drzava drzava = getDrzava(e, grad);
                drzave.add(drzava);
            }
        }

        return drzave;
    }

    public static void zapisiXml(ArrayList<Drzava> drzave) {
        try {
            UN un = new UN(drzave);
            XMLEncoder izlaz = new XMLEncoder(
                    new FileOutputStream("src/resources/un.xml"));
            izlaz.writeObject(un);
            izlaz.close();
        } catch(Exception e) {
            System.out.println("Greška prilikom spasavanja: " + e);
        }

    }

    private static Drzava getDrzava(Element e, Grad grad) {
        int stanovnika = Integer.parseInt(e.getAttribute("stanovnika"));
        String nazivDrzave = getString("naziv", e);
        Node povrsinaNode = getNode("povrsina", e);
        String jedinicaPovrsine  = "";
        Element povrsinaEle = getElement("povrsina", e);
        if(povrsinaEle != null) {
            jedinicaPovrsine = povrsinaEle.getAttribute("jedinica");
        }

        double povrsina = Integer.parseInt(povrsinaNode.getNodeValue());
        Drzava drzava = new Drzava(nazivDrzave, stanovnika, povrsina, jedinicaPovrsine, grad);
        return drzava;
    }

    private  static Grad getGrad(Element e) {
        Element glavniGrad = getElement("glavnigrad", e);
        String naziv = "";
        int stanovnika = 0;
        if(glavniGrad != null) {
            stanovnika = Integer.parseInt(glavniGrad.getAttribute("stanovnika"));
            naziv = getString("naziv", glavniGrad);
        }

        return new Grad(naziv, stanovnika, new double[0]);
    }

    protected static String getString(String tagName, Element element) {
        Node node = getNode(tagName, element);
        if(node != null) {
            return node.getNodeValue();
        }
        return null;
    }

    protected static Node getNode(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0);
            }
        }

        return null;
    }

    protected  static Element getElement(String tagName, Element parent) {
        Node node = parent.getElementsByTagName(tagName).item(0);
        if(node.getNodeType() == Node.ELEMENT_NODE) {
            Element povrsinaEle = (Element)node;
            return povrsinaEle;
        }

        return null;
    }
}
