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
interface MaterialApi extends WxMpApi {
//
//    String API_URI_uploadTmp = "https://api.weixin.qq.com/cgi-bin/media/upload"
//    String API_URI_getTmp = "https://api.weixin.qq.com/cgi-bin/media/get"

    String API_URI_addNews = "https://api.weixin.qq.com/cgi-bin/material/add_news"
    String API_URI_uploadImg = "https://api.weixin.qq.com/cgi-bin/media/uploadimg"

    String API_URI_add = "https://api.weixin.qq.com/cgi-bin/material/add_material"
    String API_URI_get = "https://api.weixin.qq.com/cgi-bin/material/get_material"
    String API_URI_del = "https://api.weixin.qq.com/cgi-bin/material/del_material"
    String API_URI_uploadNews = "https://api.weixin.qq.com/cgi-bin/material/update_news"
    String API_URI_getCount = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount"
    String API_URI_list = "https://api.weixin.qq.com/cgi-bin/material/batchget_material"

//    String API_URI_uploadVideo = "https://api.weixin.qq.com/cgi-bin/media/uploadvideo"

    /**
     * 新增永久图文素材
     */
    AddNewsResp addNews(
            String access_token,
            AddNewsReq addNewsReq
    )

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

    /**
     * 新增其他类型永久素材
     */
    AddResp add(
            String access_token,
            String type,
            Resource media
    )

    /**
     * 获取永久素材
     */
    GetResp get(
            String access_token,
            GetReq getReq
    )

    /**
     * 删除永久素材
     */
    DelResp del(
            String access_token,
            DelReq delReq
    )

    /**
     * 修改永久图文素材
     */
    UploadNewsResp updateNews(
            String access_token,
            UploadNewsReq uploadNewsReq
    )

    /**
     * 获取素材总数
     */
    GetCountResp getCount(
            String access_token
    )

    /**
     * 获取素材总数
     */
    ListResp list(
            String access_token,
            ListReq listReq
    )

//    /**
//     * 群发视频时，需要通过该接口获取 media_id
//     *
//     * @param access_token
//     * @param uploadVideoReq
//     * @return
//     */
//    UploadVideoResp uploadVideo(
//            String access_token, // FIXME
//            UploadVideoReq uploadVideoReq
//    )

    static class ListReq extends BaseReq {

        /**
         * 素材的类型
         *
         *   image - 图片
         *   video - 视频
         *   voice - 语音
         *   news  - 图文
         */
        String type

        /**
         * 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
         */
        Integer offset

        /**
         * 返回素材的数量，取值在1到20之间
         */
        Integer count
    }

    static abstract class ListResp extends BaseResp {

    }

    static class ListNewsResp extends ListResp {
        Integer total_count
        Integer item_count
        List<Item> item

        public static class Item {
            String media_id
            Long update_time
            Content content

            public static class Content {
                List<News> news_item

                public static class News {
                    String title
                    String thumb_media_id
                    Integer show_cover_pic
                    String author
                    String digest
                    String content
                    String url
                    String content_source_url
                }
            }
        }
    }

    static class ListOthersResp extends ListResp {
        Integer total_count
        Integer item_count
        List<Item> item

        public static class Item {
            String media_id
            String name
            Long update_time
            String url
        }
    }


    static class UpdateReq extends BaseReq {
        String media_id
    }

    static class DelReq extends BaseReq {

        String media_id
    }

    static class DelResp extends BaseResp {
    }

    static class GetReq extends BaseReq {

        String media_id
    }

    static class GetCountResp extends BaseResp {

        /**
         * 语音总数量
         */
        Integer voice_count

        /**
         * 视频总数量
         */
        Integer video_count

        /**
         * 图片总数量
         */
        Integer image_count

        /**
         * 图文总数量
         */
        Integer news_count
    }


    static abstract class GetResp extends BaseResp {
    }

    static class GetNewsResp extends GetResp {

        List<NewsItem> news_item
        public static class NewsItem {
            String title
            String thumb_media_id
            String show_cover_pic
            String author
            String digest
            String content
            String url
            String content_source_url

            Integer need_open_comment
            Integer only_fans_can_comment

        }
    }

    static class GetVideoResp extends GetResp {
        String title
        String description
        String down_url
    }

    static class GetOthersResp extends GetResp {
        byte[] bytes
    }

    static class AddNewsReq extends BaseReq {

        List<Article> articles

        public static class Article {
            String title
            String thumb_media_id
            String author
            String digest
            Integer show_cover_pic
            String content
            String content_source_url

            /**
             * 是否打开评论
             *
             * 0 - 不打开
             * 1 - 打开
             */
            Integer need_open_comment

            /**
             * 是否粉丝才可评论
             *
             * 0 - 所有人可评论
             * 1 - 粉丝才可评论
             */
            Integer only_fans_can_comment

        }
    }

    static class AddResp extends BaseResp {
        String media_id
        String url
    }

    static class AddNewsResp extends BaseResp {
        String media_id
    }

    static class GetTmpResp extends BaseResp {
        String type
        String media_id
        Long created_at
    }

    static class UploadTmpResp extends BaseResp {
        String type
        String media_id
        Long created_at
    }

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

        String media_id
        String index

        Article articles

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

            Integer need_open_comment
            Integer only_fans_can_comment
        }
    }

    static class UploadNewsResp extends BaseResp {

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
