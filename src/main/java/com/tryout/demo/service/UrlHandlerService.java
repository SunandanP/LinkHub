package com.tryout.demo.service;

import com.tryout.demo.db.entity.UrlMapping;
import com.tryout.demo.db.repository.UrlMappingRepository;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// the class which talks to database through JPA interface which is a only dependency here
@Service
public class UrlHandlerService {

    @Autowired
    private UrlMappingRepository repository;

    public UrlMapping getParticularMapping(UrlMapping urlMapping){
        return repository.findAll().stream().filter(record -> record.getUrl() == urlMapping.getUrl() && urlMapping.getGeneratedURL() == record.getGeneratedURL()).findFirst().orElse(null);
    }

    public String getRedirection(String url){
        UrlMapping urlMapping = repository.findAll().stream().filter(record -> {
            System.out.println(record.getGeneratedURL() + " " + url);
            return record.getGeneratedURL().equals(url.toString());
        }).findFirst().orElse(null);
        if (urlMapping == null)
            return "error";
        return urlMapping.getUrl();
    }

    public void add(UrlMapping urlMapping){
        repository.save(urlMapping);
    }

    public String generateUrl(){
        UniformRandomProvider rng = RandomSource.ISAAC.create();
        // for generation of random urls we use apache's predefined codes for building random urls
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('A', 'z')
                .usingRandom(rng::nextInt) // uses Java 8 syntax
                .build();
        return generator.generate(7);
    }
}
