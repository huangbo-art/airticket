package edu.ncc.airticket.web;

import com.github.pagehelper.PageInfo;
import edu.ncc.airticket.model.FightInformation;
import edu.ncc.airticket.model.Manager;
import edu.ncc.airticket.service.FightInformationService;
import edu.ncc.airticket.sys.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.xml.stream.events.DTD;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FightInformationController {
    @Autowired
    private FightInformationService service;
    /**
     * 新增或者修改fightinformation表的数据
     *
     * @param
     * @return
     */
    @PostMapping("/fightInformation/save")
    public String save(@RequestBody FightInformation fightInformation) {
        fightInformation.setFliDisCount(11);
        fightInformation.setFliCnumber(0);
        fightInformation.setFliFnumber(0);
        fightInformation.setFliYnumber(0);
        fightInformation.setFliRefundtime("0");
        fightInformation.setFlag(FightInformation.NORMAL);
        service.save(fightInformation);
        return "success";
    }
    @PostMapping("/fightInformation/findList1")
    public List<FightInformation>findList1(@RequestBody FightInformation condition){
        return service.findList(condition);
    }

   @PostMapping("/fightInformation/page")
    public PageInfo<FightInformation> page(@RequestBody DTO<FightInformation> dto){
        return  service.page(dto.getCondition(),dto.getPageNum(),dto.getPageSize());
    }
    @GetMapping("/fightInformation/valid/{fliNo}")
    public Map<String,Object>valid(@PathVariable("fliNo")String fliNo){
       boolean dup= service.valid(fliNo);
        Map<String,Object> rs=new HashMap<>();
        rs.put("dup",dup);
        return  rs;
    }
    @DeleteMapping("/fightInformation/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        service.delete(id);
        return "success";
    }
}
