package kz.bitlab.G114crm.services;

import kz.bitlab.G114crm.models.ApplicationRequest;
import kz.bitlab.G114crm.repositories.ApplicationRequestRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ApplicationRequestService {
    @Autowired
    private ApplicationRequestRepos applicationRequestRepos;

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

    public void setHandledAppReqById(Long id) {
        ApplicationRequest applicationRequest = applicationRequestRepos.findById(id).orElse(null);
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

}
