package pas.au.scs.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pas.au.scs.demo.employee.Employee;
import pas.au.scs.demo.employee.EmployeeServiceClient;

import java.util.List;

@RestController
public class EmployeeFeignRest
{
    Logger logger = LoggerFactory.getLogger(EmployeeFeignRest.class);

    @Autowired
    private EmployeeServiceClient employeeServiceClient;

    @RequestMapping(value = "/allemps", method = RequestMethod.GET)
    public List<Employee> allEmps()
    {
        List<Employee> emps = employeeServiceClient.listEmployees();

        return emps;
    }

}
