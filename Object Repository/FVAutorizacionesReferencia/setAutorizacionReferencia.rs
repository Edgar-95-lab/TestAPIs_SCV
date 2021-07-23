<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>setAutorizacionReferencia</name>
   <tag></tag>
   <elementGuidId>4b3dbfa4-06bb-42cf-9378-8be15494b4cc</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;dFechaPago\&quot;: \&quot;2021/02/15\&quot;,\n  \&quot;iClaveBanco\&quot;: 8,\n  \&quot;iClaveTipoDocumento\&quot;: 8,\n  \&quot;iNoOperacionModificacion\&quot;: -1,\n  \&quot;vchAutorizacion\&quot;: \&quot;Motivo Autorización\&quot;,\n  \&quot;vchFolioDocumento\&quot;: \&quot;213S1D23F1S2D1F23SD1F23S1DF3S1D23F1\&quot;,\n  \&quot;vchReferencia\&quot;: \&quot;11125000043729870250\&quot;,\n  \&quot;vchNombre\&quot;: \&quot;MARIANO\&quot;,\n  \&quot;vchPrimerApellido\&quot;: \&quot;MENDEZ\&quot;,\n  \&quot;vchSegundoApellido\&quot;: \&quot;MENDEZ\&quot;       \n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Usuario</name>
      <type>Main</type>
      <value>EPEREYRA</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Password</name>
      <type>Main</type>
      <value>EPEREYRA123</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Oficina</name>
      <type>Main</type>
      <value>0</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Almacen</name>
      <type>Main</type>
      <value>12</value>
   </httpHeaderProperties>
   <katalonVersion>8.0.5</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://localhost:53513/api/FVAutorizacionesReferencia/setAutorizacionReferencia</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
