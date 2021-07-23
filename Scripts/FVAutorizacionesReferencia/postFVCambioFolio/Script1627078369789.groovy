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

response = WS.sendRequest(findTestObject('FVAutorizacionesReferencia/postFVCambioFolio'))

/**
 * Evaluación para códigos de estado de respuesta HTTP
 * */
if (WS.getResponseStatusCode(response) == 200) {
	/**
	 * Evaluar la respuesta booleana de acuerdo al estado de consulta
	 * */
	if (WS.getElementPropertyValue(response, 'bResultado') == true) {
		
		
	} else {
		/**
		 * Condición para verificar la asignación correcta de un mensaje.
		 * */
		if(WS.getElementPropertyValue(response, 'vchMensaje').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'vchMensaje', 'No existe mensaje asignado')
			
		}
		
		/**
		 * Verificar la asignación de código de error
		 * */
		if(WS.getElementPropertyValue(response, 'iError') <= 0)
		{
			WS.verifyElementPropertyValue(response, 'iError', 'No existe código de error asignado')
			
		}

			
	}
} else if (WS.getResponseStatusCode(response) == 401) {
	println('Acceso no autorizado')
} else {
	WS.verifyResponseStatusCode(response, 'Nuevo error encontrado')
}