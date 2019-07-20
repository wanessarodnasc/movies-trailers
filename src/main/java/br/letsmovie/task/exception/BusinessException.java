package br.letsmovie.task.exception;

/**
* 
* @author Wanessa Nascimento
*
*/

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessException(String messageError){
        super(messageError);
    }
}
