package com.solvd.law_office;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.law_office.bin.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonParser {
    private static final Logger logger = LogManager.getLogger(JacksonParser.class);
    public List<Client> readXmlFile(File file) {
        ObjectMapper mapper = new ObjectMapper();
        List<Client> clientList;
        try {
            clientList = mapper.readValue(file, new TypeReference<List<Client>>(){});
            for(Client client : clientList){
                logger.info(client.getClientId());
//                String json = mapper.writeValueAsString(client);
//                logger.info(json);
            }

//            logger.info(client.getClientId());
//            logger.info(client.getClientName());
//            logger.info(client.getCountry());
//            logger.info(client.getCity());
//            for(CaseFiled caseFiled : client.getCaseFiledList()){
//                logger.info(caseFiled.getCaseFiledId());
//                logger.info(caseFiled.getAttorneyId());
//                logger.info(caseFiled.getCaseCategoryId());
//                logger.info(caseFiled.getCourtId());
//                logger.info(caseFiled.getCaseDescription());
//            }
//            for(BillDetails billDetails:client.getBillDetailList()){
//                logger.info(billDetails.getBillInvoiceNumber());
//                logger.info(billDetails.getBillAmount());
//                logger.info(billDetails.getLawFirmId());
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clientList;
    }

    public void writeXmlFile(List<Client> clients) {
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getJsonFactory();
        try {
            String json = mapper.writeValueAsString(clients);
            logger.info(json);
            JsonParser parser = factory.createParser(json);
            JsonNode actualObj = mapper.readTree(parser);
            System.out.println("Object: "+actualObj);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
