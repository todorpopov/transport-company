package org.example;

import db.entities.freight.FreightService;
import db.entities.freight.dtos.FreightDTO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.time.LocalDate;
import java.util.List;

public class MasterFileLoader {
    private final FreightService freightService;

    private final String path;

    public MasterFileLoader(FreightService freightService, String pathFromHome) {
        this.freightService = freightService;
        this.path = pathFromHome;
    }

    private String getHomePath() {
        return System.getenv("HOME");
    }

    private String makeFileName() {
        return String.format("freights-%s.xml", LocalDate.now().toString());
    }

    public void exportFreights() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument();

        Element root = document.createElement("freights");
        document.appendChild(root);

        List<FreightDTO> freightDtos = freightService.getAll();
        for (FreightDTO freightDTO : freightDtos) {
            Element freightElement = document.createElement("freight");

            Element idElement = document.createElement("id");
            idElement.appendChild(document.createTextNode(String.valueOf(freightDTO.getId())));
            freightElement.appendChild(idElement);

            Element driverElement = document.createElement("driver");
            driverElement.appendChild(document.createTextNode(freightDTO.getDriverName()));
            freightElement.appendChild(driverElement);

            Element companyElement = document.createElement("company");
            companyElement.appendChild(document.createTextNode(freightDTO.getCompanyName()));
            freightElement.appendChild(companyElement);

            Element startLocationElement = document.createElement("start-location");
            startLocationElement.appendChild(document.createTextNode(freightDTO.getStartLocation()));
            freightElement.appendChild(startLocationElement);

            Element endLocationElement = document.createElement("end-location");
            endLocationElement.appendChild(document.createTextNode(freightDTO.getEndLocation()));
            freightElement.appendChild(endLocationElement);

            Element startDateElement = document.createElement("start-date");
            startDateElement.appendChild(document.createTextNode(String.valueOf(freightDTO.getStartDate())));
            freightElement.appendChild(startDateElement);

            Element endDateElement = document.createElement("end-date");
            endDateElement.appendChild(document.createTextNode(String.valueOf(freightDTO.getEndDate())));
            freightElement.appendChild(endDateElement);

            Element typeElement = document.createElement("type");
            typeElement.appendChild(document.createTextNode(freightDTO.getTypeAsString()));
            freightElement.appendChild(typeElement);

            String cargoWeight = freightDTO.getCargoWeight() != null ? String.valueOf(freightDTO.getCargoWeight()) : "Not Applicable";
            Element cargoWeightElement = document.createElement("cargo-weight");
            cargoWeightElement.appendChild(document.createTextNode(cargoWeight));
            freightElement.appendChild(cargoWeightElement);

            Element profitElement = document.createElement("profit");
            profitElement.appendChild(document.createTextNode(String.valueOf(freightDTO.getProfit())));
            freightElement.appendChild(profitElement);

            root.appendChild(freightElement);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        String filePath = this.getHomePath() + "/" + this.path + "/" + this.makeFileName();

        StreamResult result = new StreamResult(filePath);
        transformer.transform(source, result);

        System.out.printf("\nFreights successfully exported to XML at: %s", filePath);
    }

}
