package com.tss.excel_to_db;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Description：
 * @Author: dongchuan.yang 2018/6/11
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 */
@SpringBootApplication
public class SpringBootStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(ExcelToDbApplication.class);
    }
}
