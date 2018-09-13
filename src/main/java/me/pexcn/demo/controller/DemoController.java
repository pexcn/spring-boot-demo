package me.pexcn.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.pexcn.demo.annotation.CheckAnnotation;
import me.pexcn.demo.annotation.Timestamp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pexcn
 * @date 2018-09-13
 */
@RestController
@RequestMapping("/demo")
@Api(value = "/demo", tags = "演示接口", description = "Controller 演示")
public class DemoController {
    @CheckAnnotation
    @GetMapping("/check-annotation")
    @ApiOperation("检测是否标注了自定义注解")
    public String check(HttpServletRequest request) {
        return "annotation: " + request.getAttribute("annotation");
    }

    @GetMapping("/timestamp")
    @ApiOperation(value = "注入时间戳参数并输出")
    @ApiImplicitParam(name = "timestamp", value = "无效参数，仅做演示", paramType = "query")
    public String injectTimestamp(@Timestamp String timestamp) {
        return timestamp;
    }

    @PostMapping("/sum")
    @ApiOperation(value = "输出两个参数的和")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num1", value = "第一个数", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "num2", value = "第二个数", required = true, dataType = "String", paramType = "query")
    })
    public String sum(String num1, String num2) {
        return String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2));
    }
}
