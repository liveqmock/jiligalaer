package sy.common.util.cloudstack.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import sy.common.util.cloudstack.CloudErrorType;
import sy.common.util.cloudstack.CloudException;
import sy.common.util.cloudstack.Param;
import sy.common.util.cloudstack.ProviderContext;

/**
 * 
 * @author lidongbo
 * 
 */
public class RequestMethod {

	private static final Logger log = Logger.getLogger(RequestMethod.class);

	private ProviderContext provider;

	public RequestMethod(ProviderContext provider) {
		this.provider = provider;
	}

	public String buildUrl(String command, Param... params) {
		try {
			StringBuilder str = new StringBuilder();
			str.append(provider.getEndpoint());
			str.append("/api?command=");
			str.append(command);
			for (Param param : params) {
				if (param.getValue() == null) {
					continue;
				}
				str.append("&");
				str.append(param.getKey());
				str.append("=");
				str.append(URLEncoder.encode(param.getValue(), "UTF-8")
						.replaceAll("\\+", "%20"));
			}
			return str.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException("This cannot happen: " + e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	HttpClient getClient(String url) {

		boolean ssl = url.startsWith("https");
		HttpParams params = new BasicHttpParams();

		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);

		HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

		Properties props = provider.getCustomProperties();

		if (props != null) {
			String proxyHost = props.getProperty("proxyHost");
			String proxyPort = props.getProperty("proxyPort");

			if (proxyHost != null) {
				int port = 0;

				if (proxyPort != null && proxyPort.length() > 0) {
					port = Integer.parseInt(proxyPort);
				}
				params.setParameter(ConnRoutePNames.DEFAULT_PROXY,
						new HttpHost(proxyHost, port, ssl ? "https" : "http"));
			}
		}
		return new DefaultHttpClient(params);
	}

	static public class ParsedError {
		public int code;
		public String message;
	}

	private Document parseResponse(int code, String xml) throws CloudException {

		log.debug(xml);
		try {
			ByteArrayInputStream input = new ByteArrayInputStream(
					xml.getBytes("utf-8"));

			return DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(input);
		} catch (IOException e) {
			throw new CloudException(e);
		} catch (ParserConfigurationException e) {
			throw new CloudException(e);
		} catch (SAXException e) {
			throw new CloudException("Received error code from server [" + code
					+ "]: " + xml);
		}
	}

	
	/**
	  <createaccountresponse cloud-stack-version="3.0.6.2013-05-02T10:22:00Z">
		<errorcode>431</errorcode>
		<cserrorcode>9999</cserrorcode>
		<errortext>
		Unable to execute API command createaccount due to missing parameter lastname
		</errortext>
	  </createaccountresponse>
	 */
	private ParsedError parseError(int httpStatus, String assumedXml) {

		ParsedError error = new ParsedError();

		error.code = httpStatus;
		error.message = null;
		try {
			Document doc = parseResponse(httpStatus, assumedXml);

			NodeList codes = doc.getElementsByTagName("errorcode");
			for (int i = 0; i < codes.getLength(); i++) {
				Node n = codes.item(i);

				if (n != null && n.hasChildNodes()) {
					error.code = Integer.parseInt(n.getFirstChild()
							.getNodeValue().trim());
				}
			}
			NodeList text = doc.getElementsByTagName("errortext");
			for (int i = 0; i < text.getLength(); i++) {
				Node n = text.item(i);

				if (n != null && n.hasChildNodes()) {
					error.message = n.getFirstChild().getNodeValue();
				}
			}
		} catch (Throwable ignore) {
			log.warn("parseError(): Error was unparsable: "
					+ ignore.getMessage());
			if (error.message == null) {
				error.message = assumedXml;
			}
		}
		if (error.message == null) {
			if (httpStatus == 401) {
				error.message = "Unauthorized user";
			} else if (httpStatus == 430) {
				error.message = "Malformed parameters";
			} else if (httpStatus == 531) {
				error.message = "Unable to find account";
			} else if (httpStatus == 547 || httpStatus == 530) {
				error.message = "Server error in cloud (" + httpStatus + ")";
			} else {
				error.message = "Received error code from server: "
						+ httpStatus;
			}
		}
		return error;
	}

	public Document get(String url) {

		HttpGet httpget = new HttpGet(url);
		HttpClient client = getClient(url);
		HttpResponse response;

		httpget.addHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=utf-8");
		// httpget.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
		try {
			response = client.execute(httpget);
		} catch (IOException e) {
			log.error(
					"I/O error from server communications: " + e.getMessage(),
					e);
			throw new CloudException(e);
		}
		int status = response.getStatusLine().getStatusCode();
		try {
			if (status != HttpServletResponse.SC_OK) {
				HttpEntity entity = response.getEntity();
				String body = (entity == null ? null : EntityUtils
						.toString(entity));

				if (body == null) {

					throw new CloudException(CloudErrorType.GENERAL, status,
							"Response is null.");
				}
				if (body.contains("<html>")) {
					if (status == HttpServletResponse.SC_FORBIDDEN
							|| status == HttpServletResponse.SC_UNAUTHORIZED) {
						throw new CloudException(CloudErrorType.AUTHENTICATION,
								status, body);
					} else if (status == 430 || status == 431 || status == 432
							|| status == 436) {
						return null;
					}
					throw new CloudException(status, body);
				}
				ParsedError error = parseError(status, body);
				throw new CloudException(error.code, error.message);
			}
			HttpEntity entity = response.getEntity();

			return parseResponse(status, EntityUtils.toString(entity,"utf-8"));
		} catch (IOException e) {
			throw new CloudException("IOException getting stream: "
					+ e.getMessage());
		}
	}
}
