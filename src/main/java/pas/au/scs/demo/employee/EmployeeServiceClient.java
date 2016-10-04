package pas.au.scs.demo.employee;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("SPRINGBOOT-EMPLOYEE-SERVICE")
public interface EmployeeServiceClient
{
    @RequestMapping(method = RequestMethod.GET, value = "/emps")
    List<Employee> listEmployees();
}

