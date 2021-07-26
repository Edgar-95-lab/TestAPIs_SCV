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

response = WS.sendRequest(findTestObject('FVAutorizacionesReferencia/PostEntregaFVValidacionUsuario'))

/**
 * Evaluación para códigos de estado de respuesta HTTP
 * */
if (WS.getResponseStatusCode(response) == 200) {
	/**
	 * Evaluar la respuesta booleana de acuerdo al estado de consulta
	 * */
	if (WS.getElementPropertyValue(response, 'bResultado') == true) {
		/**
		 * Verificar la existencia de mensaje
		 * */
		if(WS.getElementPropertyValue(response, 'vchMensaje').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'vchMensaje', 'No se muestra mensaje')
		}
		/**
		 * Verificar que el código de error se encuentre en 0
		 * */
		WS.verifyElementPropertyValue(response, 'iError', 0)
		/**
		 * Verificar la relación de usuario e id
		 * */
		if(WS.getElementPropertyValue(response, 'iIdUsuario') <= 0 || WS.getElementPropertyValue(response, 'vchUsuario').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'iIdUsuario', 'verificar el id asignado')
			WS.verifyElementPropertyValue(response, 'vchUsuario', 'Falta mostrar el nombre')
		}
		/**
		 * Verificar la relación de oficina y des_oficina
		 * */
		if(WS.getElementPropertyValue(response, 'cve_oficina') < 0 || WS.getElementPropertyValue(response, 'vchDesc_Oficina').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'cve_oficina', 'verificar el id asignado')
			WS.verifyElementPropertyValue(response, 'vchDesc_Oficina', 'Falta mostrar la oficina correspondiente')
		}
		/**
		 * Verificar el nombre de usuario
		 * */
		if(WS.getElementPropertyValue(response, 'vchNombreUsuario').toString().equals(''))
		{
			WS.verifyElementPropertyValue(response, 'vchNombreUsuario', 'No se muestra nombre')
		}
		/**
		 * Verificar la asignación del id
		 * */
		if(WS.getElementPropertyValue(response, 'iIdPersona') <= 0)
		{
			WS.verifyElementPropertyValue(response, 'iIdPersona', 'No se muestra el id asignado')
		}
		
		
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