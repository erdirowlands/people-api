package com.erdirowlands.peopleapi.controllers;

import com.erdirowlands.peopleapi.entities.manager.Manager;
import com.erdirowlands.peopleapi.repositories.ManagerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ManagersController {

    private final ManagerRepository managerRepository;

    public ManagersController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping("app/managers")
    public ResponseEntity<Map<String, Object>> findManagersWithNoEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size) throws Exception {

        try {
            List<Manager> managers;
            Pageable paging = PageRequest.of(page, size);
            Page<Manager> pageManagers;
            pageManagers = this.managerRepository.findManagerByEmployeesIsNull(paging);
            managers = pageManagers.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("managers", managers);
            response.put("currentPage", pageManagers.getNumber());
            response.put("totalItems", pageManagers.getTotalElements());
            response.put("totalPages", pageManagers.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("app/managers")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) throws Exception {
        try {
            Manager newManager = managerRepository.save(new Manager(manager.getName(), manager.getAge(), manager.getEmployees(),
                    manager.getEmail(), manager.getAddress()));
            return new ResponseEntity<>(newManager, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
