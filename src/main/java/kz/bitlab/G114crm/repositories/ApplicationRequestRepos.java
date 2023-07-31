package kz.bitlab.G114crm.repositories;

import kz.bitlab.G114crm.models.ApplicationRequest;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRequestRepos extends JpaRepository<ApplicationRequest, Long> {
}
