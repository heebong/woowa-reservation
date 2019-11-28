package com.h3.reservation;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-26
 */
@RestController
public class Controller {
    @GetMapping(value = "/")
    public ResponseEntity home() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping(value = "/slash")
    public ResponseEntity slash(@RequestBody TokenDto tokenDto) throws ParseException {
        String data = "{\n" +
            "   \"challenge\": \"" + tokenDto.getChallenge() + "\"" +
            "    \"blocks\": [\n" +
            "        {\n" +
            "            \"type\": \"section\",\n" +
            "            \"text\": {\n" +
            "                \"type\": \"mrkdwn\",\n" +
            "                \"text\": \"*It's 80 degrees right now.*\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"section\",\n" +
            "            \"text\": {\n" +
            "                \"type\": \"mrkdwn\",\n" +
            "                \"text\": \"Partly cloudy today and tomorrow\"\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";
        return ResponseEntity.ok(generateJsonObject(data));
    }

    @PostMapping(value = "/calendar")
    public ResponseEntity send() throws ParseException {
        String data = "{\n" +
            "    \"blocks\": [\n" +
            "        {\n" +
            "            \"type\": \"section\",\n" +
            "            \"text\": {\n" +
            "                \"type\": \"mrkdwn\",\n" +
            "                \"text\": \"*It's 80 degrees right now.*\"\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"section\",\n" +
            "            \"text\": {\n" +
            "                \"type\": \"mrkdwn\",\n" +
            "                \"text\": \"Partly cloudy today and tomorrow\"\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";
        
        return ResponseEntity.ok(generateJsonObject(data));
    }

    private JSONObject generateJsonObject(String data) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(data);
        return (JSONObject) obj;
    }
}
