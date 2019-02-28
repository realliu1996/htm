package cn.realliu.htm.web.controller;

import cn.realliu.htm.common.bean.File;
import cn.realliu.htm.common.bean.Landlord;
import cn.realliu.htm.common.exception.CommonException;
import cn.realliu.htm.service.interfaces.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/1/21
 * @Time: 17:32
 * @Description：房东业务
 */
@Controller
@RequestMapping("/landlord")
public class LandlordController {

    @Autowired
    private LandlordService landlordService;
    @Autowired
    private File newfile;

    //完善房东信息
    @RequestMapping(value = "/updateLandlord",method = RequestMethod.POST)
    public String updateLandlord(Landlord landlord, HttpSession session) {

        try {
            landlordService.update(landlord);
            session.setAttribute("landlord",landlord);
            return "redirect:/showlandlordinfo";
        } catch (CommonException e) {
            session.setAttribute("msg",e.getMessage());
            return "redirect:/showaddlandlord";
        }

    }

    //上传图片
    @ResponseBody
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public File uploadFile(@RequestParam("file") MultipartFile file) {
      try {
          newfile = landlordService.uploadPicture(file);
          return newfile;
        } catch (Exception e) {
          e.printStackTrace();
          newfile.setCode(1);
          newfile.setMsg("上传失败");
          newfile.setUrl(null);
          newfile.setTitle(null);
          newfile.setFilename(null);
          return newfile;
        }
    }


}
