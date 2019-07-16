package io.github.mlniang.zabbix.client.model.host;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.util.StringUtils;

/**
 * @author Mamadou Lamine NIANG
 **/
public enum HostInventoryProperty {

    ALIAS(4),
    ASSET_TAG(11),
    CHASSIS(28),
    CONTACT(23),
    CONTRACT_NUMBER(32),
    DATE_HW_DECOMM(47),
    DATE_HW_EXPIRY(46),
    DATE_HW_INSTALL(45),
    DATE_HW_PURCHASE(44),
    DEPLOYMENT_STATUS(34),
    HARDWARE(14),
    HARDWARE_FULL(15),
    HOST_NETMASK(39),
    HOST_NETWORKS(38),
    HOST_ROUTER(40),
    HW_ARCH(30),
    INSTALLER_NAME(33),
    LOCATION(24),
    LOCATION_LAT(25),
    LOCATION_LON(26),
    MACADDRESS_A(12),
    MACADDRESS_B(13),
    MODEL(29),
    NAME(3),
    NOTES(27),
    OOB_IP(41),
    OOB_NETMASK(42),
    OOB_ROUTER(43),
    OS(5),
    OS_FULL(6),
    OS_SHORT(7),
    POC_1_CELL(61),
    POC_1_EMAIL(58),
    POC_1_NAME(57),
    POC_1_NOTES(63),
    POC_1_PHONE_A(59),
    POC_1_PHONE_B(60),
    POC_1_SCREEN(62),
    POC_2_CELL(68),
    POC_2_EMAIL(65),
    POC_2_NAME(64),
    POC_2_NOTES(70),
    POC_2_PHONE_A(66),
    POC_2_PHONE_B(67),
    POC_2_SCREEN(69),
    SERIALNO_A(8),
    SERIALNO_B(9),
    SITE_ADDRESS_A(48),
    SITE_ADDRESS_B(49),
    SITE_ADDRESS_C(50),
    SITE_CITY(51),
    SITE_COUNTRY(53),
    SITE_NOTES(56),
    SITE_RACK(55),
    SITE_STATE(52),
    SITE_ZIP(54),
    SOFTWARE(16),
    SOFTWARE_APP_A(18),
    SOFTWARE_APP_B(19),
    SOFTWARE_APP_C(20),
    SOFTWARE_APP_D(21),
    SOFTWARE_APP_E(22),
    SOFTWARE_FULL(17),
    TAG(10),
    TYPE(1),
    TYPE_FULL(2),
    URL_A(35),
    URL_B(36),
    URL_C(37),
    VENDOR(31);

    private int id;

    HostInventoryProperty(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @JsonValue
    @Override
    public String toString() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static HostInventoryProperty fromName(String name) {
        if(StringUtils.isEmpty(name)) {
            return null;
        }
        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @JsonCreator
    public static HostInventoryProperty fromId(int id) {
        for(HostInventoryProperty property: values()) {
            if(property.id == id) {
                return property;
            }
        }
        return null;
    }
}
