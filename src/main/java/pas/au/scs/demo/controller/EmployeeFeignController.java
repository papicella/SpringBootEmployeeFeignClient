package pas.au.scs.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pas.au.scs.demo.employee.EmployeeServiceClient;

@Controller
public class EmployeeFeignController
{
    Logger logger = LoggerFactory.getLogger(EmployeeFeignController.class);

    @Autowired
    private EmployeeServiceClient employeeServiceClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) throws Exception
    {
        model.addAttribute("employees", employeeServiceClient.listEmployees());

        return "employees";
    }

}
