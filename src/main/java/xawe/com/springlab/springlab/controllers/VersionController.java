package xawe.com.springlab.springlab.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

@RestController
public class VersionController {
    

    
    @Value("${pom.version}")
    private String versao2;

    @RequestMapping(value="/version")
    public ResponseEntity<String> getVersion(){
        String retorno = "Versão ::  >> " + versao2;


        return new ResponseEntity<String>(retorno, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/version2")
    public ResponseEntity<String> getVersion2(){
        
        
        String v1 = VersionController.class.getPackage().getImplementationVersion();
        System.out.println(v1);

        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model;
        try {
            model = reader.read(new FileReader("pom.xml"));
            System.out.println(model.getId());
            System.out.println(model.getGroupId());
            System.out.println(model.getArtifactId());
            System.out.println(model.getVersion());
            System.out.println(model.getBuild());
            
        } catch (IOException | XmlPullParserException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        

        return new ResponseEntity<String>(v1, HttpStatus.ACCEPTED);
    }
}
