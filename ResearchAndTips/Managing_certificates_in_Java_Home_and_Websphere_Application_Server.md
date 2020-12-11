Importing the certificate :  
This is much easier to do in windows. We can use a browser to import it and save it to a folder like Desktop.



Assume that you are trying to reach https://abc.def.com/someContent/



1) Execute this on your console:

openssl s_client -connect abc.def.com:443



(windows users can use FireFox to see the certificate and export it instead of step1 and step2)



2)Copy the certificate information and save it to a file like abc.pem. The part your are going to copy will look like this:



-----BEGIN CERTIFICATE-----

MssJjDC8sjshHN7hhshsGGGSGSVfstsg9w0BAQUFADCBizELMAkGA1UEBhMCQkUx

EDAOBgNVBAgTB0JlbGdpdW0xETAPBgNVBAcTCFphdmVudGVtMSQwIgYDVQQKExtT

b2334GUtU29sdXRpb25zIEV1cm9wZSBCLlYxDDAKBgNVBAsTA0lTRTEjMCEGA1UE

AxMaZXNwLnN0Zy5zcC5zb255LWV1cm9wZS5jb20wHhcNMTAwNTE5MDgxNjU3WhcN

MjAwNTE2MDgxNjU3WjCBizELMAkGA1UEBhMCQkUxEDAOBgNVBAgTB0JlbGdpdW0x

ETAPBgNVBAcTCFphdmVudGVtMSQwIgYDVQQKExtTb255IGUtU29sdXRpb25zIEV1

cm9wZSBCLlYxDDAKBgNVBAsTA0lTRTEjMCEGA1UEAxMaZXNwLnN0Zy5zcC5zb255

LWV1cm9wZS5jb20wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAMt0TExB8o6g

OkikMgabQT/wI6N21BXbmP5JTRcs7tSknwxnneCl0Nc8LoEQ2pib5BLpyzQLg5Gg

kJdnskMQBJ35SMo8OiThRmuwOYb1rk/dFP8j924HUTbFaT6b8rJALYG2ljY62fj0

b+BTlzbZb+cl5sRBSIgX+Hzx9NTD64EZAgMBAAEwDQYJKoZIhvcNAQEFBQADgYEA

bkTufSkz8BO1O9q37lGkwM8Vv/dAJ8bMeYUkLNW3n34frJ72Y26Vme9iVPl7kvdK

dYdkZ8iIQIiNQUasOfwhyOPcakvz2mx60vxFz4bykhzYAwAvM80d+2XC9xqWYf3A

Jgdhdg6hhdhlfeBSh9ih3JRNlYDub+IDbrgYPsDB2uA=

-----END CERTIFICATE-----



(You should include BEGIN CERTIFICATE and END CERTIFICATE lines too)



(Windows users, can export the file with firefox; just goto website and click on certificate at bottom right; choose details; and then export)





Adding it to the server :
First, navigate to D:\dev\eclipse\java_1.7_64\jre\bin...





To list all the certificates or to get the count, use this command : 


keytool.exe -list -keystore D:\dev\eclipse\java_1.7_64\jre\lib\security\cacerts -storepass changeit

(an easier way to see them is to copy them into Notepad++)



If there is a certificate that you want to delete, find out the alias name for it and use the command below.





Use this command to import a certificate from the desktop on to the server..


keytool.exe -importcert -alias dev-d-pi-quote-exchange -file C:\Users\n0281526\Desktop\dev-d-cert.cer -trustcacerts -keystore D:\dev\eclipse\java_1.7_64\jre\lib\security\cacerts

keytool.exe -importcert -alias dev-d-autopolicy-pmwps -file C:\Users\n0281526\Desktop\dev-d-autopolicy-pmwps.libertyec.com -trustcacerts -keystore D:\dev\eclipse\java_1.7_64\jre\lib\security\cacerts -storepass changeit

keytool.exe -importcert -alias dev-d-utility-dataservices -file C:\Users\n0281526\Desktop\dev-d-utility-dataservices.libertyec.com -trustcacerts -keystore D:\dev\eclipse\java_1.7_64\jre\lib\security\cacerts -storepass changeit





To delete a certificate from the server:


keytool -delete -alias dev-d-utility-dataservices -keystore D:\dev\eclipse\java_1.7_64\jre\lib\security\cacerts -storepass changeit





======================================



%JAVA_HOME%\jre\bin\keytool -import -keystore cacerts -trustcacerts -file C:\Users\Downloads\Certs\Dummy_CertGlobalCAG2.cer -storepass changeit -alias Dummy_CertGlobalCAG2

%JAVA_HOME%\jre\bin\keytool -import -keystore cacerts -trustcacerts -file C:\Users\Downloads\Certs\Dummy_CertGlobalRootCA.cer -storepass changeit -alias Dummy_CertGlobalRootCA

%JAVA_HOME%\jre\bin\keytool -import -keystore cacerts -trustcacerts -file C:\Users\Downloads\Certs\Dummy_CertSHA2SecureServerCA.cer -storepass changeit -alias Dummy_CertSHA2SecureServerCA

%JAVA_HOME%\jre\bin\keytool -import -keystore cacerts -trustcacerts -file C:\Users\Downloads\Certs\Dummy_CertGlobalRootG2.cer -storepass changeit -alias Dummy_CertGlobalRootG2  
