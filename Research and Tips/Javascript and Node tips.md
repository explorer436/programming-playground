https://expressjs.com/en/guide/using-middleware.html 
 
https://github.com/expressjs/body-parser 
 
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/finally 

https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date 
 
https://momentjs.com/ 
 
https://docs.npmjs.com/files/package.json#dependencies 
 
https://rclayton.silvrback.com/speaking-intelligently-about-java-vs-node-performance

### To get a list of config settings in your computer for your application, use this command
  ``` 
  npm config list
  ```

https://node.green/

### Reinstalling a package after just deleting the node module works with
  ``` 
  yarn install --check-files
  ```

How to generate JSDoc comments for Javascript functions?
Using Webstorm, position the caret before the declaration of the method/function or field to document, type the opening block comment `/**`, and press `Enter`. Describe the listed parameters, return values, and so on.


### Disabling TLS in NodeJS:

  ``` 
  NODE_TLS_REJECT_UNAUTHORIZED
  ```

  If value equals '0', certificate validation is disabled for TLS connections. This makes TLS, and HTTPS by extension, insecure. The use of this environment variable is strongly discouraged.
  This can be set using the local ".env" file or using `process.env.NODE_TLS_REJECT_UNAUTHORIZED=0`

  ``` 
  NODE_TLS_REJECT_UNAUTHORIZED=0
  ```


### Jest testing tips:

If you need to chain more than one call after another you can do something like this:

``` 
const callAService(value) => {
    const firstResponse = serviceOne(value)
    return serviceTwo(firstResponse)
}

it('should behave some way when provided a value', ()=> {
      serviceOne.mockImplementation((value)=> if(value === 1) return 2 )
      serviceTwo.mockImplementation((value)=> if(value === 2) return 3)
      
      const actual = callAService(1)
      expect(actual).toEqual(3)
})
```
