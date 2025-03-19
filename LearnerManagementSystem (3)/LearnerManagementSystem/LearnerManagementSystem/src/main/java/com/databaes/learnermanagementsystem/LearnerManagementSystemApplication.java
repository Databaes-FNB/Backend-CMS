package com.databaes.learnermanagementsystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class LearnerManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnerManagementSystemApplication.class, args);
    }
}

// Intern Entity
@Entity
class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String candidateID = UUID.randomUUID().toString();
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String cohort;
    private String stream;

    // Getters and Setters
}

// Leave Entity
@Entity
class LeaveApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveID;
    private int leaveBalanceDays;
    private String leaveType;
    private String startDate;
    private String endDate;

    // Getters and Setters
}

// Task Entity
@Entity
class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String assignedTask;
    private boolean completed;

    // Getters and Setters
}

// Scorecard Entity
@Entity
class Scorecard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String details;

    // Getters and Setters
}

// Repositories
interface InternRepository extends JpaRepository<Intern, Long> {}
interface LeaveRepository extends JpaRepository<LeaveApplication, Long> {}
interface TaskRepository extends JpaRepository<Task, Long> {}
interface ScorecardRepository extends JpaRepository<Scorecard, Long> {}

// Services
@Service
class InternService {
    @Autowired
    private InternRepository repository;
    public List<Intern> getAllInterns() { return repository.findAll(); }
    public Intern addIntern(Intern intern) { return repository.save(intern); }
}

@Service
class LeaveService {
    @Autowired
    private LeaveRepository repository;
    public List<LeaveApplication> getAllLeaves() { return repository.findAll(); }
}

@Service
class TaskService {
    @Autowired
    private TaskRepository repository;
    public List<Task> getAllTasks() { return repository.findAll(); }
}

@Service
class ScorecardService {
    @Autowired
    private ScorecardRepository repository;
    public List<Scorecard> getAllScorecards() { return repository.findAll(); }
}

// Controllers
@RestController
@RequestMapping("/interns")
class InternController {
    @Autowired
    private InternService service;

    @GetMapping
    public List<Intern> getAll() { return service.getAllInterns(); }

    @PostMapping
    public Intern create(@RequestBody Intern intern) { return service.addIntern(intern); }
}

@RestController
@RequestMapping("/leaves")
class LeaveController {
    @Autowired
    private LeaveService service;

    @GetMapping
    public List<LeaveApplication> getAll() { return service.getAllLeaves(); }
}

@RestController
@RequestMapping("/tasks")
class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> getAll() { return service.getAllTasks(); }
}

@RestController
@RequestMapping("/scorecards")
class ScorecardController {
    @Autowired
    private ScorecardService service;

    @GetMapping
    public List<Scorecard> getAll() { return service.getAllScorecards(); }
}

