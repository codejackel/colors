package com.codjackel.colors.controller;

import com.codjackel.colors.domain.AppArgs;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class HomeController {



    @GetMapping
    public ResponseEntity<Map<String, String>> getInfo() throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Map<String, String> response = new HashMap<>();
        Model model = reader.read(new FileReader("pom.xml"));
        response.put("id",model.getId());
        response.put("groupId",model.getGroupId());
        response.put("artifactId",model.getArtifactId());
        response.put("version",model.getVersion());
        response.put("color", AppArgs.getColor());
        response.put("message", AppArgs.getMessage());

        log.info("Response : [{}]", response);
        return ResponseEntity.ok(response);
    }
}
