package tds.router.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "tds-router")
public class TdsRouterProperties {

    public static class Saml {

        /**
         * The full file path to the Java KeyStore (JKS) file.
         */
        private String keyStoreFile;

        /**
         * Password for the JKS File.
         */
        private String keyStorePassword;

        /**
         * Private key alias in JKS used for SAML signing.
         */
        private String privateKeyEntryAlias;
        /**
         * Private kel alias password. May be same as JKS file password.
         */
        private String privateKeyEntryPassword;
        /**
         * Identity provider metadata URL.
         */
        private String idpMetadataUrl;

        /**
         * Service Provider entity id as registered in the IDP circle of trust.
         */
        private String spEntityId;

        // Get Set


        public String getIdpMetadataUrl() {
            return idpMetadataUrl;
        }

        public void setIdpMetadataUrl(String idpMetadataUrl) {
            this.idpMetadataUrl = idpMetadataUrl;
        }

        public String getKeyStoreFile() {
            return keyStoreFile;
        }

        public void setKeyStoreFile(String keyStoreFile) {
            this.keyStoreFile = keyStoreFile;
        }

        public String getKeyStorePassword() {
            return keyStorePassword;
        }

        public void setKeyStorePassword(String keyStorePassword) {
            this.keyStorePassword = keyStorePassword;
        }

        public String getPrivateKeyEntryAlias() {
            return privateKeyEntryAlias;
        }

        public void setPrivateKeyEntryAlias(String privateKeyEntryAlias) {
            this.privateKeyEntryAlias = privateKeyEntryAlias;
        }

        public String getPrivateKeyEntryPassword() {
            return privateKeyEntryPassword;
        }

        public void setPrivateKeyEntryPassword(String privateKeyEntryPassword) {
            this.privateKeyEntryPassword = privateKeyEntryPassword;
        }

        public String getSpEntityId() {
            return spEntityId;
        }

        public void setSpEntityId(String spEntityId) {
            this.spEntityId = spEntityId;
        }

        @Override
        public String toString() {
            return "Saml{" +
                    "idpMetadataUrl='" + idpMetadataUrl + '\'' +
                    ", keyStoreFile='" + keyStoreFile + '\'' +
                    ", keyStorePassword='" + keyStorePassword + '\'' +
                    ", privateKeyEntryAlias='" + privateKeyEntryAlias + '\'' +
                    ", privateKeyEntryPassword='" + privateKeyEntryPassword + '\'' +
                    ", spEntityId='" + spEntityId + '\'' +
                    '}';
        }
    }

    //@NotBlank

    //@NotNull
    private Saml saml;
    private String rulesFile;


    public String getRulesFile() {
        return rulesFile;
    }

    public void setRulesFile(String rulesFile) {
        this.rulesFile = rulesFile;
    }

    public Saml getSaml() {
        return saml;
    }

    public void setSaml(Saml saml) {
        this.saml = saml;
    }

    @Override
    public String toString() {
        return "TdsRouterProperties{" +
                "rulesFile='" + rulesFile + '\'' +
                ", saml=" + saml +
                '}';
    }
}