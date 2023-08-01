package kz.bitlab.G114crm.repositories;

import kz.bitlab.G114crm.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepos extends JpaRepository<Course,Long> {

}
