package benchmark.tests;

import benchmark.Benchmark;
import score.Score;
import timing.Timer;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class AESEncryption implements Benchmark {

    private long benchPoints;
    private String stringToEncrypt;
    private String keyString;

    /**
     * The constructor
     *
     * @param benchPoints the score divisor
     */
    public AESEncryption(long benchPoints, String stringToEncrypt, String keyString) {
        this.benchPoints = benchPoints;
        this.stringToEncrypt = stringToEncrypt;
        this.keyString = keyString;
    }

    /**
     * Get the name of this test
     * @return the name of the test
     */
    @Override
    public String getName() {
        return "AES Encryption";
    }

    /**
     * Encrypt the string
     *
     * @throws NoSuchAlgorithmException  if SHA-1 doesn't exist
     * @throws NoSuchPaddingException    if PKCS5 Padding doesn't exist
     * @throws InvalidKeyException       if the key is invalid
     * @throws BadPaddingException       if the padding isn't good
     * @throws IllegalBlockSizeException if you need to go to prison for block size
     */
    private void encryptString() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        String encrypted;
        byte[] key;

        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        key = keyString.getBytes(StandardCharsets.UTF_8);
        key = digest.digest(key);
        key = Arrays.copyOf(key, 16);
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        encrypted = Base64.getEncoder().encodeToString(cipher.doFinal(stringToEncrypt.getBytes(StandardCharsets.UTF_8)));

    }

    /**
     * Starts the benchmark
     * @return the score of that test
     */
    @Override
    public long runTest() {
        Timer.startTiming();
        try {
            encryptString();
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return (long) (benchPoints / Timer.endTiming());
    }

    /**
     * Store the score in the Score buffer class
     * @param score the score to set
     */
    @Override
    public void setScore(long score) {
        Score.addToScores(getName(), score);
    }
}
