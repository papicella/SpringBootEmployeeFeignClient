<h1>Spring Boot Employees - Feign Client</h1>

This demo is a client to the following SERVICE project bound to a Eureka Service Registry service

https://github.com/papicella/SpringBootJPABootstrapEmployeeDemo

Feign is a java to http client binder inspired by Retrofit, JAXRS-2.0, and WebSocket. Feign's first goal was reducing 
the complexity of binding Denominator uniformly to http apis regardless of restfulness.

![alt tag](https://dl.dropboxusercontent.com/u/15829935/platform-demos/images/piv-scs-feign-client.png)

<h3> How Does This work? </h3>

- First you have to enable Feign as shown below in this spring boot application

```
package pas.au.scs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringBootEmployeeFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeFeignClientApplication.class, args);
	}
}
```

- Create the Client Interface as shown below

```
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
```

- See the pom.xml file for the required dependencies

- manifest.yml for PCF is as follows

```
---
applications:
- name: springboot-employee-feign-client
  memory: 512M
  instances: 1
  random-route: true
  timeout: 180
  path: ./target/springbootemployeefeignclient-0.0.1-SNAPSHOT.jar
  services:
    - service-registry
  env:
    JAVA_OPTS: -Djava.security.egd=file:///dev/urando
```

<hr />
Pas Apicella [papicella at pivotal.io] is a Senior Platform Architect at Pivotal Australia 