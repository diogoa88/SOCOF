-module(ex1).

%% ====================================================================
%% API functions
%% ====================================================================
-export([start_server/0 , p4/0, p/1]).

start_server() ->   Pid4 = spawn(ex1, p4, []), 
                    Pid3 = spawn(ex1, p, [Pid4]), 
                    Pid2 = spawn(ex1, p, [Pid3]),  
                    Pid1 = spawn(ex1, p, [Pid2]), 
                    register(p1, Pid1).
                  

p(Pid) -> link(Pid),
        receive 
            Message -> io:format("P: ~s ~n", [Message]) , Pid ! Message
        end,
        p(Pid).

p4() -> receive 
            "stop" -> exit(finish);
            Message -> io:format("P4: ~s ~n", [Message]) 
        end,
        p4().
