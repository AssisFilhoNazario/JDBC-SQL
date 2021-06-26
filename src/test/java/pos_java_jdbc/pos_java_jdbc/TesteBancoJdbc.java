package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SigleConnection;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		// como fosse o controller
		Userposjava userposjava = new Userposjava();
		UserPosDAO userPosDAO = new UserPosDAO();

		userposjava.setNome("Assis Nario Filho");
		userposjava.setEmail("assisnazario@gmail.com");

		userPosDAO.salvar(userposjava);
	}

	@Test
	public void initLista() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> lista = dao.lista();

			for (Userposjava userposjava : lista) {
				System.out.println(userposjava);
				System.out.println("-------------------");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void initBusca() {
		UserPosDAO dao = new UserPosDAO();

		try {

			Userposjava userposjava = dao.buscar(4L);

			System.out.println(userposjava);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void initAtualizar() {

		try {

			UserPosDAO dao = new UserPosDAO();

			Userposjava obejtoBanco = dao.buscar(4L);

			obejtoBanco.setNome("Adna Karine");

			dao.atualizar(obejtoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();

			dao.deletar(6L);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(88-9458-5598)");
		telefone.setTipo("celular");
		telefone.setUsuario(8L);

		UserPosDAO userPosDAO = new UserPosDAO();

		userPosDAO.salvarTelefone(telefone);
	}

	@Test
	public void testCarregaUserFone() {

		UserPosDAO dao = new UserPosDAO();
		List<BeanUserFone> beanUserFones = dao.listaUserFones(8L);

		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);

		}
	}
	@Test
	public void deleteUserFone() {
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonePorUser(9L);
	}

}
