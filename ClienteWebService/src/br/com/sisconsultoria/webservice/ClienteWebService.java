package br.com.sisconsultoria.webservice;

import java.io.IOException;

import org.apache.hc.client5.http.fluent.Request;


public class ClienteWebService {

	public static void main(String[] args) throws Exception, IOException {
		String content = Request.post("http://localhost:8080/gerenciador/Empresas")
				.addHeader("Accept","application/xml")
				.execute()
				.returnContent()
				.asString();
		
		System.out.println(content);
	}

}
