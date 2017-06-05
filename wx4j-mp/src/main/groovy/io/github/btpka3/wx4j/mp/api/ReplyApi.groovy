package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 模板消息接口
 */
@CompileStatic
interface ReplyApi extends WxMpApi {

    String API_URI_curInfo = "https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info"

    /**
     * 获取公众号的自动回复规则
     *
     * @param access_token
     * @return
     */
    CurInfoResp curInfo(
            String access_token
    )

    static class CurInfoResp extends BaseResp {

        /**
         * 关注后自动回复是否开启.
         * 0 - 未开启
         * 1 - 开启
         */
        Integer is_add_friend_reply_open

        /**
         * 消息自动回复是否开启
         * 0 - 未开启
         * 1 - 开启
         */
        Integer is_autoreply_open

        /**
         * 关注后自动回复的信息
         */
        AddFriendAutoReplyInfo  add_friend_autoreply_info

        /**
         * 消息自动回复的信息
         */
        MessageDefaultAutoReplyInfo message_default_autoreply_info

        /**
         * 关键词自动回复的信息
         */
        KeywordAutoReplyInfo keyword_autoreply_info

        public static class AddFriendAutoReplyInfo {
            /**
             * 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），
             * 关键词自动回复则还多了图文消息（news）
             */
            String type

            /**
             * 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
             */
            String content
        }

        public static class MessageDefaultAutoReplyInfo {
            String type
            String content
        }

        public static class KeywordAutoReplyInfo {

            List<ReplyInfo> list

            public static class ReplyInfo {
                /**
                 * 规则名称
                 */
                String rule_name

                /**
                 * 创建时间
                 */
                Long create_time

                /**
                 * 回复模式
                 * reply_all - 全部回复
                 * random_one - 随机回复其中一条
                 */
                String reply_mode

                /**
                 * 匹配的关键词列表
                 */
                List<KeywordListInfo> keyword_list_info

              List<ReplyListInfo>  reply_list_info

                public static class KeywordListInfo {
                    String type

                    /**
                     * 匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
                     */
                    String match_mode
                    String content
                }

                public static class ReplyListInfo {
                    String type
                    String match_mode
                    String content

                    /**
                     * 图文消息的信息
                     */
                    NewsInfo news_info

                    public static class NewsInfo {

                        List<News> list
                        public static  class News {

                            /**
                             * 图文消息的标题
                             */
                            String title

                            /**
                             * 作者
                             */
                            String author

                            /**
                             * 摘要
                             */
                            String digest

                            /**
                             * 是否显示封面
                             * 0 - 不显示
                             * 1 - 显示
                             */
                            Integer show_cover

                            /**
                             * 封面图片的URL
                             */
                            String cover_url

                            /**
                             * 正文的URL
                             */
                            String content_url

                            /**
                             * 原文的URL，若置空则无查看原文入口
                             */
                            String source_url
                        }
                    }
                }
            }
        }
    }

}
