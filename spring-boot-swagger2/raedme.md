Swagger是一款可以快速生成符合RESTful风格API并进行在线调试的插件。本文将介绍如何在Spring Boot中整合Swagger。

在此之前，我们先聊聊什么是REST。REST实际上为Representational State Transfer的缩写，翻译为“表现层状态转化” 。如果一个架构符合REST 原则，
就称它为RESTful架构。

实际上，“表现层状态转化”省略了主语，完整的说应该是“资源表现层状态转化”。什么是资源（Resource）？资源指的是网络中信息的表现形式，比如一段文本，一首歌，
一个视频文件等等；什么是表现层（Reresentational）？表现层即资源的展现在你面前的形式，比如文本可以是JSON格式的，也可以是XML形式的，甚至为二进制形式的。
图片可以是gif，也可以是PNG；什么是状态转换（State Transfer）？用户可使用URL通过HTTP协议来获取各种资源，HTTP协议包含了一些操作资源的方法，
比如：GET 用来获取资源， POST 用来新建资源 , PUT 用来更新资源， DELETE 用来删除资源， PATCH 用来更新资源的部分属性。通过这些HTTP协议的方法来操作资源的过程即为状态转换。


2. Swagger注解详解
2.1 @Api
@Api 用在类上，说明该类的作用。可以标记一个 Controller 类作为 Swagger 文档资源
tags：接口说明，可以在页面中显示。可以配置多个，当配置多个的时候，在页面中会显示多个接口的信息。description:对tags 进行描述说明

@RequestMapping("/api")
@Api(tags = "测试swagger接口",description = "User模块")//描述


2.2 @ApiModel
@ApiModel 用在类上，表示对类进行说明，用于实体类中的参数接收说明

@Data
@ApiModel(value = "com.pojo",description = "用户pojo")
public class User {
    @ApiModelProperty(value = "账号")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
}

2.3 @ApiModelProperty
@ApiModelProperty() 用于字段，表示对 model 属性的说明

@Data
@ApiModel(value = "com.pojo",description = "用户pojo")
public class User {
    @ApiModelProperty(value = "账号")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
}

2.4 @ApiParam
@ApiParam 用于 Controller 中方法的参数说明

value：参数说明
required：是否必填

@RestController
@RequestMapping("/api")
@Api(tags = "测试swagger接口",description = "User模块")//描述
public class SwaggerController {
    @ApiOperation(value = "我的第一个swagger接口")
    @PostMapping("/swagger")
    public User testUser(@ApiParam(value = "用户实体",required = true) @RequestBody User user, HttpServletRequest request){
        System.out.println(request.getHeader("token"));
        return user;
    }
}

2.5 @ApiOperation
@ApiOperation 用在 Controller 里的方法上，说明方法的作用，每一个接口的定义
value：接口名称

@RestController
@RequestMapping("/api")
@Api(tags = "测试swagger接口",description = "User模块")//描述
public class SwaggerController {
    @ApiOperation(value = "我的第一个swagger接口")
    @PostMapping("/swagger")
    public User testUser(@ApiParam(value = "用户实体",required = true) @RequestBody User user, HttpServletRequest request){
        System.out.println(request.getHeader("token"));
        return user;
    }
}

2.6 @ApiResponse 和 @ApiResponses
@ApiResponse 用于方法上，说明接口响应的一些信息；@ApiResponses 组装了多个 @ApiResponse

@GetMapping("/getUser")
    @ApiOperation(value = "获取用户信息接口")
    @ApiResponses({ @ApiResponse(code = 0, message = "相应成功", response = SysUser.class) })
    public SysUser getUserInfo(@ApiParam(value = "用户id",required = true) @RequestParam String id){
        return userService.getUserInfo(id);
    }
    
2.7 @ApiImplicitParam 和 @ApiImplicitParams
用于方法上，为单独的请求参数进行说明

@GetMapping("/getUser")
    @ApiOperation(value = "获取用户信息接口")
    @ApiResponses({ @ApiResponse(code = 0, message = "相应成功", response = SysUser.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "string", paramType = "query", 
required = true, defaultValue = "0f09e661-7e80-4e1b-b66a-2e266bb593bf")
    })
    public SysUser getUserInfo(@ApiParam(value = "用户id",required = true) @RequestParam String id){
        return userService.getUserInfo(id);
    }