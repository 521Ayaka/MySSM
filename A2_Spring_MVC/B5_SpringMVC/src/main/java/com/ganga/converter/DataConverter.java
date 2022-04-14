package com.ganga.converter;

import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 自定义 日期时间转换器
 *
 * 实现Converter
 *      泛型有两个
 *      <e1,e2>
 *          e1是接收的参数类型
 *          e2是要转换的类型
 *
 *  重写converter方法
 *
 */
public class DataConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {

        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
        Date date = null;
        try {
            date = simple.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
