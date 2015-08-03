package jp.co.smart.app.view;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.terasoluna.gfw.web.download.AbstractFileDownloadView;

@Component
public class TextFileDownloadView extends AbstractFileDownloadView {

   @Override
   protected InputStream getInputStream(Map<String, Object> model,
           HttpServletRequest request) throws IOException {
       Resource resource = new ClassPathResource("abc.txt");
       return resource.getInputStream();
   }

   @Override
   protected void addResponseHeader(Map<String, Object> model,
           HttpServletRequest request, HttpServletResponse response) {
       response.setHeader("Content-Disposition",
               "attachment; filename=abc.txt");
       response.setContentType("text/plain");

   }
}