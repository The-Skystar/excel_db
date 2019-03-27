package com.tss.excel_to_db.mapper;

import com.tss.excel_to_db.domain.ExcelModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 为了方便扩展, 这里直接使用注解的形式进行绑定sql语句,对应的实体类：com.tss.excel_to_db.domain.ExcelModel
 * @Author: xiangjun.yang
 * @Date: Created in  2018-2-6
 */
@Mapper
public interface ExcelModelMapper {
    /**
     * @Description: 通过“IGNORE”关键字，使插入数据的主键“已存在”时也不会报异常
     * @Param: [excelModel]
     * @Retrun: long 插入成功，返回 1，插入失败，返回 0；
     */

//    @Insert("insert into tb_district_three(city_id,city_name,parentId,shortName,level_type,city_code,zipcode,mergerName,ing,lat,pinyin)values("
//            + "#{id}, #{name}, #{parentId}, #{shortName}, #{levelType},#{cityCode，jdbcType=varchar},#{zipcode},#{mergerName} ,#{ing},#{lat},#{pinyin})")
    int add(ExcelModel excelModel);

//    @Select("SELECT distinct t.tuserID FROM tuser t  inner join tuserrightrelation tr on (t.tuserid = tr.tuserid and  t.username = #{username} ) inner join tright r on (r.trightID = tr.trightID and r.description = #{description} and r.rname ='player')  ")
//    String queryTuserByUsername(ExcelModel excelModel);
//
//    @Select("SELECT distinct 1 from data where date =  #{dateStr} and tuserid = #{tuserID}")
//    String queryDataByDate(ExcelModel excelModel);

}
