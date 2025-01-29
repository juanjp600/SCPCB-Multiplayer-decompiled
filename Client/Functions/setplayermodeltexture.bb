Function setplayermodeltexture%(arg0.mp_player, arg1%, arg2%)
    arg0\Field35\Field18 = arg1
    If (arg2 <> 0) Then
        markplayerasupdated(arg0)
    EndIf
    Return $00
End Function
