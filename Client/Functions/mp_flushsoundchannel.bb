Function mp_flushsoundchannel%(arg0.mp_soundchannel)
    freeentity(arg0\Field5)
    arg0\Field5 = $00
    stopchannel(arg0\Field1)
    arg0\Field1 = $00
    If (arg0\Field8 <> 0) Then
        mp_flushsound((Object.mp_sound arg0\Field0))
    EndIf
    Delete arg0
    Return $00
End Function
