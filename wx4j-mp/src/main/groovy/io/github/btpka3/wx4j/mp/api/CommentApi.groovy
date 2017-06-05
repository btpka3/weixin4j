package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.mp.WxMpApi.BaseReq
import io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 评论数据管理
 */
@CompileStatic
interface CommentApi extends WxMpApi {

    String API_URI_open = "https://api.weixin.qq.com/cgi-bin/comment/open"
    String API_URI_close = "https://api.weixin.qq.com/cgi-bin/comment/close"
    String API_URI_list = "https://api.weixin.qq.com/cgi-bin/comment/list"
    String API_URI_mark = "https://api.weixin.qq.com/cgi-bin/comment/markelect"
    String API_URI_unmark = "https://api.weixin.qq.com/cgi-bin/comment/unmarkelect"
    String API_URI_del = "https://api.weixin.qq.com/cgi-bin/comment/delete"


    String API_URI_reply = "https://api.weixin.qq.com/cgi-bin/comment/reply/add"
    String API_URI_delReply = "https://api.weixin.qq.com/cgi-bin/comment/reply/delete"

    /**
     * 打开已群发文章评论
     */
    OpenResp open(
            String access_token,
            OpenReq addReq
    )


    static class OpenReq extends BaseReq {

        /**
         * 群发返回的 msg_data_id
         */
        Integer msg_data_id

        /**
         * 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
         */
        Integer index
    }

    static class OpenResp extends BaseResp {

    }

    // ----------------------------------------------

    /**
     * 打开已群发文章评论
     */
    CloseResp close(
            String access_token,
            CloseReq closeReq
    )

    static class CloseReq extends BaseReq {

        /**
         * 群发返回的 msg_data_id
         */
        Integer msg_data_id

        /**
         * 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
         */
        Integer index
    }

    static class CloseResp extends BaseResp {

    }

    // ----------------------------------------------

    /**
     * 查看指定文章的评论数据
     */
    ListResp list(
            String access_token,
            ListReq listReq
    )

    static class ListReq extends BaseReq {

        /**
         * 群发返回的 msg_data_id
         */
        Integer msg_data_id

        /**
         * 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
         */
        Integer index

        /**
         * 起始位置
         */
        Integer begin

        /**
         * 获取数目（>=50会被拒绝）
         */
        Integer count

        /**
         * 评论类型
         *
         * 0 - 普通评论&精选评论
         * 1 - 普通评论
         * 2 - 精选评论
         */
        Integer type

    }

    static class ListResp extends BaseResp {
        Integer total
        List<Comment> comment

        public static class Comment {
            String user_comment_id
            String openid
            Long create_time
            String content

            /**
             * 是否精选评论
             *
             * 0 - 非精选
             * 1 - 精选
             */
            Integer comment_type

            public static class Reply {

                /**
                 * 作者回复内容
                 */
                String content

                /**
                 * 作者回复时间
                 */
                Long create_time
            }
        }
    }

    // ----------------------------------------------

    /**
     * 将评论标记精选
     */
    MarkResp mark(
            String access_token,
            MarkReq markReq
    )

    static class MarkReq extends BaseReq {
        Integer msg_data_id
        Integer index
        Integer user_comment_id
    }

    static class MarkResp extends BaseResp {

    }

    // ----------------------------------------------
    /**
     * 将评论取消精选
     */
    UnmarkResp unmark(
            String access_token,
            UnmarkReq unmarkReq
    )

    static class UnmarkReq extends BaseReq {
        Integer msg_data_id
        Integer index
        Integer user_comment_id
    }

    static class UnmarkResp extends BaseResp {

    }

    // ----------------------------------------------
    /**
     * 删除评论
     */
    DelResp del(
            String access_token,
            DelReq delReq
    )

    static class DelReq extends BaseReq {
        Integer msg_data_id
        Integer index
        Integer user_comment_id
    }

    static class DelResp extends BaseResp {

    }

    // ----------------------------------------------

    /**
     * 回复评论
     */
    ReplyResp reply(
            String access_token,
            ReplyReq replyReq
    )

    static class ReplyReq extends BaseReq {
        Integer msg_data_id
        Integer index
        Integer user_comment_id

        String content
    }

    static class ReplyResp extends BaseResp {

    }

    // ----------------------------------------------
    /**
     * 删除回复
     */
    DelReplyResp delReply(
            String access_token,
            DelReplyReq delReplyReq
    )


    static class DelReplyReq extends BaseReq {
        Integer msg_data_id
        Integer index
        Integer user_comment_id
    }

    static class DelReplyResp extends BaseResp {

    }
}
