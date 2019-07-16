package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
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
