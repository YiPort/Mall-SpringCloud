package com.leyou.sms.test;

import com.leyou.LeyouSmsApplication;
import com.leyou.sms.ye.rly.utils.RandCode;
import com.leyou.sms.ye.rly.utils.RlySmsUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= LeyouSmsApplication.class)
public class SDKTestSendTemplateSMS {
    @Autowired
    RlySmsUtils rlySmsUtils;

    @Test
    public void testSMS() throws Exception {
        System.out.println(rlySmsUtils);

        rlySmsUtils.smsSend("手机号", RandCode.getRandCode(6),null);
    }
}