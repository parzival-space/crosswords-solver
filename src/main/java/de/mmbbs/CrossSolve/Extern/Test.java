package de.mmbbs.CrossSolve.Extern;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class Test implements InitializingBean {

    
    private CWDB cwdb;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(cwdb.url);
    }

    
    
}
