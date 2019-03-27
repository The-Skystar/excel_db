package com.tss.excel_to_db.handler;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import com.tss.excel_to_db.domain.ExcelModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: easypoi的handler是用来处理一些特殊事情的。
 * 例如：导入的数据某些信息不能与现有数据库中的数据冲突，需要提前查询数据库...
 * @Author: xiangjun.yang
 * @Date: Created in  2018-2-6
 */
public class ExcelModelHandler extends ExcelDataHandlerDefaultImpl<ExcelModel> {

    private static final Logger log = LoggerFactory.getLogger(ExcelModelHandler.class);


    @Override
    public Object importHandler(ExcelModel obj, String name, Object value) {
//        log.info(name+":"+value);
        return super.importHandler(obj, name, value);
    }

}
