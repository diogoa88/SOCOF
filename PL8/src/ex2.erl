%% @author user
%% @doc @todo Add description to ex2.


-module(ex2).

%% ====================================================================
%% API functions
%% ====================================================================
-export([start_server/0, server/0, client/2]).



%% ====================================================================
%% Internal functions
%% ====================================================================

start_server() -> spawn(ex2, server, []).

server() -> 
	receive 
		{msg , From , "ping"} -> io:fwrite("The id is: ~w \n" , [From] ) , From ! {reply , "pong"};
		{msg , From , _} -> io:fwrite("The id is: ~w \n" , [From] ) , From ! {reply , "pang"}
	end,
	server().

client(PidServer , Msg) -> 
	PidServer ! {msg , self(), Msg} , 
		receive 
			{reply , R} -> io:format("Client receive the message ~s \n" , [R])
		end .
