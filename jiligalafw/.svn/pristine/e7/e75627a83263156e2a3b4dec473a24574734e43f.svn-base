package sy.controller.shared;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import sy.common.util.DateUtil;
import sy.common.util.StringUtils;


/**
 * 
 * @author lidongbo
 * 
 */
public abstract class BaseController extends MultiActionController {
	
	/**
	 * 获得一个重定向的跳转对象
	 * 
	 * @param path
	 *            跳转目标路径
	 * @return
	 */
	protected ModelAndView getRedirect(String path) {
		return new ModelAndView(new StringBuilder("redirect:").append(path)
				.toString());
	}

	protected String getRedirectStr(String path) {
		return new StringBuilder("redirect:").append(path).toString();
	}

	protected static HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}

	/** 设置输出流的内容，用于ajax */
	protected void printOutSteamContent(String content,
			HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(content);
		out.flush();
		out.close();
	}
	
	/**
	 * 上传文件
	 */
	public String uploadFile(HttpServletRequest request,MultipartFile  file){
		String newfilename="";
		//每个月份一个文件夹
		String monthFolder=DateUtil.format(new Date(), "yyyy-MM-dd").substring(0,7);
		if (StringUtils.isNotBlank(file.getOriginalFilename())) {
			String oldfilename = file.getOriginalFilename();//获取待上传之文件名称
			InputStream stream = null;// 用于读取待上传文件的输入流
			OutputStream bos = null;// 用于存储待上传文件的输出流
			try {
				//待上传文件构成的文件流
				stream = file.getInputStream();
				//待存储上传文件的基本路径，也就是存放"DmsUploadWarfileAction.UPLOAD_DIR_NAME"目录的路径
				String uploadpath = null;
				//目录存储方案
				/*
				是从当前的网站根目录，向上级回退一级，如：
				"D:\Tomcat\webapps\ROOT\"
				回退到：
				"D:\Tomcat\webapps\"
				*/
				
				//待存储文件之网站根目录的完整路径
				String app_root = this.getServletContext().getRealPath("/");
				int lastsepindex = app_root.lastIndexOf(File.separator);
				if(lastsepindex==(app_root.length()-1))
				{
					uploadpath = app_root.substring(0,lastsepindex);//去掉最右边的目录分隔符
					lastsepindex = uploadpath.lastIndexOf(File.separator);//继续寻找最后一个目录分隔符
				}
				uploadpath = uploadpath.substring(0,lastsepindex);
				
				String filepath = uploadpath + File.separator + "cms_file_upload" + File.separator +monthFolder +File.separator;
				File f = new File(filepath);// 此目录的文件对象
				if (!f.exists()) {
					f.mkdirs();// 如果目录不存在，则创建之
				}

				// 提交的新文件名称
				newfilename = file.getOriginalFilename().trim().toLowerCase();
				
				int lastdotindex = newfilename.lastIndexOf(".");
				String filebody = newfilename.substring(0,lastdotindex);
				String extname = newfilename.substring(lastdotindex+1);
				newfilename = filebody + DateUtil.format(new Date(), "'_'yyyy-MM-dd'_'HH-mm-ss.SSS") + "." + extname;
				String newfullpath = (filepath + newfilename).trim().toLowerCase();

				// 执行上传，读取上传文件内容，将文件内容写入服务器存储位置
				bos = new FileOutputStream(newfullpath);
				int byteread = 0;
				int buffersize = 8192;
				byte[] buffer = new byte[buffersize];
				while ((byteread = stream.read(buffer, 0, buffersize)) != -1) {
					bos.write(buffer, 0, byteread);
				}
				bos.flush();
				stream.close();
				stream = null;
				bos.close();
				bos = null;
				Thread.sleep(1000);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (bos != null) {
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (stream != null) {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return monthFolder+File.separator+newfilename;
	}
	
	/**
	 * 下载文件
	 */
	public void downLoadFileByDiskFileName(String fileName,String fileNameOnDisk,HttpServletResponse response) 
			throws UnsupportedEncodingException{
		if (StringUtils.isNotBlank(fileName)) {
			response.setContentType("application/octet-stream");
			response
					.setHeader("Content-Disposition",
							"attachment;filename="
									+ new String(fileName.getBytes("GBK"),
											"ISO-8859-1"));
			response.setHeader("Cache-Control",
					"must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setDateHeader("Expires",
					(System.currentTimeMillis() + 100000));

			OutputStream os = null;
			InputStream is = null;
			byte[] buf = new byte[1024];
			int readLen = 0;
			try {
				os = response.getOutputStream();
				is = new BufferedInputStream(new FileInputStream(getFileFullPath(fileNameOnDisk)));
				while ((readLen = is.read(buf, 0, 1024)) != -1) {
					os.write(buf, 0, readLen);

				}
				is.close();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
	 * 获取文件全路径
	 */
	public String getFileFullPath(String fileName) {
		String fullpath = null;
		String app_root = this.getServletContext().getRealPath("/");
		int lastsepindex = app_root.lastIndexOf(File.separator);
		if(lastsepindex==(app_root.length()-1))
		{
			fullpath = app_root.substring(0,lastsepindex);//去掉最右边的目录分隔符
			lastsepindex = fullpath.lastIndexOf(File.separator);//继续寻找最后一个目录分隔符
		}
		fullpath = fullpath.substring(0,lastsepindex);
		
		String fileFullPath = fullpath + File.separator + "cms_file_upload" + File.separator + fileName;
		return fileFullPath;
	}
}