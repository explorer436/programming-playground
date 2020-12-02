Sometimes, we probably have to turn off proxy in order for the axios calls to go through:

Using this: 'proxy: false'

 

Here is a sample:

const cleansedAddressResponse = await axios({

        method: 'get',

        url: getConfig().service.cleanseAddress.endpoint,

        headers: headers,

        params: {

          streetAddress: address.streetAddress,

          ...(address.additionalStreetAddress && { additionalStreetAddress: address.additionalStreetAddress }),

          city: address.city,

          jurisdiction: address.jurisdiction,

          zipCode: address.zipCode?.substring(0, 5),

          ...(address.county && { county: address.county })

        },

        proxy: false

      })

 

How to identify the root cause of this?

Here is a clue from the log:

      responseUrl: 'http://localhost:3128/https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will',

This tells us that a proxy is being added somewhere and to disable that from happening, explicitly set 'proxy: false' in the request.

 

[n0281526@VDDP14P-I9AGJD5 pagro-home-api]$ yarn start:local

yarn run v1.22.4

warning package.json: No license field

$ yarn build --watch

warning package.json: No license field

$ yarn build:spec && webpack --watch

warning package.json: No license field

$ redoc-cli bundle openapi/specification.yml -o public/index.html

Prerendering docs

 

🎉 bundled successfully in: public/index.html (1098 KiB) [⏱ 0.415s]

 

webpack is watching the files…

 

Webpack Bundle Analyzer saved report to /home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/report.html

Hash: 1abfb2ffbd150277fee6

Version: webpack 4.44.1

Time: 5923ms

Built at: 12/01/2020 11:54:59 AM

                              Asset       Size  Chunks                   Chunk Names

     deployment/idp-development.yml  178 bytes          [emitted]       

     deployment/idp-performance.yml  179 bytes          [emitted]       

      deployment/idp-production.yml  180 bytes          [emitted]       

            deployment/idp-test.yml  180 bytes          [emitted]       

deployment/manifest-development.yml   2.09 KiB          [emitted]       

deployment/manifest-performance.yml   1.85 KiB          [emitted]       

 deployment/manifest-production.yml   1.69 KiB          [emitted]        

       deployment/manifest-test.yml   2.03 KiB          [emitted]       

                      manifest.json  800 bytes          [emitted]       

          openapi/specification.yml   27.5 KiB          [emitted]       

                       package.json   1.29 KiB          [emitted]       

                  public/index.html   1.07 MiB          [emitted]       

                          server.js   3.74 MiB       0  [emitted]        server

                      server.js.map   3.94 MiB       0  [emitted] [dev]  server

                          yarn.lock    378 KiB          [emitted]       

Entrypoint server = server.js server.js.map

  [3] external "util" 42 bytes {0} [built]

  [5] external "path" 42 bytes {0} [built]

  [9] external "fs" 42 bytes {0} [built]

[20] external "url" 42 bytes {0} [built]

[25] external "http" 42 bytes {0} [built]

[35] external "events" 42 bytes {0} [built]

[55] (webpack)/buildin/module.js 497 bytes {0} [built]

[306] ./src/app/index.js 1.41 KiB {0} [built]

[308] ./openapi/specification.yml 20.3 KiB {0} [built]

[309] ./src/app/quotes/index.js 83 bytes {0} [built]

[310] ./src/app/quotes/quotesController.js 943 bytes {0} [built]

[333] ./src/local-server.js 802 bytes {0} [built]

[336] ./src/app/health/index.js + 1 modules 269 bytes {0} [built]

      | ./src/app/health/index.js 85 bytes [built]

      | ./src/app/health/healthController.js 179 bytes [built]

[339] multi source-map-support/register ./src/server.js 40 bytes {0} [built]

[349] ./src/server.js 636 bytes {0} [built]

    + 756 hidden modules

 

WARNING in ./node_modules/express-openapi-validator/dist/resolvers.js 21:37-56

Critical dependency: the request of a dependency is an expression

@ ./node_modules/express-openapi-validator/dist/index.js

@ ./src/app/index.js

@ ./src/server.js

@ multi source-map-support/register ./src/server.js

 

WARNING in ./node_modules/express-openapi-validator/dist/resolvers.js 37:20-39

Critical dependency: the request of a dependency is an expression

@ ./node_modules/express-openapi-validator/dist/index.js

@ ./src/app/index.js

@ ./src/server.js

@ multi source-map-support/register ./src/server.js

 

WARNING in ./node_modules/express/lib/view.js 81:13-25

Critical dependency: the request of a dependency is an expression

@ ./node_modules/express/lib/application.js

@ ./node_modules/express/lib/express.js

@ ./node_modules/express/index.js

@ ./src/server.js

@ multi source-map-support/register ./src/server.js

 

WARNING in ./node_modules/deasync/index.js 28:11-27

Critical dependency: the request of a dependency is an expression

@ ./node_modules/express-openapi-validator/dist/framework/openapi.spec.loader.js

@ ./node_modules/express-openapi-validator/dist/index.js

@ ./src/app/index.js

@ ./src/server.js

@ multi source-map-support/register ./src/server.js

[nodemon] 2.0.4

[nodemon] to restart at any time, enter `rs`

[nodemon] watching path(s): dist/server.js

[nodemon] watching extensions: js,mjs,json

[nodemon] starting `node dist/server.js`

[info] setup express

[warn] Setting up local environment

[warn] Using local server setup with user { id: 'id-1', email: 'apiuser@local.com', apis: [ 'home' ] }

(node:14303) [DEP0005] DeprecationWarning: Buffer() is deprecated due to security and usability issues. Please use the Buffer.alloc(), Buffer.allocUnsafe(), or Buffer.from() methods instead.

[info] server is listening on port 3007

[perf] Start - POST /quotes

[info] Quotes Endpoint Hit: Create Quote

(node:14303) Warning: Setting the NODE_TLS_REJECT_UNAUTHORIZED environment variable to '0' makes TLS connections and HTTPS requests insecure by disabling certificate verification.

[info] Retrieving new bearer token

[info] Retrieving new bearer token

[error] Error calling cleanse address service. Error: Request failed with status code 400

    at createError (/home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/webpack:/node_modules/axios/lib/core/createError.js:16:1)

    at settle (/home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/webpack:/node_modules/axios/lib/core/settle.js:17:1)

    at IncomingMessage.handleStreamEnd (/home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/webpack:/node_modules/axios/lib/adapters/http.js:236:1)

    at IncomingMessage.emit (events.js:228:7)

    at endReadableNT (_stream_readable.js:1185:12)

    at processTicksAndRejections (internal/process/task_queues.js:81:21) {

  config: {

    url: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress',

    method: 'get',

    params: {

      streetAddress: '232 Arcadia St',

      city: 'Park Forest',

      jurisdiction: 'IL',

      zipCode: '60466',

      county: 'Will'

    },

    headers: {

      Accept: 'application/json, text/plain, */*',

      'Content-Type': 'application/json',

      'User-Agent': 'axios/0.19.2',

      host: 'helios-develop.np.uscm.libertyec.com'

    },

    transformRequest: [ [Function: transformRequest] ],

    transformResponse: [ [Function: transformResponse] ],

    timeout: 0,

    adapter: [Function: httpAdapter],

    xsrfCookieName: 'XSRF-TOKEN',

    xsrfHeaderName: 'X-XSRF-TOKEN',

    maxContentLength: -1,

    validateStatus: [Function: validateStatus],

    data: undefined

  },

  request: ClientRequest {

    _events: [Object: null prototype] {

      socket: [Function],

      abort: [Function],

      aborted: [Function],

      error: [Function],

      timeout: [Function],

      prefinish: [Function: requestOnPrefinish]

    },

    _eventsCount: 6,

    _maxListeners: undefined,

    outputData: [],

    outputSize: 0,

    writable: true,

    _last: true,

    chunkedEncoding: false,

    shouldKeepAlive: false,

    useChunkedEncodingByDefault: false,

    sendDate: false,

    _removedConnection: false,

    _removedContLen: false,

    _removedTE: false,

    _contentLength: 0,

    _hasBody: true,

    _trailer: '',

    finished: true,

    _headerSent: true,

    socket: Socket {

      connecting: false,

      _hadError: false,

      _parent: null,

      _host: 'localhost',

      _readableState: [ReadableState],

      readable: true,

      _events: [Object: null prototype],

      _eventsCount: 6,

      _maxListeners: undefined,

      _writableState: [WritableState],

      writable: false,

      allowHalfOpen: false,

      _sockname: null,

      _pendingData: null,

      _pendingEncoding: '',

      server: null,

      _server: null,

      parser: null,

      _httpMessage: [Circular],

      [Symbol(asyncId)]: 361,

      [Symbol(kHandle)]: [TCP],

      [Symbol(lastWriteQueueSize)]: 0,

      [Symbol(timeout)]: null,

      [Symbol(kBuffer)]: null,

      [Symbol(kBufferCb)]: null,

      [Symbol(kBufferGen)]: null,

      [Symbol(kBytesRead)]: 0,

      [Symbol(kBytesWritten)]: 0

    },

    connection: Socket {

      connecting: false,

      _hadError: false,

      _parent: null,

      _host: 'localhost',

      _readableState: [ReadableState],

      readable: true,

      _events: [Object: null prototype],

      _eventsCount: 6,

      _maxListeners: undefined,

      _writableState: [WritableState],

      writable: false,

      allowHalfOpen: false,

      _sockname: null,

      _pendingData: null,

      _pendingEncoding: '',

      server: null,

      _server: null,

      parser: null,

      _httpMessage: [Circular],

      [Symbol(asyncId)]: 361,

      [Symbol(kHandle)]: [TCP],

      [Symbol(lastWriteQueueSize)]: 0,

      [Symbol(timeout)]: null,

      [Symbol(kBuffer)]: null,

      [Symbol(kBufferCb)]: null,

      [Symbol(kBufferGen)]: null,

      [Symbol(kBytesRead)]: 0,

      [Symbol(kBytesWritten)]: 0

    },

    _header: 'GET https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will HTTP/1.1\r\n' +

      'Accept: application/json, text/plain, */*\r\n' +

      'Content-Type: application/json\r\n' +

      'User-Agent: axios/0.19.2\r\n' +

      'host: helios-develop.np.uscm.libertyec.com\r\n' +

      'Connection: close\r\n' +

      '\r\n',

    _onPendingData: [Function: noopPendingOutput],

    agent: Agent {

      _events: [Object: null prototype],

      _eventsCount: 1,

      _maxListeners: undefined,

      defaultPort: 80,

      protocol: 'http:',

      options: [Object],

      requests: {},

      sockets: [Object],

      freeSockets: {},

      keepAliveMsecs: 1000,

      keepAlive: false,

      maxSockets: Infinity,

      maxFreeSockets: 256

    },

    socketPath: undefined,

    method: 'GET',

    insecureHTTPParser: undefined,

    path: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will',

    _ended: true,

    res: IncomingMessage {

      _readableState: [ReadableState],

      readable: false,

      _events: [Object: null prototype],

      _eventsCount: 3,

      _maxListeners: undefined,

      socket: [Socket],

      connection: [Socket],

      httpVersionMajor: 1,

      httpVersionMinor: 1,

      httpVersion: '1.1',

      complete: true,

      headers: [Object],

      rawHeaders: [Array],

      trailers: {},

      rawTrailers: [],

      aborted: false,

      upgrade: false,

      url: '',

      method: null,

      statusCode: 400,

      statusMessage: 'Bad Request',

      client: [Socket],

      _consuming: false,

      _dumped: false,

      req: [Circular],

      responseUrl: 'http://localhost:3128/https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will',

      redirects: []

    },

    aborted: false,

    timeoutCb: null,

    upgradeOrConnect: false,

    parser: null,

    maxHeadersCount: null,

    _redirectable: Writable {

      _writableState: [WritableState],

      writable: true,

      _events: [Object: null prototype],

      _eventsCount: 2,

      _maxListeners: undefined,

      _options: [Object],

      _redirectCount: 0,

      _redirects: [],

      _requestBodyLength: 0,

      _requestBodyBuffers: [],

      _onNativeResponse: [Function],

      _currentRequest: [Circular],

      _currentUrl: 'http://localhost:3128/https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will'

    },

   [Symbol(kNeedDrain)]: false,

    [Symbol(isCorked)]: false,

    [Symbol(kOutHeaders)]: [Object: null prototype] {

      accept: [Array],

      'content-type': [Array],

      'user-agent': [Array],

      host: [Array]

    }

  },

  response: {

    status: 400,

    statusText: 'Bad Request',

    headers: {

      'cache-control': 'no-cache',

      pragma: 'no-cache',

      'content-type': 'text/html; charset=utf-8',

      'proxy-connection': 'close',

      connection: 'close',

      'content-length': '727'

    },

    config: {

      url: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress',

      method: 'get',

      params: [Object],

      headers: [Object],

      transformRequest: [Array],

      transformResponse: [Array],

      timeout: 0,

      adapter: [Function: httpAdapter],

      xsrfCookieName: 'XSRF-TOKEN',

      xsrfHeaderName: 'X-XSRF-TOKEN',

      maxContentLength: -1,

      validateStatus: [Function: validateStatus],

      data: undefined

    },

    request: ClientRequest {

      _events: [Object: null prototype],

      _eventsCount: 6,

      _maxListeners: undefined,

      outputData: [],

      outputSize: 0,

      writable: true,

      _last: true,

      chunkedEncoding: false,

      shouldKeepAlive: false,

      useChunkedEncodingByDefault: false,

      sendDate: false,

      _removedConnection: false,

      _removedContLen: false,

      _removedTE: false,

      _contentLength: 0,

      _hasBody: true,

      _trailer: '',

      finished: true,

      _headerSent: true,

      socket: [Socket],

      connection: [Socket],

      _header: 'GET https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will HTTP/1.1\r\n' +

        'Accept: application/json, text/plain, */*\r\n' +

        'Content-Type: application/json\r\n' +

        'User-Agent: axios/0.19.2\r\n' +

        'host: helios-develop.np.uscm.libertyec.com\r\n' +

        'Connection: close\r\n' +

        '\r\n',

      _onPendingData: [Function: noopPendingOutput],

      agent: [Agent],

      socketPath: undefined,

      method: 'GET',

      insecureHTTPParser: undefined,

      path: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will',

      _ended: true,

      res: [IncomingMessage],

      aborted: false,

      timeoutCb: null,

      upgradeOrConnect: false,

      parser: null,

      maxHeadersCount: null,

      _redirectable: [Writable],

      [Symbol(kNeedDrain)]: false,

      [Symbol(isCorked)]: false,

      [Symbol(kOutHeaders)]: [Object: null prototype]

    },

    data: '<HTML><HEAD>\r\n' +

      '<TITLE>Request Error</TITLE>\r\n' +

      '</HEAD>\r\n' +

      '<BODY>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      '<big><strong></strong></big><BR>\r\n' +

      '</FONT>\r\n' +

      '<blockquote>\r\n' +

      '<TABLE border=0 cellPadding=1 width="80%">\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      '<big>Request Error (invalid_request)</big>\r\n' +

      '<BR>\r\n' +

      '<BR>\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      'Your request could not be processed. Request could not be handled\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      'This could be caused by a misconfiguration, or possibly a malformed request.\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica" SIZE=2>\r\n' +

      '<BR>\r\n' +

      'For assistance, contact your network support team.\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '</TABLE>\r\n' +

      '</blockquote>\r\n' +

      '</FONT>\r\n' +

      '</BODY></HTML>\r\n'

  },

  isAxiosError: true,

  toJSON: [Function]

}

[error] Bad Request Error {

  message: 'Missing or invalid address fields. Could not be cleansed. []',

  code: 'INVALID-CLEANSE',

  stack: 'CleanseAddressError: Missing or invalid address fields. Could not be cleansed. []\n' +

    '    at handleError (/home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/webpack:/src/app/quotes/cleanse-address/CleanseAddressService.js:71:9)\n' +

    '    at cleanseAddress (/home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/webpack:/src/app/quotes/cleanse-address/CleanseAddressService.js:56:7)\n' +

    '    at processTicksAndRejections (internal/process/task_queues.js:94:5)'

}

[perf] End - POST /quotes

[perf] {

  type: 'profiler-performance',

  data: {

    start: 1606841710741,

    end: 1606841716023,

    elapsedTime: 5282,

    method: 'POST',

    url: '/quotes'

  }

}

[error] Error calling cleanse address service. Error: Request failed with status code 400

    at createError (/home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/webpack:/node_modules/axios/lib/core/createError.js:16:1)

    at settle (/home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/webpack:/node_modules/axios/lib/core/settle.js:17:1)

    at IncomingMessage.handleStreamEnd (/home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/webpack:/node_modules/axios/lib/adapters/http.js:236:1)

    at IncomingMessage.emit (events.js:228:7)

    at endReadableNT (_stream_readable.js:1185:12)

    at processTicksAndRejections (internal/process/task_queues.js:81:21) {

  config: {

    url: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress',

    method: 'get',

    params: {

      streetAddress: '232 Arcadia St',

      city: 'Park Forest',

      jurisdiction: 'IL',

      zipCode: '60466',

      county: 'Will'

    },

    headers: {

      Accept: 'application/json, text/plain, */*',

      'Content-Type': 'application/json',

      'User-Agent': 'axios/0.19.2',

      host: 'helios-develop.np.uscm.libertyec.com'

    },

    transformRequest: [ [Function: transformRequest] ],

    transformResponse: [ [Function: transformResponse] ],

    timeout: 0,

    adapter: [Function: httpAdapter],

    xsrfCookieName: 'XSRF-TOKEN',

    xsrfHeaderName: 'X-XSRF-TOKEN',

    maxContentLength: -1,

    validateStatus: [Function: validateStatus],

    data: undefined

  },

  request: ClientRequest {

    _events: [Object: null prototype] {

      socket: [Function],

      abort: [Function],

      aborted: [Function],

      error: [Function],

      timeout: [Function],

      prefinish: [Function: requestOnPrefinish]

    },

    _eventsCount: 6,

    _maxListeners: undefined,

    outputData: [],

    outputSize: 0,

    writable: true,

    _last: true,

    chunkedEncoding: false,

    shouldKeepAlive: false,

    useChunkedEncodingByDefault: false,

    sendDate: false,

    _removedConnection: false,

    _removedContLen: false,

    _removedTE: false,

    _contentLength: 0,

    _hasBody: true,

    _trailer: '',

    finished: true,

    _headerSent: true,

    socket: Socket {

      connecting: false,

      _hadError: false,

      _parent: null,

      _host: 'localhost',

      _readableState: [ReadableState],

      readable: true,

      _events: [Object: null prototype],

      _eventsCount: 6,

      _maxListeners: undefined,

      _writableState: [WritableState],

      writable: false,

      allowHalfOpen: false,

      _sockname: null,

      _pendingData: null,

      _pendingEncoding: '',

      server: null,

      _server: null,

      parser: null,

      _httpMessage: [Circular],

      [Symbol(asyncId)]: 356,

      [Symbol(kHandle)]: [TCP],

      [Symbol(lastWriteQueueSize)]: 0,

      [Symbol(timeout)]: null,

      [Symbol(kBuffer)]: null,

      [Symbol(kBufferCb)]: null,

      [Symbol(kBufferGen)]: null,

      [Symbol(kBytesRead)]: 0,

      [Symbol(kBytesWritten)]: 0

    },

    connection: Socket {

      connecting: false,

      _hadError: false,

      _parent: null,

      _host: 'localhost',

      _readableState: [ReadableState],

      readable: true,

      _events: [Object: null prototype],

      _eventsCount: 6,

      _maxListeners: undefined,

      _writableState: [WritableState],

      writable: false,

      allowHalfOpen: false,

      _sockname: null,

      _pendingData: null,

      _pendingEncoding: '',

      server: null,

      _server: null,

      parser: null,

      _httpMessage: [Circular],

      [Symbol(asyncId)]: 356,

      [Symbol(kHandle)]: [TCP],

      [Symbol(lastWriteQueueSize)]: 0,

      [Symbol(timeout)]: null,

      [Symbol(kBuffer)]: null,

      [Symbol(kBufferCb)]: null,

      [Symbol(kBufferGen)]: null,

      [Symbol(kBytesRead)]: 0,

      [Symbol(kBytesWritten)]: 0

    },

    _header: 'GET https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will HTTP/1.1\r\n' +

      'Accept: application/json, text/plain, */*\r\n' +

      'Content-Type: application/json\r\n' +

      'User-Agent: axios/0.19.2\r\n' +

      'host: helios-develop.np.uscm.libertyec.com\r\n' +

      'Connection: close\r\n' +

      '\r\n',

    _onPendingData: [Function: noopPendingOutput],

    agent: Agent {

      _events: [Object: null prototype],

      _eventsCount: 1,

      _maxListeners: undefined,

      defaultPort: 80,

      protocol: 'http:',

      options: [Object],

      requests: {},

      sockets: [Object],

      freeSockets: {},

      keepAliveMsecs: 1000,

      keepAlive: false,

      maxSockets: Infinity,

      maxFreeSockets: 256

    },

    socketPath: undefined,

    method: 'GET',

    insecureHTTPParser: undefined,

    path: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will',

    _ended: true,

    res: IncomingMessage {

      _readableState: [ReadableState],

      readable: false,

      _events: [Object: null prototype],

      _eventsCount: 3,

      _maxListeners: undefined,

      socket: [Socket],

      connection: [Socket],

      httpVersionMajor: 1,

      httpVersionMinor: 1,

      httpVersion: '1.1',

      complete: true,

      headers: [Object],

      rawHeaders: [Array],

      trailers: {},

      rawTrailers: [],

      aborted: false,

      upgrade: false,

      url: '',

      method: null,

      statusCode: 400,

      statusMessage: 'Bad Request',

      client: [Socket],

      _consuming: false,

      _dumped: false,

      req: [Circular],

      responseUrl: 'http://localhost:3128/https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will',

      redirects: []

    },

    aborted: false,

    timeoutCb: null,

    upgradeOrConnect: false,

    parser: null,

    maxHeadersCount: null,

    _redirectable: Writable {

      _writableState: [WritableState],

      writable: true,

      _events: [Object: null prototype],

      _eventsCount: 2,

      _maxListeners: undefined,

      _options: [Object],

      _redirectCount: 0,

      _redirects: [],

      _requestBodyLength: 0,

      _requestBodyBuffers: [],

      _onNativeResponse: [Function],

      _currentRequest: [Circular],

      _currentUrl: 'http://localhost:3128/https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will'

    },

    [Symbol(kNeedDrain)]: false,

    [Symbol(isCorked)]: false,

    [Symbol(kOutHeaders)]: [Object: null prototype] {

      accept: [Array],

      'content-type': [Array],

      'user-agent': [Array],

      host: [Array]

    }

  },

  response: {

    status: 400,

    statusText: 'Bad Request',

    headers: {

      'cache-control': 'no-cache',

      pragma: 'no-cache',

      'content-type': 'text/html; charset=utf-8',

      'proxy-connection': 'close',

      connection: 'close',

      'content-length': '727'

    },

    config: {

      url: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress',

      method: 'get',

      params: [Object],

      headers: [Object],

      transformRequest: [Array],

      transformResponse: [Array],

      timeout: 0,

      adapter: [Function: httpAdapter],

      xsrfCookieName: 'XSRF-TOKEN',

      xsrfHeaderName: 'X-XSRF-TOKEN',

      maxContentLength: -1,

      validateStatus: [Function: validateStatus],

      data: undefined

    },

    request: ClientRequest {

      _events: [Object: null prototype],

      _eventsCount: 6,

      _maxListeners: undefined,

      outputData: [],

      outputSize: 0,

      writable: true,

      _last: true,

      chunkedEncoding: false,

      shouldKeepAlive: false,

      useChunkedEncodingByDefault: false,

      sendDate: false,

      _removedConnection: false,

      _removedContLen: false,

      _removedTE: false,

      _contentLength: 0,

      _hasBody: true,

      _trailer: '',

      finished: true,

      _headerSent: true,

      socket: [Socket],

      connection: [Socket],

      _header: 'GET https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will HTTP/1.1\r\n' +

        'Accept: application/json, text/plain, */*\r\n' +

        'Content-Type: application/json\r\n' +

        'User-Agent: axios/0.19.2\r\n' +

        'host: helios-develop.np.uscm.libertyec.com\r\n' +

        'Connection: close\r\n' +

        '\r\n',

      _onPendingData: [Function: noopPendingOutput],

      agent: [Agent],

      socketPath: undefined,

      method: 'GET',

      insecureHTTPParser: undefined,

      path: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will',

      _ended: true,

      res: [IncomingMessage],

      aborted: false,

      timeoutCb: null,

      upgradeOrConnect: false,

      parser: null,

      maxHeadersCount: null,

      _redirectable: [Writable],

      [Symbol(kNeedDrain)]: false,

      [Symbol(isCorked)]: false,

      [Symbol(kOutHeaders)]: [Object: null prototype]

    },

    data: '<HTML><HEAD>\r\n' +

      '<TITLE>Request Error</TITLE>\r\n' +

      '</HEAD>\r\n' +

      '<BODY>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      '<big><strong></strong></big><BR>\r\n' +

      '</FONT>\r\n' +

      '<blockquote>\r\n' +

      '<TABLE border=0 cellPadding=1 width="80%">\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      '<big>Request Error (invalid_request)</big>\r\n' +

      '<BR>\r\n' +

      '<BR>\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      'Your request could not be processed. Request could not be handled\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      'This could be caused by a misconfiguration, or possibly a malformed request.\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica" SIZE=2>\r\n' +

      '<BR>\r\n' +

      'For assistance, contact your network support team.\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '</TABLE>\r\n' +

      '</blockquote>\r\n' +

      '</FONT>\r\n' +

      '</BODY></HTML>\r\n'

  },

  isAxiosError: true,

  toJSON: [Function]

}

[error] Error calling cleanse address service. Error: Request failed with status code 400

    at createError (/home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/webpack:/node_modules/axios/lib/core/createError.js:16:1)

    at settle (/home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/webpack:/node_modules/axios/lib/core/settle.js:17:1)

    at IncomingMessage.handleStreamEnd (/home/n0281526/Downloads/GitRepositories/pagro-home-api/dist/webpack:/node_modules/axios/lib/adapters/http.js:236:1)

    at IncomingMessage.emit (events.js:228:7)

    at endReadableNT (_stream_readable.js:1185:12)

    at processTicksAndRejections (internal/process/task_queues.js:81:21) {

  config: {

    url: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress',

    method: 'get',

    params: {

      streetAddress: '232 Arcadia St',

      city: 'Park Forest',

      jurisdiction: 'IL',

      zipCode: '60466',

      county: 'Will'

    },

    headers: {

      Accept: 'application/json, text/plain, */*',

      'Content-Type': 'application/json',

      'User-Agent': 'axios/0.19.2',

      host: 'helios-develop.np.uscm.libertyec.com'

    },

    transformRequest: [ [Function: transformRequest] ],

    transformResponse: [ [Function: transformResponse] ],

    timeout: 0,

    adapter: [Function: httpAdapter],

    xsrfCookieName: 'XSRF-TOKEN',

    xsrfHeaderName: 'X-XSRF-TOKEN',

    maxContentLength: -1,

    validateStatus: [Function: validateStatus],

    data: undefined

  },

  request: ClientRequest {

    _events: [Object: null prototype] {

      socket: [Function],

      abort: [Function],

      aborted: [Function],

      error: [Function],

      timeout: [Function],

      prefinish: [Function: requestOnPrefinish]

    },

    _eventsCount: 6,

    _maxListeners: undefined,

    outputData: [],

    outputSize: 0,

    writable: true,

    _last: true,

    chunkedEncoding: false,

    shouldKeepAlive: false,

    useChunkedEncodingByDefault: false,

    sendDate: false,

    _removedConnection: false,

    _removedContLen: false,

    _removedTE: false,

    _contentLength: 0,

    _hasBody: true,

    _trailer: '',

    finished: true,

    _headerSent: true,

    socket: Socket {

      connecting: false,

      _hadError: false,

      _parent: null,

      _host: 'localhost',

      _readableState: [ReadableState],

      readable: true,

      _events: [Object: null prototype],

      _eventsCount: 6,

      _maxListeners: undefined,

      _writableState: [WritableState],

      writable: false,

      allowHalfOpen: false,

      _sockname: null,

      _pendingData: null,

      _pendingEncoding: '',

      server: null,

      _server: null,

      parser: null,

      _httpMessage: [Circular],

      [Symbol(asyncId)]: 366,

      [Symbol(kHandle)]: [TCP],

      [Symbol(lastWriteQueueSize)]: 0,

      [Symbol(timeout)]: null,

      [Symbol(kBuffer)]: null,

      [Symbol(kBufferCb)]: null,

      [Symbol(kBufferGen)]: null,

      [Symbol(kBytesRead)]: 0,

      [Symbol(kBytesWritten)]: 0

    },

    connection: Socket {

      connecting: false,

      _hadError: false,

      _parent: null,

      _host: 'localhost',

      _readableState: [ReadableState],

      readable: true,

      _events: [Object: null prototype],

      _eventsCount: 6,

      _maxListeners: undefined,

      _writableState: [WritableState],

      writable: false,

      allowHalfOpen: false,

      _sockname: null,

      _pendingData: null,

      _pendingEncoding: '',

      server: null,

      _server: null,

      parser: null,

      _httpMessage: [Circular],

      [Symbol(asyncId)]: 366,

      [Symbol(kHandle)]: [TCP],

      [Symbol(lastWriteQueueSize)]: 0,

      [Symbol(timeout)]: null,

      [Symbol(kBuffer)]: null,

      [Symbol(kBufferCb)]: null,

      [Symbol(kBufferGen)]: null,

      [Symbol(kBytesRead)]: 0,

      [Symbol(kBytesWritten)]: 0

    },

    _header: 'GET https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will HTTP/1.1\r\n' +

      'Accept: application/json, text/plain, */*\r\n' +

      'Content-Type: application/json\r\n' +

      'User-Agent: axios/0.19.2\r\n' +

      'host: helios-develop.np.uscm.libertyec.com\r\n' +

      'Connection: close\r\n' +

      '\r\n',

    _onPendingData: [Function: noopPendingOutput],

    agent: Agent {

      _events: [Object: null prototype],

      _eventsCount: 1,

      _maxListeners: undefined,

      defaultPort: 80,

      protocol: 'http:',

      options: [Object],

      requests: {},

      sockets: [Object],

      freeSockets: {},

      keepAliveMsecs: 1000,

      keepAlive: false,

      maxSockets: Infinity,

      maxFreeSockets: 256

    },

    socketPath: undefined,

    method: 'GET',

    insecureHTTPParser: undefined,

    path: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will',

    _ended: true,

    res: IncomingMessage {

      _readableState: [ReadableState],

      readable: false,

      _events: [Object: null prototype],

      _eventsCount: 3,

      _maxListeners: undefined,

      socket: [Socket],

      connection: [Socket],

      httpVersionMajor: 1,

      httpVersionMinor: 1,

      httpVersion: '1.1',

      complete: true,

      headers: [Object],

      rawHeaders: [Array],

      trailers: {},

      rawTrailers: [],

      aborted: false,

      upgrade: false,

      url: '',

      method: null,

      statusCode: 400,

      statusMessage: 'Bad Request',

      client: [Socket],

      _consuming: false,

      _dumped: false,

      req: [Circular],

      responseUrl: 'http://localhost:3128/https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will',

      redirects: []

    },

    aborted: false,

    timeoutCb: null,

    upgradeOrConnect: false,

    parser: null,

    maxHeadersCount: null,

    _redirectable: Writable {

      _writableState: [WritableState],

      writable: true,

      _events: [Object: null prototype],

      _eventsCount: 2,

      _maxListeners: undefined,

      _options: [Object],

      _redirectCount: 0,

      _redirects: [],

      _requestBodyLength: 0,

      _requestBodyBuffers: [],

      _onNativeResponse: [Function],

      _currentRequest: [Circular],

      _currentUrl: 'http://localhost:3128/https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will'

    },

    [Symbol(kNeedDrain)]: false,

    [Symbol(isCorked)]: false,

    [Symbol(kOutHeaders)]: [Object: null prototype] {

      accept: [Array],

      'content-type': [Array],

      'user-agent': [Array],

      host: [Array]

    }

  },

  response: {

    status: 400,

    statusText: 'Bad Request',

    headers: {

      'cache-control': 'no-cache',

      pragma: 'no-cache',

      'content-type': 'text/html; charset=utf-8',

      'proxy-connection': 'close',

      connection: 'close',

      'content-length': '727'

    },

    config: {

      url: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress',

      method: 'get',

      params: [Object],

      headers: [Object],

      transformRequest: [Array],

      transformResponse: [Array],

      timeout: 0,

      adapter: [Function: httpAdapter],

      xsrfCookieName: 'XSRF-TOKEN',

      xsrfHeaderName: 'X-XSRF-TOKEN',

      maxContentLength: -1,

      validateStatus: [Function: validateStatus],

      data: undefined

    },

    request: ClientRequest {

      _events: [Object: null prototype],

      _eventsCount: 6,

      _maxListeners: undefined,

      outputData: [],

      outputSize: 0,

      writable: true,

      _last: true,

      chunkedEncoding: false,

      shouldKeepAlive: false,

      useChunkedEncodingByDefault: false,

      sendDate: false,

      _removedConnection: false,

      _removedContLen: false,

      _removedTE: false,

      _contentLength: 0,

      _hasBody: true,

      _trailer: '',

      finished: true,

      _headerSent: true,

      socket: [Socket],

      connection: [Socket],

      _header: 'GET https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will HTTP/1.1\r\n' +

        'Accept: application/json, text/plain, */*\r\n' +

        'Content-Type: application/json\r\n' +

        'User-Agent: axios/0.19.2\r\n' +

        'host: helios-develop.np.uscm.libertyec.com\r\n' +

        'Connection: close\r\n' +

        '\r\n',

      _onPendingData: [Function: noopPendingOutput],

      agent: [Agent],

      socketPath: undefined,

      method: 'GET',

      insecureHTTPParser: undefined,

      path: 'https://helios-develop.np.uscm.libertyec.com/address-v0/cleansedAddress?streetAddress=232+Arcadia+St&city=Park+Forest&jurisdiction=IL&zipCode=60466&county=Will',

      _ended: true,

      res: [IncomingMessage],

      aborted: false,

      timeoutCb: null,

      upgradeOrConnect: false,

      parser: null,

      maxHeadersCount: null,

      _redirectable: [Writable],

      [Symbol(kNeedDrain)]: false,

      [Symbol(isCorked)]: false,

      [Symbol(kOutHeaders)]: [Object: null prototype]

    },

    data: '<HTML><HEAD>\r\n' +

      '<TITLE>Request Error</TITLE>\r\n' +

      '</HEAD>\r\n' +

      '<BODY>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      '<big><strong></strong></big><BR>\r\n' +

      '</FONT>\r\n' +

      '<blockquote>\r\n' +

      '<TABLE border=0 cellPadding=1 width="80%">\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      '<big>Request Error (invalid_request)</big>\r\n' +

      '<BR>\r\n' +

      '<BR>\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      'Your request could not be processed. Request could not be handled\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica">\r\n' +

      'This could be caused by a misconfiguration, or possibly a malformed request.\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '<TR><TD>\r\n' +

      '<FONT face="Helvetica" SIZE=2>\r\n' +

      '<BR>\r\n' +

      'For assistance, contact your network support team.\r\n' +

      '</FONT>\r\n' +

      '</TD></TR>\r\n' +

      '</TABLE>\r\n' +

      '</blockquote>\r\n' +

      '</FONT>\r\n' +

      '</BODY></HTML>\r\n'

  },

  isAxiosError: true,

  toJSON: [Function]

}

 

 

