package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic

/**
 * 删除客服帐号
 */
@CompileStatic
interface KsMsgApi extends WxMpApi {

    String API_URI_send = "https://api.weixin.qq.com/cgi-bin/message/custom/send"


    SendResp send(String access_token, SendReq sendReq)


    static class SendResp extends BaseResp {
    }

    static abstract class SendReq {

        CustomService customservice

        static class CustomService {
            String kf_account
        }
    }

    /**
     * 发送文本消息
     */
    static class TextMsgReq extends SendReq {
        String touser
        final String msgtype = "text"
        String text
    }

    /**
     * 发送图片消息
     */
    static class ImageMsgReq extends SendReq {
        String touser
        final String msgtype = "image"
        Image image

        static class Image {
            String media_id
        }
    }

    /**
     * 发送语音消息
     */
    static class VoiceMsgReq extends SendReq {
        String touser
        final String msgtype = "voice"
        Voice voice

        static class Voice {
            String media_id
        }
    }

    /**
     * 发送视频消息
     */
    static class VedioMsgReq extends SendReq {
        String touser
        final String msgtype = "video"
        Voice video

        static class Voice {
            String media_id
        }
    }

    /**
     * 发送音乐消息
     */
    static class MusicMsgReq extends SendReq {
        String touser
        final String msgtype = "music"
        Music music

        static class Music {
            String title
            String description
            String musicurl
            String hqmusicurl
            String thumb_media_id
        }
    }

    /**
     * 发送图文消息.
     *
     * 图文消息条数限制在10条以内，注意，如果图文数超过10，则将会无响应。
     */
    static class NewsMsgReq extends SendReq {
        String touser
        final String msgtype = "news"
        News news

        static class News {

            List<Article> articles

            static class Article {
                String title
                String description
                String url
                String picurl
            }

        }
    }

    /**
     * 发送图文消息.
     *
     * 图文消息条数限制在10条以内，注意，如果图文数超过10，则将会无响应。
     */
    static class WxCardMsgReq extends SendReq {
        String touser
        final String msgtype = "wxcard"
        WxCard wxcard

        static class WxCard {

            String card_id
            String card_ext

        }
    }

}
