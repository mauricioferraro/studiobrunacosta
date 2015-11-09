package teste;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Produto.Produto;

import bruna.Util.HibernateUtil;

public class ProdutoTeste {
	private Session Sessao;
	private Transaction transacao;
	

		public void abreConexao(){
			
			this.Sessao = HibernateUtil.getSession().getCurrentSession();
			this.transacao = this.Sessao.beginTransaction();
		
		
	}
		
		public void fechaConexao(){
			this.transacao.commit();
			try {
				if(this.Sessao.isOpen()){
					this.Sessao.close();
				}
					
				
			} catch (Exception e) {
				System.out.println("deu problema para fehar conexao"+ e.getMessage());
			}
			
		}
		
		@Test
		public void salvarProdutoTeste(){
			
			Produto p = new Produto();
			
			p.setDescricao("Produto Teste");
			p.setDataCadastro(new Date());
			p.setEstoque(20);
			p.setUnidade("quilo");
			p.setValor(10.90f);
			
			abreConexao();
			this.Sessao.save(p);
			fechaConexao();
			
			assertNull(null);
		}

}
