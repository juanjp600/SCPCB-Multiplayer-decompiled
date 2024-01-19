Function playgunsound%(arg0%, arg1#, arg2%)
    If (arg0 = $00) Then
        Return $00
    EndIf
    eqquipedgun\Field12 = playsound_strict(arg0)
    If (arg2 <> 0) Then
        multiplayer_writesound(arg0, 0.0, 0.0, 0.0, (20.0 - arg1), 1.0)
    EndIf
    Return $00
End Function
