package com.modest.web.filter;

import com.modest.constant.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * description
 *
 * @author modest
 * @date 2019/07/30
 */
//@WebServlet("/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //1.强转
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;

        //2.放行
        chain.doFilter(new MyRequest(request), response);
    }

    @Override
    public void destroy() {

    }


    class MyRequest extends HttpServletRequestWrapper{

        private HttpServletRequest request;
        private boolean flag = true;

        public MyRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }


        @Override
        public String getParameter(String name) {
            if (name == null || name.trim().length() == 0) {
                return null;
            }

            String[] values = getParameterValues(name);

            if (values == null || values.length == 0) {
                return null;
            }

            return values[0];
        }


        @Override
        public String[] getParameterValues(String name) {
            if (name == null || name.trim().length() == 0) {
                return null;
            }

            Map<String, String[]> map = getParameterMap();

            if (map == null || map.size() == 0) {
                return null;
            }

            return map.get(name);
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            String method = request.getMethod();
            if( Constant.ENCODING_PARAM_POST.equalsIgnoreCase(method)) {
                try{
                    request.setCharacterEncoding("utf-8");
                    return request.getParameterMap();
                }catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else if (Constant.ENCODING_PARAM_GET.equalsIgnoreCase(method)){
                Map<String, String[]> map = request.getParameterMap();
                if(flag) {
                    for (String key : map.keySet()) {
                        String[] arr = map.get(key);
                        for (int i = 0; i < arr.length; i++) {
                            try {
                                arr[i] = new String(arr[i].getBytes("iso8859-1"), "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    flag = false;
                }
                return map;
            }
            return super.getParameterMap();
        }

    }
}
