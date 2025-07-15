package com.payment.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class DatabaseEventController {

    @Autowired
    private DatabaseEventRepository repository;

    @PostMapping("/queueDatabase")
    public ResponseEntity<DatabaseEvent> insert(@RequestBody DatabaseEvent event) {
        event.setProcessed(false);
        return ResponseEntity.ok(repository.save(event));
    }
}
