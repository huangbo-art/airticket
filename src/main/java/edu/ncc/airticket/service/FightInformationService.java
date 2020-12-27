package edu.ncc.airticket.service;

import edu.ncc.airticket.dao.FightInformationDao;
import edu.ncc.airticket.model.FightInformation;
import edu.ncc.airticket.model.Manager;
import org.springframework.stereotype.Service;

@Service
public class FightInformationService extends BaseService<FightInformation, FightInformationDao> {
    public boolean valid(String fliNo) {
        FightInformation condition=new FightInformation();
        condition.setFliNo(fliNo);
       FightInformation fightInformation=dao.find(condition);
        return fightInformation!=null;
    }
}
