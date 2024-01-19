Function getdownloadspeed#(arg0#)
    If (1000.0 > arg0) Then
        Return 0.0
    EndIf
    Return (arg0 / 100000.0)
    Return 0.0
End Function
