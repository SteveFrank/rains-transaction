package com.rains.transaction.tx.dubbo.sample.consume;


import com.rains.transaction.common.bean.TransactionInvocation;
import com.rains.transaction.common.bean.TransactionRecover;
import com.rains.transaction.common.enums.CompensationActionEnum;
import com.rains.transaction.common.enums.TransactionStatusEnum;
import com.rains.transaction.core.compensation.command.TxCompensationAction;
import com.rains.transaction.core.compensation.command.TxCompensationCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * <p>Description: .</p>
 * <p>Company: 深圳市旺生活互联网科技有限公司</p>
 * <p>Copyright: 2015-2017.rains.com All Rights Reserved</p>
 *
 * @author yu.xiao.rains.com
 * @version 1.0
 * @date 2017/7/25 12:26
 * @since JDK 1.8
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TxCompensationServiceImplTest {


    @Autowired
    private TxCompensationCommand txCompensationCommand;


    @Test
    public void start() throws Exception {
        TxCompensationAction action = new TxCompensationAction();
        action.setCompensationActionEnum(CompensationActionEnum.SAVE);
        TransactionRecover recover = new TransactionRecover();
        recover.setRetriedCount(1);
        recover.setStatus(TransactionStatusEnum.BEGIN.getCode());
        recover.setId("222222");
        recover.setGroupId("SSSAS");
        recover.setTaskId("1111");
        recover.setCreateTime(new Date());
        recover.setTransactionInvocation(new TransactionInvocation());
        action.setTransactionRecover(recover);
        txCompensationCommand.execute(action);
        try {
            Thread.currentThread().sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void submit() throws Exception {
    }

}