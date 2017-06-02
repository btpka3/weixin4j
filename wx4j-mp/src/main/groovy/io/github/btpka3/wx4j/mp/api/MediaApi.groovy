package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.mp.WxMpApi.BaseReq
import io.github.btpka3.wx4j.mp.WxMpApi.BaseResp
import org.springframework.core.io.Resource

import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

/**
 * 媒体资源相关API
 */
@CompileStatic
interface MediaApi extends WxMpApi {

    String API_URI_uploadImg = "https://api.weixin.qq.com/cgi-bin/media/uploadimg"
    String API_URI_uploadNews = "https://api.weixin.qq.com/cgi-bin/media/uploadnews"
    String API_URI_uploadVideo = "https://api.weixin.qq.com/cgi-bin/media/uploadvideo"

    /**
     * 使用FORM表单上传图文消息内的图片获取URL
     *
     * @param access_token 调用接口凭证
     * @param media form-data中媒体文件标识，有filename、filelength、content-type等信息
     * @return
     */
    UploadImgResp uploadImg(
            String access_token,
            Resource media
    )

    UploadNewsResp uploadNews(
            String access_token,
            UploadNewsReq uploadNewsReq
    )

    /**
     * 群发视频时，需要通过该接口获取 media_id
     *
     * @param access_token
     * @param uploadVideoReq
     * @return
     */
    UploadVideoResp uploadVideo(
            String access_token, // FIXME
            UploadVideoReq uploadVideoReq
    )

    static class UploadVideoResp extends BaseResp {
        String type
        String media_id
        Long created_at
    }

    static class UploadVideoReq extends BaseReq {
        String media_id
        String title
        String description

    }


    static class UploadNewsReq extends BaseReq {

        List<Article> articles

        /**
         * 图文消息，一个图文消息支持1到8条图文
         */
        public static class Article {

            /**
             * 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
             */
            String thumb_media_id

            /**
             * 图文消息的作者
             */
            String author

            /**
             * 图文消息的标题
             */
            String title

            /**
             * 在图文消息页面点击“阅读原文”后的页面，受安全限制，如需跳转Appstore，
             * 可以使用itun.es或appsto.re的短链服务，并在短链后增加 #wechat_redirect 后缀。
             */
            String content_source_url

            /**
             * 图文消息页面的内容，支持HTML标签。
             *
             * 具备微信支付权限的公众号，可以使用a标签，
             * 其他公众号不能使用。
             *
             * 如需插入小程序卡片，内容应该是 MpMiniProgram 类对应的XML内容
             */
            String content

            /**
             * 图文消息的描述
             */
            String digest

            /**
             * 是否显示封面.
             * 1 - 显示
             * 0 - 不显示
             */
            Integer show_cover_pic


        }
    }

    static class UploadNewsResp extends BaseResp {

        /**
         * 媒体文件类型
         *
         * image - 图片
         * voice - 语音
         * video - 视频
         * thumb - 缩略图
         * news  - 图文消息
         */
        String type
        String media_id
        Long created_at

    }

    static class UploadImgResp extends BaseResp {
        String url
    }


    @XmlRootElement(name = "data-miniprogram-appid")
    static class MpMiniProgram {

        @XmlAttribute(name = "data-miniprogram-appid")
        String appid

        @XmlAttribute(name = "data-miniprogram-path")
        String path

        @XmlAttribute(name = "data-miniprogram-title")
        String title

        @XmlAttribute(name = "data-miniprogram-imageurl")
        String imageurl
    }
}
