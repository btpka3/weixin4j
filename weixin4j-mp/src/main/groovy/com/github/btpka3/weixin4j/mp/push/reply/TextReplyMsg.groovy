package com.github.btpka3.weixin4j.mp.push.reply

import com.github.btpka3.weixin4j.mp.push.ReplyMsg

/**
 *
 */
class TextReplyMsg implements ReplyMsg {

    String ToUserName
    String FromUserName
    String CreateTime
    final String MsgType = "text"

    /**
     * 回复的消息内容
     *
     * （换行：在content中能够换行，微信客户端就支持换行显示）
     */
    String Content
}
