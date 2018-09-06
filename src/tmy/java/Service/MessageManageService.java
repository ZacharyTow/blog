package tmy.java.Service;
/**
 * Created by Zt on 2018.8.26
 * MessageManageService业务层
 * 包含Dao层对象，查询blogmessage数据库
 */

import tmy.java.Bean.BlogMessage;
import java.util.List;

public interface MessageManageService {
    List<BlogMessage> getAllByManager(String loginName);
}
