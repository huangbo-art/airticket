package edu.ncc.airticket.web;

import com.github.pagehelper.PageInfo;
import edu.ncc.airticket.model.BookInfo;
import edu.ncc.airticket.service.BookInfoService;
import edu.ncc.airticket.sys.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@RestController与@Controller的区别：RestController不经过视图解析器
//直接以某种格式返回数据，我们用json
@RestController
public class BookInfoController {

    @Autowired
    private BookInfoService service;

    //@RequestBody代表将前台提交的特定格式的数据转换为java对象
    /*    @ResponseBody注解是指将请求体当中的数据转化为指定对象*/
    @RequestMapping("/bookinfo/login")
    public BookInfo bookinfoLogin(@RequestBody BookInfo bookinfo, HttpSession session, HttpServletResponse resp) {
        //开始进行判断，通过访问数据库查询bookinfo对象，如果根据用户名和密码查到了bookinfo对象
        //就代表登陆成功，查不到。就返回null，代表登陆失败
        BookInfo principal = service.find(bookinfo);
        //select *from bookinfo where man_account="zhangsan" and man_pwd="1234"
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
     * 新增或者修改bookinfo表的数据
     *
     * @param bookinfo
     * @return
     */
    @PostMapping("/bookinfo/save")
    public String save(@RequestBody BookInfo bookinfo) {
        bookinfo.setBooTime((new Date()));
        bookinfo.setFlag(bookinfo.NORMAL);
        service.save(bookinfo);
        return "success";
    }


    //查询多条数据
    @PostMapping("/bookinfo/findList")
    public List<BookInfo> findList(@RequestBody BookInfo condition) {
        return service.findList(condition);
    }

    /**
     * 查询分页的bookinfo数据
     * @return
     */
    @PostMapping("/bookinfo/page")
    public PageInfo<BookInfo> page(@RequestBody DTO<BookInfo> dto){
        return service.page(dto.getCondition(),dto.getPageNum(),dto.getPageSize());
    }

    @DeleteMapping("/bookinfo/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return "success";
    }

    @PostMapping("/bookinfo/pass/{id}")
    public String pass(@PathVariable("id") Integer id){
        service.pass(id);
        return "success";
    }

}

