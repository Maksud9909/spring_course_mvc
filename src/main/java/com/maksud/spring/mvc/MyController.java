package com.maksud.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class MyController {
    @RequestMapping ("/")
    public String showFirstView(){
        return "first-view";
    }




    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model){

        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }



    @GetMapping("showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "ask-emp-details-view";
        }else {
            return "show-emp-details-view";
        }
    }
}




//@RequestMapping("showDetails")
//    public String showEmpDetails(){
//        return "show-emp-details-view";
//    }

//@RequestMapping("showDetails")
//    public String showEmpDetails(HttpServletRequest request,Model model){
//
//        String empName = request.getParameter("EmployeeName");
//        empName = "MR " + empName;
//        model.addAttribute("ChangedNameAttribute",empName);
//
//
//        return "show-emp-details-view";
//    }