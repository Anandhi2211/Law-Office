package com.solvd.lawoffice.util.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.lawoffice.binary.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonParser {
    private static final Logger logger = LogManager.getLogger(JacksonParser.class);

    public List<Client> readXmlFile(File file) {
        ObjectMapper mapper = new ObjectMapper();
        List<Client> clientList;
        try {
            clientList = mapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clientList;
    }

    public void writeXmlFile(List<Client> clients) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/jackson/clientjacksonOUTPUT.json");
            if (!file.exists()) {
                mapper.writeValue(file, clients);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
