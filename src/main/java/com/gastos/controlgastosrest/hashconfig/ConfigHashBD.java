package com.gastos.controlgastosrest.hashconfig;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

public class ConfigHashBD {
    private ConfigHashBD(){
    }

    private static final String ALGORITMO = "PBKDF2WithHmacSHA256";
    private static final int ITERACIONES = 120_000;
    private static final int TAMANIO_SAL = 256;

    public static byte[] generarSalt(){
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    public static byte[] hashContrasenia(char[] contrasenia, byte[] salt)throws Exception{
        PBEKeySpec spec = new PBEKeySpec(contrasenia, salt, ITERACIONES, TAMANIO_SAL);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITMO);
        byte[] hash = skf.generateSecret(spec).getEncoded();


        Arrays.fill(contrasenia, '\u0000');
        return hash;
    }

    public static boolean verificarContrasenia(char[] contrasenia, byte[] salt, byte[] hashEsperado) throws Exception{
        byte[] hashCalculado = hashContrasenia(contrasenia, salt);

        boolean ok = MessageDigest.isEqual(hashCalculado, hashEsperado);

        Arrays.fill(hashCalculado, (byte) 0);
        Arrays.fill(contrasenia, '\u0000');
        return ok;
    }

    public static String toBase64(byte[] data){
        return Base64.encodeBase64String(data);
    }

    public static byte[] fromBase64(String data) {
        return Base64.decodeBase64(data);
    }
}
