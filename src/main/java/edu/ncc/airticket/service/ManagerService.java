package edu.ncc.airticket.service;

import edu.ncc.airticket.dao.ManagerDao;
import edu.ncc.airticket.model.Manager;
import org.springframework.stereotype.Service;

@Service    //Service注解用于表明这是个Service，同时和component作用一致，加入到IOC容器
public class ManagerService extends BaseService<Manager, ManagerDao> {

    //判断用户名是否是否存在
    public boolean valid(String manAccount) {
        Manager condition=new Manager();
        condition.setManAccount(manAccount);
        Manager manager=dao.find(condition);
        return manager!=null;
    }
}
