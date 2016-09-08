package es.bootools.touchbar.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Service enables the class to be used as a Spring service
 * @Transactional enables transaction support for this class
 */
@Service("springService")
@Transactional
public class ArithmeticService {

	protected static Logger logger = Logger.getLogger("service");

	/**
	 * Adds two numbers
	 */
	public Integer add(Integer operand1, Integer operand2) {

		// A simple arithmetic addition
		return operand1 + operand2;
	}

}
