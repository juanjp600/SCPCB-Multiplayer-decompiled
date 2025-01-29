Function event_issomebodyinroom%(arg0.events)
    Return (((arg0\Field24 <> Null) And (arg0\Field24\Field5 <> mp_getmyindex())) And (mp_rooms[arg0\Field24\Field22] = arg0\Field1))
    Return $00
End Function
