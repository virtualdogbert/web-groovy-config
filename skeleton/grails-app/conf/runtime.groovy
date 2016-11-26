
//move logic to GrailsConfiguration.groovy
this.setProperty("newthing", [testing:[testing1:20]]) //a way for merge into the current config


def catalinaBase = System.properties.getProperty("catalina.base")
def catalinaHome = System.getProperty("catalina.home")
def configLocation = System.properties.getProperty("config.location")

if (!configLocation) {
    configLocation = catalinaBase ? "${catalinaBase}/conf" : null
}
if (configLocation) {
    //TODO add local config user config slurper to parse and then merge
    def configFiles = ["${configLocation}/${appName}-config.groovy", "${configLocation}/${appName}-datasource.groovy"]
    configFiles.each {
        if (new File(it).exists()) {
            if (!grails.config.locations) {
                grails.config.locations = []
            }
            grails.config.locations << "file:${it}"
        }
    }
}


import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

//import org.apache.commons.codec.binary.Base64
//TODO get key from file
    public static String encrypt(String key, String initVector, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"))
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES")

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv)

            byte[] encrypted = cipher.doFinal(value.getBytes())
            System.out.println("encrypted string: " + Base64.encodeBase64String(encrypted))

            return Base64.encodeBase64String(encrypted)
        } catch (Exception ex) {
            ex.printStackTrace()
        }

        return null
    }

    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"))
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES")

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv)

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted))

            return new String(original)
        } catch (Exception ex) {
            ex.printStackTrace()
        }

        return null
    }
