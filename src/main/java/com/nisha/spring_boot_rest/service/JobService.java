package com.nisha.spring_boot_rest.service;

import com.nisha.spring_boot_rest.model.JobPost;
import com.nisha.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1,"java dev","must have good dsa skills",1,List.of("Java", "Spring Boot", "DSA")),
                new JobPost(2,"front end dev","must have good dsa skills",1,List.of("c", "system design", "html"))
        ));
        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {

        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}


