package kz.bitlab.G114crm.services;

import kz.bitlab.G114crm.models.Course;
import kz.bitlab.G114crm.repositories.CourseRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepos courseRepos;

    public List<Course> getAllCourse(){
        return courseRepos.findAll();
    }


}
