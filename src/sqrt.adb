with Ada.Numerics.Elementary_Functions;
use Ada.Numerics.Elementary_Functions;
with Ada.Integer_Text_IO, Ada.Text_IO, Ada.Float_Text_IO;
use Ada.Integer_Text_IO, Ada.Text_IO, Ada.Float_Text_IO;
procedure sqrt is
   X : Float;
begin
   Put_Line ("Roots");
   loop
      Get (X);
      exit when X = 0.0;
      Put ("Root of ");
      Put (X);
      Put (" is ");
      if X < 0.0 then
         Put ("not calculable");
      else
         Put (Sqrt (X));
      end if;
      Put_Line ("");
   end loop;
   Put ("Program finished!");
end sqrt;
