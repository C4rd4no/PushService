package PushService;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class PushJsonConverter {
    private ObjectMapper mapper;

    public PushJsonConverter(){
        this.mapper = new ObjectMapper();
    }

    public String convertToJson(Map<String, Object> body){
        String jsonResult = null;
        try {
            jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

}
