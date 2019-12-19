package com.imooc.controller.center;


import com.imooc.pojo.Users;
import com.imooc.pojo.bo.center.CenterUserBO;
import com.imooc.service.center.CenterUserService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.n3r.idworker.utils.CookieUtils;
import org.n3r.idworker.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "用户信息接口",tags = {"用户信息接口"})
@RestController
@RequestMapping("/userInfo")
public class CenterUserController {
    @Autowired
    private CenterUserService centerUserService;

//    @ApiOperation(value = "用户头像修改",notes = "用户头像修改",httpMethod = "POST")
//    @PostMapping("/update")
//    public IMOOCJSONResult update(@ApiParam(name = "userId",value = "用户id",required = true)
//                                  @RequestParam String userId,
//                                  @ApiParam(name = "file",value = "用户头像",required = true)
//                                  MultipartFile file,
//                                  HttpServletRequest request, HttpServletResponse response){
//        //定义头像保存的地址
//        String fileSpace = IMAGE_USER_FACE_LOCATION;
//        //在路径上为每一个用户增加一个userid，用户区别不同的用户创建
//        String uploadPathPrefix = File.separator+userId;
//
//        if(file!=null){
//            FileOutputStream fileOutputStream = null;
//            try {
//
//            }
//
//            String fileName = file.getOriginalFilename();
//            if (StringUtils.isNotBlank(fileName)) {
//                String fileNameArr[] =  fileName.split("\\.");
//                String suffix = fileNameArr[fileNameArr.length - 1];
//
//                // 文件名称重组 覆盖式上传，增量式：额外拼接当前时间
//                String newFileName = "face-" + userId + "." + suffix;
//
//                //上传头像保存的位置
//               String finalFacePath =  fileSpace + uploadPathPrefix + File.separator + newFileName;
//
//               File outFile = new File(finalFacePath);
//               if(outFile.getParentFile()!=null){
//                    //创建文件夹
//                   outFile.getParentFile().mkdirs();
//               }
//                // 文件输出保存到目录
//                fileOutputStream = new FileOutputStream(outFile);
//                InputStream inputStream = file.getInputStream();
//                IOUtils.copy(inputStream,fileOutputStream);
//            }
//        }else {
//            return IMOOCJSONResult.errorMsg("文件不能为空");
//        }
//        return IMOOCJSONResult.ok();
//    }

    @ApiOperation(value = "修改用户信息",notes = "修改用户信息",httpMethod = "POST")
    @PostMapping("/update")
    public IMOOCJSONResult update(@ApiParam(name = "userId",value = "用户id",required = true)
                                    @RequestParam String userId,
                                  @RequestBody @Valid CenterUserBO centerUserBO,
                                  BindingResult result,
                                  HttpServletRequest request, HttpServletResponse response){

        //判断binding是否包含错误的验证信息,如果有 直接return
        if(result.hasErrors()){
            Map<String,String> errorMap =   getErrors(result);
            return IMOOCJSONResult.errorMap(errorMap);
        }

        Users userResult = centerUserService.updateUserInfo(userId,centerUserBO);
        CookieUtils.setCookie(request,response,
                "user", JsonUtils.objectToJson(userResult),true);

        //TODO 后续要改 增加令牌token 会整合redis 分布式会话

        return IMOOCJSONResult.ok();
    }

    private Map<String,String> getErrors(BindingResult result){

        Map<String,String> map = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error : errorList) {
            String errorField = error.getField();
            //验证错误的信息
            String errorMsg = error.getDefaultMessage();
            map.put(errorField,errorMsg);
        }
        return map;
    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }
}
