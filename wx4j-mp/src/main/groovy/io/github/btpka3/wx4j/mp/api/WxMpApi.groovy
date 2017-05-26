package io.github.btpka3.wx4j.mp.api;

/**
 *
 */
interface WxMpApi<Query, Req, Resp> {

    Resp query(Query query, Req req);

//    String queryAsString(Query query, Req req)

//
//    public Object selfAt(String appId) {
//
//
//        String url = getProps().url + "/api/wx/selfAt";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(new ArrayList<MediaType>(Arrays.asList(MediaType.APPLICATION_JSON_UTF8)));
////        headers.set("Authorization", OAuth2AccessToken.BEARER_TYPE+" " + tokenInfos.access_token);
//        String uri = UriComponentsBuilder.fromHttpUrl(url).queryParam("appId", appId).build().toUri().toString();
//
//        HttpEntity<String> reqEntity = new HttpEntity<String>(null, headers);
//
//        final ResponseEntity<String> respEntity = getRestTemplate().exchange(uri, HttpMethod.GET, reqEntity, String.class);
//
//        Object respJson = new JsonSlurper().parseText(respEntity.getBody());
//
//        final Object data = (respJson == null ? null : respJson.data);
//        if (!respEntity.getStatusCode().equals(HttpStatus.OK) || !getProperty("RespUtils").invokeMethod("isSuccess", new Object[]{(Integer) (respJson == null ? null : respJson.status)}) || !((data == null ? null : data.accessToken))) {
//            getLog().error("获取 accessToken 失败: " + respEntity.getBody());
//            Assert.isTrue(false, "获取 accessToken 失败");
//        }
//
//
//        return respJson;
//    }
//
//    public Object selfUserAt(String appId, String code) {
//
//        String url = getProps().url + "/api/wx/selfUserAt";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(new ArrayList<MediaType>(Arrays.asList(MediaType.ALL)));
//        String uri = UriComponentsBuilder.fromHttpUrl(url).queryParam("appId", appId).queryParam("code", code).build().toUri().toString();
//
//        HttpEntity<String> reqEntity = new HttpEntity<String>(null, headers);
//
//        final ResponseEntity<String> respEntity = getRestTemplate().exchange(uri, HttpMethod.GET, reqEntity, String.class);
//
//        Object respJson = new JsonSlurper().parseText(respEntity.getBody());
//
//        final Object data = (respJson == null ? null : respJson.data);
//        if (!respEntity.getStatusCode().equals(HttpStatus.OK) || !getProperty("RespUtils").invokeMethod("isSuccess", new Object[]{(Integer) (respJson == null ? null : respJson.status)}) || !((data == null ? null : data.accessToken))) {
//            getLog().error("获取 accessToken 失败: " + respEntity.getBody());
//            Assert.isTrue(false, "获取 accessToken 失败");
//        }
//
//
//        return respJson;
//    }

}
