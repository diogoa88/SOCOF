-module(ex).

-define (NumberOfTriage, 3).
-define (NumberOfhealthProvider, 5).
-define (TimeOutTriage, 4000).
-define (TimeOutPriority,15000).
-define (MaxPriority, 3).

-export([start/0, registerPerson/1, waitingList/1, addToList/2, getFistElement/1,
        createNTriage/1, triage/1,central/1,searchPacientByPriority/2, 
        healthProvider/1, createNhealthProvider/1,
        test/0]).




%% Start the program
start() ->  register(waitingList, spawn(ex, waitingList,[[]])),
            register(central, spawn(ex, central,[[]])),
            createNTriage(?NumberOfTriage),
            createNhealthProvider(?NumberOfhealthProvider).

    
%%create N Triage
createNTriage(0)-> ok;
createNTriage(Number)-> spawn(ex, triage,[Number]), createNTriage(Number-1).

    
%%create N healthProvider
createNhealthProvider(0)-> ok;
createNhealthProvider(Number)-> spawn(ex, healthProvider,[Number]), createNhealthProvider(Number-1).

test()->
    registerPerson("Peter"),
    registerPerson("Andre"),
    registerPerson("Diogo"),
    registerPerson("Manel"),
    registerPerson("Ricardo"),
    registerPerson("Sofia"),
    registerPerson("Tiago"),
    registerPerson("OLIVER"),
    registerPerson("HARRY "),
    registerPerson("JACK "),
    registerPerson("GEORGE "),
    registerPerson("CHARLIE "),
    registerPerson("FREDDIE "),
    registerPerson("OSCAR ").

%%Add Person to WaitingList
registerPerson(Name) -> waitingList ! {add , Name}.

%%The waiting List
waitingList(List) -> 
    receive
        {add, Name} ->  NewList=addToList(List,Name), 
                        waitingList(NewList);
        {get, Pid} ->   {First, NewList} = getFistElement(List),
                        Pid ! First,
                        waitingList(NewList)
    end.



%%triage
triage(Number) -> 
    timer:sleep(?TimeOutTriage),
    waitingList ! {get , self()} ,
    receive
        error ->%% io:format("Triage ~w cant get a pacient ~n", [Number]);
                ok;
        Name -> Priority = rand:uniform(?MaxPriority),
                io:format("Triage ~w get a pacient ~s with Priority ~w ~n", [Number, Name, Priority]),
                central ! {add, Name, Priority}
    end,
    triage(Number).

%% central
central(List) ->
    receive
        {add , Name , Priority} ->  NewList = addToList(List,{Name,Priority}),
                                    central(NewList);
        {get , Pid } -> case searchPacientByPriority(List,?MaxPriority) of
                    {{Name,Priority}, NewList}->Pid ! {Name, Priority},
                                                central(NewList);
                    not_found -> %%io:format("Central don't have pacients ~n",[]),
                                Pid ! not_found,
                                central(List);
                    _ -> io:format("Error on search By priority ~n" ,[]),
                    Pid ! not_found,
                        central(List)
                    end;
        _ -> io:format("Bad request for central ~n",[])
    end. 

%% Search the Pacients by Priority
searchPacientByPriority(_,0)->not_found;
searchPacientByPriority([],_)-> not_found;
searchPacientByPriority(List,Priority) -> 
       FilterList=lists:filter(fun({_ , Value}) -> Value==Priority end, List),
        case getFistElement(FilterList) of
            {error, []} -> searchPacientByPriority(List,Priority-1);
            {Element,_} -> {Element,lists:delete(Element, List)}
        end.

%% Health Provider
healthProvider(Number) ->
    central ! {get, self()},
    receive
        {Name , Priority} ->  io:format("Health Provider n ~w is taking care of Pacient: ~s Priority: ~w ~n", [Number,Name,Priority]),
                              timer:sleep(?TimeOutPriority * Priority);
                           
        not_found -> io:format("Health Provider n~w dont have patients ~n" , [Number]),
                    timer:sleep(?TimeOutPriority)
    end,
    healthProvider(Number).

%% add element to the end of the list
addToList(List,Element) -> List ++ [Element].

%% get First element of a list
getFistElement([]) -> {error, []};
getFistElement([H|T]) -> {H,T}.
