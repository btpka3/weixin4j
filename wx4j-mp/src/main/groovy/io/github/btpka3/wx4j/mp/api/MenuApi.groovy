package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.mp.WxMpApi.BaseReq

import static io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 自定义菜单
 */
@CompileStatic
interface MenuApi extends WxMpApi {

    String API_URI_create = "https://api.weixin.qq.com/cgi-bin/menu/create"
    String API_URI_createCustom = "https://api.weixin.qq.com/cgi-bin/menu/addconditional"
    String API_URI_query = "https://api.weixin.qq.com/cgi-bin/menu/get"
    String API_URI_queryAll = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info"
    String API_URI_del = "https://api.weixin.qq.com/cgi-bin/menu/delete"
    String API_URI_delCustom = "https://api.weixin.qq.com/cgi-bin/menu/delconditional"
    String API_URI_testCustom = "https://api.weixin.qq.com/cgi-bin/menu/trymatch"


    CreateResp create(
            String access_token,
            CreateReq createReq
    )

    CreateCustomResp createCustom(
            String access_token,
            CreateCustomReq createCustomReq
    )

    /**
     * 查询 自定义菜单。
     *
     * 只能查询到 通过 create() , createCustom() 创建的菜单。
     * 而通过 微信管理后台创建的则查询不到。
     */
    QueryResp query(
            String access_token
    )

    /**
     * 获取自定义菜单配置
     *
     * 1. 第三方平台开发者可以通过本接口，在旗下公众号将业务授权给你后，
     *      立即通过本接口检测公众号的自定义菜单配置，并通过接口再次给公众号设置好自动回复规则，
     *      以提升公众号运营者的业务体验。
     *
     * 2. 本接口与自定义菜单查询接口的不同之处在于，本接口无论公众号的接口是如何设置的，
     *      都能查询到接口，而自定义菜单查询接口则仅能查询到使用API设置的菜单配置。
     *
     * 3. 认证/未认证的服务号/订阅号，以及接口测试号，均拥有该接口权限。
     *
     * 4. 从第三方平台的公众号登录授权机制上来说，该接口从属于消息与菜单权限集。
     *
     * 5. 本接口中返回的图片/语音/视频为临时素材（临时素材每次获取都不同，
     *      3天内有效，通过素材管理-获取临时素材接口来获取这些素材），
     *      本接口返回的图文消息为永久素材素材（通过素材管理-获取永久素材接口来获取这些素材）。
     */
    QueryAllResp queryAll(
            String access_token
    )

    DelResp del(
            String access_token
    )

    DelCustomResp delCustom(
            String access_token,
            DelCustomReq DelCustomReq
    )

    TestCustomResp testCustom(
            String access_token,
            TestCustomReq TestCustomReq
    )

    static class QueryAllResp extends BaseResp {

        Integer is_menu_open

        SelfMenuInfo selfmenu_info

        static class SelfMenuInfo {
            List<Button> button
        }
    }

    static class TestCustomReq extends BaseReq {

        /**
         * 粉丝的OpenID，或粉丝的微信号
         */
        String user_id
    }

    static class TestCustomResp extends BaseResp {
        List<Button> button
    }


    static class DelCustomReq extends BaseReq {
        String menuid
    }

    static class DelCustomResp extends BaseResp {

    }

    static class DelResp extends BaseResp {

    }

    static class QueryResp extends BaseResp {
        Menu menu

        ConditionalMenu conditionalmenu

        public static class Menu {
            List<Button> button
            String menuid
        }

        public static class ConditionalMenu {
            List<Button> button

            MatchRule matchrule
            String menuid
        }
    }


    static class CreateCustomReq extends BaseReq {
        /**
         * 一级菜单按钮
         */
        List<Button> button

        MatchRule matchrule


    }

    static class MatchRule {
        /**
         * 用户标签的id
         * 可通过用户标签管理接口获取
         */
        String tag_id

        /**
         * 性别
         *
         * 1 - 男
         * 2 - 女
         * 不填则不做匹配
         */
        Integer sex
        String country
        String province
        String city

        /**
         * 客户端版本，当前只具体到系统型号。
         *
         * 1 - IOS
         * 2 - Android
         * 3 - Others
         * 不填则不做匹配
         */
        String client_platform_type

        String language
    }

    static class CreateCustomResp extends BaseResp {
        String menuid
    }

    static class CreateReq extends BaseReq {
        /**
         * 一级菜单按钮
         */
        List<Button> button
    }

    static class CreateResp extends BaseResp {
    }


    static abstract class Button {
    }

    /**
     * 通过API调用创建的菜单。
     *
     * 菜单按钮类型。
     *
     * 1. click :
     *      点击推事件用户点击click类型按钮后，微信服务器会通过消息接口推送消息类型为
     *      event的结构给开发者（参考消息接口指南），并且带上按钮中开发者填写的key值，
     *      开发者可以通过自定义的key值与用户进行交互。
     *
     * 2. view :
     *      跳转URL用户点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的网页URL，
     *      可与网页授权获取用户基本信息接口结合，获得用户基本信息。
     *
     * 3. scancode_push :
     *      扫码推事件用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描
     *      结果（如果是URL，将进入URL），且会将扫码的结果传给开发者，开发者可以下发消息
     *
     * 4. scancode_waitmsg :
     *      扫码推事件且弹出“消息接收中”提示框用户点击按钮后，微信客户端将调起扫一扫工具，
     *      完成扫码操作后，将扫码的结果传给开发者，同时收起扫一扫工具，
     *      然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息
     *
     * 5. pic_sysphoto :
     *      弹出系统拍照发图用户点击按钮后，微信客户端将调起系统相机，完成拍照操作后，
     *      会将拍摄的相片发送给开发者，并推送事件给开发者，同时收起系统相机，
     *      随后可能会收到开发者下发的消息
     *
     * 6. pic_photo_or_album :
     *      弹出拍照或者相册发图用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”
     *      或者“从手机相册选择”。用户选择后即走其他两种流程。
     *
     * 7. pic_weixin :
     *      弹出微信相册发图器用户点击按钮后，微信客户端将调起微信相册，完成选择操作后，
     *      将选择的相片发送给开发者的服务器，并推送事件给开发者，
     *      同时收起相册，随后可能会收到开发者下发的消息。
     *
     * 8. location_select :
     *      弹出地理位置选择器用户点击按钮后，微信客户端将调起地理位置选择工具，完成选择操作后，
     *      将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，
     *      随后可能会收到开发者下发的消息。
     *
     * 9. media_id :
     *      下发消息（除文本消息）用户点击media_id类型按钮后，
     *      微信服务器会将开发者填写的永久素材id对应的素材下发给用户，
     *      永久素材类型可以是图片、音频、视频、图文消息。
     *      请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
     *
     * 10. view_limited :
     *      跳转图文消息URL用户点击view_limited类型按钮后，
     *      微信客户端将打开开发者在按钮中填写的永久素材id对应的图文消息URL，
     *      永久素材类型只支持图文消息。
     *      请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
     *
     * 注意:
     *   1. 3到8的所有事件，仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户，
     *      旧版本微信用户点击后将没有回应，开发者也不能正常接收到事件推送。
     *
     *   2. 9和10，是专门给第三方平台旗下未微信认证（具体而言，是资质认证未通过）
     *      的订阅号准备的事件类型，它们是没有事件推送的，能力相对受限，其他类型的公众号不必使用
     */
    static abstract class ApiButton extends Button {
    }

    static class MenuButton extends ApiButton {
        String name
        List<Button> sub_button
    }

    static class ClickButton extends ApiButton {
        final String type = "click"
        String name
        String key
    }

    static class ViewButton extends ApiButton {
        final String type = "view"
        String name
        String url
    }

    static class MiniProgramButton extends ApiButton {
        final String type = "miniprogram"
        String name
        String url
        String appid
        String pagepath
    }

    static class ScanCodeWaitMsgButton extends ApiButton {
        final String type = "scancode_waitmsg"
        String name
        String url
        String key
    }

    static class ScanCodePushButton extends ApiButton {
        final String type = "scancode_push"
        String name
        String key
    }

    static class PicSysPhotoButton extends ApiButton {
        final String type = "pic_sysphoto"
        String name
        String key
    }

    static class PicPhotoOrAlbumButton extends ApiButton {
        final String type = "pic_photo_or_album"
        String name
        String key
    }

    static class PicWeixinButton extends ApiButton {
        final String type = "pic_weixin"
        String name
        String key
    }

    static class LocationSelectButton extends ApiButton {
        final String type = "location_select"
        String name
        String key
    }

    static class MediaIdButton extends ApiButton {
        final String type = "location_select"
        String name
        String media_id
    }

    static class ViewLimitedButton extends ApiButton {
        final String type = "view_limited"
        String name
        String media_id
    }

    /**
     * 通过公众平台官网通过网站功能发布菜单
     */
    static abstract class MpButton extends Button {

    }

    static class MenuMpButton extends MpButton {
        String name
        SubButton sub_button

        static class SubButton {
            List<MpButton> list
        }
    }

    static class ViewMpButton extends MpButton {
        final String type = "view"
        String name
        String url
    }

    static class NewsButton extends MpButton {
        final String type = "news"
        String name
        String value

        NewsInfo news_info

        static class NewsInfo {
            List<News> list

            static class News {
                String title
                String author
                String digest
                Integer show_cover
                String cover_url
                String content_url
                String source_url
            }
        }
    }

    static class VideoMpButton extends MpButton {
        final String type = "video"
        String name
        String value
    }

    static class VoiceMpButton extends MpButton {
        final String type = "voice"
        String name
        String value
    }

    static class TextMpButton extends MpButton {
        final String type = "text"
        String name
        String value
    }

    static class ImgMpButton extends MpButton {
        final String type = "img"
        String name
        String value
    }
}
