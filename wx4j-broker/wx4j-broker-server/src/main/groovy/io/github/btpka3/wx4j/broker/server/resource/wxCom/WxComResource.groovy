package io.github.btpka3.wx4j.broker.server.resource.wxCom

import groovy.util.logging.Slf4j
import io.github.btpka3.wx4j.broker.api.WxCom
import io.github.btpka3.wx4j.broker.api.model.WxComResiterResp
import io.github.btpka3.wx4j.broker.server.store.WxAppStore
import io.swagger.annotations.Api
import io.swagger.annotations.ApiParam
import org.springframework.stereotype.Component

import javax.ws.rs.*
/**
 *
 */
@Api(
        value = "/user",
        description = "用户",
        tags = ["user"]
)
@Path("/user")
@javax.inject.Singleton
@Component
@Slf4j
class WxComResource implements WxCom {

    WxAppStore wxAppStore

    void authNotify(

             // HEADER 中单值
            @ApiParam(value = "年龄")
            @HeaderParam("age")
                    int age,

            // HEADER 中多值
            @ApiParam(value = "偏好")
            @HeaderParam("hobbies")
                    List<String> hobbies,

            @PathParam("companyId")
            String companyId,

            // Query 中单值
            @ApiParam(
                value = "姓名",
                allowableValues='zhang3,li4,wang5'
            )
            @DefaultValue("zhang3")
            @QueryParam("name")
                    String name,

            // Query 中多值
            @ApiParam(value = "地址")
            @QueryParam("addrs")
                   List< String> addrs
    ){

    }

    @Override
    WxComResiterResp register(){

     return null
    }

}
