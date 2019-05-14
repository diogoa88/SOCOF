-module(ex2).

%% ====================================================================
%% API functions
%% ====================================================================
-export([start/0 , server/3, printer/0, harddisk/0,memory/0]).

start() -> PidPrinter = spawn(ex2, printer, []),
            PidHardDisk = spawn(ex2, harddisk, []),
            PidMemory = spawn(ex2, memory, []),
            register(server, spawn(ex2, server,[PidPrinter,PidHardDisk,PidMemory])).

server(PidPrinter,PidHardDisk,PidMemory) -> 
    link(PidPrinter),
    link(PidHardDisk),
    link(PidMemory),
    receive 
        printer -> PidPrinter ! "Print";
        harddisk -> PidHardDisk ! "harddisk";
        memory -> PidMemory ! "memory";
        _ -> io:format("Error ~n",[])
    after 10000 ->
        PidPrinter ! "The resourse will be deactivated",
        PidHardDisk ! "The resourse will be deactivated",
        PidMemory ! "The resourse will be deactivated",
        timer:sleep(5000),
        exit(PidPrinter, kill),
        exit(PidHardDisk, kill),
        exit(PidMemory, kill),
        server(spawn(ex2,printer,[]),spawn(ex2,harddisk,[]),spawn(ex2,memory,[]))
    end,
    server(PidPrinter,PidHardDisk,PidMemory).

printer() -> 
    receive 
        M -> io:format("Printer : ~s ~n" , [M])
    end,
    printer().

harddisk() -> 
    receive 
        M -> io:format("Harddisk : ~s ~n" , [M])
    end,
    harddisk().

memory() -> 
    receive 
        M -> io:format("Memory : ~s ~n" , [M])
    end,
    memory().
