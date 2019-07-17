package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * TLS Encryptions.
 * Possible values are:
 * 1 - (default) No encryption;
 * 2 - PSK;
 * 4 - certificate.
 *
 * @see <a href="https://www.zabbix.com/documentation/4.0/manual/api/reference/host/object#host">Host object</a>
 * @author Mamadou Lamine NIANG
 **/
public enum TLSEncryption {

    NO_ENCRYPTION(1),
    PSK(2),
    CERTIFICATE(4);

    private int value;

    TLSEncryption(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }

    @JsonCreator
    public static TLSEncryption fromValue(int value) {
        for(TLSEncryption tlsEncryption: values()) {
            if(tlsEncryption.value == value) {
                return tlsEncryption;
            }
        }
        return NO_ENCRYPTION;
    }
}
