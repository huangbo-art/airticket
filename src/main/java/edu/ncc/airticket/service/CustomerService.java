package edu.ncc.airticket.service;

import edu.ncc.airticket.dao.CustomerDao;
import edu.ncc.airticket.model.Customer;
import edu.ncc.airticket.model.Manager;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<Customer , CustomerDao> {

    //判断用户名是否是否存在
    public boolean valid(String cusAccount) {
        Customer condition=new Customer();
        condition.setCusAccount(cusAccount);
        Customer customer=dao.find(condition);
        return customer!=null;
    }
}
