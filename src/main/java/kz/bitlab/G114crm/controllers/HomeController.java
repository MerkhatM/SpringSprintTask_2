package kz.bitlab.G114crm.controllers;

import kz.bitlab.G114crm.models.ApplicationRequest;
import kz.bitlab.G114crm.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private ApplicationRequestService applicationRequestService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("zayavki", applicationRequestService.getReqList());
        return "home";
    }

    @GetMapping("details/{id}")
    public String detailsPage(@PathVariable Long id, Model model) {
        model.addAttribute("appReq", applicationRequestService.getAppReqById(id));
        return "details";
    }

    @GetMapping("/newAppReq")
    public String newAppReqPage(Model model) {
        model.addAttribute("zayavki", applicationRequestService.getNewAppReq());
        return "home";
    }

    @GetMapping("/handledAppReq")
    public String handledAppReqPage(Model model) {
        model.addAttribute("zayavki", applicationRequestService.getHandledAppReq());
        return "home";
    }

    @GetMapping("/addAppReq")
    public String addPage() {
        return "addAppReq";
    }

    @PostMapping("/addAppReq")
    public String addAppReq(ApplicationRequest applicationRequest) {
        applicationRequestService.addAppReq(applicationRequest);
        return "redirect:/";
    }

    @PostMapping("/deleteAppReq/{id}")
    public String deleteAppReq(@PathVariable Long id) {
        applicationRequestService.deleteAppReqById(id);
        return "redirect:/";
    }

    @PostMapping("/editAppReq/{id}")
    public String editAppReq(@PathVariable Long id) {
        applicationRequestService.editAppReqById(id);
        return "redirect:/details/" + id;
    }


}
