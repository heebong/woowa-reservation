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
    public Challenge slash(@RequestBody TokenDto tokenDto) {
        return new Challenge(tokenDto.getChallenge());
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

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(data);
        JSONObject jsonObj = (JSONObject) obj;
        return ResponseEntity.ok(jsonObj);
    }
}
