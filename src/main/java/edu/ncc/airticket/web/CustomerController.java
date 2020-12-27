package edu.ncc.airticket.web;

import com.github.pagehelper.PageInfo;
import edu.ncc.airticket.model.Customer;
import edu.ncc.airticket.service.CustomerService;
import edu.ncc.airticket.sys.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping("/customer/login")
    public Customer customerLogin(@RequestBody Customer customer, HttpSession session, HttpServletResponse resp){
        Customer principal = service.find(customer);
        if (principal != null){
            //登录成功
            session.setAttribute("principal",principal);
            return principal;
        }
        //如果失败，证明密码或者用户名输入错误，在这里除了返回空数据外，设置响应的状态码为403
        resp.setStatus(403);
        return null;
    }

    /**
     * 新增或者修改customer表的数据
     *
     * @param customer
     * @return
     */
    @PostMapping("/customer/save")
    public String save(@RequestBody Customer customer) {
        customer.setCusTime((new Date()));
        customer.setFlag(customer.NORMAL);
        service.save(customer);
        return "success";
    }

    @GetMapping("/customer/valid/{cusAccount}")
    public Map<String, Object> valid(@PathVariable("cusAccount") String cusAccount) {
        boolean dup = service.valid(cusAccount);
        Map<String, Object> rs = new HashMap<>();
        rs.put("dup", dup);
        return rs;
    }

    //查询多条数据
    @PostMapping("/customer/findList")
    public List<Customer> findList(@RequestBody Customer condition) {
        return service.findList(condition);
    }

    /**
     * 查询分页的customer数据
     * @return
     */
    @PostMapping("/customer/page")
    public PageInfo<Customer> page(@RequestBody DTO<Customer> dto){
        return service.page(dto.getCondition(),dto.getPageNum(),dto.getPageSize());
    }

    @DeleteMapping("/customer/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return "success";
    }
}
