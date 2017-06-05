package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi
import io.github.btpka3.wx4j.mp.WxMpApi.BaseReq
import io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 用户标签管理
 */
@CompileStatic
interface UserTagApi extends WxMpApi {

    String API_URI_create = "https://api.weixin.qq.com/cgi-bin/tags/create"
    String API_URI_list = "https://api.weixin.qq.com/cgi-bin/tags/get"
    String API_URI_update = "https://api.weixin.qq.com/cgi-bin/tags/update"
    String API_URI_del = "https://api.weixin.qq.com/cgi-bin/tags/delete"

    String API_URI_getUserByTag = "https://api.weixin.qq.com/cgi-bin/user/tag/get"
    String API_URI_tagUser = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging"
    String API_URI_untagUser = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging"
    String API_URI_getTagByUser = "https://api.weixin.qq.com/cgi-bin/tags/getidlist"

    // ----------------------------------------------
    CreateResp create(
            String access_token,
            CreateReq createReq
    )

    static class CreateReq extends BaseReq {
        Tag tag

        public static class Tag {
            String name
        }

    }

    static class CreateResp extends BaseResp {
        Tag tag
        public static class Tag {
            Integer id
            String name
        }
    }

    // ----------------------------------------------

    /**
     * 获取公众号已创建的标签
     */
    ListResp list(
            String access_token
    )

    static class ListResp extends BaseResp {
        List<Tag> tags

        public static class Tag {
            Integer id
            String name

            /**
             * 此标签下粉丝数
             */
            Integer count
        }
    }

    // ----------------------------------------------
    /**
     * 编辑标签
     */
    UpdateResp update(
            String access_token,
            UpdateReq updateReq
    )

    static class UpdateReq extends BaseReq {
        Tag tag

        public static class Tag {
            Integer id
            String name
        }
    }

    static class UpdateResp extends BaseResp {
    }

    // ----------------------------------------------
    /**
     * 删除标签
     */
    DelResp del(
            String access_token,
            DelReq delReq
    )

    static class DelReq extends BaseReq {
        Tag tag

        public static class Tag {
            Integer id
        }
    }

    static class DelResp extends BaseResp {
    }

    // ----------------------------------------------

    /**
     * 获取标签下粉丝列表
     */
    GetUserByTagResp getUserByTag(
            String access_token,
            GetUserByTagReq getUserByTagReq
    )

    static class GetUserByTagReq extends BaseReq {
        Integer tagid

        /**
         * 第一个拉取的OPENID，不填默认从头开始拉取
         */
        String next_openid
    }

    static class GetUserByTagResp extends BaseResp {

        /**
         * 这次获取的粉丝数量
         */
        Integer count

        /**
         * 粉丝列表
         */
        Data data

        public static class Data {
            List<String> openid
            String next_openid
        }
    }

    // ----------------------------------------------

    /**
     * 批量为用户打标签
     */
    TagUserResp tagUser(
            String access_token,
            TagUserReq tagUserReq
    )


    static class TagUserReq extends BaseReq {
        Integer tagid

        /**
         * 粉丝列表
         */
        List<String> openid_list
    }

    static class TagUserResp extends BaseResp {

    }

    // ----------------------------------------------

    /**
     * 批量为用户取消标签
     */
    UntagUserResp untagUser(
            String access_token,
            UntagUserReq untagUserReq
    )

    static class UntagUserReq extends BaseReq {
        Integer tagid

        /**
         * 粉丝列表
         */
        List<String> openid_list
    }

    static class UntagUserResp extends BaseResp {

    }

    // ----------------------------------------------

    /**
     * 批量为用户取消标签
     */
    GetTagByUserResp getTagByUser(
            String access_token,
            GetTagByUserReq getTagByUserReq
    )

    static class GetTagByUserReq extends BaseReq {
        String openid
    }

    static class GetTagByUserResp extends BaseResp {
        List<Integer> tagid_list
    }
}
