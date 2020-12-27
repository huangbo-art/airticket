package edu.ncc.airticket.service;

import edu.ncc.airticket.dao.AirTypeDao;
import edu.ncc.airticket.model.AirType;
import org.springframework.stereotype.Service;

@Service
public class AirTypeService extends BaseService<AirType, AirTypeDao>{
    public boolean valid(String airCode) {
        AirType condition=new AirType();
        condition.setAirCode(airCode);
        AirType airType=dao.find(condition);
        return airType!=null;
    }
}
