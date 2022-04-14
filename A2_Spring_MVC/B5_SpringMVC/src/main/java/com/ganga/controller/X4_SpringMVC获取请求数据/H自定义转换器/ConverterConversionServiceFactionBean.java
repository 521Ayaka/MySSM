package com.ganga.controller.X4_SpringMVC获取请求数据.H自定义转换器;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/web/x4/")
public class ConverterConversionServiceFactionBean {

    @RequestMapping("/converter")
    @ResponseBody
    public String converterTest(@RequestParam("date") Date date){
        //http://localhost:8080/B5_SpringMVC_war/web/x4/converter?date=2060/11/11
        System.out.println(date);
        String dateStr = date.toString();
        return dateStr;
    }

}
