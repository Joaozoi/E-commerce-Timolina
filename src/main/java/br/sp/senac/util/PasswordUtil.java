package br.sp.senac.util;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
	public static String criptografarSenha(String senha) {
		return BCrypt.hashpw(senha, BCrypt.gensalt());
	}
	  public static boolean verificarSenha(String senha, String hashArmazenado) {
	        return BCrypt.checkpw(senha, hashArmazenado);
	    }

}


