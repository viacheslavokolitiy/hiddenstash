package org.satorysoft.todomvvm.ui.misc

import java.nio.charset.Charset
import java.security.MessageDigest

/**
 * Created by viacheslavokolitiy on 24.09.2016.
 */
class HashCreator {

    fun createSHA256Hash(userData: String) : String{
        val messageDigest = MessageDigest.getInstance("SHA-256")
        messageDigest.update(userData.toByteArray(Charset.forName("UTF-8")))

        val digest = messageDigest.digest()

        return String.format("%064x", java.math.BigInteger(1, digest))
    }
}