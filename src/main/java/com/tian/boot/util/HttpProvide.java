package com.tian.boot.util;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpProvide {
	 /**
     * 通过GET方式发起http请求
     */

    public String requestByGetMethod(String urlq){
    	String content="";
        //创建默认的httpClient实例
        CloseableHttpClient httpClient = getHttpClient();
        try {
            //用get方法发送http请求
        	URL url = new URL(urlq);
        	URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
            HttpGet get = new HttpGet(uri);
            //System.out.println("执行get请求:...."+get.getURI());
            CloseableHttpResponse httpResponse = null;
            //发送get请求
            httpResponse = httpClient.execute(get);
                //response实体
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
                	content=EntityUtils.toString(entity);                 
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                closeHttpClient(httpClient);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return content;
    }
    private void closeHttpClient(CloseableHttpClient client) throws IOException{
        if (client != null){
            client.close();
        }
    }
    
    private CloseableHttpClient getHttpClient(){
        return HttpClients.createDefault();
    }
    public static String getData(String url){    
        HttpClient httpClient = new HttpClient();
        //设置代理
        GetMethod getMethod = new GetMethod(url); //get指定url的数据
        try {
            int status = httpClient.executeMethod(getMethod);
            if (status == HttpStatus.SC_OK) {  //请求url后，服务器返回的执行状态
                return getMethod.getResponseBodyAsString();
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    }
