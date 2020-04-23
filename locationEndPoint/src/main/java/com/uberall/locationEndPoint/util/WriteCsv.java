package com.uberall.locationEndPoint.util;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import com.uberall.locationEndPoint.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
public class WriteCsv{

    private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsv.class);

    /**
     * Writes the CSV output to given printWriter.
     *
     * @param writer
     * @param resource Any kind of resource list.
     * @param columns The list of resource fields to be generated as columns in csv.
     * @param klazz Resource class type.
     * @param <U>
     */
    public static <U> void writeResources(PrintWriter writer, List<U> resource, String[] columns, Class<U> klazz) {
        try {
            ColumnPositionMappingStrategy<U> mapStrategy= new ColumnPositionMappingStrategy<>();
            mapStrategy.setType(klazz);
            mapStrategy.setColumnMapping(columns);
            StatefulBeanToCsv<U> beanToCsv = new StatefulBeanToCsvBuilder<U>(writer)
                    .withMappingStrategy(mapStrategy)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            beanToCsv.write(resource);

        } catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }
}
