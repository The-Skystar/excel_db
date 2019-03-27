package com.tss.excel_to_db.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.JSON;
import com.tss.excel_to_db.util.Constant;
import com.tss.excel_to_db.util.IPUtil;
import com.tss.excel_to_db.vo.ExcelModelVo;
import com.tss.excel_to_db.domain.ExcelModel;
import com.tss.excel_to_db.result.CodeMsg;
import com.tss.excel_to_db.result.Result;
import com.tss.excel_to_db.service.ImportService;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description: 控制层
 * @Author: xiangjun.yang
 * @Date: Created in  2018-2-6
 */
@RestController
public class ExcelToDBController {

    @Autowired
    ImportService importService;

    private static final Logger log = LoggerFactory.getLogger(ExcelToDBController.class);

    /**
     * @Description: 跳转至首页(也就是导入Excel的页面)
     * @Param: []
     * @Retrun: java.lang.String
     */
    @GetMapping("/toImport")
    public String toImport(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ServletContext servletContext = session.getServletContext();
        ServletContext servletContextSoccer = servletContext.getContext("/Soccer");
        HttpSession sessionSoccer =(HttpSession)servletContextSoccer.getAttribute("session");
        log.info("进入Excel_to_DB 系统");
        return "importExcel";
    }

    /**
     * @Description: 异步接收上传的Excel文件并传递至Service层
     * @Param: [file]
     * @Retrun: com.tss.excel_to_db.result.Result<com.tss.excel_to_db.result.CodeMsg>
     */
    @PostMapping("/doImport")
    public Result<CodeMsg> doImport(@RequestParam("file") MultipartFile file) throws InterruptedException {
        CodeMsg codeMsg = importService.verfiyExcel(file);
        do {

        }while (importService.getTempSize(Constant.succSizeTempKey)==0);

        // 返回封装好的结果集
        return Result.success(codeMsg);
    }

    /**
     * @Description: 导出Excel文件
     * @Param: response
     * @Param: failTypeName 失败类型的名称，例如:格式错误(format)/导入数据库失败(db)/excel模板下载(excelDemo)
     * @Retrun: void
     */
    @GetMapping("/doExport")
    public void doExport(HttpServletResponse response, @RequestParam("failTypeName") String failTypeName) {
        try {
            // 设置响应输出的头类型
            response.setHeader("content-Type", "application/vnd.ms-excel");
            // 导出文件名称
            String exportExcelName;
            if ("format".equals(failTypeName)) {
                exportExcelName = "数据格式校验失败的数据";
            } else if ("db".equals(failTypeName)) {
                exportExcelName = "导入数据库失败的数据";
            } else {
                exportExcelName = failTypeName;
            }
            // 下载文件的默认名称
            response.setHeader("Content-Disposition", "attachment;filename=" +
                    URLEncoder.encode(exportExcelName, "UTF-8") + ".xls");
            ExportParams exportParams = new ExportParams();
            /* exportParams.setDataHanlder(null); 设置handler来处理特殊数据 */
            // 根据失败类型的名称(failTypeName),获取对应的List
            List<ExcelModel> failList = importService.getFailList(failTypeName);

            // 导出Excel
            Workbook workbook = ExcelExportUtil.exportExcel(exportParams, ExcelModel.class, failList);
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * @Description: 异步获取当前消息队列中未被消费的队列大小
     * @Param: []
     * @Retrun: com.tss.excel_to_db.result.Result<java.lang.Long>
     */
    @PostMapping("/getUndoSize")
    public Result<Long> getUndoSize() {

        return Result.success(importService.getTempSize(Constant.succSizeTempKey));
    }

    /**
     * @Description: 跳转至同步结果页面
     * @Param: []
     * @Retrun: java.lang.String
     */
    @GetMapping("/toResult")
    public String toResult() {
        return "importResult";
    }

    /**
     * @Description: 异步获取同步结果页面中饼状图所需的数据
     * @Param: []
     * @Retrun: com.tss.excel_to_db.result.Result<com.tss.excel_to_db.vo.ExcelModelVo>
     */
    @PostMapping("/getResultData")
    public Result<ExcelModelVo> getResultData() {
        ExcelModelVo resultData = importService.getResultData();
        return Result.success(resultData);
    }
}
