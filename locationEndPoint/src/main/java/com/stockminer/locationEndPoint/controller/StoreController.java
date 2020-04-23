package com.stockminer.locationEndPoint.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockminer.locationEndPoint.model.Location;
import com.stockminer.locationEndPoint.util.WriteCsv;
import com.stockminer.locationEndPoint.model.StoreInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class StoreController {
    /**
     * Generate CSV output for all request with
     * Accept:text/csv HTTP header.
     *
     * @param response
     * @throws IOException
     */
    @GetMapping(path = "/storeInfo", produces = "text/csv")
    private void getStoreDataCsv(HttpServletResponse response) throws IOException {
        StoreInfo storeInfo = getStoreInfo();
        WriteCsv.writeResources(response.getWriter(),storeInfo.getResponse().getLocations(), new String[]{ "name",
                "city",
                "zip",
                "streetAndNumber",
                "openingHours",
                "keywords",
                "lat",
                "lng"}
                , Location.class);
    }

    /**
     * Generate Json output for all request with
     * Accept:application/json HTTP header.
     *
     * @return List<Location>
     * @throws IOException
     */
    @GetMapping(path = "/storeInfo", produces = "application/json")
    private List<Location> getStoreData() throws IOException {
        StoreInfo storeInfo = getStoreInfo();
        return storeInfo.getResponse().getLocations();
    }

    /**
     *
     * @return
     * @throws IOException
     */
    private StoreInfo getStoreInfo() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = Location.class.getResourceAsStream("/static/StoreInfo.json");
        return mapper.readValue(inputStream, StoreInfo.class);
    }
}


