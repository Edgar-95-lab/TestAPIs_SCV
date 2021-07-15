import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

int operation = 21021011

int valor = 0

response = WS.sendRequest(findTestObject('FVAutorizacionesReferencia/getConsultaReferenciaAut'))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'bResultado', true)

WS.verifyElementPropertyValue(response, 'dFechaEmision', '2021-07-09T00:00:00')

WS.verifyElementPropertyValue(response, 'dFechaVigencia', '2021-07-09T00:00:00')

WS.verifyElementPropertyValue(response, 'iError', 0)

for (int i = operation; i <= WS.getElementPropertyValue(response, 'iNoOperacionModificacion'); i++) {
    valor = i
}

WS.verifyElementPropertyValue(response, 'iNoOperacionModificacion', valor)

WS.verifyElementPropertyValue(response, 'mTotalReferencia', 1659.0000)

WS.verifyElementPropertyValue(response, 'tiBandera', 3)

WS.verifyElementPropertyValue(response, 'tiEstatusAutorizacion', 0)

WS.verifyElementPropertyValue(response, 'tiEstatusReferencia', 1)

WS.verifyElementPropertyValue(response, 'vchDescEstatusRef', 'EMITIDO')

WS.verifyElementPropertyValue(response, 'vchDescEtatusAut', 'NO AUTORIZADA')

WS.verifyElementPropertyValue(response, 'vchMensaje', 'Los datos se consultaron exitosamente')

WS.verifyElementPropertyValue(response, 'vchMensajeLog', '')

WS.verifyElementPropertyValue(response, 'vchNombre', 'SANTOS CAZARIN CRUZ DAVID ESTUARDO')

WS.verifyElementPropertyValue(response, 'vchReferencia', '11125120071631703225')



