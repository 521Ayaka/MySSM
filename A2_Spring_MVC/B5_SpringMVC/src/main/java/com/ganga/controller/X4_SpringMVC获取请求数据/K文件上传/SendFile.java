package com.ganga.controller.X4_SpringMVC获取请求数据.K文件上传;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/web/x4")
public class SendFile {

    /**
     *单文件上传
     * @param filename 提交的文件名
     * @param upload   注意: 提交表单input file的 name的名字 两个参数要的参数名一定要一样
     */
    @RequestMapping("/upload01")
    @ResponseBody
    public String upload01(String filename, MultipartFile upload){
        //http://localhost:8080/B5_SpringMVC_war/jsp/upload.jsp
        System.out.println(filename);
        //obj.getOriginalFilename() 获取文件名称
        String originalFilename = upload.getOriginalFilename();
        try {
            //obj.transferTo(File file) 文件对拷 将文件上传到该file上
            upload.transferTo(new File("D:\\MySSM\\A2_Spring_MVC\\B5_SpringMVC\\src\\main\\webapp\\file\\"+originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "......";
    }


    /**
     * 多文件上传
     * @param fileName
     * @param upload1 表单提交文件 name="upload1"
     * @param upload2 表单提交文件 name="upload2"
     * @param upload3 表单提交文件 name="upload3"
     * @return
     */
    @RequestMapping("/upload02-1")
    @ResponseBody
    public String upload02(String fileName,MultipartFile upload1,MultipartFile upload2,MultipartFile upload3){
        //http://localhost:8080/B5_SpringMVC_war/jsp/upload.jsp
        System.out.println(fileName);
        String name1 = upload1.getOriginalFilename();
        String name2 = upload2.getOriginalFilename();
        String name3 = upload3.getOriginalFilename();
        try {
            upload1.transferTo(new File("D:\\MySSM\\A2_Spring_MVC\\B5_SpringMVC\\src\\main\\webapp\\file\\" + name1));
            upload2.transferTo(new File("D:\\MySSM\\A2_Spring_MVC\\B5_SpringMVC\\src\\main\\webapp\\file\\" + name2));
            upload3.transferTo(new File("D:\\MySSM\\A2_Spring_MVC\\B5_SpringMVC\\src\\main\\webapp\\file\\" + name3));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "......";
    }

    /**
     * 改进多文件上传
     * @param fileName
     * @param upload  提交一个upload数组
     * @return
     */
    @RequestMapping("/upload02-2")
    @ResponseBody
    public String upload03(String fileName,MultipartFile[] upload){
        //http://localhost:8080/B5_SpringMVC_war/jsp/upload.jsp
        System.out.println(fileName);
        for (MultipartFile multipartFile : upload) {
            String originalFilename = multipartFile.getOriginalFilename();
            try {
                multipartFile.transferTo(new File("D:\\MySSM\\A2_Spring_MVC\\B5_SpringMVC\\src\\main\\webapp\\file\\"+originalFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "......";
    }



}
