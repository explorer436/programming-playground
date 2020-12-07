How to use special characters in username/password for HTTP proxy?

I am trying to setup an HTTP proxy on a Windows machine. Problem is, the password has a special character (@) in it that is causing the set command to fail.

I have tried both escaping the character (\@), to no avail.

For example, with the username Foo and password B@r, I have tried the following commands:
set http_proxy=http://foo:B\@r@http-gateway.domain.org:80

Other than changing the password how can I have the proxy use the password?


--------------------------------------------------------------------------
Answer:

You have to percent-encode | encode the special characters. 
Look at this page for reference : https://www.w3schools.com/tags/ref_urlencode.asp

e.g. instead of this: http://foo:B@r@http-gateway.domain.org:80

you write this: http://foo:B%40r@http-gateway.domain.org:80
So @ gets replaced with %40.

If you have a `#` in the password, replace it with `%23`.