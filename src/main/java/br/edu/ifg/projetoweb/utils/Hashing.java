package br.edu.ifg.projetoweb.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Hashing {
	private final int logRounds;

	public Hashing(int logRounds) {
		this.logRounds = logRounds;
	}

	public String hash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(logRounds));

	}

	public boolean verifyHash(String password, String hash) {
		return BCrypt.checkpw(password, hash);
	}
}
