package com.codejackal.colors.controller;

import com.codejackal.colors.domain.AppArgs;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class HomeController {


    @Value("${project.version}")
    private String projectVersion;

    @Value("${project.groupId}")
    private String groupId;

    @Value("${project.artifactId}")
    private String artifactId;

    @Value("${project.id}")
    private String id;

    @GetMapping
    public ResponseEntity<Map<String, String>> getInfo() throws IOException, XmlPullParserException {

        Map<String, String> response = new HashMap<>();
        response.put("id",id);
        response.put("groupId",groupId);
        response.put("artifactId",artifactId);
        response.put("version",projectVersion);
        response.put("color", AppArgs.getColor());
        response.put("message", AppArgs.getMessage());

        log.info("Response : [{}]", response);
        return ResponseEntity.ok(response);
    }
}
