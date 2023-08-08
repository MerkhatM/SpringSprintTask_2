package kz.bitlab.G114crm.controllers;

import kz.bitlab.G114crm.models.ApplicationRequest;
import kz.bitlab.G114crm.services.ApplicationRequestService;
import kz.bitlab.G114crm.services.CourseService;
import kz.bitlab.G114crm.services.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ApplicationRequestService applicationRequestService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private OperatorService operatorService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("zayavki", applicationRequestService.getReqList());
        return "home";
    }

    @GetMapping("details/{id}")
    public String detailsPage(@PathVariable Long id, Model model) {
        model.addAttribute("appReq", applicationRequestService.getAppReqById(id));
        model.addAttribute("courses", courseService.getAllCourse());
        model.addAttribute("operators", operatorService.getOperators());
        System.out.println(operatorService.getOperators().toString());
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
    public String addPage(Model model) {
        model.addAttribute("courses", courseService.getAllCourse());
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

    @PostMapping("/setHandledAppReq/{id}")
    public String setHandledAppReq(@PathVariable Long id, @RequestParam(name = "operators_id") List<Long> idOfOperators) {
        applicationRequestService.setHandledAppReqById(id, idOfOperators);
        return "redirect:/details/" + id;
    }

    @PostMapping("/editAppReq")
    public String editAppReq(ApplicationRequest updatedapplicationRequest) {
        applicationRequestService.updateAppReq(updatedapplicationRequest);
        return "redirect:/details/" + updatedapplicationRequest.getId();
    }

    @PostMapping("/deleteOperatorFromAppReq")
    public String deleteOperatorFromAppReq(@RequestParam(name = "operatorIdOfAppReq") Long operatorIdOfAppReq, @RequestParam(name = "idOfAppreq") Long idOfAppreq) {
        applicationRequestService.deleteOperatorFromAppReq(operatorIdOfAppReq, idOfAppreq);
        return "redirect:/details/" + idOfAppreq;
    }

}
