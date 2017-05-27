package io.github.btpka3.wx4j.mp.api

import groovy.transform.CompileStatic
import io.github.btpka3.wx4j.mp.WxMpApi

import static io.github.btpka3.wx4j.mp.WxMpApi.BaseReq
import static io.github.btpka3.wx4j.mp.WxMpApi.BaseResp

/**
 * 创建分组
 *
 * 一个公众账号，最多支持创建100个分组。
 */
@CompileStatic
interface UserGroupApi extends WxMpApi {

    String API_URI_create = "https://api.weixin.qq.com/cgi-bin/groups/create"
    String API_URI_update = "https://api.weixin.qq.com/cgi-bin/groups/create"
    String API_URI_del = "https://api.weixin.qq.com/cgi-bin/groups/delete"
    String API_URI_list = "https://api.weixin.qq.com/cgi-bin/groups/get"
    String API_URI_findByUser = "https://api.weixin.qq.com/cgi-bin/groups/get"
    String API_URI_change = "https://api.weixin.qq.com/cgi-bin/groups/members/update"
    String API_URI_batchChange = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate"


    CreateResp create(String access_token, CreateReq createReq)

    UpdateResp update(String access_token, UpdateReq createReq)

    DelResp del(String access_token, DelReq delReq)

    ListResp list(String access_token)

    FindByUserResp findByUser(String access_token, FindByUserReq findByUserReq)

    ChangeResp change(String access_token, ChangeReq changeReq)

    BatchChangeResp batchChange(String access_token, BatchChangeReq batchChangeReq)

    static class BatchChangeReq extends BaseReq {

        List<String> openid_list

        String to_groupid
    }

    static class BatchChangeResp extends BaseResp {
    }

    static class ChangeReq {
        String openid
        String to_groupid
    }

    static class ChangeResp extends BaseResp {
    }

    static class FindByUserReq {
        String openid
    }

    static class FindByUserResp extends BaseResp {
        String groupid
    }


    static class ListResp extends BaseResp {
        List<Group> groups

        static class Group {
            String id
            String name
            int count
        }
    }

    static class DelReq {
        Group group

        static class Group {
            String id
        }
    }

    static class DelResp extends BaseResp {}

    static class CreateReq {
        Group group

        static class Group {
            String name
        }
    }

    static class CreateResp extends BaseResp {
        Group group

        static class Group {
            String id
            String name
        }
    }


    static class UpdateReq {
        Group group

        static class Group {
            String id
            String name
        }
    }

    static class UpdateResp extends BaseResp {}

}
