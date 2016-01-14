package cc.cynara.bookstore.web.coltroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.activation.FileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sun.misc.BASE64Encoder;

import cc.cynara.bookstore.domain.Book;
import cc.cynara.bookstore.domain.Category;
import cc.cynara.bookstore.domain.Orders;
import cc.cynara.bookstore.domain.Page;
import cc.cynara.bookstore.service.BusnessService;
import cc.cynara.bookstore.service.impl.BusnessServiceImpl;
import cc.cynara.bookstore.util.FormUtils;
import cc.cynara.bookstore.web.formbean.CategoryFormBean;
//操作后台
public class ManagerServlet extends HttpServlet {
	private BusnessService s = new BusnessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if("addCategory".equals(operation)){
			addCategory(request,response);
		}
		if("listAllCategory".equals(operation)){
			listAllCategory(request,response);
		}
		if("delCategory".equals(operation)){
			delCategory(request,response);
		}
		if("showCategoryUI".equals(operation)){
			showCategoryUI(request,response);
		}
		if("addBook".equals(operation)){
			addBook(request,response);
		}
		if("listAllBook".equals(operation)){
			listAllBook(request,response);
		}
		if("showOrdes0".equals(operation)){
			showOrdes0(request,response);
		}
		if("updateOrder".equals(operation)){
			updateOrder(request,response);
		}
		if("showOrdes1".equals(operation)){
			showOrdes1(request,response);
		}
		if("detailedOrder".equals(operation)){
			detailedOrder(request,response);
		}
	}
	//查询已发货订单的详细信息
	private void detailedOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		Orders orders =  s.findORdersById(orderId);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/manager/detailedOrder.jsp").forward(request, response);
	}
	//查询已发货的所有订单
	private void showOrdes1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Orders> orders = s.findOrdersByState(1);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/manager/showDeliverOrders.jsp").forward(request, response);
	}
	//将订单标记为已发货
	private void updateOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		s.updateOrder(orderId);
		showOrdes0(request, response);
	}
	//查询所有未发货订单
	private void showOrdes0(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Orders> orders = s.findOrdersByState(0);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/manager/showOrders.jsp").forward(request, response);
	}
	//查看所有图书 并分页
	private void listAllBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		List<Book> books = s.findAllBook();
//		request.setAttribute("books", books);
//		request.getRequestDispatcher("/manager/listBook.jsp").forward(request, response);
		String pagenum = request.getParameter("pagenum");
		Page page = s.findPageRecords(pagenum);
		page.setUrl("/servlet/ManagerServlet?operation=listAllBook");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/manager/listBook.jsp").forward(request, response);
	}
	//添加图书  和图片上传
	private void addBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("/files");
		try {
			Book book = new Book();
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			//解析请求
			List<FileItem> iteams = upload.parseRequest(request);
			for (FileItem fileItem : iteams) {
				if(fileItem.isFormField()){
					//封装数据到javaben中
					String fileName = fileItem.getFieldName();//字段名
					String value = fileItem.getString(request.getCharacterEncoding());
					BeanUtils.setProperty(book, fileName, value);
				}else{
					//图片上传
					InputStream in  = fileItem.getInputStream();
					String fileName = fileItem.getName();
					fileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("\\")+1);
					book.setImage(fileName);
					OutputStream out = new FileOutputStream(path+"\\"+fileName);
					byte[] b = new byte[1024];
					int len = -1;
					while((len = in.read(b))!=-1){
						out.write(b, 0, len);
					}
					out.close();
					in.close();
					fileItem.delete();
				}
			}
			s.addBook(book);
			List<Book> books = s.findAllBook();
			request.setAttribute("books", books);
			request.setAttribute("message", "<script type='text/javascript'>alert('添加成功')</script>");
			request.getRequestDispatcher("/manager/addBook.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			showCategoryUI(request, response);
		}
	}
	//显示图书的分类信息
	private void showCategoryUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> cs = s.findAllCategory();
		request.setAttribute("cs", cs);
		request.getRequestDispatcher("/manager/addBook.jsp").forward(request, response);
	}
	//删除分类
	private void delCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		s.delCategory(id);
		listAllCategory(request, response);
	}
	//显示所有分类
	private void listAllCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> cs = s.findAllCategory();
		request.setAttribute("cs", cs);
		request.getRequestDispatcher("/manager/listCartgory.jsp").forward(request, response);
//		String pagenum = request.getParameter("pagenum");
//		Page page = s.findPageRecords(pagenum);
//		page.setUrl("/servlet/ManagerServlet?operation=listAllBook");
//		request.setAttribute("page", page);
//		request.getRequestDispatcher("/manager/listBook.jsp").forward(request, response);
	}
	//添加分类
	private void addCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Category c = FormUtils.fillBean(Category.class, request);
		request.setAttribute("category", c);
		CategoryFormBean formBean = FormUtils.fillBean(CategoryFormBean.class, request);
		if(!formBean.invated()){
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/manager/addCategory.jsp").forward(request, response);
		}else{
			s.addCategory(c);
			listAllCategory(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
