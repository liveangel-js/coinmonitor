package org.liveangel.A;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sjiang3 on 8/17/17.
 */
public class JacksonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtils.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJosn(Object object){
        String json = null;
        try {
            json =  objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.warn("Error during serialize " + object + " to json " +e) ;
        }
        return json;
    }

    public static <T> T fromJson(String json, Class<T> tClass){
        T object = null;
        try {
            object = objectMapper.readValue(json, tClass);
        } catch (IOException e) {
            LOGGER.warn("Error during deserialize " + json + " from json ",e);
        }
        return object;
    }

    public static Map<String, Object> fromJsonToMap(String json){
        Map<String, Object> map = null;
        if(json!=null && !json.equals("")){
            map = fromJson(json, Map.class);
            return map;
        }else{
            return new HashMap<>();
        }
    }
}