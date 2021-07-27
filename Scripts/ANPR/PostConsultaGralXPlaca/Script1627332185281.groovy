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

response = WS.sendRequest(findTestObject('ANPR/PostConsultaGralXPlaca'))

/**
 * Evaluación para códigos de estado de respuesta HTTP
 * */
if (WS.verifyResponseStatusCodeInRange(response, 200, 204) == true) {
    /**
	 * Evaluar la respuesta booleana de acuerdo al estado de consulta
	 * */
    if (WS.getElementPropertyValue(response, 'bResultado') == true) {
        /**
		 * Verificar la existencia de mensaje
		 * */
        if (WS.getElementPropertyValue(response, 'vchMensaje').toString().equals('')) {
            WS.verifyElementPropertyValue(response, 'vchMensaje', 'No se muestra mensaje')
        }
        
        /**
		 * Verificar que el código de error se encuentre en 0
		 * */
        WS.verifyElementPropertyValue(response, 'iError', 0)

        /**
		 * Verificar el vchTipo
		 * */
        if (WS.getElementPropertyValue(response, 'vchTipo').toString().equals('')) {
            WS.verifyElementPropertyValue(response, 'vchTipo', '')
        }
        
        /**
			 * Verificar el vchTipo
			 * */
        if (WS.getElementPropertyValue(response, 'vchTipo').toString().equals('')) {
            WS.verifyElementPropertyValue(response, 'vchTipo', 'No se muestra vchTipo')
        }
        
        /**
		 * Verificar que el vehículo tenga asignado su modelo
		 * */
        if (WS.getElementPropertyValue(response, 'smModeloVehicular') < 1950) {
            WS.verifyElementPropertyValue(response, 'smModeloVehicular', 'Modelo vehicular no mostrado')
        }
        
        /**
		 * Verificar el registro correcto del motor
		 * */
        if (WS.getElementPropertyValue(response, 'vchNoMotor').toString().equals('') || !((WS.getElementPropertyValue(response, 
            'vchNoMotor').toString().trim().length() >= 11) && (WS.getElementPropertyValue(response, 
            'vchNoMotor').toString().trim().length() <= 17))) {
            WS.verifyElementPropertyValue(response, 'vchNoMotor', 'longitud en el número de motor incorrecta')
        }
        
        /**
	     * Verificar el registro correcto del motor
	     * */
        if (WS.getElementPropertyValue(response, 'NIV').toString().equals('') || (WS.getElementPropertyValue(response, 'NIV').toString().trim().length() != 
        17)) {
            WS.verifyElementPropertyValue(response, 'NIV', 'Valor incorrecto en NIV')
        }
		/**
		 * Verificar El nombre completo del propietario del vehículo
		 * */
		if (WS.getElementPropertyValue(response, 'vchNombrePropietario').toString().equals('')) {
		WS.verifyElementPropertyValue(response, 'vchNombrePropietario', 'No se muestra el nombre del propietario')
		}
		
		if (WS.getElementPropertyValue(response, 'vchApellidoPaterno').toString().equals('')) {
			WS.verifyElementPropertyValue(response, 'vchApellidoPaterno', 'Verificar apellido paterno')
		}
		
		if (WS.getElementPropertyValue(response, 'vchApellidoMaterno').toString().equals('')) {
			WS.verifyElementPropertyValue(response, 'vchApellidoMaterno', 'Verificar apellido materno')
		}
		
		/**
		 * Verificar el estatus
		 * */
		if (WS.getElementPropertyValue(response, 'vchEstatus').toString().equals('')) {
			WS.verifyElementPropertyValue(response, 'No se muestra ningún estatus')
		}
		
    } else {
        if (WS.getElementPropertyValue(response, 'vchMensaje').toString().equals('')) {
            WS.verifyElementPropertyValue(response, 'vchMensaje', 'No existe mensaje asignado')
        }
        
        if (WS.getElementPropertyValue(response, 'iError') <= 0) {
            WS.verifyElementPropertyValue(response, 'iError', 'No existe código de error asignado')
        }
    }
} else {
    WS.verifyResponseStatusCode(response, 'Error en la petición, verifique el número correspondiente')
}