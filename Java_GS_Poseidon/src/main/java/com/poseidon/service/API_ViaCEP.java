package com.poseidon.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.poseidon.model.Endereco;

public class API_ViaCEP {
	
	
	public String getEndereco(String Cep) throws Exception {
		Endereco endereco = null;
		
		HttpGet request = new HttpGet("https://viacep.com.br/ws/"+Cep+"/json/");
		try (CloseableHttpClient httpClient = 
				HttpClientBuilder.create().disableRedirectHandling().build();
				CloseableHttpResponse response = httpClient.execute(request)){
			
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				Gson gson = new Gson();
				endereco = gson.fromJson(result, Endereco.class);
			}
			
			System.out.println("API Connection: Success");
			return endereco.toString();
			
		} catch (Exception e) {
			throw new Exception("Erro while accessing viaCEP API" + e.getMessage(), e);
		}
		
	}

}
