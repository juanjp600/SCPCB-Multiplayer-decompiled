Function flushplayerpivot%(arg0.mp_player)
    If (((arg0\Field18 = $00) Lor (arg0\Field5 = mp_getmyindex())) <> 0) Then
        Return $00
    EndIf
    freeentity(arg0\Field18)
    arg0\Field18 = $00
    Return $01
    Return $00
End Function
