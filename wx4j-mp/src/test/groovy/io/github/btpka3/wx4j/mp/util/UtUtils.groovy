package io.github.btpka3.wx4j.mp.util

import groovy.json.JsonOutput
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.github.btpka3.wx4j.mp.api.*
import io.github.btpka3.wx4j.mp.api.AppAtApi.GetAppAtResp
import io.github.btpka3.wx4j.mp.api.JsApiTicketApi.GetTicketResp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.*
import org.springframework.stereotype.Component
import org.springframework.util.Assert

@Component
@Slf4j
@CompileStatic
class UtUtils implements Serializable {

    public static final long serialVersionUID = 1L

    /**
     * key : wxMpName
     */
    private Map wxMpAts = [:]

    /**
     * key : wxMpName
     */
    private Map wxMpJsApiTickets = [:]

    /**
     * key : wxMpName
     * value: Map - key : user openId, value : userAt
     */
    private Map wxMpUserAts = [:]

    //-------------------------

    private transient boolean loaded = false

    @Autowired
    transient UtProps utProps

    @Autowired
    transient AppAtApi appAtApi

    @Autowired
    transient JsApiTicketApi jsApiTicketApi

    @Autowired
    transient UserAtApi userAtApi

    private void logData() {
        log.info("wxMpAts = " + JsonOutput.prettyPrint(JsonOutput.toJson(wxMpAts)))
        log.info("wxMpJsApiTickets = " + JsonOutput.prettyPrint(JsonOutput.toJson(wxMpJsApiTickets)))
        log.info("wxMpUserAts = " + JsonOutput.prettyPrint(JsonOutput.toJson(wxMpUserAts)))
    }

    @EventListener([ContextRefreshedEvent])
    synchronized void loadData() {
        log.info("22222222222222222222222222222222222")

        if (loaded) {
            return
        }

        if (!utProps?.dataFile?.exists()) {
            return
        }

        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(utProps.dataFile))
        UtUtils utUtils = (UtUtils) objIn.readObject()

        this.wxMpAts = utUtils.wxMpAts
        this.wxMpJsApiTickets = utUtils.wxMpJsApiTickets
        this.wxMpUserAts = utUtils.wxMpUserAts

        log.info("从 ${utProps.dataFile} 加载上次执行的数据")
        logData()
    }

    @EventListener([ContextClosedEvent])
    synchronized void saveData() {
        log.info("3333333333333333333333333333333")
        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(utProps.dataFile))
        objOut.writeObject(this)

        log.info("向 ${utProps.dataFile} 写入当前的数据")
        logData()

    }

    synchronized String getWxMpAt(String wxAppName) {

        if (wxMpAts[wxAppName]) {
            return wxMpAts[wxAppName]
        }

        String appId = utProps.wx[wxAppName].appId
        String appSecret = utProps.wx[wxAppName].appSecret

        GetAppAtResp resp = appAtApi.getAppAt(appId, appSecret)
        String at = resp?.access_token
        Assert.notNull(at, "无法获取 access token")
        wxMpAts[wxAppName] = at
        return at
    }


    synchronized String saveUserAt(String wxAppName, String openId, String userAt) {
        if (wxMpUserAts[wxAppName] == null) {
            wxMpUserAts[wxAppName] = [:]
        }

        userAtApi.isValid(userAt, openId)

        wxMpUserAts[wxAppName][openId] = userAt
    }

    synchronized String getUserAt(String wxAppName, String openId) {

        if (wxMpUserAts[wxAppName] == null) {
            wxMpUserAts[wxAppName] = [:]
        }
        if (!wxMpUserAts[wxAppName][openId]) {
            throw new RuntimeException("请先手动执行 UserAtImplTest#getUserAt01")
        }




        return wxMpUserAts[wxAppName][openId]
    }


    synchronized String getWxMpJsApiTicket(String wxAppName) {

        if (wxMpJsApiTickets[wxAppName]) {
            return wxMpJsApiTickets[wxAppName]
        }
        String at = this.getWxMpAt(wxAppName)

        GetTicketResp resp = jsApiTicketApi.getTicket(at)
        String ticket = resp?.ticket
        Assert.notNull(ticket, "无法获取 JsApiTicket")
        wxMpAts[wxAppName] = ticket
        return ticket
    }

}
