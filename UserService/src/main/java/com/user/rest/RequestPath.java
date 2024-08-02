package com.user.rest;

import lombok.Getter;

@Getter
public class RequestPath {

	public static final String USER_CREATE = "api/users/createUser";
	public static final String USER_DELETE = "api/users/{id}";
	public static final String USER_UPDATE = "api/users/{id}";
	public static final String USER_GET = "api/users/{id}";
	public static final String GET_USERS = "api/users";
}
