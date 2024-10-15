package lk.ijse.phase02.service.impl;


import jakarta.transaction.Transactional;
import lk.ijse.phase02.dao.CustomerDao;
import lk.ijse.phase02.service.CustomerService;
import lk.ijse.phase02.service.UserService;
import lk.ijse.phase02.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;


}
