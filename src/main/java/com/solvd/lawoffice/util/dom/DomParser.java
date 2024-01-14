package com.solvd.lawoffice.util.dom;

import com.solvd.lawoffice.Main;
import com.solvd.lawoffice.binary.CaseFiled;
import com.solvd.lawoffice.binary.Court;
import com.solvd.lawoffice.binary.Judge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class DomParser {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private Document document;
    public void initializer(String filePath) {
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.document = builder.parse(filePath);
            this.document.getDocumentElement().normalize();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Court> courtParser() {
        ArrayList<Court> courtArrayList = new ArrayList<>();
        logger.info("Root Element " + this.document.getDocumentElement().getNodeName());
        NodeList courtList = this.document.getElementsByTagName("court");
        for (int temp = 0; temp < courtList.getLength(); temp++) {
            Court court = new Court();
            Node courtNode = courtList.item(temp);
            if (courtNode.getNodeType() == courtNode.ELEMENT_NODE) {
                Element courtElement = (Element) courtNode;
                court.setCourtId(Integer.parseInt(courtElement.getAttribute("id")));
                court.setCountry(courtElement.getElementsByTagName("country").item(0).getTextContent());
                court.setCity(courtElement.getElementsByTagName("city").item(0).getTextContent());
                ArrayList<CaseFiled> caseFiledArrayList = caseList(courtElement,"case");
                for (CaseFiled caseFiled : caseFiledArrayList){
                    court.setCaseFiledList(caseFiled);
                }
                Judge judge = judgeDetails(courtElement,"judge");
                court.setJudge(judge);
            }
            courtArrayList.add(court);
        }
        return  courtArrayList;
    }

    private Judge judgeDetails(Element courtElement, String Case) {
        Judge judge = new Judge();
        NodeList judgeList = courtElement.getElementsByTagName(Case);
        for(int temp = 0;temp < judgeList.getLength();temp ++){
            Node judgeNode = judgeList.item(temp);
            if(judgeNode.getNodeType()==judgeNode.ELEMENT_NODE){
                Element judgeElement = (Element) judgeNode;
                judge.setJudgeId(Integer.parseInt(judgeElement.getAttribute("id")));
                judge.setJudgeName(judgeElement.getAttribute("name"));
            }
        }
        return judge;
    }
    private ArrayList<CaseFiled> caseList(Element courtElement, String Case) {
        ArrayList<CaseFiled> caseFiledArrayList = new ArrayList<>();
        NodeList caseNodeList = ((Element) courtElement).getElementsByTagName(Case);
        for (int temp1 = 0; temp1 < caseNodeList.getLength(); temp1++) {
            Node caseNode = caseNodeList.item(temp1);
            if (caseNode.getNodeType() == caseNode.ELEMENT_NODE) {
                CaseFiled caseFiled = new CaseFiled();
                Element caseElement = (Element) caseNode;
                caseFiled.setCourtId(Integer.parseInt(courtElement.getAttribute("id")));
                caseFiled.setCaseFiledId(Integer.parseInt(caseElement.getAttribute("id")));
                caseFiled.setCaseDescription(caseElement.getElementsByTagName("case_description").item(0).getTextContent());
                caseFiled.setClientId(Integer.parseInt(caseElement.getElementsByTagName("client_id").item(0).getTextContent()));
                caseFiled.setAttorneyId(Integer.parseInt(caseElement.getElementsByTagName("attorney_id").item(0).getTextContent()));
                caseFiled.setCaseCategoryId(Integer.parseInt(caseElement.getElementsByTagName("case_category_id").item(0).getTextContent()));
                caseFiledArrayList.add(caseFiled);
            }
        }
        return caseFiledArrayList;
    }
}
