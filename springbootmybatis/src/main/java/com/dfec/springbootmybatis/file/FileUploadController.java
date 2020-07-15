package com.dfec.springbootmybatis.file;


import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/8 11:39
 * @describe
 **/
@Controller
public class FileUploadController {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //指定文件代销
        long size= 1024*1024*10;
        factory.setMaxFileSize(DataSize.ofBytes(size*10));
        /// 设定上传文件大小
        factory.setMaxRequestSize(DataSize.ofBytes(size*100));
        return factory.createMultipartConfig();
    }

    @RequestMapping("/file")
    public String file(){
        return "file";
    }

    @RequestMapping("/fileUpLoad")
    @ResponseBody
    public String fileUpLoad(@RequestParam("fileName") MultipartFile file){

        if(file.isEmpty())return "false";

        //获得原始文件名
        String filename = file.getOriginalFilename();
        //文件大小
        long filesize = file.getSize();
        System.out.println("文件名："+filename+"文件大小："+filesize);

        String savePath = "E:\\";
        File savefile = new File(savePath + "/" + filename);

        try {
            //保存文件到指定位置
            file.transferTo(savefile);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "false";
    }

    @RequestMapping("/Mfile")
    public String Mfile(){
        return "multifile";
    }

    @RequestMapping(value = "/MfileUpLoad",method = RequestMethod.POST )
    @ResponseBody
    public String  multifileUpload(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");

        for (MultipartFile file : files) {
            if(file.isEmpty()) return "false";

            //获得原始文件名
            String filename = file.getOriginalFilename();
            //文件大小
            long filesize = file.getSize();
            System.out.println("文件名："+filename+"文件大小："+filesize);
            String savePath = "E:\\";
            File savefile = new File(savePath + "/" + filename);
            try {
                //保存文件到指定位置
                file.transferTo(savefile);
            } catch (IOException e) {
                e.printStackTrace();
                return "false";
            }


        }
         return "上传成功";
    }


}
