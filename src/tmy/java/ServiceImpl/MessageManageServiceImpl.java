package tmy.java.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tmy.java.Bean.BlogMessage;
import tmy.java.Dao.MessageManageDao;
import tmy.java.Service.MessageManageService;

import java.util.List;

/**
 * Created by Zt on 2018.8.7
 * MessageManageServiceImpl
 * 实现MessageManageService功能
 */

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)  //表示数据库隔离级别为如果当前有就使用当前，如果没有就创建新的事务，
//隔离级别为：读已提交，也就是数据在写入的时候是无法被读的，只有提交后才能让其他事务读取，防止数据库发生脏读
@Service("messageManageService")
public class MessageManageServiceImpl implements MessageManageService {
    @Autowired
    private MessageManageDao messageManageDao;

    @Override
    public List<BlogMessage> getAllByManager(String loginName){
        List<BlogMessage> blogMessages = messageManageDao.findAllByManager(loginName);
        return blogMessages;
    }

}
