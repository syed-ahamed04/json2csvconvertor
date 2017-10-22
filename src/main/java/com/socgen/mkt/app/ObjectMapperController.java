package com.socgen.mkt.app;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jsontocsv.parser.JSONFlattener;
import org.jsontocsv.writer.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socgen.mkt.dto.Employee;

@RestController
public class ObjectMapperController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
   
    @RequestMapping("/")
    public String index() throws JsonParseException, JsonMappingException, IOException {
        
    	 ObjectMapper objectMapper = new ObjectMapper();
         Employee emp = objectMapper.readValue(new File("F:\\workspace\\jsonTocsvConverter_1.0\\src\\main\\resources\\employee.json"), Employee.class);
         logger.info(emp.toString());
         
         
         /*
          *  Parse a JSON String and convert it to CSV
          */
         List<Map<String, String>> flatJson = JSONFlattener.parseJson(jsonString());
         // Using the default separator ','
         CSVWriter.writeToFile(CSVWriter.getCSV(flatJson), "files/sample_string.csv");

         
         
         return emp.toString();
    }
    
    
    private static String jsonString() {
        return  "[" +
                "    {" +
                "        \"studentName\": \"Foo\"," +
                "        \"Age\": \"12\"," +
                "        \"subjects\": [" +
                "            {" +
                "                \"name\": \"English\"," +
                "                \"marks\": \"40\"" +
                "            }," +
                "            {" +
                "                \"name\": \"History\"," +
                "                \"marks\": \"50\"" +
                "            }" +
                "        ]" +
                "    }" +
                "]";
    }
    
}