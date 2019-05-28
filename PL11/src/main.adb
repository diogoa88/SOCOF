with Calendar, Ada.Text_IO, Ada.Integer_Text_IO, Ada.Task_Identification;
use Calendar, Ada.Text_IO, Ada.Integer_Text_IO, Ada.Task_Identification;

procedure Main is

   task Farmer is
      entry RetriveData(T: in Integer; Id: in Task_Id);
   end Farmer;
   task body Farmer is
      T:Integer:=0;
      Id:Task_Id;
   begin
      loop
         select
            accept RetriveData(T: in Integer; Id: in Task_Id) do
               Put("Retrive ");
               Put(T);
               Put(" from ");
               Put(Image(Id));
               Put_Line("");
            end RetriveData;
         or
            delay 10.0;
            Put ("Don't have information");
            Put_Line("");
         end select;
      end loop;
   end Farmer;

   task type Sensor is
      entry movement_detected;
   end Sensor;
   task body Sensor is
      T:Integer:=0;
      Id:Task_Id;
   begin
      loop
         accept movement_detected do
            T := T +1;
            Id:=Sensor'Identity;
            Farmer.RetriveData(T,Id);
         end movement_detected;
      end loop;
   end Sensor;


   S : Sensor;
   S1 : Sensor;
   S2 : Sensor;

begin
   S.movement_detected;
   S1.movement_detected;
   S2.movement_detected;
   delay 2.0;
   S.movement_detected;
   S1.movement_detected;

   delay 5.0;
   S.movement_detected;
   S1.movement_detected;
   delay 9.0;
   S2.movement_detected;
end Main;
