package kz.bitlab.G114crm.repositories;

import kz.bitlab.G114crm.models.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepos extends JpaRepository<Operator,Long> {
}
