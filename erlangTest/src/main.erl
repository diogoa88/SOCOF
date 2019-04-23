%% @author Diogo Araújo
%% @doc @todo Add description to main.


-module(main).

%% ====================================================================
%% API functions
%% ====================================================================
-export([start/0, inc/1]).



%% ====================================================================
%% Internal functions
%% ====================================================================
start() -> io:fwrite("Hello World\n").

inc(X) -> X + 1.