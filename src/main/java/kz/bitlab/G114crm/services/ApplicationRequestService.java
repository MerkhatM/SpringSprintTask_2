package kz.bitlab.G114crm.services;

import kz.bitlab.G114crm.models.ApplicationRequest;
import kz.bitlab.G114crm.models.Operator;
import kz.bitlab.G114crm.repositories.ApplicationRequestRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
public class ApplicationRequestService {
    @Autowired
    private ApplicationRequestRepos applicationRequestRepos;
    @Autowired
    private OperatorService operatorService;

    public List<ApplicationRequest> getReqList() {
        return applicationRequestRepos.findAll();
    }

    public ApplicationRequest getAppReqById(Long id) {
        return applicationRequestRepos.findById(id).orElse(null);
    }

    public void addAppReq(ApplicationRequest applicationRequest) {
        applicationRequest.setHandled(false);
        applicationRequestRepos.save(applicationRequest);
    }

    public void updateAppReq(ApplicationRequest updatedapplicationRequest) {
        applicationRequestRepos.save(updatedapplicationRequest);
    }

    public void deleteAppReqById(Long id) {
        applicationRequestRepos.deleteById(id);
    }

    public void setHandledAppReqById(Long id, List<Long> idOfOperators) {
        ApplicationRequest applicationRequest = applicationRequestRepos.findById(id).orElse(null);
        List<Operator> operatorList = new ArrayList<>();
        for (Long idshka :
                idOfOperators) {
            Operator operator = operatorService.getOperatorById(idshka);
            operatorList.add(operator);
        }
        applicationRequest.setOperators(operatorList);
        applicationRequest.setHandled(true);
        applicationRequestRepos.save(applicationRequest);
    }

    public List<ApplicationRequest> getHandledAppReq() {
        List<ApplicationRequest> applicationRequestsList = applicationRequestRepos.findAll();
        return applicationRequestsList.stream().
                filter(applicationRequest -> applicationRequest.isHandled())
                .toList();
    }

    public List<ApplicationRequest> getNewAppReq() {
        List<ApplicationRequest> applicationRequestsList = applicationRequestRepos.findAll();
        return applicationRequestsList.stream().
                filter(applicationRequest -> !applicationRequest.isHandled())
                .toList();
    }

    public void deleteOperatorFromAppReq(Long operatorIdOfAppReq, Long idOfAppreq) {
        ApplicationRequest applicationRequest = getAppReqById(idOfAppreq);
        Operator operator = operatorService.getOperatorById(operatorIdOfAppReq);
        if (applicationRequest == null || operator == null)
            return;
        List<Operator> operatorList = applicationRequest.getOperators();
        operatorList.remove(operator);
        applicationRequest.setOperators(operatorList);
        updateAppReq(applicationRequest);
    }
}
