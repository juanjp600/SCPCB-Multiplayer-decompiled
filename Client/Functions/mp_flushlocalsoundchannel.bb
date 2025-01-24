Function mp_flushlocalsoundchannel%(arg0.mp_localsoundchannel)
    stopchannel(arg0\Field1)
    arg0\Field1 = $00
    If (arg0\Field3 <> 0) Then
        mp_flushsound((Object.mp_sound arg0\Field0))
    EndIf
    Delete arg0
    Return $00
End Function
