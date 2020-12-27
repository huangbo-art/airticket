package edu.ncc.airticket.web;

import com.github.pagehelper.PageInfo;
import edu.ncc.airticket.model.Manager;
import edu.ncc.airticket.service.ManagerService;
import edu.ncc.airticket.sys.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@RestController与@Controller的区别：RestController不经过视图解析器
//直接以某种格式返回数据，我们用json
@RestController
public class ManagerController {

    @Autowired
    private ManagerService service;

    //@RequestBody代表将前台提交的特定格式的数据转换为java对象
    /*    @ResponseBody注解是指将请求体当中的数据转化为指定对象*/
    @RequestMapping("/manager/login")
    public Manager managerLogin(@RequestBody Manager manager, HttpSession session, HttpServletResponse resp) {
        //开始进行判断，通过访问数据库查询manager对象，如果根据用户名和密码查到了Manager对象
        //就代表登陆成功，查不到。就返回null，代表登陆失败
        Manager principal = service.find(manager);
        //select *from manager where man_account="zhangsan" and man_pwd="1234"
        if (principal != null) {
            //登陆成功
            session.setAttribute("principal", principal);
            return principal;
        }
        //如果失败，证明密码或者用户名输入错误，在这里除了返回空数据外，设置响应的状态码为403
        resp.setStatus(403);
        return null;
    }

    /**
     * 新增或者修改manager表的数据
     *
     * @param manager
     * @return
     */
    @PostMapping("/manager/save")
    public String save(@RequestBody Manager manager) {
        manager.setManTime((new Date()));
        manager.setFlag(Manager.NORMAL);
        service.save(manager);
        return "success";
    }

    @GetMapping("/manager/valid/{manAccount}")
    public Map<String, Object> valid(@PathVariable("manAccount") String manAccount) {
        boolean dup = service.valid(manAccount);
        Map<String, Object> rs = new HashMap<>();
        rs.put("dup", dup);
        return rs;
    }

    //查询多条数据
    @PostMapping("/manager/findList")
    public List<Manager> findList(@RequestBody Manager condition) {
        return service.findList(condition);
    }

    /**
     * 查询分页的manager数据
     * @return
     */
    @PostMapping("/manager/page")
    public PageInfo<Manager> page(@RequestBody DTO<Manager> dto){
        return service.page(dto.getCondition(),dto.getPageNum(),dto.getPageSize());
    }

    @DeleteMapping("/manager/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return "success";
    }

}

