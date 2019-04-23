%% @author user
%% @doc @todo Add description to ex3.


-module(ex3).

%% ====================================================================
%% API functions
%% ====================================================================
-export([start_server/0, server/0, open_Account/2]).



%% ====================================================================
%% Internal functions
%% ====================================================================


start_server() -> Pid = spawn(ex3, server,[]),
				  register(bank,Pid).
				  

server() -> 
	receive 
		{open_Account, Client , InitialAmount , PidClient} ->   PidClient ! {"ok" , "Account created"}
	end,
server().


open_Account(Client, InitialAmount) -> 
	bank ! {open_Account,Client, InitialAmount , self()},
	receive
		{"ok", Value} -> io:format("~s\n", [Value] );
		{"not_found", Value} -> io:format("Error")
	end.
