package edu.ncc.airticket.web;

import com.github.pagehelper.PageInfo;
import edu.ncc.airticket.model.AirType;

import edu.ncc.airticket.model.Manager;
import edu.ncc.airticket.service.AirTypeService;
import edu.ncc.airticket.sys.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新增或者修改manager表的数据
 * @param
 * @return
 *
 * */
@RestController
class AirTypeController {

    @Autowired
    private AirTypeService service;


    @DeleteMapping("/airType/maintain/{id}")
    public String maintain(@PathVariable("id") Integer id) {
        service.maintain(id);
        return "success";
    }

    @GetMapping("/airType/valid/{airCode}")
    public Map<String,Object> valid(@PathVariable("airCode") String airCode){
        boolean dup=service.valid(airCode);
        Map<String,Object> rs=new HashMap<>();
        rs.put("dup",dup);
        return rs;
    }

    @PostMapping("/airType/save")
    public String save(@RequestBody AirType airType) {
        airType.setFlag(AirType.NORMAL);
        service.save(airType);
        return "success";
    }

    @PostMapping("airType/page")
    public PageInfo<AirType> page(@RequestBody DTO<AirType> dto){
        return service.page(dto.getCondition(),dto.getPageNum(),dto.getPageSize());

    }

    @PostMapping("/airType/findList")
    public List<AirType> findList(@RequestBody AirType condition){
        return  service.findList(condition);
    }
}
