package com.javalab03;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Renren {
	private static DefaultHttpClient httpClient;
	private static HttpResponse response;
	private static String userId;
	private static String requestToken;
	private static String rtk;

	public Renren(String userName, String passWord) {
		httpClient = new DefaultHttpClient();
		String origURL = "http://www.renren.com/home";
		String domain = "renren.com";
		String loginURL = "http://www.renren.com/PLogin.do";
		HttpPost httpPost = new HttpPost(loginURL);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", userName));
		params.add(new BasicNameValuePair("password", passWord));
		params.add(new BasicNameValuePair("origURL", origURL));
		params.add(new BasicNameValuePair("domain", domain));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response = postMethod(httpPost);
		String url = response.getFirstHeader("Location").getValue();
		String content = getContent(url);
		StringBuffer sb = new StringBuffer(content);
		int startPos = sb.indexOf("http://www.renren.com/profile.do?id=");
		int endPos = sb.indexOf("\"><span stats=\"V6Hd_Profile\"");
		userId = sb.substring(startPos + 36, endPos);
		startPos = sb.indexOf("get_check:'");
		endPos = sb.indexOf("',get_check_x:'");
		requestToken = sb.substring(startPos + 11, endPos);
		startPos = sb.indexOf("get_check_x:'");
		endPos = sb.indexOf("',env:{domain:");
		rtk = sb.substring(startPos + 13, endPos);
	}

	public HttpResponse postMethod(HttpPost httpPost) {
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpPost.abort();
		}
		return httpResponse;
	}

	public HttpResponse getMethod(String url) {
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpGet.abort();
		}
		return httpResponse;
	}

	public String getContent(String url) {
		HttpGet httpGet = new HttpGet(url);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String content = null;
		try {
			content = httpClient.execute(httpGet, responseHandler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpGet.abort();
		}
		return content;
	}

	public boolean updateStatus(String words) {
		String url = "http://shell.renren.com/" + userId + "/status";
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("content", words));
		params.add(new BasicNameValuePair("hostid", userId));
		params.add(new BasicNameValuePair("requestToken", requestToken));
		params.add(new BasicNameValuePair("_rtk", rtk));
		params.add(new BasicNameValuePair("channel", "renren"));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response = postMethod(httpPost);
		return true;
	}

	public boolean updateLog(String title, String words) {
		String url = "http://blog.renren.com/blog/0/addBlog";
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("title", title));
		params.add(new BasicNameValuePair("body", "<p>" + words + "</p>"));
		params.add(new BasicNameValuePair("requestToken", requestToken));
		params.add(new BasicNameValuePair("_rtk", rtk));
		params.add(new BasicNameValuePair("blogControl", "99"));
		params.add(new BasicNameValuePair("editBlogControl", "99"));
		params.add(new BasicNameValuePair("jf_vip_em", "-true"));
		params.add(new BasicNameValuePair("postFormId", requestToken));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response = postMethod(httpPost);
		return true;
	}
}