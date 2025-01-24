Function mp_updatelocalsoundchannel%(arg0.mp_localsoundchannel)
    channelvolume(arg0\Field1, (arg0\Field2 * opt\Field20))
    If (channelplaying(arg0\Field1) = $00) Then
        mp_flushlocalsoundchannel(arg0)
    EndIf
    Return $00
End Function
