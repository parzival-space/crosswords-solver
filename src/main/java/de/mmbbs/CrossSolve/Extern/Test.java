package de.mmbbs.CrossSolve.Extern;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class Test implements InitializingBean {

    @Autowired
    private CWDB cwdb;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(cwdb.URL);
        List result = cwdb.getSoluation("gesetzlich", 5);
        for (Object object : result) {
            log.info("{}", object);
        }
    }

    
    
}
