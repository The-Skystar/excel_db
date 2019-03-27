package com.tss.excel_to_db.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 为了方便扩展，这里的字段命名规则为col[列]+1[列数]
 * 例如：col1代表的就是第一列的数据，通过@Excel(name=?)注解进行区分
 * @Author: xiangjun.yang
 * @Date: Created in  2018-2-6
 */
@Data
public class ExcelModel implements Serializable {
    // 官方文档 http://easypoi.mydoc.io/
    @Excel(name = "行政代码")
    private String id;

    @Excel(name = "名称")
    private String name;

    @Excel(name = "父级行政代码")
    private String parentId;

    @Excel(name = "简称")
    private String shortName;

    @Excel(name = "级别")
    private String levelType;

    @Excel(name = "城市代码")
    private String cityCode;

    @Excel(name = "邮编")
    private String zipcode;

    @Excel(name = "路径")
    private String mergerName;

    @Excel(name = "经度")
    private String ing;

    @Excel(name = "纬度")
    private String lat;

    @Excel(name = "拼音")
    private String pinyin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    //    @Excel(name = "数据统计日期",format = "yyyy-MM-dd")
//    private Date date;
//
//    @Excel(name = "登录账户")
//    @NotBlank(message = "该字段不能为空")
//    private String username;
//
//    @Excel(name = "真实姓名")
//    @Pattern(regexp = "[\\u4E00-\\u9FA5]{2,5}", message = "姓名中文2-5位")
//    private String realname;
//
//    @Excel(name = "球员位置")
//    private String description;
//
//    @Excel(name = "上场时间")
//    @Max(value = 135)
//    @Min(value = -1)
//    private int minutes;
//
//    @Excel(name = "进球数")
//    @Max(value = 100)
//    @Min(value = -1)
//    private int goals;
//
//    @Excel(name = "助攻数")
//    @Max(value = 100)
//    @Min(value = -1)
//    private int assists;
//
//    @Excel(name = "抢断数")
//    @Max(value = 100)
//    @Min(value = -1)
//    private int tackles;
//
//    @Excel(name = "解围数")
//    @Max(value = 100)
//    @Min(value = -1)
//    private int clear;
//
//    @Excel(name = "犯规数")
//    @Max(value = 100)
//    @Min(value = -1)
//    private int fouls;
//
//    @Excel(name = "传球数")
//    @Max(value = 100)
//    @Min(value = -1)
//    private int pass;
//
//    /**
//     * 用户ID
//     */
//    private String tuserID;
//
//    private String dateStr;
//
//    public String getDateStr() {
//        return dateStr;
//    }
//
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//        this.dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getRealname() {
//        return realname;
//    }
//
//    public void setRealname(String realname) {
//        this.realname = realname;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public int getMinutes() {
//        return minutes;
//    }
//
//    public void setMinutes(int minutes) {
//        this.minutes = minutes;
//    }
//
//    public int getGoals() {
//        return goals;
//    }
//
//    public void setGoals(int goals) {
//        this.goals = goals;
//    }
//
//    public int getAssists() {
//        return assists;
//    }
//
//    public void setAssists(int assists) {
//        this.assists = assists;
//    }
//
//    public int getTackles() {
//        return tackles;
//    }
//
//    public void setTackles(int tackles) {
//        this.tackles = tackles;
//    }
//
//    public int getClear() {
//        return clear;
//    }
//
//    public void setClear(int clear) {
//        this.clear = clear;
//    }
//
//    public int getFouls() {
//        return fouls;
//    }
//
//    public void setFouls(int fouls) {
//        this.fouls = fouls;
//    }
//
//    public int getPass() {
//        return pass;
//    }
//
//    public void setPass(int pass) {
//        this.pass = pass;
//    }
//
//    public String getTuserID() {
//        return tuserID;
//    }
//
//    public void setTuserID(String tuserID) {
//        this.tuserID = tuserID;
//    }
}
