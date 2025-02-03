Function getbool$(arg0%)
    If (arg0 <> 0) Then
        Return getlocalstring("gui", "yes")
    EndIf
    Return getlocalstring("gui", "no")
    Return ""
End Function
