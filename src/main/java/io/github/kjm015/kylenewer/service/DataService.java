package io.github.kjm015.kylenewer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DataService {

    @Autowired
    private KyleRepository repository;

}
