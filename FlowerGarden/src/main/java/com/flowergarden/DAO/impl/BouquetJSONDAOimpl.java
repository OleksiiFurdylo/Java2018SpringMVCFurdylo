package com.flowergarden.DAO.impl;

import com.flowergarden.DAO.BouquetJSONDAO;
import org.springframework.stereotype.Repository;
import com.flowergarden.flowers.BouquetWrapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.mapped.Configuration;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamReader;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by OleksiiF on 30.03.2018.
 */
@Repository
public class BouquetJSONDAOimpl implements BouquetJSONDAO{
    private BouquetWrapper bouquetWrapper;

    @Autowired
    public void setBouquetWrapper(BouquetWrapper bouquetWrapper) {
        this.bouquetWrapper = bouquetWrapper;
    }

    @Override
    public void saveBouquetToFile(BouquetWrapper bouquetWrapper){

        JAXBContext jc = null;

        try (Writer writer = new OutputStreamWriter(new FileOutputStream("bouquet"+bouquetWrapper.getId()+".json"))){
            jc = JAXBContext.newInstance(BouquetWrapper.class);
            Configuration config = new Configuration();
            MappedNamespaceConvention con = new MappedNamespaceConvention(config);

            XMLStreamWriter xmlStreamWriter = new MappedXMLStreamWriter(con, writer);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(bouquetWrapper, xmlStreamWriter);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public BouquetWrapper readBouquetFromFile(int bouquetId) {

        JAXBContext jc =  null;
        try {
            jc = JAXBContext.newInstance(BouquetWrapper.class);

            String file = new String(Files.readAllBytes(Paths.get("bouquet"+bouquetId+".json")));
            JSONObject jo = new JSONObject(file);

            Configuration config = new Configuration();
            MappedNamespaceConvention con = new MappedNamespaceConvention(config);
            XMLStreamReader xmlStreamReader = new MappedXMLStreamReader(jo, con);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            BouquetWrapper bouquetWrapper = (BouquetWrapper) unmarshaller.unmarshal(xmlStreamReader);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return bouquetWrapper;

    }


}