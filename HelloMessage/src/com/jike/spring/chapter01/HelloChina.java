/**
 * 
 */
package com.jike.spring.chapter01;

/**
 * @author liukaibo
 *
 */
public class HelloChina implements IHelloMessage {

	/* (non-Javadoc)
	 * @see com.jike.spring.chapter01.IHelloMessage#sayHello()
	 */
	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "大家好";
	}
}