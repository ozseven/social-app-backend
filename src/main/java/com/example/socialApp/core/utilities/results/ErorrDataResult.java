package com.example.socialApp.core.utilities.results;

public class ErorrDataResult<T> extends DataResult<T> {
	public ErorrDataResult(T data, String message) {
		super(data,false, message);
	}
	public ErorrDataResult(T data) {
		super(data,false);
	}
	public ErorrDataResult( String message) {
		super(null,false, message);
	}
	public ErorrDataResult() {
		super(null,false);
	}
}
