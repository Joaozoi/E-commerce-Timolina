package br.sp.senac.service;

import java.sql.SQLException;

import br.sp.senac.dao.ClienteDAO;
import br.sp.senac.model.Cliente;
import br.sp.senac.util.PasswordUtil;

public class ClienteService {

    private ClienteDAO clienteDAO;

    public ClienteService() throws SQLException {
        this.clienteDAO = new ClienteDAO();
    }

    public String registrarCliente(String email, String senha, String nome, String endereco) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty() || nome == null || nome.isEmpty() || endereco == null || endereco.isEmpty()) {
            return "Todos os campos são obrigatórios.";
        }

       
        if (clienteDAO.verificarEmailExistente(email)) {
            return "E-mail já cadastrado. Tente um diferente.";
        } else {
           
            Cliente novoCliente = new Cliente(email, senha, nome, endereco);
            if (clienteDAO.salvar(novoCliente)) {
                return "Conta criada com sucesso!";
            } else {
                return "Erro ao criar a conta. Tente novamente.";
            }
        }
    }

    public boolean autenticarCliente(String email, String senha) {
     
     
        Cliente cliente = clienteDAO.buscarPorEmail(email);

        
        if (cliente != null && PasswordUtil.verificarSenha(senha, cliente.getSenha())) {
            return true;  
        } else {
            return false;  
        }
    }
}
