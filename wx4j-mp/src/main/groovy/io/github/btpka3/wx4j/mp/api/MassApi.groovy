package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.mp.WxMpApi.BaseReq
import io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 群发相关API
 */
@CompileStatic
interface MassApi extends WxMpApi {

    String API_URI_byTag = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall"
    String API_URI_bytOpenId = "https://api.weixin.qq.com/cgi-bin/message/mass/send"
    String API_URI_del = "https://api.weixin.qq.com/cgi-bin/message/mass/delete"
    String API_URI_preview = "https://api.weixin.qq.com/cgi-bin/message/mass/preview"


    ByTagResp byTag(
            String access_token,
            ByTagReq byTagReq
    )

    ByOpenIdResp bytOpenId(
            String access_token,
            ByOpenIdReq byOpenIdReq
    )

    DelResp del(
            String access_token,
            DelReq delReq
    )

    PreviewResp preview(
            String access_token,
            PreviewReq previewReq
    )

    static abstract class PreviewReq extends BaseReq {
        /**
         * 接收消息用户对应该公众号的openid
         */
        String touser

        /**
         * 接收消息用户对应该公众号的微信号
         *
         * 注意： touser 和 towxname 只能选择一个
         */
        String towxname

    }

    static abstract class PreviewMpnewsReq extends PreviewReq {
        final String msgtype = "mpnews"
        Mpnews mpnews
        public static class Mpnews {
            String media_id
        }
    }


    static abstract class PreviewTextReq extends PreviewReq {
        final String msgtype = "text"
        Text text
        public static class Text {
            String content
        }
    }

    static abstract class PreviewVoiceReq extends PreviewReq {
        final String msgtype = "voice"
        Voice voice
        public static class Voice {
            String media_id
        }
    }

    static abstract class PreviewImageReq extends PreviewReq {
        final String msgtype = "image"
        Image image
        public static class Image {
            String media_id
        }
    }

    static abstract class PreviewMpvideoReq extends PreviewReq {
        final String msgtype = "mpvideo"
        Mpvideo mpvideo
        public static class Mpvideo {
            String media_id
        }
    }

    static abstract class PreviewWxcardReq extends PreviewReq {
        final String msgtype = "wxcard"
        Wxcard wxcard
        public static class Wxcard {
            String card_id
            String card_ext

            public static class CardExt {
                String code
                String openid
                String timestamp
                String signature
            }
        }
    }

    static class PreviewResp extends BaseResp {

        /**
         * 消息发送任务的ID
         */
        String msg_id

    }

    ////
    static abstract class DelReq extends BaseReq {

        /**
         * 发送出去的消息ID
         */
        Long msg_id

        /**
         * 要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章
         */
        String article_idx
    }

    static abstract class ByOpenIdReq extends BaseReq {
        List<String> touser
    }

    static abstract class DelResp extends BaseResp {
    }

    static class ByOpenIdMpnewsReq extends ByOpenIdReq {
        final String msgtype = "mpnews"

        Mpnews mpnews

        /**
         * 图文消息被判定为转载时，是否继续群发。
         *
         * 1 - 继续群发（转载）
         * 0 - 停止群发。
         */
        Integer send_ignore_reprint

        public static class Mpnews {
            Integer media_id
        }
    }

    static class ByOpenIdTextReq extends ByOpenIdReq {
        final String msgtype = "text"
        Text text

        public static class Text {
            String content
        }
    }

    static class ByOpenIdVoiceReq extends ByOpenIdReq {
        final String msgtype = "voice"

        Voice voice

        public static class Voice {
            String media_id
        }
    }

    static class ByOpenIdImageReq extends ByOpenIdReq {
        final String msgtype = "image"

        Image image

        public static class Image {
            String media_id
        }
    }


    static class ByOpenIdMpvideoReq extends ByOpenIdReq {
        final String msgtype = "mpvideo"

        Mpvideo mpvideo

        public static class Mpvideo {
            String media_id
            String title
            String description
        }
    }

    static class ByOpenIdWxcardReq extends ByOpenIdReq {
        final String msgtype = "wxcard"

        Wxcard wxcard

        public static class Wxcard {
            String card_id
        }
    }


    static class ByOpenIdResp extends BaseResp {

        /**
         * 消息发送任务的ID
         */
        String msg_id

        /**
         * 消息的数据ID.
         *
         * 该字段只有在群发图文消息时，才会出现.
         * 可以用于在图文分析数据接口中，获取到对应的图文消息的数据，
         * 是图文分析数据接口中的msgid字段中的前半部分，
         * 详见图文分析数据接口中的msgid字段的介绍。
         */
        String msg_data_id
    }

    // --------
    static abstract class ByTagReq extends BaseReq {
        Filter filter
        public static class Filter {
            Boolean is_to_all
            Integer tag_id
        }
    }

    static class ByTagMpnewsReq extends ByTagReq {
        final String msgtype = "mpnews"

        Mpnews mpnews

        /**
         * 图文消息被判定为转载时，是否继续群发。
         *
         * 1 - 继续群发（转载）
         * 0 - 停止群发。
         */
        Integer send_ignore_reprint

        public static class Mpnews {
            Integer media_id
        }
    }

    static class ByTagTextReq extends ByTagReq {
        final String msgtype = "text"
        Text text

        public static class Text {
            String content
        }
    }

    static class ByTagVoiceReq extends ByTagReq {
        final String msgtype = "voice"

        Voice voice

        public static class Voice {
            String media_id
        }
    }

//    static class ByTagVoiceReq extends ByTagReq {
//        final String msgtype = "voice"
//        Voice voice
//
//        public static class Voice {
//            String media_id
//        }
//    }

    static class ByTagImageReq extends ByTagReq {
        final String msgtype = "image"
        Image image

        public static class Image {
            String media_id
        }
    }

    static class ByTagMpvideoReq extends ByTagReq {
        final String msgtype = "mpvideo"
        Mpvideo mpvideo

        public static class Mpvideo {
            String media_id
        }
    }

    static class ByTagWxcardReq extends ByTagReq {
        final String msgtype = "wxcard"
        Wxcard wxcard

        public static class Wxcard {
            String media_id
        }
    }


    static class ByTagResp extends BaseResp {

        /**
         * 消息发送任务的ID
         */
        String msg_id

        /**
         * 消息的数据ID.
         *
         * 该字段只有在群发图文消息时，才会出现.
         * 可以用于在图文分析数据接口中，获取到对应的图文消息的数据，
         * 是图文分析数据接口中的msgid字段中的前半部分，
         * 详见图文分析数据接口中的msgid字段的介绍。
         */
        String msg_data_id
    }


}
