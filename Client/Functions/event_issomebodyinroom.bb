Function event_issomebodyinroom%(arg0.events)
    Return (((arg0\Field21 <> Null) And (arg0\Field21\Field5 <> mp_getmyindex())) And (mp_rooms[arg0\Field21\Field22] = arg0\Field1))
    Return $00
End Function
