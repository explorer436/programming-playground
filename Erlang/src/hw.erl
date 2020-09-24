-module(hw).

%% API
%% exports tell the outside users what functions this module has.
%% if a function is not exported, it cannot be accessed from outside the module.
%% the functions that need to be exported are exposed as comma-separated lists.
-export([helloworld/0, helloworld/1]).

helloworld() ->
  "Hello world".
%% . represents the end of the function (similar to ; in Java)

helloworld(X) ->
  "Hello " ++ X.