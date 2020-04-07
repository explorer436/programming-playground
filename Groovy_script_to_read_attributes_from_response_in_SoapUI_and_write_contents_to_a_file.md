```
import com.eviware.soapui.support.XmlHolder

def response = testRunner.testCase.testSteps["TestRequest"].testRequest.response.getRequest().getResponseContentAsXml()

def responseAsXml = new XmlHolder( response )


responseAsXml.declareNamespace( 'ns2', 'http://abcd.com/test/xyz/service/specificservice/v1_0')


def RqUID = responseAsXml.getNodeValue("//ns2:getResponse/response/RqUID")

log.info("RqUID [" + RqUID + "]")



def payload = responseAsXml.getNodeValue("//ns2:getResponse/response/Payload")

log.info("payl [" + payload + "]")



def responseFile = new PrintWriter ("C:\\Users\\explorer\\Downloads\\folder\\" + RqUID + ".txt")



responseFile.println(payload)

responseFile.flush()

responseFile.close()
```