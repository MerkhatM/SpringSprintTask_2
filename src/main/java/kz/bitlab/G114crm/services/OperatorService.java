package kz.bitlab.G114crm.services;

import kz.bitlab.G114crm.models.ApplicationRequest;
import kz.bitlab.G114crm.models.Operator;
import kz.bitlab.G114crm.repositories.OperatorRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OperatorService {
    @Autowired private OperatorRepos operatorRepos;

    public List<Operator> getOperators(){
        return  operatorRepos.findAll();
    }

    public Operator getOperatorById(Long id) {
        return operatorRepos.findById(id).orElse(null);
    }

    public void deleteOperator(Operator operator){
        operatorRepos.delete(operator);
    }
}
