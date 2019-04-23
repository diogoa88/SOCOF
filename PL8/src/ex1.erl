%% @author user
%% @doc @todo Add description to ex.


-module(ex1).

%% ====================================================================
%% API functions
%% ====================================================================
-export([start_server/0, server/0, client/2]).



%% ====================================================================
%% Internal functions
%% ====================================================================


start_server() -> spawn(ex1, server,[]).

server() -> 
	receive 
		{ msg, From , Msg} -> io:fwrite("The id is: ~w \n" , [From] ), From ! {reply, Msg}
	end,
server().


client(PidServer, Msg) -> 
	PidServer ! {msg, self(), Msg} ,
		receive 
			{reply, R} -> io:format("Client receive the message ~s \n" , [R])
		end.